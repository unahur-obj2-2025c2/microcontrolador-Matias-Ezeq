package ar.unahur.edu.obj2.patroncommand.excepciones;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.invoker.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.LOD;

public class FueraDeRangoDeMemoriaExceptionTest {
    Programable micro = new Microcontrolador();
    Programa programa = new Programa();

    @BeforeEach
    public void setup() {
        programa.vaciarLista();
        programa.resetearMicro(micro);
    }

    @Test 
    public void accederAUnaDireccionMenorACeroLanzaExcepcion() {
        programa.agregarOperacion(new LOD(-4));
        assertThrows(FueraDeRangoDeMemoriaException.class, () -> programa.ejecutar(micro));
    }

    @Test 
    public void accederAUnaDireccionMayorA1023LanzaExcepcion() {
        programa.agregarOperacion(new LOD(1024));
        assertThrows(FueraDeRangoDeMemoriaException.class, () -> programa.ejecutar(micro));
    }
}
