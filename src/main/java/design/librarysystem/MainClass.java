package design.librarysystem;

import design.librarysystem.enums.AccountStatus;
import design.librarysystem.model.Account;

public class MainClass {

    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        System.out.println(account.getAccountStatus().getStatusCode());
    }
}
