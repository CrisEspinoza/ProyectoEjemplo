package ibm.hack.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="catastrofe")
public class Catastrofe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catastrofe_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name="catastrofe_comuna",
            joinColumns={@JoinColumn(name="catastrofe_id")},
            inverseJoinColumns={@JoinColumn(name="comuna_id")})
    private Set<Comuna> comuna;

    @OneToMany(mappedBy="catastrofe")
    @JsonIgnore
    private List<Voluntariado> voluntariados;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Catastrofe() {
    }

    public Set<Comuna> getComuna() {
        return comuna;
    }

    public void setComuna(Set<Comuna> comuna) {
        this.comuna = comuna;
    }

    public List<Voluntariado> getVoluntariados() {
        return voluntariados;
    }

    public void setVoluntariados(List<Voluntariado> voluntariados) {
        this.voluntariados = voluntariados;
    }
}
