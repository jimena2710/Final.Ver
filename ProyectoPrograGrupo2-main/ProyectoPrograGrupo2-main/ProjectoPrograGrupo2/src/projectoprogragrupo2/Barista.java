package projectoprogragrupo2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Barista {

    private String bebida;
    private String horaEntrega;
    private boolean bebidaAsignada = true;
    private int bebidasAsignadas = 0;

    //Trabajador para el objeto
    private Trabajador trabajador;

    //Objeto de bebidas es 7 porque son 7 trabajadores
    private Barista bebidas[] = new Barista[7];

    public Barista(String bebida, String horaEntrega, Trabajador trabajador, boolean bebidaAsignada) {
        this.bebida = bebida;
        this.horaEntrega = horaEntrega;
        this.trabajador = trabajador;
    }

    public Barista() {
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    //Reservamos bebida con el trabajador aqui verificamos que trabajador tenga solo 1 bebida
    public void reservarBebida(Trabajador trabajador[]) {
        //Verficamos bebida
        setTrabajador(trabajador);
        //Bandera por si tiene beibda
        boolean bandera = true;
        if (bebidasAsignadas == 7) {
            JOptionPane.showMessageDialog(null, "No se pueden asignar mas bebidas");
            bandera = false;
        }
        //Verficamos con esta seccion si el trabajador ya tiene bebida asignada
        for (int i = 0; i < bebidasAsignadas; i++) {
            if (bebidas[i].trabajador.getId().equals(this.trabajador.getId())) {
                JOptionPane.showMessageDialog(null, "El trabajador ya tiene una bebida asignada: " + bebidas[i].getBebida());
                bandera = false;
                break;
            }

        }
        if (bandera) {
            JOptionPane.showMessageDialog(null, "Asignando bebida al trabajador...");
            setBebida();
            setHora();
            bebidas[bebidasAsignadas] = new Barista(bebida, horaEntrega, this.trabajador, false);
            bebidasAsignadas++;
        }

    }

    public void setTrabajador(Trabajador trabajador[]) {
        Trabajador trabajadorUsar = new Trabajador().buscarTrabajador(trabajador);
        this.trabajador = trabajadorUsar;
    }

    public void cambiarBebida() {

        //boolean bandera no permite asignar bebida si no damos el input correct
        boolean bandera = true;
        int opcion = 0;
        //Que muestra si no hay bebidas
        if (bebidasAsignadas == 0) {
            JOptionPane.showMessageDialog(null, "No hay bebidas por cambiar");
            bandera = false;
        } //Que hacemos si, si hay bebidas
        else {
            mostrarReservas();
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual es el trabajador que desea cambiar la bebida"));
            if (opcion > bebidasAsignadas) {
                JOptionPane.showMessageDialog(null, "Esta opcion no es valida");
                bandera = false;

            }
            if (bandera) {

                bebidas[opcion - 1].setBebida();
                JOptionPane.showMessageDialog(null, "Bebida cambiada con exito");

            }

        }
    }

    public void eliminarReserva() {
        //boolean lo mismo que anterior
        boolean bandera = true;
        if (bebidasAsignadas == 0) {
            JOptionPane.showMessageDialog(null, "No hay bebida por borrar");
            bandera = false;
        } else {
            mostrarReservas();
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual es la reservacion que quere borrar"));
            if (opcion > bebidasAsignadas) {
                JOptionPane.showMessageDialog(null, "Esta opcion no es valida");
                bandera = false;

            }
            //El codigo anterior es el mismo verificamos igual y ahora si todo esta bien borramos la reservacion usare parte del codigo de gym para que null mueva 
            if (bandera) {
                bebidas[opcion - 1] = null;
                for (int i = opcion; i < bebidasAsignadas - 1; i++) {
                    bebidas[i] = bebidas[i + 1];
                }
                bebidas[bebidasAsignadas - 1] = null;
                bebidasAsignadas--;
            }

        }
    }

    public void setBebida() {
        boolean bandera = true;
        while (bandera) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Cual bebida quiere escoger\n"
                    + "1. Cafe\n"
                    + "2. Capuccino\n"
                    + "3. Capuccino vainilla\n"
                    + "4. Chocolate\n"
                    + "5. Moka\n"
                    + "6. Te chai\n"
                    + "7. Cafe frio\n"
            ));

            switch (opcion) {
                case 1:
                    this.bebida = "Cafe";
                    bandera = false;
                    break;
                case 2:
                    this.bebida = "Capuccino";
                    bandera = false;
                    break;
                case 3:
                    this.bebida = "Capuccino Vanilla";
                    bandera = false;
                    break;
                case 4:
                    this.bebida = "Chocolate";
                    bandera = false;
                    break;
                case 5:
                    this.bebida = "Moka";
                    bandera = false;
                    break;
                case 6:
                    this.bebida = "Te chai";
                    bandera = false;
                    break;
                case 7:
                    this.bebida = "Cafe frio";
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
        this.bebidaAsignada = false;
    }

    public void setHora() {
        String hour = "";
        Random aleatorio = new Random();
        int hora = aleatorio.nextInt(6, 17);
        int min = aleatorio.nextInt(0, 59);
        hour = hora + ":" + min;
        this.horaEntrega = hour;

    }

    public void mostrarReservas() {
        String mensaje = "";
        if (bebidasAsignadas == 0) {
            mensaje = "No hay bebida asignadas";
        } else {
            for (int i = 0; i < bebidasAsignadas; i++) {
                mensaje += (i + 1) + ")" + "El trabajador:  " + bebidas[i].trabajador.getName() + "\n tiene la bebida: " + bebidas[i].getBebida() + "\n" + "Se entrega a la hora: " + bebidas[i].getHoraEntrega() + "\n";

            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public boolean isBebidaAsignada() {
        return bebidaAsignada;
    }

    public String getBebida() {
        return bebida;
    }

}
