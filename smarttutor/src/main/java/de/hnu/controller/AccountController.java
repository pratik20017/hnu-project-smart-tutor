package de.hnu.controller;

import de.hnu.data.Account;
import de.hnu.dto.AccountRequestDto;
import de.hnu.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/smart-tutor/account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        Account acc = accountService.createAccount(accountRequestDto);
        return ResponseEntity.ok(acc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Integer id) {
        Account account = accountService.getById(id).orElse(null);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> signInAccount(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.printf("Request to signInAccount with email: %s and password: %s", email, password);
        Account account = accountService.getByEmailAndPassword(new AccountRequestDto(email, password))
                .orElse(null);

        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }
}
