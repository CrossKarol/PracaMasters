package validators;

import karol.appdemo.constans.AppDemoConstatns;
import karol.appdemo.user.User;
import karol.appdemo.utilities.AppdemoUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls){
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors){
        @SuppressWarnings("unused")
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");

    }

    public void checkPasswords(String newPass, Errors errors){

        if(!newPass.equals(null)) {
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(AppDemoConstatns.PASSWORD_PATTERN, newPass);
            if(!isMatch) {
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
            }
        }
    }
}
