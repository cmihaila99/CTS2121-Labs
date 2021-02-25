package tema1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        ///Sugestia 1: alegerea de nume mai inspirate pentru variabile, de ex numarContainer1, numarContainer2 etc
        TipContainer[] tipC = new TipContainer[4];
        tipC=TipContainer.values();
        int[] nrc1=new int[]{2,2,3,1};
        PortContainer portContainer1=new PortContainer("PC1",tipC,nrc1);
        int[] nrc2=new int[]{3,3,2,4};
        PortContainer portContainer2=new PortContainer("PC2",tipC,nrc2);
        int[] nrc3=new int[]{2,6,4,2};
        PortContainer portContainer3=new PortContainer("PC3",tipC,nrc3);
        int[] nrc4=new int[]{7,3,6,5};
        //PortContainer portContainer4=new PortContainer("PC4",tipC,nrc4);


        //Sugestia 4: realizarea unei functii de afisare, pentru ca se repeta aceasta secventa de linii de cod
        PortContainer portContainer4=new PortContainer();
        try {
            portContainer4=(PortContainer) portContainer3.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("PortContainerul 3 este: " + portContainer3.toString());
        System.out.println("Clona,portContainer4, creata dupa portContainerul 3 este: " + portContainer4.toString());
        portContainer4.setEticheta("PC4");
        portContainer4.setTip(tipC);
        portContainer4.setNrContainere(nrc4);
        System.out.println("PortContainerul 4 a devenit: " + portContainer4.toString());
        System.out.println("Capacitatea portContainerului 4 este " + portContainer4.getCapacitate());
        System.out.println();

        //Colectie de tip lista pentru PortConainere
        ArrayList<PortContainer> listaPortContainere= new ArrayList<>();
        listaPortContainere.add(portContainer1);
        listaPortContainere.add(portContainer2);
        listaPortContainere.add(portContainer3);
        listaPortContainere.add(portContainer4);

        //afisarea listei la consola si salvarea acesteia in fisier
        FileWriter iesireFisier=null;
        BufferedWriter scriere=null;

        System.out.println("Lista de PortContainere:");
        try {
            iesireFisier=new FileWriter("PortContainere.csv",false);
            scriere=new BufferedWriter(iesireFisier);
                    for (PortContainer i:listaPortContainere) {
                        System.out.println(i.toString());
                        scriere.write(i.toString());
                        scriere.newLine();
                    }
            scriere.close();
            iesireFisier.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        int a = portContainer1.getCapacitate();
//        System.out.println(a);

        System.out.println("\nCoada de PortContainere:");
        //citirea listei din fisier si refacerea acesteia intr-o colectie de tip coada



        /////Sugestia 3: realizarea unei functii care citeste si reface o lista pentru a putea fi reutilizata

        ////Sugestia 5: De asemenea, aici s-ar fi putut face de fapt 2 functii, una care citeste din fisier si una care reface lista intr-o colectie de tip coada
        ArrayDeque<PortContainer> coadaPortContainereImportata=new ArrayDeque<>();
        FileReader intrareFisier=null;
        BufferedReader citire=null;

        try {
            intrareFisier=new FileReader("PortContainere.csv");
            citire=new BufferedReader(intrareFisier);
            Scanner scannerFisier=new Scanner(citire);
            while(scannerFisier.hasNext()){

                String linie = scannerFisier.nextLine();
                Scanner scannerLinie = new Scanner(linie);
                scannerLinie.useDelimiter(",");

                PortContainer existent=new PortContainer();
                existent.setEticheta(scannerLinie.next());
                TipContainer[] tipImportat=new TipContainer[4];
                tipImportat=TipContainer.values() ;
                existent.setTip(tipImportat);
                scannerLinie.next();
                int[] nrContainerImportat=new int[4];
                existent.setNrContainere(nrContainerImportat);

                coadaPortContainereImportata.offerFirst(existent);
                citire.close();
                intrareFisier.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }

        PortContainer test=null;
        while(!coadaPortContainereImportata.isEmpty()){
            test=coadaPortContainereImportata.pollLast();
            System.out.println(test.toString());
        }

        ////
        Macara macara1=new Macara(TipContainer.Mic_10mc,100);
        Macara macara2=new Macara(TipContainer.Mediu_25mc,250);
        Macara macara3=new Macara(TipContainer.Mare_50mc,500);
        Macara macara4=new Macara(TipContainer.Jumbo_100mc,1000);

        //Lista de obiecte de tip Macara
        ArrayList<Macara> listaMacarale=new ArrayList<>();
        listaMacarale.add(macara1);
        listaMacarale.add(macara2);
        listaMacarale.add(macara3);
        listaMacarale.add(macara4);

        //Testare DescarcaContainer(PortContainer,Macara)
        System.out.println();
        System.out.println("\nInainte de descarcare, numarul de containere din fiecare tip a fost:");
        for(int i=0;i<4;i++) {
            System.out.println(" Din tipul "+listaMacarale.get(i).getTip()+ " au fost "+listaPortContainere.get(i).getNrContainere()[i] + " containere");
        }
        int ContainereRamase1=macara1.DescarcaContainer(portContainer1,macara1);
        int ContainereRamase2=macara2.DescarcaContainer(portContainer2,macara2);
        int ContainereRamase3=macara3.DescarcaContainer(portContainer3,macara3);
        int ContainereRamase4=macara4.DescarcaContainer(portContainer4,macara4);

        //Lista formata din numarul de containere ramase din fiecare tip
        ArrayList<Integer> listaContainereRamase=new ArrayList<>();
        listaContainereRamase.add(ContainereRamase1);
        listaContainereRamase.add(ContainereRamase2);
        listaContainereRamase.add(ContainereRamase3);
        listaContainereRamase.add(ContainereRamase4);

        System.out.println("\nDupa descarcare, numarul de containere din fiecare tip a devenit:");
        for(int i=0;i<4;i++) {
            System.out.println(" Din tipul "+listaMacarale.get(i).getTip()+ " exista acum "+listaContainereRamase.get(i) + " containere");
        }

        ////Sugestia 2: comentarii care nu au fost sterse

        /////incercare fire de executie
//        int[] nrcr1=new int[]{3,2,3,4};
//        int[] nrcr2=new int[]{5,4,3,1};
//        int[] nrcr3=new int[]{1,3,3,2};
//        int[] nrcr4=new int[]{4,2,5,3};
//
//        PortContainer portContainerR1=new PortContainer("PCR1",tipC,nrcr1,4);
//        PortContainer portContainerR2=new PortContainer("PCR2",tipC,nrcr2,4);
//        PortContainer portContainerR3=new PortContainer("PCR3",tipC,nrcr3,4);
//        PortContainer portContainerR4=new PortContainer("PCR4",tipC,nrcr4,4);
//
//        Thread macaraR1=new Macara(TipContainer.Mic_10mc,100,portContainerR1);
//        Thread macaraR2=new Macara(TipContainer.Mediu_25mc,250,portContainerR1);
//        Thread macaraR3=new Macara(TipContainer.Mare_50mc,500,portContainerR1);
//        Thread macaraR4=new Macara(TipContainer.Jumbo_100mc,1000,portContainerR1);
//
//        macaraR1.setName("Firul 1");
//        macaraR2.setName("Firul 2");
//        macaraR3.setName("Firul 3");
//        macaraR4.setName("Firul 4");
//
//        macaraR1.start();
//        macaraR2.start();
//        macaraR3.start();
//        macaraR4.start();


    }
}
