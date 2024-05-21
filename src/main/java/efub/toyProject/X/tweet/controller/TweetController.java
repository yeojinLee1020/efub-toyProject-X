package efub.toyProject.X.tweet.controller;

import efub.toyProject.X.tweet.domain.Tweet;
import efub.toyProject.X.tweet.dto.CreateTweetResponseDto;
import efub.toyProject.X.tweet.dto.TweetRequestDto;
import efub.toyProject.X.tweet.dto.TweetResponseDto;
import efub.toyProject.X.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    // 트윗 생성
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreateTweetResponseDto createTweet(@RequestBody @Valid final TweetRequestDto requestDto){
        Tweet savedTweet = tweetService.createNewTweet(requestDto);
        return new CreateTweetResponseDto();
    }

}
