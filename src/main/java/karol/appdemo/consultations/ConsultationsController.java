package karol.appdemo.consultations;


import karol.appdemo.user.User;
import karol.appdemo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ConsultationsController {


    @Autowired
    private ConsultationsService consultationsService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserRepository userRepository;

    @GET
    @RequestMapping(value = "/student/saveconsultations")
    public String consultationsForm(Model model) {
        Consultations consultations = new Consultations();

        List<User> tmpListProf = new ArrayList<>();

        List<User> userList = userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getRoles().iterator().next().getRole().equals("ROLE_PROFESOR")) {
                tmpListProf.add(userList.get(i));
            }
        }

        model.addAttribute("profList", tmpListProf);

        model.addAttribute("consultations", consultations);
        return "student/saveconsultations";
    }

    @GET
    @RequestMapping(value = "/student/myconsultations")
    public String myConsultationsForm(Model model) {
        Consultations u = new Consultations();
        model.addAttribute("consultations", u);
        List<Consultations> consultationsList = consultationsService.findAll();
        model.addAttribute("consultationsList", consultationsList);
        return "student/myconsultations";

    }


    @POST
    @RequestMapping(value = "/student/addconsultations")
    public String consultationsAction(Consultations consultations, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Tutaj mamy błąd bez zapisu.");
            return "student/saveconsultations";
        } else {
            consultationsService.saveConsultations(consultations);
            model.addAttribute("message", messageSource.getMessage("consultations.add.success", null, locale));
            model.addAttribute("consultations", new Consultations());
            returnPage = "student/saveconsultations";
        }
        return returnPage;
    }
}
