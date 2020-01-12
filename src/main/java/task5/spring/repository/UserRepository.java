package task5.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task5.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

//дополнительный метод к интерфейсу
User findByUsername(String username);

}
