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

        // Redirect to profile page
        return "redirect:/profile";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
