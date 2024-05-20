package efub.toyProject.X.account.controller;

import efub.toyProject.X.account.domain.Account;
import efub.toyProject.X.account.dto.AccountResponseDto;
import efub.toyProject.X.account.dto.SignUpRequestDto;
import efub.toyProject.X.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // 계정 조회
    @GetMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto getAccount(@PathVariable Long accountId) {
        Account findAccount = accountService.findAccountById(accountId);
        return AccountResponseDto.from(findAccount);
    }
}
