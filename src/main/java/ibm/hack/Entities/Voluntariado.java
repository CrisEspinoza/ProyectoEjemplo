package ibm.hack.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Voluntariado")
public class Voluntariado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voluntariado_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="catastrofe_id")
    private Catastrofe catastrofe;

    @OneToMany(mappedBy="voluntariado")
    @JsonIgnore
    private List<Beneficio> Beneficio;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name="voluntario_voluntariado",
            joinColumns={@JoinColumn(name="voluntariado_id")},
            inverseJoinColumns={@JoinColumn(name="voluntario_id")})
    private Set<Voluntario> voluntarios;

    @Column(nullable = false)
    private Timestamp fechaDeInicio;

    @Column(nullable = false)
    private Timestamp fechaDeTermino;

    @Column(nullable = false)
    private Timestamp fechaDeIngreso;

    public Voluntariado() {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Catastrofe getCatastrofe() {
        return catastrofe;
    }

    public void setCatastrofe(Catastrofe catastrofe) {
        this.catastrofe = catastrofe;
    }

    public List<ibm.hack.Entities.Beneficio> getBeneficio() {
        return Beneficio;
    }

    public void setBeneficio(List<ibm.hack.Entities.Beneficio> beneficio) {
        Beneficio = beneficio;
    }


    public Timestamp getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Timestamp fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Timestamp getFechaDeTermino() {
        return fechaDeTermino;
    }

    public void setFechaDeTermino(Timestamp fechaDeTermino) {
        this.fechaDeTermino = fechaDeTermino;
    }

    public Timestamp getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Timestamp fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
}
