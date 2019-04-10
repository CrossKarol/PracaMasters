package karol.appdemo.consultations;


import java.util.List;

public interface ConsultationsService {

    void saveConsultations(Consultations consultations);

    List<Consultations> findAll();
}
