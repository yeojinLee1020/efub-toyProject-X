package efub.toyProject.X.tweet.dto;

import efub.toyProject.X.tweet.domain.Tweet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TweetResponseDto {

    private Long tweetId;
    private String writer;
    private String content;
    private LocalDateTime postDate;

    public static TweetResponseDto from(Tweet tweet, String writer){
        return new TweetResponseDto(
                tweet.getTweetId(),
                writer,
                tweet.getContent(),
                tweet.getPostDate()
        );
    }

}
