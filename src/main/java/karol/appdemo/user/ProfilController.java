package karol.appdemo.user;


import karol.appdemo.post.Post;
import karol.appdemo.utilities.UserUtilities;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import validators.ChangePasswordValidator;
import validators.EditUserProfileValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ProfilController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfilController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    @GET
    @RequestMapping(value = "/profilusers")
    public String showUserProfilePage(Model model)
    {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        int nrRoli = user.getRoles().iterator().next().getId();
        user.setNrRoli(nrRoli);
        byte[] encoded=Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);

        model.addAttribute("user", user);
        return "profilusers";
    }
    @GET
    @RequestMapping(value = "/profilprof")
    public String showProfProfilePage(Model model)
    {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        int nrRoli = user.getRoles().iterator().next().getId();
        user.setNrRoli(nrRoli);
        byte[] encoded=Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);
        return "profilprof";
    }

    @GET
    @RequestMapping(value = "/editpassword")
    public String editUserPassword(Model model)
    {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);
        return "editpassword";
    }

    @POST
    @RequestMapping(value = "/updatepass")
    public String changeUSerPassword(User user, BindingResult result, Model model, Locale locale) {
        String returnPage = null;
        new ChangePasswordValidator().validate(user, result);
        new ChangePasswordValidator().checkPasswords(user.getNewPassword(), result);
        if (result.hasErrors()) {
            returnPage = "editpassword";
        } else {
            userService.updateUserPassword(user.getNewPassword(), user.getEmail());
            returnPage = "editpassword";
            model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
        }
        return returnPage;
    }

    @GET
    @RequestMapping(value = "/editprofilusers")
    public String changeUserData(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        byte[] encoded=Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);
        return "editprofilusers";
    }
    @GET
    @RequestMapping(value = "/editprofilprof")
    public String changeProfData(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        byte[] encoded=Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);
        return "editprofilprof";
    }


    @GET
    @RequestMapping(value = "/updateprofilusers")
    public String changeUserDataAction(User user, BindingResult result, Model model, Locale locale) {
        LOG.info("**** WYWOŁANO > updateprofiluser()");
        user.setFileName(user.getPhoto().getOriginalFilename());
        try {
            user.setData(user.getPhoto().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setFileType(user.getPhoto().getContentType());
        LOG.info(user.getData().toString());
        LOG.info(user.getFileName());
        LOG.info(user.getFileType());

        String returnPage = null;
        new EditUserProfileValidator().validate(user, result);
        if(result.hasErrors()) {
            returnPage = "editprofilusers";
        }else {
            userService.updateUserProfile(user.getName(), user.getLastName(), user.getEmail(), user.getKierunek(), user.getGroupLab(), user.getId());
            userService.updatePhoto(user.getFileName(),user.getFileType(),user.getData(),user.getId());
            model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
            returnPage = "afteredit";
        }
        return returnPage;
    }

    @GET
    @RequestMapping(value = "/updateprofilprof")
    public String changeProfDataAction(User user, BindingResult result, Model model, Locale locale) {
        LOG.info("**** WYWOŁANO > updateprofiluser()");
        user.setFileName(user.getPhoto().getOriginalFilename());
        try {
            user.setData(user.getPhoto().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setFileType(user.getPhoto().getContentType());
        LOG.info(user.getData().toString());
        LOG.info(user.getFileName());
        LOG.info(user.getFileType());
        String returnPage = null;
        new EditUserProfileValidator().validate(user, result);
        if(result.hasErrors()) {
            returnPage = "updateprofilprof";
        }else {
            userService.updateProfProfile(user.getName(), user.getLastName(), user.getEmail(), user.getKonsultacje(), user.getPhone(), user.getTitleP(), user.getMyPage(), user.getInfoStudent(), user.getRoom(), user.getId());
            userService.updatePhoto(user.getFileName(),user.getFileType(),user.getData(),user.getId());
            model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
            returnPage = "afteredit";
        }
        return returnPage;
    }


    @GET
    @RequestMapping(value = "/listprofesor")
    public String openListAllProf(Model model) {

        List<User> tmpListProf = new ArrayList<>();

        List<User> userList = userRepository.findAll();
        for(int i = 0; i < userList.size(); i++)
        {
            if(userList.get(i).getRoles().iterator().next().getRole().equals("ROLE_PROFESOR"))
            {
                tmpListProf.add(userList.get(i));
            }
        }
        model.addAttribute("userList", tmpListProf);
        return "listprofesor";
    }
}
