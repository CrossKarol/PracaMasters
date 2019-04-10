package karol.appdemo.deanGroup;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("deanGroupRepository")
public interface DeanGroupRepository extends JpaRepository<DeanGroup, Integer> {

    @Modifying
    @Query(value = "DELETE FROM deangroup WHERE groupdean_id = :id", nativeQuery = true)
    void deleteDeanGroup(@Param("id") int id);
}
