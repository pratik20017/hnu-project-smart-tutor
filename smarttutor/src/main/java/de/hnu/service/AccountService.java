package de.hnu.service;

import de.hnu.data.Account;
import de.hnu.dto.AccountRequestDto;
import de.hnu.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account(accountRequestDto.email(), accountRequestDto.password());
        return accountRepository.save(account);
    }

    public Optional<Account> getByEmailAndPassword(AccountRequestDto accountRequestDto) {
        return accountRepository.findDistinctByEmailAndPassword(accountRequestDto.email(), accountRequestDto.password());
    }

    public Optional<Account> getById(Integer id) {
        return accountRepository.findById(id);
    }
}
