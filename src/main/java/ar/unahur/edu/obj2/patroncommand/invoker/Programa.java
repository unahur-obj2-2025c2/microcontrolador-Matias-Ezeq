package ar.unahur.edu.obj2.patroncommand.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Programa {
    List<Operable> operaciones;

    public Programa() {
        operaciones = new ArrayList<>();
    }

    public void agregarOperacion(Operable operacion) {
        operaciones.add(operacion);
    }

    public void agregarOperaciones(List<Operable> operaciones) {
        this.operaciones.addAll(operaciones);
    }

    public void vaciarLista() {
        operaciones.clear();
    }

    public void ejecutar(Programable micro){
        micro.run(operaciones);
    }

    public void resetearMicro(Programable micro) {
        micro.reset();
    }

}
