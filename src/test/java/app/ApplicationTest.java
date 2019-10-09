package app;

import app.model.User;
import app.repository.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private IUserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void createUserTest(){
        User user = new User();
        user.setUserName("calvin");
        user.setPassword(encoder.encode("prueba"));
        User returned = repo.save(user);

        assertTrue(user.getUserName().equalsIgnoreCase(returned.getUserName()));

    }

}
