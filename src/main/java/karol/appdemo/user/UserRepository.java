package karol.appdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);




    @Modifying
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email")
    public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail, u.kierunek = :newKierunek, u.groupLab = :newGroupLab WHERE u.id= :id")
    public void updateUserProfile(@Param("newName") String newName, @Param("newLastName") String newLastName,
                                  @Param("newEmail") String newEmail, @Param("newKierunek") String newKierunek,
                                  @Param("newGroupLab") String newGroupLab, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE User u SET u.active = :activeParam WHERE u.activationCode = :activationCode")
    public void updateActivation(@Param("activeParam") int activeParam, @Param("activationCode") String activationCode);


    @Modifying
    @Query("UPDATE User u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail, u.konsultacje = :newKonsultacje, " +
            "u.phone = :newPhone, u.titleP = :newTitleP, u.myPage = :newMyPage, u.infoStudent = :newInfoStudent, u.room = :newRoom WHERE u.id= :id")
    public void updateProfProfile(@Param("newName") String newName, @Param("newLastName") String newLastName,
                                  @Param("newEmail") String newEmail, @Param("newKonsultacje") String newKonsultacje,
                                  @Param("newPhone") String newPhone, @Param("newTitleP") String newTitleP,
                                  @Param("newMyPage") String newMyPage, @Param("newInfoStudent") String newInfoStudent,
                                  @Param("newRoom") String newRoom, @Param("id") Integer id);
}
