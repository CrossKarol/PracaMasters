package karol.appdemo.spotted;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("spottedCommentRepository")
public interface SpottedCommentRepository extends JpaRepository<SpottedComment, Integer> {

    @Modifying
    @Query("UPDATE SpottedComment u SET u.spottedLikeComment = :akceptationParam3 WHERE spotted_comment_id = :id")
    void countLike(@Param("id") int id, @Param("akceptationParam3") int akceptationParam);


    @Modifying
    @Query("UPDATE SpottedComment u SET u.spottedDislikeComment = :akceptationParam4 WHERE spotted_comment_id = :id")
    void countDislike(@Param("id") int id, @Param("akceptationParam4") int akceptationParam);
}
