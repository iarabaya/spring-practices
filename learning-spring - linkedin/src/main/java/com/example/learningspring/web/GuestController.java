package com.example.learningspring.web;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        //model.addAttribute("guests", this.guestService.getGuests());
        List<Guest> guestList = this.guestService.getGuests();
        model.addAttribute("guests", guestList);
        return "hotel-guests";
    }
}
