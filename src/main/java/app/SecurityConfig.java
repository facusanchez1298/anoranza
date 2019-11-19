package app;

import app.service.UserService;
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
    private UserService userService;

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

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCrypt);
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
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                .and()
                    .authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .logout()
                .and()
                .csrf().disable();

    }
}
