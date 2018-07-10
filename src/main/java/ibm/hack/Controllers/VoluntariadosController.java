package ibm.hack.Controllers;

import ibm.hack.Entities.Voluntariado;
import ibm.hack.Entities.Voluntario;
import ibm.hack.Repository.VoluntariadoRepository;
import ibm.hack.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voluntariados")
public class VoluntariadosController {

    @Autowired
    private VoluntariadoRepository voluntariadoRepository;

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Voluntariado> getAllVoluntariado() {
        List<Voluntariado> voluntariados=  voluntariadoRepository.findAll();
        return voluntariados;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Voluntario> getVoluntario(@PathVariable Integer id)
    {
        Long staticId = id.longValue();
        List<Voluntario> voluntarios = voluntarioRepository.findClubById(staticId);
        return voluntarios;
    }

}
