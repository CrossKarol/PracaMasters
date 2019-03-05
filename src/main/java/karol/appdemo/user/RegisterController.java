package karol.appdemo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import validators.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class RegisterController {

//   Auto owijanie, zmienna userServie
    @Autowired
    private UserService userService;
//   Pozwala pobierać komunikaty z messageSource z kodu Java
    @Autowired
    MessageSource messageSource;


    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "register";
    }

//    Ma się wywołac adduser w naszym formularzu
//    Metoda registerAction obsługuje to wywołanie
//    Adnotacja post z tego samego pakietu co get, coś wkładamy do bazy
//    Metoda przyjmuje 4 argumenty: result - walidacja, model - dorzucamy cos po walidacji
//    returnPage - nazwa strony
//    sprawdzenie czy adres email już istnieje
//    wywołanie walidatora
//    ify, 1 - mam taki email. wywołuje messageSource, getmessage i rzucam błąd, null i z jakiego języka mam rzucic error

    @POST
    @RequestMapping(value = "/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        User userExist = userService.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validate(user, result);

        if(userExist != null) {
            result.rejectValue("email", messageSource.getMessage("error.userEmailExist", null, locale));
        }
        if(result.hasErrors()) {
            returnPage = "register";
//            Jeśli są błędy wracamy do /register
        }else {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("user", new User());
            returnPage = "register";
        }
        return returnPage;
    }
}