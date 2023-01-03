/**
 * Stavy stroje
 */
public enum StrojStav {
    /////////////////////////////
    ////// Počáteční stav ///////
    /////////////////////////////
    S_0("Systém čeká na vstup"),

    /////////////////////////////
    ////// Cyklus nádoby A //////
    /////////////////////////////
    S_1A("Napouštění louhem A"),
    S_2A("Vypouštění louhu A"),
    S_3A("Napouštění vodou A"),
    S_4A("Proplachování vodou A"),
    S_5A("Vypouštění vody A"),

    /////////////////////////////
    ////// Cyklus nádoby B //////
    /////////////////////////////
    S_1B("Napouštění louhem B"),
    S_2B("Vypouštění louhu B"),
    S_3B("Napouštění vodou B"),
    S_4B("Proplachování vodou B"),
    S_5B("Vypouštění vody B"),

    /////////////////////////////
    ////// Chybový cyklus ///////
    /////////////////////////////
    S_6("Nádrže nejsou prázdné"),
    S_7("Ruční vypouštění obou nádrží");


    /////////////////////////////
    //////// Konstruktor ////////
    /////////////////////////////
    private final String popis;

    StrojStav(String popis) {
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
