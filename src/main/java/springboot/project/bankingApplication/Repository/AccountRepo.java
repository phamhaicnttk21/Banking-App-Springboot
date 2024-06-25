package springboot.project.bankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.project.bankingApplication.Model.Account;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
