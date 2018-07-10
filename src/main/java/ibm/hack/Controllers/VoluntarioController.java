package ibm.hack.Controllers;

import ibm.hack.Entities.Voluntario;
import ibm.hack.Repository.VoluntarioRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Voluntario> getAllUser(){
        return voluntarioRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Voluntario create(@RequestBody Voluntario user){
        return voluntarioRepository.save(user);

    }

    @PostMapping("/auth")
    public Voluntario autentificar(@RequestBody String json) throws JSONException {
        JSONObject response = new JSONObject(json);
        String firstName= response.getString("firstName");
        String password=response.getString("password");

        Voluntario user=voluntarioRepository.findByfirstName(firstName);

        if(user==null || !user.getPassword().equals(password)) {
            return null;
        }

        return user;

    }
}
