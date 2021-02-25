package tema1;

public class Macara extends Thread implements DescarcaContainer  {
    private TipContainer tip;
    private int timpManipulare;

    PortContainer portContainer;

    public Macara(TipContainer tip, int timpManipulare) {
        this.tip = tip;
        this.timpManipulare = timpManipulare;
    }

    public Macara() {
        this.tip=null;
        this.timpManipulare=0;
    }

    public Macara(TipContainer tip, int timpManipulare, PortContainer portContainer) {
        this.tip = tip;
        this.timpManipulare = timpManipulare;
        this.portContainer = portContainer;
    }

    public TipContainer getTip() {
        return tip;
    }

    public void setTip(TipContainer tip) {
        this.tip = tip;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }



    ///Sugestia 5: Aceeasi functie comentata poate crea confuzii daca varianta gresita nu este stearsa din fisier
    ///Sugestia 6: De asemenea, functii care au aceeasi denumire pot crea confuzii

    @Override
    public int DescarcaContainer(PortContainer portContainer, Macara macara) {
        int nrcontainereRamase=0;
        for(int i=0;i<portContainer.getTip().length;i++){
            if(portContainer.getNrContainere()[i]!=0){
                if(portContainer.getTip()[i].toString()==macara.tip.toString()){
                    portContainer.setNumarTipContainer(i,portContainer.getNrContainere()[i]-1);
                    nrcontainereRamase=portContainer.getNrContainere()[i];
                }
            }

        }
        return nrcontainereRamase;
    }
////
////    public int descarcaContainer(PortContainer portContainer, Macara macara) {
////       int nrcontainereRamase = 0;
////        synchronized (this) {
////            if (this.portContainer.isDescarcare()) {
////                for (int i = 0; i < portContainer.getTip().length; i++) {
////                    if (portContainer.getNrContainere()[i] != 0) {
////                        if (portContainer.getTip()[i].toString() == macara.tip.toString()) {
////                           portContainer.setNumarTipContainer(i, portContainer.getNrContainere()[i] - 1);
////                            nrcontainereRamase = portContainer.getNrContainere()[i];
////                        }
////                    }
////                }
////            }
////        }
////        return nrcontainereRamase;
////    }
////

////   public void run() {
////        ////Macara macara=new Macara();
////    try {
////        while(true) {
////            sleep(timpManipulare);
////            ////descarcaContainer(portContainer,macara);
////        }
////    } catch (InterruptedException e) {
////
////   }
////}

}
