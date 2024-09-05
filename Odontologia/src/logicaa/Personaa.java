package logicaa;

import java.time.LocalDate;
import java.time.Period;

public class Personaa {
    private String nombre;
    private String apellido;
    private String cedula;
    private String numeTelefono;
    private LocalDate Fecha_nacimiento;

    public Personaa() {
    }

    public Personaa(String nombre, String apellido, String cedula, String numeTelefono, LocalDate Fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numeTelefono = numeTelefono;
        this.Fecha_nacimiento = Fecha_nacimiento; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeTelefono() {
        return numeTelefono;
    }

    public void setNumeTelefono(String numeTelefono) {
        this.numeTelefono = numeTelefono;
    }
    public LocalDate getFecha_naciemiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }
    public int calcularEdad(){
        return Period.between(Fecha_nacimiento,LocalDate.now()).getYears();
    }

    public void infoPersona() {
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Apellido: "+ this.apellido);
    System.out.println("Cedula: "+ this.cedula);
    System.out.println("Numero de Telefono: "+ this.numeTelefono);
    System.out.println("Fecha de Nacimiento: "+ this.Fecha_nacimiento);
    System.out.println("Edad: "+ calcularEdad()+ "Años");
    }

   

}
