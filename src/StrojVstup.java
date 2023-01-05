import java.util.Arrays;
import java.util.Optional;

/**
 * Vstup stroje
 */
public enum StrojVstup {
    /////////////////////////////
    ////// Skupina signálů //////
    /////////////////////////////
    AB_00(1, "A prázdná, B prázdná"),
    AB_01(2, "A prázdná, B plná"),
    AB_10(3, "A plná, B prázdná"),
    AB_11(4, "A plná, B plná"),

    /////////////////////////////
    ////// Aktivní signály //////
    /////////////////////////////
    RUC(5, "Ruční vypouštění nádrží"),
    N_A(6, "Sanitace nádrže A"),
    N_B(7, "Sanitace nádrže B"),

    /////////////////////////////
    ////// Pasivní signály //////
    /////////////////////////////
    LA1_0(8, "Horní čidlo LA1 není aktivní"),
    LA1_1(9, "Horní čidlo LA1 aktivní"),
    LA2_0(10, "Dolní čidlo LA2 není aktivní"),
    LA2_1(11, "Dolní čidlo LA2 aktivní"),
    LA3_0(12, "Horní čidlo LA3 není aktivní"),
    LA3_1(13, "Horní čidlo LA3 aktivní"),
    LA4_0(14, "Dolní čidlo LA4 není aktivní"),
    LA4_1(15, "Dolní čidlo LA4 aktivní"),
    Q_0(16, "Q není aktivní (pH kleslo)"),
    Q_1(17, "Q aktivní (pH nekleslo)");

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
