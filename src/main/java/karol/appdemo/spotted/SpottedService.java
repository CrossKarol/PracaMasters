package karol.appdemo.spotted;

import java.util.List;

public interface SpottedService {

    void saveSpottedPost(SpottedPost spottedPost);

    List<SpottedPost> findAll();

    void saveSpottedComment(SpottedComment spottedComment);

    List<SpottedComment> findAllComment();

    void likeSpottedPost(int id, int countLike);

    void dislikeSpottedPost(int id, int countDislike);

    void likeSpottedComment(int id, int countLikeComment);

    void dislikeSpottedComment(int id, int countDislikeComment);


}
