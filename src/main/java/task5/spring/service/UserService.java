package task5.spring.service;


import task5.spring.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface UserService {

    //1-й получить список всех пользователей
    List<User> getAllUsers();

    //2-й получить пользователя по ID
    User getUserById(long id) /*throws SQLException*/;

    //3-й проверить есть ли зарегистрированный пользователь с искомым именем
//    boolean checkUserByName(String name) throws SQLException;

    //4-й проверить есть ли зарегистрированный пользователь с искомым логином
 //   boolean checkUserByLogin(String login) throws SQLException;

    //5-й создать и добавить в базу нового пользователя
    void addUser(User user);

    //6-й обновить и записать в базу новые данные пользователя
    void updateUser(User user);

    //Дополненный метод + роли + пасс
    public void updateUserAndRole(User user,  String selectedRole);


    //7-й удалить пользователя через ID
    void deleteUserById(long id) /*throws SQLException*/;

    //8-й проверить есть ли зарегистрированный пользователь
    // с искомым login и password
    public User isExist(String login, String password);

    // два метода из Секьюрити

    void addUserWithRoleUser(User user);

    User findByUsername(String username);

    void addUser2(User user, String selectedRole); //сохранить с ролями


}