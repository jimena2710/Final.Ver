package proyectofinal.grupo2;

import javax.swing.JOptionPane;
//Nota el codigo es el mismo que en yoga probablemente lo podriamo hacer en una clase llamada reserva para poder evitar copiar el codigo

public class Baile {
    //Contador reservaciones

    private int reservaciones = 0;

    //Trabajador que vamos a usar
    private Trabajador trabajador;

    //Objeto Baile
    private Baile baile[] = new Baile[30];

    public Baile() {
    }

    public Baile(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public void reservarBaile(Trabajador trabajador[]) {

        //Bandera para verficar si esta llena la lista
        boolean bandera = true;
        if (reservaciones == 30) {
            JOptionPane.showMessageDialog(null, "Ya estan las 30 reservaciones hechas");
            bandera = false;
        }
        //Verificamos si ese trabajador tiene una reserva en la lista
        setTrabajador(trabajador);
        for (int i = 0; i < reservaciones; i++) {
            if (baile[i].trabajador.getName().equals(this.trabajador.getName())) {
                JOptionPane.showMessageDialog(null, "Este trabajador ya tiene una reserva de baile");
                bandera = false;
            }

        }

        //Si no tiene reserva pasamos a reservar
        if (bandera) {
            baile[reservaciones] = new Baile(this.trabajador);
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
                mensaje += (i + 1) + ")" + "El trabajador " + baile[i].trabajador.getName() + " Tiene una reserva de baile de 7:00 pm a 8:00 pm";

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
                baile[opcion - 1] = null;
                for (int i = opcion; i < reservaciones - 1; i++) {
                    baile[i] = baile[i + 1];
                }
                baile[reservaciones - 1] = null;
                reservaciones--;
            }

        }
    }

}
