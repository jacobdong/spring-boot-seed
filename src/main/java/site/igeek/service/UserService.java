package site.igeek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import site.igeek.convert.PaginationDataConvert;
import site.igeek.model.common.PaginationData;
import site.igeek.model.po.User;
import site.igeek.repository.UserRepository;

import javax.annotation.Resource;

/**
 * Created by jacobdong on 16/5/5.
 */
@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    public PaginationData<User> getUsers(int pageIndex, int pageSize, Sort sort) {
        PageRequest pageable = new PageRequest(pageIndex - 1, pageSize, sort);
        Page userPage = userRepository.findAll(pageable);
        return PaginationDataConvert.convertJpaPage2PaginationData(userPage, pageSize);
    }


    public User getUser(String userId) {
        return userRepository.findOne(userId);
    }

}
