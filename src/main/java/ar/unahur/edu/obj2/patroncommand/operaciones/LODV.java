package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class LODV extends Comando{
    private final Integer val;

    public LODV(Integer valor) {
        this.val = valor;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }

}
