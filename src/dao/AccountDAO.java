package dao;

import model.Account;

import java.util.List;

/**
 * Created by sstoica on 4/25/2018.
 */
public interface AccountDAO {
    public boolean saveAccount(Account account);

    public List<Account> getAccounts();
}
