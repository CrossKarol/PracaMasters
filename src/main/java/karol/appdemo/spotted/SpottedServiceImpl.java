package karol.appdemo.spotted;


import karol.appdemo.user.User;
import karol.appdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("spottedService")
@Transactional
public class SpottedServiceImpl implements SpottedService {

    @Autowired
    private SpottedPostRepository spottedPostRepository;

    @Autowired
    private SpottedCommentRepository spottedCommentRepository;

    @Autowired
    private UserService userService;


    @Override
    public void saveSpottedPost(SpottedPost spottedPost) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss a");
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String autor = user.toString();
        spottedPost.setAuthor(autor);
        spottedPost.setCreateOn(ft.format(dNow));
        spottedPost.setData(user.getData());
        spottedPostRepository.save(spottedPost);
    }


    @Override
    public void saveSpottedComment(SpottedComment spottedComment) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss a");
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String autor = user.toString();
        spottedComment.setAuthor(autor);
        spottedComment.setCreateOn(ft.format(dNow));
        spottedComment.setData(user.getData());
        spottedCommentRepository.save(spottedComment);
    }

    @Override
    public List<SpottedComment> findAllComment() {
        List<SpottedComment> spottedCommentList = spottedCommentRepository.findAll();
        return spottedCommentList;
    }

    @Override
    public void likeSpottedPost(int id, int countLike) {
        spottedPostRepository.countLike(id, countLike);
    }

    @Override
    public void dislikeSpottedPost(int id, int countDislike) {
        spottedPostRepository.countDislike(id, countDislike);
    }

    @Override
    public void likeSpottedComment(int id, int countLikeComment) {
        spottedCommentRepository.countLike(id, countLikeComment);
    }

    @Override
    public void dislikeSpottedComment(int id, int countDislikeComment) {
        spottedCommentRepository.countDislike(id, countDislikeComment);
    }

    @Override
    public List<SpottedPost> findAll() {
        List<SpottedPost> spottedPostList = spottedPostRepository.findAll();
        return spottedPostList;
    }

}
