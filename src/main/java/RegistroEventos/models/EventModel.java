package RegistroEventos.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;



@Entity //Con esta anotación cada atributo dentro de esta clase lo va a generar como una columna en nuestra base de datos
@Table(name = "event") //Para nombrar la tabla y no quede con EventModel, igual también se puede poner en la @Entity
public class EventModel {

    @Id //Anotación para que sea valor unico o primary key
    @GeneratedValue(strategy =  GenerationType.UUID) //Para generar un valor de tipo UUID
    private String id;

    //Se utiliza dependencia validation para utilizar @NotBlank, @NotNull, @Future
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La fecha es obligatoria")
    @Future(message = "La fecha debe ser en el futuro") //@Future sirve
    private LocalDate fecha;

    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;

    /**
     * Cuando aplicas @Min a un campo, el validador verifica que el valor de ese campo sea igual o mayor al valor especificado en la anotación.
     * Si el valor es menor, la validación falla y se devuelve un mensaje de error.
     */

    @Min(value = 0, message = "La capacidad del evento no puede ser negativa")
    private int capacidad;

    // Constructor vacío
    public EventModel() {
    }

    // Constructor lleno
    public EventModel(String id, String nombre, LocalDate fecha, String ubicacion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    // Métodos getter y setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull(message = "La fecha es obligatoria") @Future(message = "La fecha debe ser en el futuro") LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull(message = "La fecha es obligatoria") @Future(message = "La fecha debe ser en el futuro") LocalDate fecha) {
        this.fecha = fecha;
    }

    public @NotBlank(message = "La ubicación es obligatoria") String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(@NotBlank(message = "La ubicación es obligatoria") String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Min(value = 0, message = "La capacidad del evento no puede ser negativa")
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(@Min(value = 0, message = "La capacidad del evento no puede ser negativa") int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
