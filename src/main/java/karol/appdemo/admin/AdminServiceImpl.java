package karol.appdemo.admin;


import karol.appdemo.user.Role;
import karol.appdemo.user.RoleRepository;
import karol.appdemo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private JpaContext jpaContext;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userList = adminRepository.findAll(pageable);
        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = adminRepository.findUserById(id);
        return user;
    }
    @Override
    public void updateUser(int id, int nrRoli, int activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli, id);
    }

    @Override
    public List<User> findAllSearch(String param) {
        List<User> userList = adminRepository.findAllSearch(param);
        return userList;
    }

    @Override
    public void insertInBatch(List<User> userList) {
        EntityManager em = jpaContext.getEntityManagerByManagedType(User.class);

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            Role role = roleRepository.findByRole("ROLE_USER");
            u.setRoles(new HashSet<Role>(Arrays.asList(role)));
            u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
            em.persist(u);
            if (i % 50 == 0 && i > 0) {
                em.flush();
                em.clear();
                System.out.println("**** Załadowano " + i + " rekordów z " + userList.size() );
            }
        }
    }
    public void saveAll(List<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            Role role = roleRepository.findByRole("ROLE_USER");
            userList.get(i).setRoles(new HashSet<Role>(Arrays.asList(role)));
            userList.get(i).setPassword(bCryptPasswordEncoder.encode(userList.get(i).getPassword()));
        }
        adminRepository.saveAll(userList);
    }

}
