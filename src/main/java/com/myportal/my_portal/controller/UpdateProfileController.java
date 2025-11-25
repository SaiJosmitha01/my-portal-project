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

    // Show edit profile page
    @GetMapping("/profile/edit")
    public String showEditProfile(Model model, HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", loggedUser);
        return "profile-edit"; // JSP page name
    }

    // Handle form submit
    @PostMapping("/profile/edit")
    public String updateProfile(User updatedUser,
                                HttpSession session,
                                Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        // Update username + email
        loggedUser.setUsername(updatedUser.getUsername());
        loggedUser.setEmail(updatedUser.getEmail());

        // Update password only if changed
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            loggedUser.setPassword(updatedUser.getPassword());
        }

        // Save updated user (password will be encrypted)
        userService.updateUser(loggedUser);

        // Update session
        session.setAttribute("loggedUser", loggedUser);

        model.addAttribute("success", "Profile updated successfully!");

        return "profile-edit";
    }
}
