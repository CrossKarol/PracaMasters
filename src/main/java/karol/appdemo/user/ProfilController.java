package karol.appdemo.user;


import karol.appdemo.utilities.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService;

    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfilePage(Model model)
    {
        String username = UserUtilities.getLoggedUser();

        User user = userService.findUserByEmail(username);

        int nrRoli = user.getRoles().iterator().next().getId();

        user.setNrRoli(nrRoli);

        model.addAttribute("user", user);

        return "profil";
    }
}
