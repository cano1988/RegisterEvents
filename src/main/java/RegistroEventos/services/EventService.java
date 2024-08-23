package RegistroEventos.services;

import RegistroEventos.models.EventModel;
import RegistroEventos.repositories.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service //es una especialización de la anotación @Component y se utiliza para marcar una clase como un "servicio" en la arquitectura de una aplicación.
public class EventService {

    @Autowired //Inyección de dependencias
    IEventRepository eventRepository;

    //Obtener todos los eventos
    public ArrayList<EventModel> getEvent(){
        return (ArrayList<EventModel>) eventRepository.findAll();
    }

    // Guardar un evento
    public EventModel saveEvent(EventModel event) {
        return eventRepository.save(event);
    }
    /**
     * Aquí, findById devuelve un Optional<Event>. Esto significa que el método puede devolver un Event, o si no encuentra ninguno, devolverá un Optional.empty() en lugar de null.
     * Ayuda a evitar errores cuando se encuentra un valor null
     */

    //Obtener evento por id
    public Optional<EventModel> getById(String id){
        return eventRepository.findById(id);
    }

    // Modificacion de evento
    public EventModel updateByid(EventModel request, String id){
         EventModel event = eventRepository.findById(id).orElseThrow(); //El método orElseThrow() de la clase Optional en Java se utiliza para manejar situaciones en las que un valor puede no estar presente (es decir, puede ser Optional.empty()). Este método devuelve el valor si está presente, y si no lo está, lanza una excepción personalizada.
        event.setNombre(request.getNombre());
        event.setFecha(request.getFecha());
        event.setUbicacion(request.getUbicacion());
        event.setCapacidad(request.getCapacidad());
        eventRepository.save(event);
        return event;
    }

    //Eliminar evento
    public Boolean deleteEvent(String id){
        try {
            eventRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

