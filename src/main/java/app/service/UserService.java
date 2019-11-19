package app.service;

import app.excepciones.Classes.UserNullExeption;
import app.model.User;
import app.model.UserRecived;
import app.repository.UserRecivedRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;


    /**
     * Conexion a base de datos
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Optional<User> user = repo.findByUserName(userName);

      if(user.isPresent()){
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDetails =
          new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), roles);
        return userDetails;
      }
      throw new UserNullExeption("the entered user not exist");
    }

}
