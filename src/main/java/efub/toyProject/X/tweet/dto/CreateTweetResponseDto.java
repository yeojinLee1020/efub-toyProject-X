package efub.toyProject.X.tweet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTweetResponseDto {
    // 성공 메시지 반환 dto
    private String message = "성공적으로 트윗이 생성되었습니다";
}
