package karol.appdemo.consultations;


import java.util.List;

public interface ConsultationsService {

    void saveConsultations(Consultations consultations);

    List<Consultations> findAll();

    List<Consultations> findAllMyConsultationsProfZero();

    List<Consultations> findAllMyConsultationsProfOne();

    List<Consultations> findAllMyConsultationsProfTwo();

    List<Consultations> findAllMyConsultationsStudentZero();

    List<Consultations> findAllMyConsultationsStudentOne();

    List<Consultations> findAllMyConsultationsStudentTwo();

    void akceptConsultation(int id, int akceptationCode);

    void noakceptConsultation(int id, int akceptationCode);

    void updateMessageFeedback(int id, String messageFeed);
}
