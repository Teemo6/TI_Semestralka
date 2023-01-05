import java.util.Arrays;
import java.util.Optional;

/**
 * Vstup stroje
 */
public enum StrojVstup {
    /////////////////////////////
    ////// Skupina signálů //////
    /////////////////////////////
    AB_00(0, "A prázdná, B prázdná"),
    AB_01(1, "A prázdná, B plná"),
    AB_10(2, "A plná, B prázdná"),
    AB_11(3, "A plná, B plná"),

    /////////////////////////////
    ////// Aktivní signály //////
    /////////////////////////////
    RUC(4, "Ruční vypouštění nádrží"),
    N_A(5, "Sanitace nádrže A"),
    N_B(6, "Sanitace nádrže B"),

    /////////////////////////////
    ////// Pasivní signály //////
    /////////////////////////////
    LA1_0(7, "LA1 není aktivní"),
    LA1_1(8, "LA1 aktivní"),
    LA2_0(9, "LA2 není aktivní"),
    LA2_1(10, "LA2 aktivní"),
    LA3_0(11, "LA3 není aktivní"),
    LA3_1(12, "LA3 aktivní"),
    LA4_0(13, "LA4 není aktivní"),
    LA4_1(14, "LA4 aktivní"),
    Q_0(15, "Q není aktivní"),
    Q_1(16, "Q aktivní");

    /////////////////////////////
    //////// Konstruktor ////////
    /////////////////////////////
    private final int index;
    private final String popis;

    StrojVstup(int oznaceni, String popis) {
        this.index = oznaceni;
        this.popis = popis;
    }

    /**
     * Vrátí enum podle čísla
     * @return StrojVstup
     */
    public static Optional<StrojVstup> convert(int cislo) {
        return Arrays.stream(StrojVstup.values()).filter(i -> i.getIndex() == cislo).findFirst();
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
