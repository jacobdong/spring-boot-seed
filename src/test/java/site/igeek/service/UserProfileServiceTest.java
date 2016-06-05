package site.igeek.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.igeek.ApplicationLauncher;
import site.igeek.model.po.document.Gender;
import site.igeek.model.po.document.UserProfile;

import javax.annotation.Resource;

/**
 * Created by jacobdong on 16/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationLauncher.class)
public class UserProfileServiceTest {

    @Resource
    UserProfileService userProfileService;


    @Test
    public void addAndGetTest() {
        UserProfile userProfile = new UserProfile();
        String id = "TEST_ID";

        userProfile.setId(id);
        userProfile.setIntro("介绍说明");
        userProfile.setGender(Gender.MALE);
        userProfile.setName("JacobDong");
        userProfile.setAge(26);

        userProfileService.add(userProfile);


        UserProfile userProfileExist = userProfileService.getById(id);

        Assert.assertEquals(userProfile.getIntro(), userProfileExist.getIntro());
        Assert.assertEquals(userProfile.getGender(), userProfileExist.getGender());
        Assert.assertEquals(userProfile.getName(), userProfileExist.getName());
        Assert.assertEquals(userProfile.getAge(), userProfileExist.getAge());
    }
}

