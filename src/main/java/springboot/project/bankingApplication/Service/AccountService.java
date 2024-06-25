package springboot.project.bankingApplication.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.project.bankingApplication.Model.Account;
import springboot.project.bankingApplication.Repository.AccountRepo;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(Account account){
     return    accountRepo.save(account);
    }

    public Optional<Account> getAccount(Long id){
        return accountRepo.findById(id);
    }

    public Account deposit(Long id,double amount){
        Account account = getAccount(id).orElseThrow(()->new RuntimeException("Account not Found"));
        account.setBalance(account.getBalance()+amount);
        return accountRepo.save(account);
    }
    public  Account withDraw(Long id,double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance()<amount){
            System.out.println("There isn't enough money to withdraw");
        }else {
            account.setBalance(account.getBalance()-amount);

        }
        return accountRepo.save(account);
    }

}
