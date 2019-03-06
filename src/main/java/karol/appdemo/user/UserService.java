package karol.appdemo.user;

public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
    public void updateUserPassword(String newPassword, String email);
}
