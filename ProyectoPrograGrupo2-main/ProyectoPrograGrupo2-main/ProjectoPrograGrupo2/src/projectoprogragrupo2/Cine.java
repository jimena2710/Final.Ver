package projectoprogragrupo2;

public class Cine {

    public Cine() {
        
    }
    
    

    private int asientos = 0;
    private String nombrePelicula = "";

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    //Metodo para asignar cantidad de asientos
    //Retornamos -1 en caso de que sea un numero negativo o mayor a 30 que es el maximo
    //Si es 1 el numero fue asignado y podemos usar el getAsietnos para ver la cantidad de asientos
    public int cantidadAsientos(int cantidadAsientos) {
        int validacion = 0;
        if (cantidadAsientos < 0 || cantidadAsientos > 30) {
            validacion = -1;

        } else {
            this.asientos = cantidadAsientos;
            validacion++;
        }

        return validacion;
    }

}
