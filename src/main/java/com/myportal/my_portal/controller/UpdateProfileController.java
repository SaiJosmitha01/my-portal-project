package com.myportal.my_portal.controller;
import com.myportal.my_portal.User;
import com.myportal.my_portal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UpdateProfileController {
    @Autowired
    private UserService userService;

    // Show update profile page
    @GetMapping("/profile/edit")
    public String showEditProfile(Model model, HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", loggedUser);
        return "profile-edit"; // profile-edit.jsp
    }

    // Handle form submit
    @PostMapping("/profile/update")
    public String updateProfile(String username,
                                String email,
                                String password,
                                HttpSession session,
                                Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        // Update fields
        loggedUser.setUsername(username);
        loggedUser.setEmail(email);

        if (password != null && !password.isEmpty()) {
            loggedUser.setPassword(password); // Password will be encrypted in service
        }

        userService.updateUser(loggedUser);

        // update session data
        session.setAttribute("loggedUser", loggedUser);

        model.addAttribute("success", "Profile updated successfully!");

        return "profile-edit";
    }
}
