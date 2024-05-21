package efub.toyProject.X.tweet.service;

import efub.toyProject.X.account.domain.Account;
import efub.toyProject.X.account.service.AccountService;
import efub.toyProject.X.tweet.domain.Tweet;
import efub.toyProject.X.tweet.dto.TweetRequestDto;
import efub.toyProject.X.tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TweetService {
    private final AccountService accountService;
    private final TweetRepository tweetRepository;

    //계정 생성
    public Tweet createNewTweet(TweetRequestDto requestDto){
        Account account = accountService.findAccountById(Long.parseLong(requestDto.getAccountId()));
        Tweet tweet = requestDto.toEntity(account);
        Tweet savedTweet = tweetRepository.save(tweet);
        return savedTweet;
    }

    // 트윗 목록 조회시 모든 트윗 가져오는 메서드
    public List<Tweet> findAllTweets() {
        List<Tweet> tweets = tweetRepository.findAll();
        return tweets;
    }
}
