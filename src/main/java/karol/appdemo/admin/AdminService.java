package karol.appdemo.admin;

import karol.appdemo.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;


public interface AdminService {

    Page<User> findAll(Pageable pageable);
    User findUserById(int id);
    void updateUser(int id, int nrRoli, int activity);
    List<User> findAllSearch(String param);
    void insertInBatch(List<User> userList);
    void saveAll(List<User> userList);
    void deleteUserById(int id);
}