package app.repository;

import app.model.User;
import app.model.UserRecived;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRecivedRepository extends JpaRepository<UserRecived, Long> {

    Optional<UserRecived> findByUserName(String userName);


}
