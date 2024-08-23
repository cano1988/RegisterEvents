package RegistroEventos.controllers;

import RegistroEventos.models.EventModel;
import RegistroEventos.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("/event") //Para definir la ruta nivel general y no desde cada petición HTTP
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ArrayList<EventModel> getEvent(){
        return this.eventService.getEvent();
    }

    // La anotación @valid es para que cuando se cree o se actualice el endpoint salga el mensaje de las vaidaciones
    @PostMapping
    public EventModel saveEvent(@Valid @RequestBody EventModel event){ //@Requestbody, es que vamos a pasar algo por el body, en este caso a postman
        return this.eventService.saveEvent(event);
    }

    @GetMapping("/{id}")
    public Optional<EventModel> getEventById(@PathVariable String id){
        return this.eventService.getById(id);
    }

    @PutMapping("/{id}")
    public EventModel updateEventById(@Valid @RequestBody EventModel event, @PathVariable String id){
        return this.eventService.updateByid(event, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id ){
       boolean ok =  this.eventService.deleteEvent(id);
       if(ok){
           return "Event with id" + id + " was deleted";
       }else
           return "Error, we have a problem and we can't delete the id" + id;
    }
}
