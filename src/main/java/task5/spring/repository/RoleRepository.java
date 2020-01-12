package task5.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import task5.spring.model.Role;


@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {
}

