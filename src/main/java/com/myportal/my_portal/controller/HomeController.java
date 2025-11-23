package com.myportal.my_portal.controller;

import com.myportal.my_portal.User;
import com.myportal.my_portal.dto.RegisterDTO;
import com.myportal.my_portal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // Home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Show Registration Form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle Form Submission with DTO
    @PostMapping("/register")
    public String registerUser(
            @Valid RegisterDTO dto,
            BindingResult result,
            Model model) {

        // Validation errors
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "register";
        }
        // Check password match
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }


        // Duplicate email check
        if (userService.findByEmail(dto.getEmail()) != null) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }

        // Convert DTO → Entity
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userService.saveUser(user);

        return "success";
    }
}


