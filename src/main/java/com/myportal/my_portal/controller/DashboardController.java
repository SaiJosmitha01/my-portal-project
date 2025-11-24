package com.myportal.my_portal.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        // If user not logged in → redirect to login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        return "dashboard";  // dashboard.jsp
    }
}
