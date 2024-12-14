package projectoprogragrupo2;

import javax.swing.JOptionPane;

public class Gimnasio {

    //Nombre entrenador lista que usamos || Usamos 3 porque cada trainer es una columna es nuestra matrix
    private String trainerNameList[] = {"Trainer1", "Trainer2", "Trainer3"};
    //Entrenador que escogemos
    private String trainer;
    //Matrix de numeros con horas que podemos escoger
    private int horasDispo[][] = {{2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5}, {6, 6, 6}, {7, 7, 7}};
    //Hora de entrada no repetir misma hora con mismo trainer
    private int horaEntrada;
    //Trabajador de nuestro contructor
    private Trabajador trabajador;
    //Cantidad de reservaciones hechas
    private int reservaciones = 0;
    //Son 7 trabajadores solo podemos hacer 7 reservaciones
    private Gimnasio gym[] = new Gimnasio[7];

    public Gimnasio() {
    }

    public Gimnasio(String trainer, int horaEntrada, Trabajador trabajador) {
        this.trainer = trainer;
        this.horaEntrada = horaEntrada;
        this.trabajador = trabajador;
    }

    public void eliminarReserva() {
        //Bandera para repeticion
        boolean bandera = true;
        while (bandera) {
            //Si reservaciones es 0 no se puede hacer nada
            if (reservaciones == 0) {
                JOptionPane.showMessageDialog(null, "No hay reservaciones que se puedan borrar");
                bandera = false;
            }
            if (bandera) {
                verReservaciones();
                //Copiamos codigo ya que es el mismo el error es no hacer separacion en set hora y trainer mb
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual reserva desea eliminar"));
                opcion--;
                String trainer = gym[opcion].getTrainer();
                int hora = gym[opcion].getHoraEntrada();
                for (int i = 0; i < 3; i++) {
                    if (trainer.equals(trainerNameList[i])) {
                        for (int j = 0; j < 6; j++) {
                            if (horasDispo[j][i] == 0 && hora == j + 2) {
                                horasDispo[j][i] = hora;
                                bandera = false;
                                break;
                            }
                        }
                    }
                }
                //Movemos las reservaciones a la izquerda movemos la null al final
                for (int i = opcion; i < reservaciones - 1; i++) {
                    gym[i] = gym[i + 1];
                }
                //Borramos la reservacion y tmb reducimos cantidad de reservaciones 
                gym[reservaciones - 1] = null;
                reservaciones--;
            }
        }
    }

    public void modificarReserva(Trabajador trabajador[]) {
        //bandera para verificar
        boolean bandera = true;
        if (reservaciones == 0) {
            JOptionPane.showMessageDialog(null, "No hay reservaciones para modificar");
            bandera = false;
        }

        while (bandera) {
            verReservaciones();
            //Buscamos reservacion a cambiar
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual reserva desea cambiar"));
            opcion--;
            String trainer = gym[opcion].getTrainer();
            int hora = gym[opcion].getHoraEntrada();
            for (int i = 0; i < 3; i++) {
                if (trainer.equals(trainerNameList[i])) {
                    for (int j = 0; j < 6; j++) {
                        if (horasDispo[j][i] == 0 && hora == j + 2) {
                            horasDispo[j][i] = hora;
                            bandera = false;
                            break;
                        }
                    }
                }
            }
            mostrarHoras();
            int nuevaHora = Integer.parseInt(JOptionPane.showInputDialog("Cual es la nueva hora de entrada"));
            gym[opcion].setHoraEntrada(nuevaHora);
            //"Cerramos" la hora otra vez
            for (int i = 0; i < 3; i++) {
                if (trainerNameList[i].equals(trainer)) {
                    horasDispo[nuevaHora - 2][i] = 0;
                }

            }

        }
    }

    public void hacerReservacion(Trabajador trabajador[]) {
        buscarTrabajador(trabajador);
        setHoraEntradaEntrenador();
        boolean bandera = true;
        while (bandera) {

            if (reservaciones == 7) {
                JOptionPane.showMessageDialog(null, "No se pueden hacer mas reservaciones");
                bandera = false;

            } else {
                gym[reservaciones] = new Gimnasio(trainer, horaEntrada, this.trabajador);
                reservaciones++;
                JOptionPane.showMessageDialog(null, "Reservacion hecha!!!");
                bandera = false;
            }

        }
    }

    public void verReservaciones() {
        //Asi evitamos el nullpoint exeption????
        String mensaje = "";
        //Bandera
        boolean bandera = true;
        if (this.reservaciones == 0) {
            JOptionPane.showMessageDialog(null, "No hay reservaciones que se puedan ver");
            bandera = false;
        }
        
            if(bandera)  {
                for (int i = 0; i < reservaciones; i++) {
                    mensaje += (i + 1) + ")" + "El trabajdor: " + gym[i].trabajador.getName() + "\n"
                            + "Esta con el entrenador: " + gym[i].getTrainer() + "\n"
                            + "A la hora: " + gym[i].getHoraEntrada() + "\n";

                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        
    }

    public void buscarTrabajador(Trabajador trabajador[]) {

        String mensaje = "";
        //bandera buscar id correcto
        boolean bandera = true;
        while (bandera) {
            String idTrabajador = JOptionPane.showInputDialog("Cual es el id del trabajador");
            for (int i = 0; i < 7; i++) {
                if (trabajador[i].getId().equals(idTrabajador)) {
                    this.trabajador = trabajador[i];
                    mensaje = "Trabajador encontrado";
                    bandera = false;
                    break;
                } else {
                    mensaje = "Trabajador no existe";
                }
            }

        }
        JOptionPane.showMessageDialog(null, mensaje);

    }

    public void setHoraEntradaEntrenador() {
        //bandera para ver que el trainer este correcto
        boolean bandera = true;
        //bandera para que hora este bien
        boolean bandera1 = true;

        int trainer = 0;
        int hora = 0;

        mostrarHoras();
        //Verificacion de trainer
        while (bandera) {
            trainer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de entrenador que quiere"));
            if (trainer < 1 || trainer > 3) {
                JOptionPane.showMessageDialog(null, "En entrenador no es valido intente otra vez");
            } else {

                trainer--;
                this.trainer = trainerNameList[trainer];
                bandera = false;
            }

        }
        //verificacion de hora
        while (bandera1) {
            hora = Integer.parseInt(JOptionPane.showInputDialog("Cual hora quiere agendar"));
            if (hora < 2 || hora > 7 || horasDispo[hora - 2][trainer] == 0) {
                JOptionPane.showMessageDialog(null, "Hora incorrecta intente otra vez");
            } else {

                hora = hora - 2;
                this.horaEntrada = horasDispo[hora][trainer];
                bandera1 = false;
            }

        }

        //Cambiamos a 0 en la matriz al escoger la hora en el trainer
        horasDispo[hora][trainer] = 0;

    }

    public void mostrarHoras() {
        String mensaje = "";
        //i son nuestras columnas son nuestros trainers
        for (int i = 0; i < 3; i++) {
            mensaje += i + 1 + ")" + trainerNameList[i] + " Horas disponibles:" + "\n";
            for (int j = 0; j < 6; j++) {
                if (horasDispo[j][i] == 0) {
                    mensaje += "No disponible" + "\n";
                } else {
                    mensaje += horasDispo[j][i] + ":00 pm" + "\n";
                }
            }

        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String getTrainer() {
        return trainer;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

}
