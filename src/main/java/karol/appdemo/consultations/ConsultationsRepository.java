package karol.appdemo.consultations;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("consultationsRepository")
public interface ConsultationsRepository extends JpaRepository<Consultations, Integer> {
}
