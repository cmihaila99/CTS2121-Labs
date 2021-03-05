package ro.ase.acs.main;

import ro.ase.acs.readers.ConsoleReader;
import ro.ase.acs.writers.ConsoleWriter;
import ro.ase.acs.writers.Writeable;
import ro.ase.acs.readers.Readable;
import ro.ase.acs.main.IoC;

public class Orchestrator {
    private Readable reader ;
    private Writeable writer ;
    private IoC container;

    public Orchestrator(Readable reader, Writeable writer){
        this.reader=reader;
        this.writer=writer;
    }
    public Orchestrator(IoC container) {
        this.container = container;
        this.writer = this.container.resolve(Writeable.class);
        this.reader = this.container.resolve(Readable.class);
    }

    public void execute(){
        writer.write(reader.read());
    }
}
