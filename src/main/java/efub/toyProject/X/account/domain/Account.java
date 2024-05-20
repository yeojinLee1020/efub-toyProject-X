package efub.toyProject.X.account.domain;

import efub.toyProject.X.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", updatable = false)
    private Long accountId;

    @Column(name = "name" , updatable = false, nullable = false, length = 20)
    private String name;

    @Column(name = "nickname" , updatable = false, nullable = false, length = 20)
    private String nickname;

    @Column(name = "email" , updatable = false, nullable = false, length = 50)
    private String email;

    @Column(name = "bio")
    private String bio;

    @Column(name = "password" , updatable = false, nullable = false, length = 20)
    private String password;

    @Builder // 객체 생성
    public Account(String name, String nickname, String email, String bio, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.bio = bio;
        this.password = password;
    }
}
