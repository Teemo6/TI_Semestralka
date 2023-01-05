
/**
 * Výstup stroje
 */
public enum StrojVystup {
    /////////////////////////////
    //////     Ventily     //////
    /////////////////////////////
    V1_0("       Uzavři ventil 1"),
    V1_1("       Otevři ventil 1"),
    V2_0("       Uzavři ventil 2"),
    V2_1("       Otevři ventil 2"),
    V3_0("       Uzavři ventil 3"),
    V3_1("       Otevři ventil 3"),
    V4_0("       Uzavři ventil 4"),
    V4_1("       Otevři ventil 4"),
    V5_0("       Uzavři ventil 5"),
    V5_1("       Otevři ventil 5"),
    V6_0("       Uzavři ventil 6"),
    V6_1("       Otevři ventil 6"),
    V7_0("       Uzavři ventil 7"),
    V7_1("       Otevři ventil 7"),

    /////////////////////////////
    //////     Ostatní     //////
    /////////////////////////////
    P_0("       Vypni čerpadlo"),
    P_1("       Spusť čerpadlo"),
    Z_0("       Zhasni žárovku"),
    Z_1("       Rozsviť žárovku");

    /////////////////////////////
    //////// Konstruktor ////////
    /////////////////////////////
    private final String popis;

    StrojVystup(String popis) {
        this.popis = popis;
    }

    /**
     * Vrátí string v popisu
     * @return popis
     */
    public String getPopis() {
        return popis;
    }
}
