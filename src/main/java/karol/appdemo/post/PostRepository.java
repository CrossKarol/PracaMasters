package karol.appdemo.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {


    @Modifying
    @Query(value = "DELETE FROM post WHERE post_id = :id", nativeQuery = true)
    void deletePost(@Param("id") int id);

}
