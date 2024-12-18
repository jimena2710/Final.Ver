
package proyectofinal.grupo2;

import IGU.Inicio;

import javax.swing.JOptionPane;

public class ProyectoFinalGrupo2 {
    
    public static void main(String[] args) {

        //Interfaz Gráfica 
        //Inicio
        Inicio start = new Inicio();
        start.setVisible(true);
        start.setLocationRelativeTo(null);

        //Llamamos a gym
        Gimnasio gim = new Gimnasio();
        //Llamaos a barista
        Barista barista = new Barista();

        //Llamamos a yoga
        Yoga yoga = new Yoga();

        //Baile
        Baile baile = new Baile();

        //Cine
        Cine cine1[] = new Cine[100];
        int contadorSalas = 0;
        //Cantidad Peliculas
        String peliculas[] = {"Amistad", "Ángeles", "Ali", "Admitido", "El escape perfecto"};

        //Precargamos informacion de trabajador en lista
        Trabajador trabajador1[] = new Trabajador[30];
        trabajador1[0] = new Trabajador("Mike", "It", "1");
        trabajador1[1] = new Trabajador("Juan", "It", "2");
        trabajador1[2] = new Trabajador("Hernest", "It", "3");
        trabajador1[3] = new Trabajador("Sofia", "It", "4");
        trabajador1[4] = new Trabajador("Juliana", "It", "5");
        trabajador1[5] = new Trabajador("Fernanda", "It", "6");
        trabajador1[6] = new Trabajador("Bravo", "It", "7");

        /*
        //Ciclo de menu
        int opcion = 0;
        boolean ciclo = true;
        while (ciclo) {
            //Continuar
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Hola que desea hacer:" + "\n1.Ver gimnasio\n" + "2.Barista\n" + "3. Baile o Yoga\n" + "4.Cine\n" + "5.Salir"));
            switch (opcion) {
                case 1:
                    int opcion1 = Integer.parseInt(JOptionPane.showInputDialog("1.Ver reservaciones\n" + "2.Hacer reservaciones\n" + "3.Cambiar reservacion\n" + "4.Eliminar reservacion"));
                    switch (opcion1) {
                        case 1:
                            gim.verReservaciones();
                            break;
                        case 2:
                            gim.hacerReservacion(trabajador1);
                            break;
                        case 3:
                            gim.modificarReserva(trabajador1);
                            break;
                        case 4:
                            gim.eliminarReserva();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("1.Ver bebidas asignadas\n" + "2.Asignar bebida\n" + "3.Cambiar bebida\n" + "4.Eliminar bebida reservada"));
                    switch (opcion2) {
                        case 1:
                            barista.mostrarReservas();
                            break;
                        case 2:
                            barista.reservarBebida(trabajador1);
                            break;
                        case 3:
                            barista.cambiarBebida();
                            break;
                        case 4:
                            barista.eliminarReserva();
                            break;
                    }
                    break;
                case 3:
                    int opcion3 = Integer.parseInt(JOptionPane.showInputDialog("Hola!! con que desea interactuar\n" + "1.Ver yoga\n" + "2. Ver baile"));
                    switch (opcion3) {
                        case 1:
                            int opcion4 = Integer.parseInt(JOptionPane.showInputDialog("1.Ver reservaciones\n" + "2.Hacer reservacion\n" + "3.Borrar Reservacion\n"));
                            switch (opcion4) {
                                case 1:
                                    yoga.mostrarReservaciones();
                                    break;
                                case 2:
                                    yoga.reservarYoga(trabajador1);
                                    break;
                                case 3:
                                    yoga.eliminarReserva();
                                    break;

                            }
                            break;
                        case 2:
                            int opcion5 = Integer.parseInt(JOptionPane.showInputDialog("1.Ver reservaciones\n" + "2.Hacer reservacion\n" + "3.Borrar Reservacion\n"));
                            switch (opcion5) {
                                case 1:
                                    baile.mostrarReservaciones();
                                    break;
                                case 2:
                                    baile.reservarBaile(trabajador1);
                                    break;
                                case 3:
                                    baile.eliminarReserva();
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                                    break;

                            }

                            break;

                    }
                    break;
                case 4:

                    //Entrada Clase Cine
                    //Cantidad de espacios para el cine
                    int opcion6 = Integer.parseInt(JOptionPane.showInputDialog("1.Ver salas\n2.Modificar Salas\n3.Borrar Sala"));
                    switch (opcion6) {

                        case 1:
                            String mensaje = "";
                            if (contadorSalas == 0) {
                                JOptionPane.showMessageDialog(null, "No hay salas que se puedan ver");

                            } else {
                                for (int i = 0; i < contadorSalas; i++) {
                                    mensaje += cine1[i].getNomPelicula() + "\n" + cine1[i].mostrarSalas();
                                }
                                JOptionPane.showMessageDialog(start, mensaje);
                            }
                            break;
                        case 2:
                            int ciclo1 = Integer.parseInt(JOptionPane.showInputDialog("Cuantas salas va a crear"));
                            mensaje = "";
                            for (int t = 0; t < peliculas.length; t++) {
                                mensaje += peliculas[t] + "\n";

                            }
                            JOptionPane.showMessageDialog(null, mensaje);
                            String nombrePelicula = JOptionPane.showInputDialog("Cual es la pelicula que quiere escoger");

                            for (int i = 0; i < ciclo1; i++) {
                                int cantidadAsietnos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos asientos va a tener la sala"));
                                if (cantidadAsietnos > 31) {
                                    JOptionPane.showMessageDialog(null, "No se pueden tener mas de 30 asientos se asigo la cantidad maxima automaticamente");
                                    cantidadAsietnos = 30;
                                }

                                cine1[contadorSalas] = new Cine(cantidadAsietnos, trabajador1, nombrePelicula);
                                for (int j = 0; j < cantidadAsietnos; j++) {

                                    cine1[i].ocuparAsientos();

                                }
                                for (int j = 0; j < cantidadAsietnos; j++) {
                                    cine1[i].llenarTrabajadores(trabajador1);
                                }

                                contadorSalas++;

                            }
                            break;
                             case 3:
        // borrar las salas
        if (contadorSalas == 0) {
            JOptionPane.showMessageDialog(null, "No hay salas");
        } else {
            String cantidadSalas = "Salas disponibles:\n";
            for (int i = 0; i < contadorSalas; i++) {
                salasDisponibles += (i + 1) + ". Sala - Película: " + cine1[i].getNomPelicula() + "\n";
            }
            JOptionPane.showMessageDialog(null, cantidadSalas);
            int borrarSala = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de sala que desea borrar (1 a " + contadorSalas + "):")) - 1;
            
            if (borrarSala >= 0 && borrarSala < contadorSalas) {
                for (int i = borrarSala; i < contadorSalas - 1; i++) {
                    cine1[i] = cine1[i + 1]; // Desplazar las salas hacia atrás
                }
                
                JOptionPane.showMessageDialog(null, "Se borró la sala de forma exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "No es un número válido.");
            }
        }
        break;
case 4:
        // Agregar trabajadores a la sala
        if (contadorSalas == 0) {
            JOptionPane.showMessageDialog(null, "No hay salas disponibles");
        } else {
            String cantidadSalas = "Salas disponibles:\n";
            for (int i = 0; i < contadorSalas; i++) {
                cantidadSalas += (i + 1) + ". Sala - Película: " + cine1[i].getNomPelicula() + "\n";
            }
            JOptionPane.showMessageDialog(null, cantidadSalas);
            int salaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de sala donde va a agregar un nuevo trabajador (1 a " + contadorSalas + "):")) - 1;
            
            if (salaSeleccionada >= 0 && salaSeleccionada < contadorSalas) {
                String nombreTrabajador = JOptionPane.showInputDialog("Ingrese el nombre del trabajador:");
                Trabajador nuevoTrabajador = new Trabajador(nombreTrabajador); // se crea un nuevo trabajador
                cine1[salaSeleccionada].llenarTrabajadores(new Trabajador[] {nuevoTrabajador});
                JOptionPane.showMessageDialog(null, "El trabajador fue agregado de froma exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido.");
            }
        }
        break;

    default:
        JOptionPane.showMessageDialog(null, "Opción no válida.");
        break;
                    }

            }

        }
         */
    }
}
