package tema1;

public class MacaraRobotizata {
    PortContainer portContainer;
    Macara macara;

    public MacaraRobotizata(PortContainer portContainer, Macara macara) {
        this.portContainer = portContainer;
        this.macara = macara;
    }

    public MacaraRobotizata() {
        this.portContainer=null;
        this.macara=null;
    }

    public PortContainer getPortContainer() {
        return portContainer;
    }

    public void setPortContainer(PortContainer portContainer) {
        this.portContainer = portContainer;
    }

    public Macara getMacara() {
        return macara;
    }

    public void setMacara(Macara macara) {
        this.macara = macara;
    }
}
