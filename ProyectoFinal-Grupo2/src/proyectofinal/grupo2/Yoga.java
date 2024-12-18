package proyectofinal.grupo2;

import javax.swing.JOptionPane;

public class Yoga {

    //Contador reservaciones
    private int reservaciones = 0;

    //Trabajador que vamos a usar
    private Trabajador trabajador;

    //Objeto yoga
    private Yoga yoga[] = new Yoga[30];

    public Yoga() {
    }

    public Yoga(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    //LLenamos lista usando trabajador
    public void reservarYoga(Trabajador trabajador[]) {

        //Bandera para verficar si esta llena la lista
        boolean bandera = true;
        if (reservaciones == 30) {
            JOptionPane.showMessageDialog(null, "Ya estan las 30 reservaciones hechas");
            bandera = false;
        }
        //Verificamos si ese trabajador tiene una reserva en la lista
        setTrabajador(trabajador);
        for (int i = 0; i < reservaciones; i++) {
            if (yoga[i].trabajador.getName().equals(this.trabajador.getName())) {
                JOptionPane.showMessageDialog(null, "Este trabajador ya tiene una reserva de yoga");
                bandera = false;
            }

        }

        //Si no tiene reserva pasamos a reservar
        if (bandera) {
            yoga[reservaciones] = new Yoga(this.trabajador);
            reservaciones++;
            JOptionPane.showMessageDialog(null, "Reservado con exito");

        }
    }

    public void mostrarReservaciones() {
        String mensaje = "";
        //Bandera verificar si reservas es 0
        boolean bandera = true;
        if (reservaciones == 0) {
            JOptionPane.showMessageDialog(null, "No hay reservas que se puedan mostrar");
            bandera = false;
        }
        if (bandera) {
            for (int i = 0; i < reservaciones; i++) {
                mensaje += (i + 1) + ")" + "El trabajador " + yoga[i].trabajador.getName() + " Tiene una reserva de yoga de 7:00 pm a 8:00 pm";

            }
        }
        JOptionPane.showMessageDialog(null, mensaje);

    }

    //Set trabajador similar al que usamos en barista, intente hacer lo mismo en gym pero no logre resultados
    public void setTrabajador(Trabajador trabajador[]) {
        Trabajador trabajadorUsar = new Trabajador().buscarTrabajador(trabajador);
        this.trabajador = trabajadorUsar;
    }
    
    //Usamos el codigo eliminar reserva (Quisa se puede poner en otra parte para no tener que copiarlo todo el tiempo)
    //Nota 2, intente hacerlo en la clase trabajador sin exito
       public void eliminarReserva() {
        //boolean lo mismo que anterior
        boolean bandera = true;
        if (reservaciones == 0) {
            JOptionPane.showMessageDialog(null, "No hay reservaciones por borrar");
            bandera = false;
        } else {
            mostrarReservaciones();
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual es la reservacion que quere borrar"));
            if (opcion > reservaciones) {
                JOptionPane.showMessageDialog(null, "Esta opcion no es valida");
                bandera = false;

            }
            //El codigo anterior es el mismo verificamos igual y ahora si todo esta bien borramos la reservacion usare parte del codigo de gym para que null mueva 
            if (bandera) {
                yoga[opcion - 1] = null;
                for (int i = opcion; i < reservaciones - 1; i++) {
                    yoga[i] = yoga[i + 1];
                }
                yoga[reservaciones - 1] = null;
                reservaciones--;
            }

        }
    }

}
