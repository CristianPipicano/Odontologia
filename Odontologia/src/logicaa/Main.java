package logicaa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        List<Personaa> personas = new ArrayList<>();

        do {
            MostrarMenu();
            opcion = ObtenerOpcion(leer);

            switch (opcion) {
                case 1:
                    RegistrarPaciente(leer, personas);
                    break;
                case 2:
                    RegistrarOdontologo(leer, personas);
                    break;
                case 3:
                    VerPaciente(personas);
                    break;
                case 4:
                    VerOdontologo(personas);
                    break;
                case 5:
                    AsignarOdontologoPaciente(leer, personas);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Seleccione una opción válida, por favor.");
            }

        } while (opcion != 6);

        leer.close();

    }

    public static void MostrarMenu() {
        System.out.println("-------------MENU--------------");
        System.out.println("Opción 1. Registrar un Paciente");
        System.out.println("Opcion 2. Registrar un  Odontologo");
        System.out.println("Opción 3. Ver Paciente Registrados");
        System.out.println("Opción 4. Ver Odontologo Registrados");
        System.out.println("Opción 5. Asignar Odontolog a Paciente");
        System.out.println("Opción 6. Salir");
        System.out.print("Seleccione una opción: ");

    }

    public static int ObtenerOpcion(Scanner leer) {
        int opcion = 0;
        try {

            opcion = leer.nextInt();
            leer.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese una opcion valida");
            leer.nextLine();
        }
        return opcion;
    }

    public static void RegistrarPaciente(Scanner leer, List<Personaa> personas) {
        try {
            System.out.print("Escriba el nombre del paciente: ");
            String nombrePaciente = leer.nextLine();
            System.out.print("Escriba el apellido: ");
            String apellidoPaciente = leer.nextLine();
            System.out.print("Escriba la cédula: ");
            String cedulaPaciente = leer.nextLine();
            System.out.print("Escriba el número de teléfono: ");
            String numTelefonoPaciente = leer.nextLine();
            System.out.print("Escriba el ID del paciente: ");
            int idPaciente = leer.nextInt();
            leer.nextLine(); // Consumir la nueva línea pendiente
            System.out.print("Escriba la consulta del paciente: ");
            String consultaPaciente = leer.nextLine();
            System.out.println("Escriba su Fecha de Nacimiento Dia-Mes-Año (ej. 27-08-2024)");
            String fechaNacimientotoString = leer.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientotoString, formato);
            int IdOdontologoAsignado = 0;

            Pacientee paciente = new Pacientee(idPaciente, consultaPaciente, IdOdontologoAsignado, nombrePaciente,
                    apellidoPaciente,
                    cedulaPaciente, numTelefonoPaciente, fechaNacimiento);
            personas.add(paciente);

            System.out.println("¡Paciente registrada con éxito!");

        } catch (DateTimeParseException e) {
            System.out.println("ERROR!, ingresa solo numeros y en el orden del formato Dias-Mes-Año");

        }

    }

    public static void RegistrarOdontologo(Scanner leer, List<Personaa> personas) {
        try {
            System.out.print("Escriba el nombre del odontólogo: ");
            String nombreOdontologo = leer.nextLine();
            System.out.print("Escriba el apellido: ");
            String apellidoOdontologo = leer.nextLine();
            System.out.print("Escriba la cédula: ");
            String cedulaOdontologo = leer.nextLine();
            System.out.print("Escriba el número de teléfono: ");
            String numTelefonoOdontologo = leer.nextLine();
            System.out.print("Escriba el ID del odontólogo: ");
            int idOdontologo = leer.nextInt();
            leer.nextLine(); // Consumir la nueva línea pendiente
            System.out.print("Escriba la especialización del odontólogo: ");
            String especializacionOdontologo = leer.nextLine();
            System.out.println("Escriba su Fecha de Nacimiento Dia-Mes-Año (ej. 27-08-2024)");
            String fechaNacimientoOdon = leer.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaNacimientoOdontologo = LocalDate.parse(fechaNacimientoOdon, formato);

            Odontologoo odontologo = new Odontologoo(idOdontologo, especializacionOdontologo, nombreOdontologo,
                    apellidoOdontologo, cedulaOdontologo, numTelefonoOdontologo, fechaNacimientoOdontologo);
            personas.add(odontologo);
            System.out.println("¡Odontologo registrada con éxito!");

        } catch (DateTimeParseException e) {
            System.out.println("ERROR!, ingresa solo numeros y en el orden del formato Dias-Mes-Año");

        }

    }

    public static void VerPaciente(List<Personaa> personas) {
        if (!personas.isEmpty()) {
            System.out.println("--------Información del paciente--------");
            for (Personaa persona : personas) {
                if (persona instanceof Pacientee) {
                    Pacientee paciente =(Pacientee)persona;
                    persona.infoPersona();

                    if (paciente.getId_odontologoAsignado()!=0) {
                        Odontologoo odontologo = buscarOdontologooid(personas, paciente.getId_odontologoAsignado());
                        if (odontologo!=null) {
                            System.out.println("Nombre: "+odontologo.getNombre()+ "Apellido: "+odontologo.getApellido());
                        }
                    }

                }
                System.out.println("----------------------------------");
            }
        } else {
            System.out.println("No hay personas registradas");
        }
    }

    public static void VerOdontologo(List<Personaa> personas) {
        if (!personas.isEmpty()) {

            System.out.println("--------Información del Odontologo--------");
            for (Personaa persona : personas) {
                if (persona instanceof Odontologoo) {
                    persona.infoPersona();
                    

                }
                System.out.println("----------------------------------");
            }

        } else {
            System.out.println("No hay personas registradas.");
        }
    }

    public static void AsignarOdontologoPaciente(Scanner leer, List<Personaa> personas) {
        List<Odontologoo> odontologos = new ArrayList<>();
        List<Pacientee> pacientes = new ArrayList<>();

        for (Personaa persona : personas) {
            if (persona instanceof Pacientee)
                pacientes.add((Pacientee) persona);
            else if (persona instanceof Odontologoo) {
                odontologos.add((Odontologoo) persona);
            }

        }
        if (odontologos.isEmpty()) {
            System.out.println("no hay odontologo  registrado");
            return;

        }
        if (pacientes.isEmpty()) {
            System.out.println("no hay paciente registrado");
            return;
        }
        System.out.println("seleccione el id del paciente que desea asignar un odontologo ");
        for (Pacientee paciente : pacientes) {

            System.out.println("ID: " + paciente.getId_paciente() + " Nombre: " + paciente.getNombre()
                    + " Apellido:" + paciente.getApellido() + " consulta del paciente:"
                    + paciente.getConsultaPaciente());
        }
        int id_paciente = leer.nextInt();
        leer.nextLine();

        Pacientee pacienteseleccinado = bucarPacienteid(personas, id_paciente);

        if (pacienteseleccinado == null) {
            System.out.println("paciente no encontrado");
            return;

        }
        System.out.println("seleccione el id del odontologo que desea asignar un paciente ");
        for (Odontologoo odontologo : odontologos) {

            System.out.println("ID: " + odontologo.getId_odontologo() + " Nombre: " + odontologo.getNombre()
                    + "Apellido:" + odontologo.getApellido() + " especializacion del odontologo:"
                    + odontologo.getEspecializacion());
        }
        int idodontologo = leer.nextInt();
        leer.nextLine();

        Odontologoo odontologoseleccinado = buscarOdontologooid(personas, idodontologo);

        if (odontologoseleccinado == null) {
            System.out.println("odontologo no encontrado");
            return;

        }
        pacienteseleccinado.setId_odontologoAsignado(idodontologo);
        System.out.println("odontologo asignado con exito!");

    }

    public static Odontologoo buscarOdontologooid(List<Personaa> personas, int idOdontologo) {
        for (Personaa persona : personas) {
            if (persona instanceof Odontologoo) {
                Odontologoo odontologo = (Odontologoo) persona;
                if (((Odontologoo) persona).getId_odontologo() == idOdontologo) {
                    return odontologo;
                }

            }
        }
        return null;
    }

    public static Pacientee bucarPacienteid(List<Personaa> personas, int idPaciente) {
        for (Personaa persona : personas) {
            if (persona instanceof Pacientee) {
                Pacientee paciente = (Pacientee) persona;
                if (paciente.getId_paciente() == idPaciente) {
                    return paciente;
                }
            }
        }
        return null;
    }

}
