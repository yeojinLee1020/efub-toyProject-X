package efub.toyProject.X.tweet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllTweetsResponseDto {
    private List<TweetResponseDto> tweets;
}
