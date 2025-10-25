package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public abstract class Comando implements Operable{

    private Programable microBackup;

    @Override
    public void execute(Programable micro) {
        microBackup = micro.copiar();
        this.doExecute(micro);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro){
        micro.copiarDesde(microBackup);
    }

    protected abstract void doExecute(Programable micro);

}
