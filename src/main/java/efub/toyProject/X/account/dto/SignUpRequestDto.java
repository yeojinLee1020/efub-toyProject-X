package efub.toyProject.X.account.dto;

import efub.toyProject.X.account.domain.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDto {

    @NotBlank(message = "이름은 필수입니다")
    private String name;

    @NotBlank(message = "닉네임은 필수입니다")
    private String nickname;

    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "유효하지 않은 이메일 형식입니다.",
            regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    private String bio;

    @NotBlank(message = "비밀번호는 필수입니다")
    private String password;

    @Builder
    public SignUpRequestDto(String name, String nickname, String email, String bio, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.bio = bio;
        this.password = password;
    }

    public Account toEntity() {
        return Account.builder()
                .name(this.name)
                .nickname(this.nickname)
                .email(this.email)
                .bio("hello!")
                .password(this.password)
                .build();
    }
}
