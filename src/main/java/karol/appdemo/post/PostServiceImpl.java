package karol.appdemo.post;


import karol.appdemo.user.User;
import karol.appdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public void savePost(Post post) {

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss a");
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String autor = user.toString();
        System.out.println(autor);

//        List<Post> postList = postRepository.findAll();
//
//        for(int i = 0; i < postList.size(); i++) {
//            System.out.println(postList.get(i).getAuthor());
//            System.out.println(postList.get(i).getContent());
//        }

        post.setAuthor(autor);
        post.setCreatedOn(ft.format(dNow));
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

}