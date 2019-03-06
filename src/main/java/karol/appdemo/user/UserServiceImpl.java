package karol.appdemo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

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
        user.setActive(1);
        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
    }

    @Override
    public void updateUserPassword(String newPassword, String email){
        userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
    }

    @Override
    public void updateUserProfile(String newName, String newLastName, String newEmail, int id) {
        userRepository.updateUserProfile(newName, newLastName, newEmail, id);
    }
}
