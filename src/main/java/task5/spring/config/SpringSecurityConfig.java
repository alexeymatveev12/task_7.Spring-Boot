package task5.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//

    @Configuration
    @EnableWebSecurity
    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        //Autowired - сделал через конструктор
        private UserDetailsService userDetailsService;

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        //Перенаправление на разные страницы после входа в Spring Security
        @Bean
        public AuthenticationSuccessHandler userAuthenticationSuccessHandler() {
            return new UserAuthenticationSuccessHandler();
        }

        @Autowired
        SpringSecurityConfig(UserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }


        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .authorizeRequests()
                  .antMatchers("/welcome").permitAll()
                //    .antMatchers("/welcome").anonymous()
                //        .antMatchers("/welcome*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    // .antMatchers("/admin/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                    .anyRequest().anonymous() //для того чтобы /login не был доступен для авторизованных пользователей
                    .and()

                    .formLogin()
                    .loginPage("/login")
                    //куда перенаправлять после логина
                    //    .defaultSuccessUrl("/welcome", true)
                    .successHandler(userAuthenticationSuccessHandler()) //стратегия перенаправления после /login
                    .failureUrl("/login?error=true")
                    .and()

                    .logout()
                    .logoutUrl("/perform_logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .and()



                    .csrf()
                    .disable()
            ;

        }
    }

