//package quinto.elemento.prueba.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import quinto.elemento.prueba.model.Administrator;
//import quinto.elemento.prueba.model.Alumno;
//import quinto.elemento.prueba.model.Profesor;
//import quinto.elemento.prueba.model.Usuario;
//import quinto.elemento.prueba.repository.AdministratorRepository;
//import quinto.elemento.prueba.repository.AlumnoRepository;
//import quinto.elemento.prueba.repository.ProfesorRepository;
//import quinto.elemento.prueba.repository.UsuarioRepository;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AlumnoRepository alumnoRepository;
//    @Autowired
//    private ProfesorRepository profesorRepository;
//    @Autowired
//    private AdministratorRepository administratorRepository;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests().antMatchers("/js/**", "/css/**").permitAll()
//                .antMatchers("/login*").permitAll()
//                .antMatchers("/home/**").hasAnyAuthority( "ADMIN", "PROFESOR", "ALUMNO")
//                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .and()
//                .formLogin()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .loginPage("/api/login")
//                .permitAll()
//                .and()
//                .logout().logoutUrl("api/logout").permitAll();
//    }
//
//
//
//
//        }
//
//
//
