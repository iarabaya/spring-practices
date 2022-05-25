package com.example.learningspring.webservice;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.data.Guest;
import com.example.learningspring.data.GuestRepository;
import com.example.learningspring.data.Room;
import com.example.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final GuestService guestService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }


    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required = false) String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests(){
        return this.guestService.getGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void postGuest(@RequestBody Guest newGuest){
        this.guestService.addGuest(newGuest);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }



}
