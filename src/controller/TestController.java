package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sstoica on 4/24/2018.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value={"","/index","/index*","/view*"})
    public String index() {
        return "testRequestMapping";
    }

    @RequestMapping(value = "/name")
    public String methodWithParams(@RequestParam(value = "userName", required = false, defaultValue = "Guest") String userName, Model model) {
        System.out.println("page requested by " + userName);
        model.addAttribute(userName);
        return "testRequestMapping";
    }

    @RequestMapping(value = "/dynamic/{category:[a-z]+/{userName}")
    public  String dynamicUrl(@PathVariable("userName") String userName){
        return "testRequestMapping";
    }

    @RequestMapping("*")
    public String fallBackPage() {
        return "fileNotFound";
    }
}
