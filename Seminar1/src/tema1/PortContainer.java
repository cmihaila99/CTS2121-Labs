package tema1;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class PortContainer implements Cloneable, Numarabil {
    private String eticheta;
    private TipContainer[] tip;
    private int[] nrContainere;

    private Semaphore descarcare;
    private int nrPermisiuni;

    public PortContainer(String eticheta, TipContainer[] tip, int[] nrContainere) {
        this.eticheta = eticheta;
        this.tip = tip;
        this.nrContainere = nrContainere;
    }

    public PortContainer() {
        this.eticheta = null;
        this.tip = null;
        this.nrContainere = null;
    }
/////
    public PortContainer(String eticheta, TipContainer[] tip, int[] nrContainere, int nrPermisiuni) {
        this.eticheta = eticheta;
        this.tip = tip;
        this.nrContainere = nrContainere;
        this.nrPermisiuni = nrPermisiuni;
        this.descarcare=new Semaphore(nrPermisiuni);
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public TipContainer[] getTip() {
        return tip;
    }

    public void setTip(TipContainer[] tip) {
        this.tip = tip;
    }

    public void setNumarTipContainer(int i,int valoare){ this.nrContainere[i]=valoare; }

    public int[] getNrContainere() {
        return nrContainere;
    }

    public void setNrContainere(int[] nrContainere) {
        this.nrContainere = nrContainere;
    }

    public int getNrPermisiuni() {
        return nrPermisiuni;
    }

    public void setNrPermisiuni(int nrPermisiuni) {
        this.nrPermisiuni = nrPermisiuni;
    }

    @Override
    public String toString() {
        return this.eticheta + "," + Arrays.toString(tip) + "," + Arrays.toString(nrContainere);

    }

    @Override
    public int getCapacitate() {
        int capacitateContainer = 0;
        capacitateContainer = nrContainere[0] * 10 + nrContainere[1] * 25 + nrContainere[2] * 50 + nrContainere[3] * 100;
        return capacitateContainer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PortContainer clona=(PortContainer) super.clone();
        clona.eticheta=eticheta;
        clona.tip=tip;
        clona.nrContainere=new int[nrContainere.length];
        for(int i=0; i<nrContainere.length; i++)
        {
            clona.nrContainere[i]=nrContainere[i];
        }
        return clona;
    }


    ////Sugestia 2: comentarii care nu au fost sterse

//    public synchronized boolean isDescarcare() {
//        return this.descarcare.tryAcquire();
//    }
//
//    public synchronized void ObtineDescarcare(){
//        try {
//            this.descarcare.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public synchronized void ElibereazaDescarcare(){ this.descarcare.release();}
}
