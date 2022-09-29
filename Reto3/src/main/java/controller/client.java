package controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class client{
    @RequestMapping("/")
    public String saludar(){
        return "<p style='color:blue'>HOLA MUNDO <hr> </p>";
    }
}
