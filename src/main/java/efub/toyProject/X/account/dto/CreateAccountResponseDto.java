package efub.toyProject.X.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAccountResponseDto {
    // 성공 메시지 반환 dto
    private String message = "성공적으로 계정이 생성되었습니다";
}
