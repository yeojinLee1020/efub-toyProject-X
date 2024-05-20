package efub.toyProject.X.account.repository;

import efub.toyProject.X.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsByEmail(String email);
}
