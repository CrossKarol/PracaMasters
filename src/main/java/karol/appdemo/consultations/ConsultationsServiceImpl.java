package karol.appdemo.consultations;


import karol.appdemo.user.User;
import karol.appdemo.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("consultationsService")
@Transactional
public class ConsultationsServiceImpl implements ConsultationsService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultationsServiceImpl.class);

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
        consultations.setMessageFeedback("Odpowiedź zwrotna dla studenta");
        consultationsRepository.save(consultations);

    }

    @Override
    public List<Consultations> findAll() {
        List<Consultations> consultationsList = consultationsRepository.findAll();
        return consultationsList;
    }

    @Override
    public List<Consultations> findAllMyConsultationsProfZero() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getTo_profesor().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 0) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }



    @Override
    public List<Consultations> findAllMyConsultationsProfOne() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getTo_profesor().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 1) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }

    @Override
    public List<Consultations> findAllMyConsultationsProfTwo() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getTo_profesor().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 2) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }

    @Override
    public List<Consultations> findAllMyConsultationsStudentZero() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getFrom_user().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 0) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }

    @Override
    public List<Consultations> findAllMyConsultationsStudentOne() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getFrom_user().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 1) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }

    @Override
    public List<Consultations> findAllMyConsultationsStudentTwo() {

        List<Consultations> myConsultationsListProf = new ArrayList<>();
        List<Consultations> consultationsList = consultationsRepository.findAll();
        String b = userService.actuallUser();
        User user = userService.findUserByEmail(b);
        String fromUser = user.toString();

        for (int i = 0; i < consultationsList.size(); i++) {
            if (consultationsList.get(i).getFrom_user().equals(fromUser)) {
                if(consultationsList.get(i).getAkceptation() == 2) {
                    myConsultationsListProf.add(consultationsList.get(i));
                }
            }
        }
        return myConsultationsListProf;
    }



    @Override
    public void akceptConsultation(int id, int akceptationCode) {
        LOG.debug("[WYWOŁANIE >>> ConsultationsServiceImpl.akceptConsultations > PARAMETR: " + id);
        consultationsRepository.updateAkceptation(id, 1);
    }

    @Override
    public void noakceptConsultation(int id, int akceptationCode) {
        LOG.debug("[WYWOŁANIE >>> ConsultationsServiceImpl.noakceptConsultations > PARAMETR: " + id);
        consultationsRepository.updateAkceptation(id, 2);

    }

    @Override
    public void updateMessageFeedback(int id, String messageFeed) {
        LOG.debug("[WYWOŁANIE >>> ConsultationsServiceImpl.updateMessageFeedback > PARAMETR: " + id);
        consultationsRepository.updateFeedback(id, messageFeed);
    }


}
