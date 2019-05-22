package karol.appdemo.consultations;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("consultationsRepository")
public interface ConsultationsRepository extends JpaRepository<Consultations, Integer> {



    @Modifying
    @Query("UPDATE Consultations u SET u.akceptation = :akceptationParam WHERE consultations_id = :id")
    void updateAkceptation(@Param("id") int id, @Param("akceptationParam") int akceptationParam);

    @Modifying
    @Query("UPDATE Consultations u SET u.messageFeedback = :messageFeed WHERE consultations_id = :id")
    void updateFeedback(@Param("id") int id, @Param("messageFeed") String messageFeed);

}
