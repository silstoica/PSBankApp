package model;

import org.springframework.format.annotation.DateTimeFormat;
import validations.PSCode;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by sstoica on 4/20/2018.
 */
public class Account {

    @NotNull(message = "Number can't be blank")
    private Integer accountNo;

    @NotNull(message = "Name can't be blank")
    @Size(min = 2, max = 50, message = "Invalid length for name")
    @Pattern(regexp = "[A-Za-z(\\s)]+", message = "Invalid name")
    private String accountHolderName;

    @NotNull(message = "Balance is required")
    @Min(value = 5000, message = "Minimum balance must be greater than 5000")
    private Integer balance;

    @NotNull(message = "Type can't be blank")
    private String accountType;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "Date can't be blank")
    @Past(message = "Date must be before present moment")
    private Date dateOfBirth;

    @NotNull(message = "PS code is required")
    @PSCode
    private String psCode;



    public Account(){
        accountNo = 0;
        accountHolderName = "";
        balance = 0;
    }
    public Account(Integer accountNo, String accountHolderName, Integer balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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
