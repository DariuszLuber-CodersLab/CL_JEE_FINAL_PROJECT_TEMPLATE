package pl.coderslab.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validationGroups.FullValidationGroup;

import javax.persistence.*;
import javax.validation.groups.Default;

@Entity
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {Default.class, FullValidationGroup.class})
    private String username;

    @JsonIgnore
    @NotEmpty(groups = {Default.class, FullValidationGroup.class})
    private String password;

    @JsonIgnore
    @Transient
    private String repeatPwd;

    @NotEmpty(groups = {FullValidationGroup.class})
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPwd() {
        return repeatPwd;
    }

    public void setRepeatPwd(String repeatPwd) {
        this.repeatPwd = repeatPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
