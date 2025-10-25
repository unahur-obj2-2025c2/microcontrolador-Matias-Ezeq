package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.invoker.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.*;
import ar.unahur.edu.obj2.patroncommand.operaciones.*;

public class MicrocontroladorTest {
    Programable micro = new Microcontrolador();
    Programa programa = new Programa();

    @BeforeEach
    public void setup() {
        programa.vaciarLista();
        programa.resetearMicro(micro);
    }
    
    @Test
    public void programCounterAvanza3con3Instrucciones() {
        programa.agregarOperacion(new NOP());
        programa.agregarOperacion(new NOP());
        programa.agregarOperacion(new NOP());

        programa.ejecutar(micro);
        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    public void sumar20mas17() {
        programa.agregarOperacion(new LODV(20));
        programa.agregarOperacion(new SWAP());
        programa.agregarOperacion(new LODV(17));
        programa.agregarOperacion(new ADD());
        
        programa.ejecutar(micro);
        assertEquals(37,micro.getAcumuladorA());
    }

    @Test
    public void sumar2mas8mas5() {
        programa.agregarOperacion(new LODV(2));
        programa.agregarOperacion(new STR(0));
        programa.agregarOperacion(new LODV(8));
        programa.agregarOperacion(new SWAP());
        programa.agregarOperacion(new LODV(5));
        programa.agregarOperacion(new ADD());
        programa.agregarOperacion(new SWAP());
        programa.agregarOperacion(new LOD(0));
        programa.agregarOperacion(new ADD());

        programa.ejecutar(micro);
        assertEquals(15,micro.getAcumuladorA());
    }
}
