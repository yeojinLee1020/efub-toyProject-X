package efub.toyProject.X.account.dto;

import efub.toyProject.X.account.domain.Account;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String name;
    private String nickname;
    private String email;
    private String bio;
    private LocalDateTime joinDate;


    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(
                account.getAccountId(),
                account.getName(),
                account.getNickname(),
                account.getEmail(),
                account.getBio(),
                account.getJoinDate()
        );
    }
}
