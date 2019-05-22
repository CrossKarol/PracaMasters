package karol.appdemo.spotted;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Locale;

@Controller
public class SpottedController {


    @Autowired
    private SpottedService spottedService;
    @Autowired
    private MessageSource messageSource;


    @GET
    @RequestMapping(value = "/spottedall")
    public String spottedForm(Model model) {
        SpottedPost spottedPost = new SpottedPost();
        model.addAttribute("spottedPost", spottedPost);
        SpottedComment spottedComment = new SpottedComment();
        model.addAttribute("spottedComment", spottedComment);

        List<SpottedPost> spottedPostList = spottedService.findAll();
        byte[] encoded;
        for(SpottedPost a:spottedPostList) {
            encoded = Base64.encodeBase64(a.getData());
            a.setImage(new String(encoded));
        }
        List<SpottedComment> spottedCommentList = spottedService.findAllComment();
        byte[] encoded1;
        for(SpottedComment a:spottedCommentList) {
            encoded1 = Base64.encodeBase64(a.getData());
            a.setImage(new String(encoded1));
        }
        model.addAttribute("spottedPostList", spottedPostList);
        model.addAttribute("spottedCommentList", spottedCommentList);

        return "/spottedall";
    }

    @POST
    @RequestMapping(value = "/addpostspotted")
    public String postAction(SpottedPost spottedPost, BindingResult result, Model model, Locale locale) {

        String returnPage = null;

        if (result.hasErrors()) {
            returnPage = "/spottedall";
        } else {

            spottedService.saveSpottedPost(spottedPost);

            model.addAttribute("message", messageSource.getMessage("post.added.success", null, locale));
            model.addAttribute("postSpotted", new SpottedPost());
            returnPage = "/spottedall";
        }
        return returnPage;
    }
    @POST
    @RequestMapping(value = "/addcommentspotted")
    public String postActionComment(SpottedComment spottedComment, BindingResult result, Model model, Locale locale) {

        String returnPage = null;

        if (result.hasErrors()) {
            returnPage = "/spottedall";
        } else {

            spottedService.saveSpottedComment(spottedComment);

            model.addAttribute("commentSpotted", new SpottedComment());
            returnPage = "/spottedall";
        }
        return returnPage;
    }

    @POST
    @RequestMapping(value = "/spottedall/likepost/{id}")
    public String likePost(SpottedPost spottedPost, @PathVariable("id") int id) {

        spottedService.likeSpottedPost(id,  spottedPost.getSpottedLike());

        return "redirect:/spottedall";
    }

    @POST
    @RequestMapping(value = "/spottedall/dislikepost/{id}")
    public String dislikePost(SpottedPost spottedPost, @PathVariable("id") int id) {

        spottedService.dislikeSpottedPost(id, spottedPost.getSpottedDislike());

        return "redirect:/spottedall";
    }

    @POST
    @RequestMapping(value = "/spottedall/likecomment/{id}")
    public String likeComment(SpottedComment spottedComment, @PathVariable("id") int id) {

        spottedService.likeSpottedComment(id,  spottedComment.getSpottedLikeComment());

        return "redirect:/spottedall";
    }

    @POST
    @RequestMapping(value = "/spottedall/dislikecomment/{id}")
    public String dislikeComment(SpottedComment spottedComment, @PathVariable("id") int id) {

        spottedService.dislikeSpottedComment(id, spottedComment.getSpottedDislikeComment());

        return "redirect:/spottedall";
    }

}
