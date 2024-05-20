package efub.toyProject.X.account.dto;

import efub.toyProject.X.account.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String name;
    private String nickname;
    private String email;
    private String bio;


    public AccountResponseDto(Long accountId, String name, String nickname, String email, String bio) {
        this.accountId = accountId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.bio = bio;
    }

    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(
                account.getAccountId(),
                account.getName(),
                account.getNickname(),
                account.getEmail(),
                account.getBio());
    }
}
