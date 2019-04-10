package karol.appdemo.deanGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Locale;

@Controller
public class DeanGroupController {

    private static final Logger LOG = LoggerFactory.getLogger(DeanGroupController.class);
    private static int ELEMENTS = 10;

    @Autowired
    private DeanGroupService deanGroupService;

    @Autowired
    private MessageSource messageSource;


    @GET
    @RequestMapping(value = "/admin/deangroup/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String deanGroupForm(@PathVariable("page") int page, Model model) {

        LOG.info("**** WYWOŁANO > deanGroupForm(" + page + ", "+ model + ")");
        Page<DeanGroup> pages = getAllDeanGroupPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<DeanGroup> deanGroupList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("deanGroupList", deanGroupList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);

        return "admin/deangroup";

    }


    @POST
    @RequestMapping(value = "/admin/deangroup/adddeangroup")
    public String deanGroupAction(DeanGroup deanGroup, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Tutaj mamy błąd bez zapisu.");
            return "/admin/deangroup/1";
        } else {
            deanGroupService.saveDeanGroup(deanGroup);
            model.addAttribute("message", messageSource.getMessage("deangroup.add.success", null, locale));
            model.addAttribute("deanGroup", new DeanGroup());
            returnPage = "redirect:/admin/deangroup/1";
        }
        return returnPage;
    }

    @DELETE
    @RequestMapping(value = "/admin/deangroup/delete/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String deleteDeanGroup(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> DeanGroupController.deleteDeanGroup > PARAMETR: " + id);
        deanGroupService.deleteDeanGroupById(id);
        return "redirect:/admin/deangroup/1";
    }

    //Pobranie listy grup laboratoryjnych
    private Page<DeanGroup> getAllDeanGroupPageable(int page){
        Page<DeanGroup> pages = deanGroupService.findAll(PageRequest.of(page, ELEMENTS));
        return pages;
    }




}
