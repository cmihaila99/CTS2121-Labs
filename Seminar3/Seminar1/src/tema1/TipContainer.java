package tema1;

public enum TipContainer {

    Mic_10mc("Mic_10mc"),
    Mediu_25mc("Mediu_25mc"),
    Mare_50mc("Mare_50mc"),
    Jumbo_100mc("Jumbo_100mc");

    String tip;

    TipContainer(String tip) {
        this.tip = tip;
    }
}
