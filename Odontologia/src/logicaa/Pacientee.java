package logicaa;

import java.time.LocalDate;

public class Pacientee extends Personaa {
    private int id_paciente;
    private String consultaPaciente;
    private  int id_odontologoAsignado;

    public Pacientee(int id_paciente, String consultaPaciente,int id_odontologoAsignado, String nombre, String apellido, String cedula,
            String numeTelefono, LocalDate Fecha_nacimiento) {
        super(nombre, apellido, cedula, numeTelefono,Fecha_nacimiento);
        this.id_paciente = id_paciente;
        this.consultaPaciente = consultaPaciente;
        this.id_odontologoAsignado = id_odontologoAsignado;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getConsultaPaciente() {
        return consultaPaciente;
    }

    public void setConsultaPaciente(String consultaPaciente) {
        this.consultaPaciente = consultaPaciente;
    }
    public int getId_odontologoAsignado(){
        return id_odontologoAsignado;
    }
    public  void setId_odontologoAsignado(int id_odontologoAsignado){
        this.id_odontologoAsignado = id_odontologoAsignado;
    }
    @Override
    public  void infoPersona(){

        super.infoPersona();
        System.out.println("ID Paciente: "+this.id_paciente);
        System.out.println("Consulta: "+this.consultaPaciente);
        System.out.println("ID odontologo: "+this.id_odontologoAsignado);

    }
}
