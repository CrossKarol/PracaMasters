package karol.appdemo.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {
}
