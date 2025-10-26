package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.FueraDeRangoDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable{
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoria;

    public Microcontrolador() {
        this.reset();
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(operacion -> operacion.execute(this));
    }

    @Override
    public void incProgramCounter() {
        this.programCounter += 1;
    }

    @Override
    public Integer getProgramCounter() {
        return this.programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return this.acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return this.acumuladorB;
    }

    private void estaDentroDelRangoDeMemoria(Integer addr){
        if(addr <0 || addr >= memoria.size()) {
            throw new FueraDeRangoDeMemoriaException();
        }
    }

    @Override
    public void setAddr(Integer addr) {
        this.estaDentroDelRangoDeMemoria(addr);
        this.memoria.set(addr, this.acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) {
        this.estaDentroDelRangoDeMemoria(addr);
        return this.memoria.get(addr);
    }

    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.programCounter = 0;
        memoria = Arrays.asList(new Integer[1024]);
    }

    @Override
    public Programable copiar() {
        Microcontrolador nuevo = new Microcontrolador();
        nuevo.acumuladorA = this.acumuladorA;
        nuevo.acumuladorB = this.acumuladorB;
        nuevo.programCounter = this.programCounter;

        return nuevo;
    }

    @Override
    public void copiarDesde(Programable microDeRespaldo) {
        this.acumuladorA = microDeRespaldo.getAcumuladorA();
        this.acumuladorB = microDeRespaldo.getAcumuladorB();
        this.programCounter = microDeRespaldo.getProgramCounter();
    }

}
