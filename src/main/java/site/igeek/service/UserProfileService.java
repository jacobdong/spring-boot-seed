package site.igeek.service;

import org.springframework.stereotype.Service;
import site.igeek.model.po.document.UserProfile;
import site.igeek.repository.document.UserProfileRepository;

import javax.annotation.Resource;

/**
 * Created by jacobdong on 16/6/5.
 */
@Service
public class UserProfileService {
    @Resource
    UserProfileRepository userProfileRepository;


    public UserProfile getById(String id) {
        return userProfileRepository.findOne(id);
    }


    public UserProfile add(UserProfile userProfile) {
        //TODO 业务检查
        return userProfileRepository.save(userProfile);
    }
}
