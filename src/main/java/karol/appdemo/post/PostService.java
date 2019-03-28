package karol.appdemo.post;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    void savePost(Post post);

    List<Post> findAll();
}
