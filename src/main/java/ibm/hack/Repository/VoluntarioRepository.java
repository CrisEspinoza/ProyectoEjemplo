package ibm.hack.Repository;

import ibm.hack.Entities.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoluntarioRepository extends JpaRepository<Voluntario,Long> {

    Voluntario  findByfirstName(String email);
    List<Voluntario> findClubById(Long id);
}
