package efub.toyProject.X.tweet.repository;

import efub.toyProject.X.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
