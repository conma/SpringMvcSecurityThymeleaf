package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController
{
    @RequestMapping("")
    private String user()
    {
        return "user";
    }
}