package karol.appdemo.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Locale;

@Controller
public class PostController {


    @Autowired
    private PostService postService;

    @Autowired
    private MessageSource messageSource;


    @GET
    @RequestMapping(value = "/adminposts")
    public String postForm(Model model) {
        Post u = new Post();
        model.addAttribute("post", u);
        return "adminposts";
    }

    @GET
    @RequestMapping(value = "/userposts")
    public String postFormaAll(Model model) {
        List<Post> postList = postService.findAll();
        model.addAttribute("postList", postList);

        return "userposts";
    }

    @POST
    @RequestMapping(value = "/addpost")
    public String postAction(Post post, BindingResult result, Model model, Locale locale) {

        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Nie wchodzi dalej w ifa");
            returnPage = "adminposts";
        } else {
            postService.savePost(post);
            model.addAttribute("message", messageSource.getMessage("post.added.success", null, locale));
            model.addAttribute("post", new Post());
            returnPage = "adminposts";
        }
        return returnPage;
    }
}
