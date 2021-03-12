package com.example.demo.Contollers;

import com.example.demo.Models.location.Location;
import com.example.demo.Models.location.LocationRepo;
import com.example.demo.Models.unicorn.Unicorn;
import com.example.demo.Models.unicorn.UnicornRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class UnicornController {

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    UnicornRepo unicornRepo;

    @GetMapping("/moveunicorn")
    public RedirectView ChangeLocationUnicorn(String unicornName, Location location, Principal principal, Model m) {
        Unicorn movedUnicorn = unicornRepo.findByName(unicornName);
        movedUnicorn.location = location;
        unicornRepo.save(movedUnicorn);

        if (movedUnicorn == null) {
            m.addAttribute("Unicorn doesn't exist", true);
        }

        m.addAttribute("unicorn", movedUnicorn);
        m.addAttribute("principal", principal);
        return new RedirectView("/");
    }

    @GetMapping("/addunicorn")
    public RedirectView newUnicorn(Principal principal, Model m, String UnicornName, String UnicornColor, String FavoriteFood) {
        Unicorn newUnicorn = new Unicorn(
          UnicornName,
          UnicornColor,
          FavoriteFood,
          locationRepo.getOne((long) 1)
        );
        unicornRepo.save(newUnicorn);
        return new RedirectView("/");
    }
}
