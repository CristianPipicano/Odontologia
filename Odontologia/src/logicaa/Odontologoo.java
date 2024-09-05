package logicaa;

import java.time.LocalDate;

public class Odontologoo extends Personaa {
    private int id_odontologo;
    private String especializacion;

    public Odontologoo() {
    }

    public Odontologoo(int id_odontologo, String especializacion, String nombre, String apellido, String cedula,
            String numeTelefono,LocalDate Fecha_nacimiento) {
        super(nombre, apellido, cedula, numeTelefono, Fecha_nacimiento);
        this.id_odontologo = id_odontologo;
        this.especializacion = especializacion;
    }
    

    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    @Override
 public void infoPersona()
    {
    super.infoPersona();
    System.out.println("ID Odontologo: "+ this.id_odontologo);
    System.out.println(" Especialidad: "+this.especializacion
    );
 }

}
