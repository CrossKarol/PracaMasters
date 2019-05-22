package karol.appdemo.post;


import karol.appdemo.user.User;
import karol.appdemo.user.UserService;
import karol.appdemo.utilities.UserUtilities;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);


    @Autowired
    private PostService postService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;


    @GET
    @RequestMapping(value = "/admin/adminposts")
    public String postFormAdmin(Model model) {

        Post u = new Post();
        model.addAttribute("post", u);
        List<Post> postList = postService.findAll();
        byte[] encoded;
        for(Post a:postList) {
            encoded = Base64.encodeBase64(a.getData());
            a.setImage(new String(encoded));
        }
        model.addAttribute("postList", postList);
        return "/admin/adminposts";
    }
    @GET
    @RequestMapping(value = "/profesor/profesorposts")
    public String postFormProfesor(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        List<Post> tmpListPost = new ArrayList<>();
        Post u = new Post();
        model.addAttribute("post", u);
        List<Post> postList = postService.findAll();
        byte[] encoded;
        for(Post a:postList) {
            encoded = Base64.encodeBase64(a.getData());
            a.setImage(new String(encoded));
        }
        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getAuthor().equals(user.toString())) {
                tmpListPost.add(postList.get(i));
            }
        }
        model.addAttribute("postList", tmpListPost);
        return "/profesor/profesorposts";
    }

    @GET
    @RequestMapping(value = "/student/userposts")
    public String postFormaAll(Model model) {
        List<Post> postList = postService.findAll();
        byte[] encoded;
        for(Post u:postList) {
            encoded = Base64.encodeBase64(u.getData());
            u.setImage(new String(encoded));
        }

        model.addAttribute("postList", postList);



        return "/student/userposts";
    }

    @POST
    @RequestMapping(value = "/profesor/addpost")
    public String postAction(Post post, BindingResult result, Model model, Locale locale) {

        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Nie wchodzi dalej w ifa");
            returnPage = "/profesor/profesorposts";
        } else {
            postService.savePost(post);
            model.addAttribute("message", messageSource.getMessage("post.added.success", null, locale));
            model.addAttribute("post", new Post());
            returnPage = "/profesor/profesorposts";
        }
        return returnPage;
    }

    @POST
    @RequestMapping(value = "/admin/addpost")
    public String postActionAdmin(Post post, BindingResult result, Model model, Locale locale) {

        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Nie wchodzi dalej w ifa");
            returnPage = "/admin/adminposts";
        } else {
            postService.savePost(post);
            model.addAttribute("message", messageSource.getMessage("post.added.success", null, locale));
            model.addAttribute("post", new Post());
            returnPage = "/admin/adminposts";
        }
        return returnPage;
    }


    @DELETE
    @RequestMapping(value = "/profesor/profesorposts/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> PostControler.deletePost > PARAMETR: " + id);
        postService.deletePostById(id);
        return "redirect:/profesor/profesorposts";
    }

    @DELETE
    @RequestMapping(value = "/admin/adminposts/delete/{id}")
    public String deletePostAdmin(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> PostControler.deletePost > PARAMETR: " + id);
        postService.deletePostById(id);
        return "redirect:/admin/adminposts";
    }

}
