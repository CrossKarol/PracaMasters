package karol.appdemo.consultations;


import karol.appdemo.user.User;
import karol.appdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("consultationsService")
@Transactional
public class ConsultationsServiceImpl implements ConsultationsService {

    @Autowired
    private UserService userService;

    @Autowired
    private ConsultationsRepository consultationsRepository;

    @Override
    public void saveConsultations(Consultations consultations) {


        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        consultations.setFrom_user(fromUser);
        consultationsRepository.save(consultations);

    }

    @Override
    public List<Consultations> findAll() {
        List<Consultations> consultationsList = consultationsRepository.findAll();
        return consultationsList;
    }
}
