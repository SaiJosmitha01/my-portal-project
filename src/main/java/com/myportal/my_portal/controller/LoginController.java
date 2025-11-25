package com.myportal.my_portal.controller;

import com.myportal.my_portal.User;
import com.myportal.my_portal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // Show reset page
    @GetMapping("/reset-password")
    public String showResetPassword(HttpSession session, Model model) {

        if (session.getAttribute("resetEmail") == null) {
            return "redirect:/forgot-password";
        }

        return "reset-password";
    }

    // Handle reset submit
    @PostMapping("/reset-password")
    public String resetPassword(String password, String confirmPassword,
                                HttpSession session, Model model) {

        String email = (String) session.getAttribute("resetEmail");

        if (email == null) {
            return "redirect:/forgot-password";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "reset-password";
        }

        User user = userService.findByEmail(email);

        // Encrypt new password
        user.setPassword(encoder.encode(password));
        userService.saveUser(user);

        // Clear session
        session.removeAttribute("resetEmail");

        return "redirect:/login?resetSuccess=true";
    }


    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp
    }

    // Handle login form submit
    @PostMapping("/login")
    public String loginUser(String email, String password, Model model, HttpSession session) {

        // Check if email exists
        User user = userService.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Invalid email!");
            return "login";
        }

        // Compare encrypted password
        if (!encoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Incorrect password!");
            return "login";
        }

        // Login OK → store user in session
        session.setAttribute("loggedUser", user);

        // Redirect to dashboard
        return "redirect:/dashboard";
    }
    // Show forgot password page
    @GetMapping("/forgot-password")
    public String showForgotPassword() {
        return "forgot-password";
    }

    // Handle email verification
    @PostMapping("/forgot-password")
    public String processForgotPassword(String email, Model model, HttpSession session) {

        User user = userService.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Email not found!");
            return "forgot-password";
        }

        // Store the email temporarily in session for reset step
        session.setAttribute("resetEmail", email);

        // Redirect to reset password page
        return "redirect:/reset-password";
    }


    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
