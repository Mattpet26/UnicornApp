package com.example.demo.Contollers;

import com.example.demo.Models.location.Location;
import com.example.demo.Models.location.LocationRepo;
import com.example.demo.Models.unicorn.Unicorn;
import com.example.demo.Models.unicorn.UnicornRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    UnicornRepo unicornRepo;

    @GetMapping("/")
    public String home(Principal principal, Model m){
        //SeedData();
        ArrayList<Unicorn> unicorns = (ArrayList<Unicorn>) unicornRepo.findAll();
        ArrayList<Location> locations = (ArrayList<Location>) locationRepo.findAll();
        m.addAttribute("unicorns", unicorns);
        m.addAttribute("locations", locations);
        return "home";
    }

    public void SeedData(){
        Location barn = new Location("Barn");
        Location lake = new Location("Lake");
        Location trail = new Location("Trail");
        locationRepo.save(barn);
        locationRepo.save(lake);
        locationRepo.save(trail);

        Unicorn Tim = new Unicorn("Tim", "Red", "Spaghetti", barn);
        Unicorn Jack = new Unicorn("Jack", "Blue", "Apples", lake);
        Unicorn Jill = new Unicorn("Jill", "Green", "Hay", trail);
        unicornRepo.save(Tim);
        unicornRepo.save(Jack);
        unicornRepo.save(Jill);
    }
}
