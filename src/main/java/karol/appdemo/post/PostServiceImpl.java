package karol.appdemo.post;


import karol.appdemo.user.User;
import karol.appdemo.user.UserRepository;
import karol.appdemo.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    private static final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void savePost(Post post) {

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss a");
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String autor = user.toString();
        System.out.println(autor);


        post.setAuthor(autor);
        post.setCreatedOn(ft.format(dNow));
        post.setData(user.getData());
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    @Override
    public void deletePostById(int id) {
        LOG.debug("[WYWOŁANIE >>> PostServiceImpl.deletePost > PARAMETR: " + id);
        postRepository.deletePost(id);

    }

}