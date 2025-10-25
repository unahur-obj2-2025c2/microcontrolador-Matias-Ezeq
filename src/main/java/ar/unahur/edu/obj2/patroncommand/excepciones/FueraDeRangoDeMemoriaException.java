package ar.unahur.edu.obj2.patroncommand.excepciones;

public class FueraDeRangoDeMemoriaException extends RuntimeException{
    public FueraDeRangoDeMemoriaException() {
        super("dirección de memoria fuera de rango");
    }
}
