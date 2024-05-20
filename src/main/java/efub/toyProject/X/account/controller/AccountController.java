package efub.toyProject.X.account.controller;

import efub.toyProject.X.account.domain.Account;
import efub.toyProject.X.account.dto.AccountResponseDto;
import efub.toyProject.X.account.dto.SignUpRequestDto;
import efub.toyProject.X.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    // 계정 생성
    @PostMapping
    public AccountResponseDto signUp(@RequestBody @Valid final SignUpRequestDto requestDto){
        Long id = accountService.signup(requestDto); //등록
        Account findAccount = accountService.findAccountById(id);
        return AccountResponseDto.from(findAccount);
    }
}
