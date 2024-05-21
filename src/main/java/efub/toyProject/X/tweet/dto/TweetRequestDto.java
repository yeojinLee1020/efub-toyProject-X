package efub.toyProject.X.tweet.dto;

import efub.toyProject.X.account.domain.Account;
import efub.toyProject.X.tweet.domain.Tweet;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetRequestDto {

    @NotBlank(message = "계정 Id는 필수입니다.")
    private String accountId;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    public Tweet toEntity(Account account){
        return Tweet.builder()
                .account(account)
                .content(this.content)
                .build();
    }


}
