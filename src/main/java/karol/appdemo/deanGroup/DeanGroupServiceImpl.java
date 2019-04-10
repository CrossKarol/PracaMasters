package karol.appdemo.deanGroup;

import karol.appdemo.admin.AdminServiceImpl;
import karol.appdemo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service("deanGroupService")
@Transactional
public class DeanGroupServiceImpl implements DeanGroupService {

    private static final Logger LOG = LoggerFactory.getLogger(DeanGroupServiceImpl.class);

    @Autowired
    private DeanGroupRepository deanGroupRepository;


    @Override
    public void saveDeanGroup(DeanGroup deanGroup) {
        deanGroupRepository.save(deanGroup);
    }

    @Override
    public Page<DeanGroup> findAll(Pageable pageable) {
        Page<DeanGroup> deanGroupList = deanGroupRepository.findAll(pageable);
        return deanGroupList;
    }

    @Override
    public void deleteDeanGroupById(int id) {
        LOG.debug("[WYWOŁANIE >>> DeanGroupServiceImpl.deleteDeanGroupById > PARAMETR: " + id);
        deanGroupRepository.deleteDeanGroup(id);
    }

    @Override
    public List<DeanGroup> findAll() {
        List<DeanGroup> deanGroupList = deanGroupRepository.findAll();
        return deanGroupList;
    }

}
