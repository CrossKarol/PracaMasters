package karol.appdemo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;

import static java.awt.Event.LOAD_FILE;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //Sprawddza czy istnieje juz taki email
    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }


//    Odbieramy aktualne hasło, szyfrujemy, i ustawiamy acitve
//    Odczytujemy id role, findbyrole zwróci id roli, ustawiamy wartość tej roli
//    Odbiera poszczególne elemnty obiektu user i odpowiednio je zapisuje w kolumnach w danej tablicy
//    Jest to ogólny zapis Usera
    @Override
    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(0);
        user.setActivationCode("Kod aktywacyjny");
        user.setKonsultacje("Godziny Konsultacji");
        user.setPhone("Numer telefonu");
        user.setTitleP("Stopień Naukowy");
        user.setMyPage("Strona internetowa");
        user.setInfoStudent("Informacje dla Studenta");
        user.setRoom("Numer pokoju");
        user.setKierunek("kierunek Studiów");
        user.setGroupLab("Grupa Laboratoryjna");
        user.setFileName("Nazwa pliku zdjęcia");
        user.setFileType("Typ pliku zdjęcia");

        Integer actualRola = user.getNrRoli();
        String nowRola = null;
        if(actualRola == 2)
            nowRola = "ROLE_USER";
        else if(actualRola == 1)
            nowRola = "ROLE_PROFESOR";
        Role role = roleRepository.findByRole(nowRola);
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
    }

    @Override
    public void updateUserPassword(String newPassword, String email){
        userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
    }

    @Override
    public void updateUserProfile(String newName, String newLastName, String newEmail, String newKierunek, String newGroupLab, int id) {
        userRepository.updateUserProfile(newName, newLastName, newEmail, newKierunek, newGroupLab, id);
    }


    @Override
    public void updateUserActivation(int activeCode, String activationCode) {
        userRepository.updateActivation(activeCode, activationCode);
    }

    @Override
    public void updateProfProfile(String newName, String newLastName, String newEmail, String newKonsultacje, String newPhone, String newTitleP, String newMyPage, String newInfoStudent, String newRoom, int id) {
        userRepository.updateProfProfile(newName, newLastName, newEmail, newKonsultacje, newPhone, newTitleP, newMyPage, newInfoStudent, newRoom, id);
    }


    @Override
    public String actuallUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

}
