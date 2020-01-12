package task5.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task5.spring.model.Role;
import task5.spring.model.User;
import task5.spring.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService} interface.

 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserDetailsServiceImpl получаем User
        // он уже содержит объект UserDetails - в противном случае на основании полученных данных формируем объект UserDetails -
        // который позволит проверить введенный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        User user = userRepository.findByUsername(username);
        return user;



        //зашифрованный пароль!!!!
//        System.out.println("user ----- " + user);
////создаю новый сет разрешений
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        System.out.println("grantedAuthorities ------ " + grantedAuthorities);
////в цикле дабавлюя в разрешения пользователя все роли, которые храняться в БД
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        System.out.println("user.getUsername() ------ " + user.getUsername());
//        System.out.println("user.getPassword() ------ " + user.getPassword());
//        System.out.println("grantedAuthorities ------ " + grantedAuthorities);
//        //юзер: имя, пароль, РАЗРЕШЕНИЯ (из ролей)
//        System.out.println("new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities) ------ " + new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}