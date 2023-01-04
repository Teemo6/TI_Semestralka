import java.util.Arrays;
import java.util.Optional;

public enum StrojVstup {
    /////////////////////////////
    ////// Aktivní signály //////
    /////////////////////////////
    N_A(0, "Spuštění sanitace nádrže A"),
    N_B(1, "Spuštění sanitace nádrže B"),
    RUC(2, "Ruční vypouštění nádrží"),

    /////////////////////////////
    ////// Pasivní signály //////
    /////////////////////////////
    LA1_0(3, "Hladina klesla pod horní čidlo A"),
    LA1_1(4, "Hladina stoupla nad horní čidlo A"),
    LA2_0(5, "Hladina klesla pod dolní čidlo A"),
    LA2_1(6, "Hladina stoupla nad dolní čidlo A"),
    LA3_0(7, "Hladina klesla pod horní čidlo B"),
    LA3_1(8, "Hladina stoupla nad horní čidlo B"),
    LA4_0(9, "Hladina klesla pod dolní čidlo B"),
    LA4_1(10, "Hladina stoupla nad dolní čidlo B"),
    Q_0(11, "Výtok má vysoké pH"),
    Q_1(12, "Výtok má nízké pH");

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
