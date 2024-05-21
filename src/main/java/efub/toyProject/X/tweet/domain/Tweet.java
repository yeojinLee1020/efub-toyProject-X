package efub.toyProject.X.tweet.domain;

import efub.toyProject.X.account.domain.Account;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id",updatable = false)
    private Long tweetId;

    @ManyToOne
    @JoinColumn(name = "account_id", updatable = false)
    private Account account;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime postDate;

    @Builder
    public Tweet(Account account, String content, LocalDateTime postDate) {
        this.account = account;
        this.content = content;
        this.postDate = postDate;
    }
}
