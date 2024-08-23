package RegistroEventos.repositories;


import RegistroEventos.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // clase que permite hacer query a una base de datos
public interface IEventRepository extends JpaRepository<EventModel, String> {


}
