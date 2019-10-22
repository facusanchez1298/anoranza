package app;

import app.model.UserRecived;
import app.repository.UserRecivedRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private UserRecivedRepository repo;

    @Test
    public void createUserTest(){
        UserRecived user = new UserRecived();
        user.setUserName("calvin");
        UserRecived returned = repo.save(user);

        assertTrue(user.getUserName().equalsIgnoreCase(returned.getUserName()));

    }

}
