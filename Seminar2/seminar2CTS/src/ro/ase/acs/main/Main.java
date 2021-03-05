package ro.ase.acs.main;
import ro.ase.acs.readers.Readable;


import ro.ase.acs.readers.ConsoleReader;
import ro.ase.acs.writers.ConsoleWriter;
import ro.ase.acs.writers.FileWriter;
import ro.ase.acs.writers.Writeable;

public class Main {
    public static void main(String[] args){
        IoC container = new IoC();
        container.register(Writeable.class, FileWriter.class);
        container.register(Readable.class, ConsoleReader.class);

        // Orchestrator orchestrator = new Orchestrator(new ConsoleReader(),new FileWriter());
        Orchestrator orchestrator = new Orchestrator(container);
        orchestrator.execute();
    }



}
