package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class LOD extends Comando{
    private final Integer addr;

    public LOD(Integer addr) {
        this.addr = addr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(this.addr));
    }

}
