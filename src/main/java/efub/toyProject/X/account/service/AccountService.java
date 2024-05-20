package efub.toyProject.X.account.service;

import efub.toyProject.X.account.domain.Account;
import efub.toyProject.X.account.dto.SignUpRequestDto;
import efub.toyProject.X.account.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;
    public Long signup(SignUpRequestDto requestDto) {
        if (existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 email입니다." + requestDto.getEmail());
        }
        Account account = accountRepository.save(requestDto.toEntity());
        return account.getAccountId();
    }

    private boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 Account를 찾을 수 없습니다.id="+id));
    }
}
