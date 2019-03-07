package karol.appdemo.admin;

import karol.appdemo.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AdminService {

    Page<User> findAll(Pageable pageable);
    User findUserById(int id);
    void updateUser(int id, int nrRoli, int activity);
}