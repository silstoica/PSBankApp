package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by sstoica on 4/25/2018.
 */

@Entity
@Table(name="account")
public class AccountEntity {
    @Id
    @Column(name="accountNo")
    private int accNo;

    @Column(name="accountHolderName")
    private String accHolderName;

    @Column(name="balance")
    private int balance;

    @Column(name="accountType")
    private String accountType;

    @Column(name="dateOfBirth")
    private Date dateOfBirth;

    @Column(name="psCode")
    private String psCode;

    public AccountEntity(){

    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }
}
