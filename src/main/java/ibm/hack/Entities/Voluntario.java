package ibm.hack.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Voluntario")
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voluntario_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="voluntarios")
    @JsonIgnore
    private Set<Voluntariado> voluntariados;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="voluntarios1")
    @JsonIgnore
    private Set<Beneficio> beneficios;

    public Voluntario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
