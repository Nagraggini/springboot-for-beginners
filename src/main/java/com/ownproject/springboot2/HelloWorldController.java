package com.ownproject.springboot2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Ez egy irányító, és megjelöltük ezt az osztályt, ő tud a böngészővel kommunikálni.
@Controller
public class HelloWorldController {

    //Ha beírod a weboldalad nevét, akkor egyből az index fog megjelenni.
    //@RequestMapping("/") annotációval semmi mást nem érünk el, hogy a weboldaluk "/" részénél lefut a megjelölt metódusunk, és az jelen helyzetben visszaadja az index.html képernyőnket. 
    @RequestMapping("/") // Lehet GetMapping is.
    public String helloWorld() {

        return "index"; // Betöltjük az index.html fájlt.
    }

}
