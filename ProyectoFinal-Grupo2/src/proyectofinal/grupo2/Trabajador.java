package proyectofinal.grupo2;

import javax.swing.JOptionPane;

public class Trabajador {

    private String name;
    private String position;
    private String id;

    public Trabajador(String name, String position, String id) {

        this.name = name;
        this.position = position;
        this.id = id;
    }

    //Buscar trabajador usamos para todas las clases
    public Trabajador buscarTrabajador(Trabajador trabajador[]) {
        Trabajador trabajador1=null;
        String mensaje = "";
        //bandera buscar id correcto
        boolean bandera = true;
        while (bandera) {
            String idTrabajador = JOptionPane.showInputDialog("Cual es el id del trabajador");
            for (int i = 0; i < 7; i++) {
                if (trabajador[i].getId().equals(idTrabajador)) {
                    trabajador1 = trabajador[i];
                    mensaje = "Trabajador encontrado";
                    bandera = false;
                    break;
                } else {
                    mensaje = "Trabajador no existe";
                }
            }

        }
        JOptionPane.showMessageDialog(null, mensaje);
        return trabajador1;

    }

    public Trabajador() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
