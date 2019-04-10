package karol.appdemo.user;


import karol.appdemo.deanGroup.DeanGroup;
import karol.appdemo.deanGroup.DeanGroupRepository;
import karol.appdemo.utilities.UserUtilities;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private DeanGroupRepository deanGroupRepository;

    @GET
    @RequestMapping(value = "/student/profilusers")
    public String showUserProfilePage(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        int nrRoli = user.getRoles().iterator().next().getId();
        user.setNrRoli(nrRoli);
        byte[] encoded = Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);
        return "student/profilusers";
    }

    @GET
    @RequestMapping(value = "profesor//profilprof")
    public String showProfProfilePage(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        int nrRoli = user.getRoles().iterator().next().getId();
        user.setNrRoli(nrRoli);
        byte[] encoded = Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);
        return "profesor/profilprof";
    }

    @GET
    @RequestMapping(value = "/editpassword")
    public String editUserPassword(Model model) {
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
    @RequestMapping(value = "/student/editprofilusers")
    public String changeUserData(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        byte[] encoded = Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);

        List<DeanGroup> deanGroupList = deanGroupRepository.findAll();

        List<String> departmentString = new ArrayList<>();
        List<String> studyOfFieldString = new ArrayList<>();
        List<String> specializationString = new ArrayList<>();

        departmentString.add(deanGroupList.get(0).getDepartment());
        studyOfFieldString.add(deanGroupList.get(0).getFieldOfStudy());
        specializationString.add(deanGroupList.get(0).getSpecialization());

        boolean flag;
        for (int i = 1; i <
                deanGroupList.size(); i++) {
            flag = true;

            for (int c = 0; c < departmentString.size(); c++) {
                if ((deanGroupList.get(i).getDepartment().equals(departmentString.get(c)))) {
                    flag = false;
                }

            }
            if (flag) {
                departmentString.add(deanGroupList.get(i).getDepartment());
            }
        }
        for (int i = 1; i < deanGroupList.size(); i++) {
            flag = true;
            for (int c = 0; c < studyOfFieldString.size(); c++) {
                if ((deanGroupList.get(i).getFieldOfStudy().equals(studyOfFieldString.get(c)))) {
                    flag = false;
                }

            }
            if (flag) {
                studyOfFieldString.add(deanGroupList.get(i).getFieldOfStudy());
            }
        }
        for (int i = 1; i < deanGroupList.size(); i++) {
            flag = true;
            for (int c = 0; c < specializationString.size(); c++) {
                if ((deanGroupList.get(i).getSpecialization().equals(specializationString.get(c)))) {
                    flag = false;
                }

            }
            if (flag) {
                specializationString.add(deanGroupList.get(i).getSpecialization());
            }
        }

        model.addAttribute("departmentString", departmentString);
        model.addAttribute("studyOfFieldString", studyOfFieldString);
        model.addAttribute("specializationString", specializationString);
        model.addAttribute("deanGroupList", deanGroupList);
        return "student/editprofilusers";
    }

    @GET
    @RequestMapping(value = "/profesor/editprofilprof")
    public String changeProfData(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        byte[] encoded = Base64.encodeBase64(user.getData());
        String encodedString = new String(encoded);
        model.addAttribute("image", encodedString);
        model.addAttribute("user", user);

        return "profesor/editprofilprof";
    }


    @GET
    @RequestMapping(value = "/student/updateprofilusers")
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
        if (result.hasErrors()) {
            LOG.info("Tu jesteś debilu: 1");
            returnPage = "student/editprofilusers";
        } else {
            LOG.info("Tu jesteś debilu: 2");
            userService.updateUserProfile(user.getName(), user.getLastName(), user.getEmail(), user.getKierunek(), user.getGroupLab(), user.getSpecjalizacja(), user.getWydzial(), user.getId());
            userService.updatePhoto(user.getFileName(), user.getFileType(), user.getData(), user.getId());
            model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
            returnPage = "afteredit";
        }
        return returnPage;
    }

    @GET
    @RequestMapping(value = "/profesor/updateprofilprof")
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
        if (result.hasErrors()) {
            returnPage = "updateprofilprof";
        } else {
            userService.updateProfProfile(user.getName(), user.getLastName(), user.getEmail(), user.getKonsultacje(), user.getPhone(), user.getTitleP(), user.getMyPage(), user.getInfoStudent(), user.getRoom(), user.getId());
            userService.updatePhoto(user.getFileName(), user.getFileType(), user.getData(), user.getId());
            model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
            returnPage = "afteredit";
        }
        return returnPage;
    }


    @GET
    @RequestMapping(value = "/student/listprofesor")
    public String openListAllProf(Model model) {

        List<User> tmpListProf = new ArrayList<>();
        byte[] encoded;
        List<User> userList = userRepository.findAll();
        for(User u:userList) {
            encoded = Base64.encodeBase64(u.getData());
            u.setImage(new String(encoded));
        }

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getRoles().iterator().next().getRole().equals("ROLE_PROFESOR")) {
                tmpListProf.add(userList.get(i));
            }
        }
        model.addAttribute("userList", tmpListProf);
        return "student/listprofesor";
    }
}
