package service;

import model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sstoica on 4/25/2018.
 */
public interface AccountService {
    public boolean saveAccount(Account account);

    public List<Account> getAccounts();
}
