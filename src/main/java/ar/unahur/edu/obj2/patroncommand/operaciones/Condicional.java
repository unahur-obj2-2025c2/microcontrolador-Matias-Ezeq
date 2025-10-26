package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.ArrayList;
import java.util.List;

public abstract class Condicional extends Comando{
    protected List<Comando> subrutina;

    public Condicional(){
        this.subrutina = new ArrayList<>();
    }

    public void agregarOperacion(Comando operacion){
        this.subrutina.add(operacion);
    }

    public void agregarOperaciones(List<Comando> operaciones){
        this.subrutina.addAll(operaciones);
    }

}
