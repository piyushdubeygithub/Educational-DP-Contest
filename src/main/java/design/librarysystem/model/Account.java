package design.librarysystem.model;

import design.librarysystem.enums.AccountStatus;

public class Account {
    private Integer id;
    private AccountStatus accountStatus;

    public boolean resetPassword(){
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
