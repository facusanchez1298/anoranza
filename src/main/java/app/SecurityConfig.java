package app;

import app.model.UserRecived;
import app.service.UserService;
import app.service.interfaces.UserRecivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * Acá hago la conexion a base de datos para que use los usernames y las claves de la BD, de paso le doy el
     * encriptador.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);
    }

    /**
     * Acá me aseguro que el usuario tenga permiso de revisar cualquier pagina excepto reserva y contacto.
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeRequests().antMatchers("/reserva").authenticated()
                .and()
                .authorizeRequests().antMatchers("/contacto").authenticated()
                .and()
                .authorizeRequests().antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .logout();
        ;

    }
}
