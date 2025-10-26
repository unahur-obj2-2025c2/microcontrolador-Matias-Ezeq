package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class IFNZ extends Condicional{

    @Override
    protected void doExecute(Programable micro) {
        if (micro.getAcumuladorA() != 0) {
            this.subrutina.forEach(c -> c.doExecute(micro));
        }
    }

}
