package dao;

import entity.AccountEntity;
import model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sstoica on 4/25/2018.
 */
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveAccount(Account account) {
        boolean saveFlag = true;
        AccountEntity entity = new AccountEntity();
        entity.setAccNo(account.getAccountNo());
        entity.setAccHolderName(account.getAccountHolderName());
        entity.setBalance(account.getBalance());
        entity.setAccountType(account.getAccountType());
        entity.setDateOfBirth(account.getDateOfBirth());
        entity.setPsCode(account.getPsCode());
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
            saveFlag = false;
        }
        return saveFlag;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> list = new ArrayList<>();
        try{
            Session session = sessionFactory.getCurrentSession();
            Query<AccountEntity> query = session.createQuery("From AccountEntity", AccountEntity.class);
            List<AccountEntity> accounts = query.getResultList();
            for (int i=0; i< accounts.size(); i++) {
                AccountEntity entity = (AccountEntity)accounts.get(i);
                Account account = new Account();
                account.setAccountNo(entity.getAccNo());
                account.setAccountHolderName(entity.getAccHolderName());
                account.setBalance(entity.getBalance());
                account.setDateOfBirth(entity.getDateOfBirth());
                account.setPsCode(entity.getPsCode());
                list.add(account);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
