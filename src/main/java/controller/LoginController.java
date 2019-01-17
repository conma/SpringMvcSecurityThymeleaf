package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController
{
    @RequestMapping
    public String home(Model model)
    {
        return "redirect:login";
    }

    @RequestMapping("/login")
    public String loginPage(Model model)
    {
        return "login";
    }

    @RequestMapping("/forgot")
    public String forgot(Model model)
    {
        return "forgot";
    }

    @RequestMapping("/logout")
    public String logout(Model model)
    {
        return "login";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model)
    {
        return "403";
    }
    
}
