package controller;

import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sstoica on 4/19/2018.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account-form";
    }

    @RequestMapping("/showAccount")
    public String showAccount(){
        return "showAccount";
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("account") Account account,
                              BindingResult result
                              ) {
//        Integer acNo = Integer.parseInt(request.getParameter("accountNumber"));
//        String acName = request.getParameter("accountHolderName");
//        Integer balance = Integer.parseInt(request.getParameter("balance"));
//
//        model.addAttribute("accountNumer", acNo);
//        model.addAttribute("accountHolderName", acName);
//        model.addAttribute("balance", balance);

        if (result.hasErrors())
            return "account-form";
        else{
            accountService.saveAccount(account);
            return "redirect:/list";
        }
    }

    @GetMapping("/list")
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "listAccounts";
    }

    @GetMapping("/edit")
    public String updateAccount(@RequestParam ("accountNo") int accNo, Model model) {
        Account account = accountService.getAccount(new Integer(accNo));
        model.addAttribute("account", account);

        return "showAccount";
    }
}
