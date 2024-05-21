package efub.toyProject.X.tweet.controller;

import efub.toyProject.X.tweet.domain.Tweet;
import efub.toyProject.X.tweet.dto.AllTweetsResponseDto;
import efub.toyProject.X.tweet.dto.CreateTweetResponseDto;
import efub.toyProject.X.tweet.dto.TweetRequestDto;
import efub.toyProject.X.tweet.dto.TweetResponseDto;
import efub.toyProject.X.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    // 트윗 전체 조회
    @GetMapping()
    public AllTweetsResponseDto getAllTweets(){
        List<TweetResponseDto> list = new ArrayList<>();
        List<Tweet> tweets = tweetService.findAllTweets();
        for (Tweet tweet : tweets) {
            TweetResponseDto dto = TweetResponseDto.from(tweet, tweet.getAccount().getNickname());
            list.add(dto);
        }
         return new AllTweetsResponseDto(list);
    }

    // 트윗 상세 조회
    @GetMapping("/{tweetId}")
    public TweetResponseDto getOneTweet(@PathVariable(name = "tweetId") Long tweetId){
        Tweet tweet = tweetService.findTweetById(tweetId);
        return TweetResponseDto.from(tweet, tweet.getAccount().getNickname());
    }

}
