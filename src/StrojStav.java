/**
 * Stavy stroje
 */
public enum StrojStav {
    /////////////////////////////
    ////// Počáteční stav ///////
    /////////////////////////////
    S_0(0, "Počáteční stav"),
    S_1(1, "Nádrže nejsou prázdné"),
    S_2(2, "Ruční vypouštění nádrže A"),
    S_3(3, "Ruční vypouštění nádrže B"),
    S_4(4, "Systém čeká na vstup"),

    /////////////////////////////
    ///// Sanitace nádoby A /////
    /////////////////////////////
    S_5A(5, "Napouštění louhem nádrže A"),
    S_6A(6, "Vypouštění louhu nádrže A"),
    S_7A(7, "Napouštění vodou nádrže A"),
    S_8A(8, "Proplachování vodou nádrže A"),
    S_9A(9, "Vypouštění vody nádrže A"),

    /////////////////////////////
    ///// Sanitace nádoby B /////
    /////////////////////////////
    S_5B(10, "Napouštění louhem nádrže B"),
    S_6B(11, "Vypouštění louhu nádrže B"),
    S_7B(12, "Napouštění vodou nádrže B"),
    S_8B(13, "Proplachování vodou nádrže B"),
    S_9B(14, "Vypouštění vody nádrže B");

    /////////////////////////////
    //////// Konstruktor ////////
    /////////////////////////////
    private final int index;
    private final String popis;

    StrojStav(int oznaceni, String popis) {
        this.index = oznaceni;
        this.popis = popis;
    }

    /**
     * Vrátí označení operace
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Vrátí string v popisu
     * @return popis
     */
    public String getPopis() {
        return popis;
    }
}
