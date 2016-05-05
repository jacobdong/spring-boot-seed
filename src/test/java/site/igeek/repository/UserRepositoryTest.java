package site.igeek.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.igeek.ApplicationLauncher;
import site.igeek.model.po.User;

/**
 * Created by jacobdong on 16/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationLauncher.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    private final String TEST_USER_ID = "TEST_USER_ID";

    @Test
    public void addTest() {
        User user = new User();
        user.setId(TEST_USER_ID);
        user.setAccount("test_account");
        user.setPassword("123456");
        userRepository.save(user);
    }
}
