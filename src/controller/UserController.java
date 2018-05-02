package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sstoica on 4/24/2018.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/new")
    public String register() {
        return "register";
    }
}
