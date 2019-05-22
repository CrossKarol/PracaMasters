package karol.appdemo.consultations;


import karol.appdemo.user.User;
import karol.appdemo.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.tools.tree.BinaryLogicalExpression;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ConsultationsController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultationsController.class);

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
        List<Consultations> consultationsListZero = consultationsService.findAllMyConsultationsStudentZero();
        model.addAttribute("consultationsListStudentZero", consultationsListZero);
        List<Consultations> consultationsListOne = consultationsService.findAllMyConsultationsStudentOne();
        model.addAttribute("consultationsListStudentOne", consultationsListOne);
        List<Consultations> consultationsListTwo = consultationsService.findAllMyConsultationsStudentTwo();
        model.addAttribute("consultationsListStudentTwo", consultationsListTwo);
        return "student/myconsultations";

    }

    @GET
    @RequestMapping(value = "/profesor/myconsultationsprof")
    public String myConsultationsFormProf(Model model) {
        Consultations u = new Consultations();
        model.addAttribute("consultations", u);
        List<Consultations> consultationsListZero = consultationsService.findAllMyConsultationsProfZero();
        model.addAttribute("consultationsListProfZero", consultationsListZero);
        List<Consultations> consultationsListOne = consultationsService.findAllMyConsultationsProfOne();
        model.addAttribute("consultationsListProfOne", consultationsListOne);
        List<Consultations> consultationsListTwo = consultationsService.findAllMyConsultationsProfTwo();
        model.addAttribute("consultationsListProfTwo", consultationsListTwo);
        return "profesor/myconsultationsprof";

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
            returnPage = "redirect:/student/saveconsultations";
        }
        return returnPage;
    }


    @POST
    @RequestMapping(value = "/profesor/myconsultationsprof/akceptation/{id}")
    public String akceptationConsultation(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> ConsultationsController.skceptationConsulation > PARAMETR: " + id);
        consultationsService.akceptConsultation(id, 1);
        return "redirect:/profesor/myconsultationsprof";
    }
    @POST
    @RequestMapping(value = "/profesor/myconsultationsprof/noakceptation/{id}")
    public String noakceptationConsultation(Consultations consultations, @PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> ConsultationsController.noakceptationConsultation > PARAMETR: " + id);
        consultationsService.noakceptConsultation(id,2);
        consultationsService.updateMessageFeedback(id, consultations.getMessageFeedback());
        return "redirect:/profesor/myconsultationsprof";
    }

}
