package ibm.hack.Controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/request")
public class PruebaController {

    @RequestMapping(value = "/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String getExercise(@PathVariable("string") String string)
    {
        /*Conversation service = new Conversation("2018-02-16");
        service.setUsernameAndPassword("20fd70a6-cc5f-4cd3-8bc0-b139db21deec", "1r1tTDvp2bf6");

        InputData input = new InputData.Builder(string).build();
        MessageOptions options = new MessageOptions.Builder("0b3abfe7-671d-4805-a8a0-1171913b8ff5")
                .input(input)
                .build();
        MessageResponse response = service.message(options).execute();
        //System.out.println(response);*/
        return string;
    }
}
