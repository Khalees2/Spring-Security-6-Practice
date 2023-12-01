package com.practice.springsecurity.controller.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts")
    public String getAccounts() { return "Accounts"; }

    @GetMapping("/account/{accountId}")
    public String getAccounts(@PathVariable int accountId) { return "Account: "+accountId; }
}
