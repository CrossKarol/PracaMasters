package karol.appdemo.spotted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("spottedPostRepository")
public interface SpottedPostRepository extends JpaRepository<SpottedPost, Integer> {

    @Modifying
    @Query("UPDATE SpottedPost u SET u.spottedLike = :akceptationParam WHERE spotted_post_id = :id")
    void countLike(@Param("id") int id, @Param("akceptationParam") int akceptationParam);


    @Modifying
    @Query("UPDATE SpottedPost u SET u.spottedDislike = :akceptationParam1 WHERE spotted_post_id = :id")
    void countDislike(@Param("id") int id, @Param("akceptationParam1") int akceptationParam);
}
