package task5.spring.model;


import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;



@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    // toString в цикле с toString User
   /* @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }*/
    //переопределяем для корректного отображения на фронте
    @Override
    public String toString() {
        return name;
    }

    /////////////////////////////// @Override    GrantedAuthority
    @Override
    public String getAuthority() {
        return name;
    }
}
