import jdk.swing.interop.SwingInterOpUtils;

public class Stroj {
    private StrojStav stav;

    private final StrojStav[][] tab_prechodu = new StrojStav[StrojStav.values().length][StrojVstup.values().length];
    private final int[][] tab_transformaci = new int[StrojStav.values().length][StrojVstup.values().length];
    private final int[][] tab_vystupu = new int[StrojStav.values().length][StrojVstup.values().length];

    private boolean v1;
    private boolean v2;
    private boolean v3;
    private boolean v4;
    private boolean v5;
    private boolean v6;
    private boolean v7;

    private boolean p;
    private boolean z;

    public Stroj(){
        inic_tab();
        inic_stav();

        v1 = false;
        v2 = false;
        v3 = false;
        v4 = false;
        v5 = false;
        v6 = false;
        v7 = false;

        p = false;
        z = false;
    }

    public void inic_tab(){
        // TABULKA PRECHODU
        // Pocatecni stav
        tab_prechodu[StrojStav.S_0.getIndex()][StrojVstup.LA2_1.getIndex()] =  StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()][StrojVstup.LA4_1.getIndex()] =  StrojStav.S_1;
        tab_prechodu[StrojStav.S_1.getIndex()][StrojVstup.RUC.getIndex()] =    StrojStav.S_2;
        tab_prechodu[StrojStav.S_2.getIndex()][StrojVstup.LA2_0.getIndex()] =  StrojStav.S_3;
        tab_prechodu[StrojStav.S_3.getIndex()][StrojVstup.LA4_0.getIndex()] =  StrojStav.S_4;

        // Sanitace A
        tab_prechodu[StrojStav.S_4.getIndex()] [StrojVstup.N_A.getIndex()] =   StrojStav.S_5A;
        tab_prechodu[StrojStav.S_5A.getIndex()][StrojVstup.LA1_1.getIndex()] = StrojStav.S_6A;
        tab_prechodu[StrojStav.S_6A.getIndex()][StrojVstup.LA2_0.getIndex()] = StrojStav.S_7A;
        tab_prechodu[StrojStav.S_7A.getIndex()][StrojVstup.LA1_1.getIndex()] = StrojStav.S_8A;
        tab_prechodu[StrojStav.S_8A.getIndex()][StrojVstup.Q_0.getIndex()] =   StrojStav.S_9A;
        tab_prechodu[StrojStav.S_9A.getIndex()][StrojVstup.LA2_0.getIndex()] = StrojStav.S_4;

        // Sanitace B
        tab_prechodu[StrojStav.S_4.getIndex()] [StrojVstup.N_B.getIndex()] =   StrojStav.S_5B;
        tab_prechodu[StrojStav.S_5B.getIndex()][StrojVstup.LA3_1.getIndex()] = StrojStav.S_6B;
        tab_prechodu[StrojStav.S_6B.getIndex()][StrojVstup.LA4_0.getIndex()] = StrojStav.S_7B;
        tab_prechodu[StrojStav.S_7B.getIndex()][StrojVstup.LA3_1.getIndex()] = StrojStav.S_8B;
        tab_prechodu[StrojStav.S_8B.getIndex()][StrojVstup.Q_0.getIndex()] =   StrojStav.S_9B;
        tab_prechodu[StrojStav.S_9B.getIndex()][StrojVstup.LA4_0.getIndex()] = StrojStav.S_4;

        // TABULKA TRANSFORMACI

        // TABULKA VYSTUPU
        // Pocatecni stav
        tab_vystupu[StrojStav.S_0.getIndex()][StrojVstup.LA2_1.getIndex()] = 0;
        tab_vystupu[StrojStav.S_0.getIndex()][StrojVstup.LA4_1.getIndex()] = 1;
        tab_vystupu[StrojStav.S_1.getIndex()][StrojVstup.RUC.getIndex()] =   2;
        tab_vystupu[StrojStav.S_2.getIndex()][StrojVstup.LA2_0.getIndex()] = 3;
        tab_vystupu[StrojStav.S_3.getIndex()][StrojVstup.LA4_0.getIndex()] = 4;

        // Sanitace A
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_A.getIndex()] =   5;
        tab_vystupu[StrojStav.S_5A.getIndex()][StrojVstup.LA1_1.getIndex()] = 6;
        tab_vystupu[StrojStav.S_6A.getIndex()][StrojVstup.LA2_0.getIndex()] = 7;
        tab_vystupu[StrojStav.S_7A.getIndex()][StrojVstup.LA1_1.getIndex()] = 8;
        tab_vystupu[StrojStav.S_8A.getIndex()][StrojVstup.Q_0.getIndex()] =   9;
        tab_vystupu[StrojStav.S_9A.getIndex()][StrojVstup.LA2_0.getIndex()] = 10;

        // Sanitace B
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_B.getIndex()] =   11;
        tab_vystupu[StrojStav.S_5B.getIndex()][StrojVstup.LA3_1.getIndex()] = 12;
        tab_vystupu[StrojStav.S_6B.getIndex()][StrojVstup.LA4_0.getIndex()] = 13;
        tab_vystupu[StrojStav.S_7B.getIndex()][StrojVstup.LA3_1.getIndex()] = 14;
        tab_vystupu[StrojStav.S_8B.getIndex()][StrojVstup.Q_0.getIndex()] =   15;
        tab_vystupu[StrojStav.S_9B.getIndex()][StrojVstup.LA4_0.getIndex()] = 16;
    }

    public void inic_stav(){
        stav = StrojStav.S_0;
    }

    public void vstup_znaku(StrojVstup vstup){
        vyst_akce(vstup);
        transf_akce(vstup);
    }

    public void transf_akce(StrojVstup vstup){
        StrojStav tab_stav = tab_prechodu[stav.getIndex()][vstup.getIndex()];
        if(tab_stav != null){
            this.stav = tab_stav;
            printStav();
        }
    }

    public void vyst_akce(StrojVstup vstup){
        int vystup = tab_vystupu[stav.getIndex()][vstup.getIndex()];
        switch (vystup) {
            // Smycka A
            case 1 -> {
                v1 = true;
                v3 = true;
            }
            case 2 -> {
                v1 = false;
                v3 = false;
                v5 = true;
                p = true;
            }
            case 3 -> {
                v5 = false;
                p = false;
                v2 = true;
                v3 = true;
            }
            case 4 -> {
                v5 = true;
                v7 = true;
            }
            case 5 -> {
                v2 = false;
                v3 = false;
            }
            case 6 -> {
                v5 = false;
                v7 = false;
            }

            // Smycka B
            case 7 -> {
                v1 = true;
                v4 = true;
            }
            case 8 -> {
                v1 = false;
                v4 = false;
                v6 = true;
                p = true;
            }
            case 9 -> {
                v6 = false;
                p = false;
                v2 = true;
                v4 = true;
            }
            case 10 -> {
                v6 = true;
                v7 = true;
            }
            case 11 -> {
                v2 = false;
                v4 = false;
            }
            case 12 -> {
                v6 = false;
                v7 = false;
            }

            // Chybova smycka
            case 13 -> z = true;
            case 14 -> {
                v5 = false;
                v6 = true;
            }
            case 15 -> {
                z = false;
                v6 = false;
                v7 = false;
            }
        }
    }
/*
    public void prompt(){
        switch (stav) {
            // Pocatecni stav
            case S_0 -> {
                System.out.println("------------------------------");
                System.out.println("|           Stav 0           |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|  Jsou obě nádrže prázdné?  |");
                System.out.println("|       0 = NE, 1 = ANO      |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");


                System.out.println("------------------------------");
                System.out.println("|           Stav 0           |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|   Zvolte sanitaci nádrže   |");
                System.out.println("|      0 = N/A, 1 = N/B      |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");
            }

            // Smycka A
            case S_1A -> {
                System.out.println("------------------------------");
                System.out.println("|          Stav 1_A          |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|   Je nádrž A plná louhu?   |");
                System.out.println("|   0 = LA01/0, 1 = LA01/1   |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");

            }
            case S_2A -> {
                System.out.println("------------------------------");
                System.out.println("|          Stav 2_A          |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|   Je nádrž A vyprázdněna?  |");
                System.out.println("|   0 = LA02/0, 1 = LA02/1   |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");
            }
            case S_3A -> {
                System.out.println("------------------------------");
                System.out.println("|          Stav 3_A          |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|    Je nádrž A plná vody?   |");
                System.out.println("|   0 = LA01/0, 1 = LA01/1   |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");

            }
            case S_4A -> {
                System.out.println("------------------------------");
                System.out.println("|          Stav 4_A          |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|     Kleslo pH na výtoku?   |");
                System.out.println("|      0 = Q/0, 1 = Q/1      |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");
            }

            case S_5A -> {
                System.out.println("------------------------------");
                System.out.println("|          Stav 5_A          |");
                System.out.printf ("|"+center(stav.getPopis())+ "|\n");
                System.out.println("|----------------------------|");
                System.out.println("|     Kleslo pH na výtoku?   |");
                System.out.println("|    0 = LA02/0, 1 = LA02/1  |");
                System.out.println("------------------------------");
                System.out.print("Vstup: ");
            }

            // Smycka B
            case S_1B -> System.out.println("");
            case S_2B -> System.out.println("");
            case S_3B -> System.out.println("");
            case S_4B -> System.out.println("");
            case S_5B -> System.out.println("");

            // Chybova smycka
            case S_6 -> System.out.println("");
            case S_7 -> System.out.println("");
            case S_8 -> System.out.println("");
        }
    }

    public static String center(String string) {
        int cap = 28;
        StringBuilder sb = new StringBuilder(cap);
        sb.setLength((cap - string.length()) / 2);
        sb.append(string);
        sb.setLength(cap);
        return sb.toString().replace('\0', ' ');
    }
*/
    public void printStav(){
        System.out.println("----------------");
        System.out.println("Stav: " + stav + ", " + stav.getPopis());
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("v3: " + v3);
        System.out.println("v4: " + v4);
        System.out.println("v5: " + v5);
        System.out.println("v6: " + v6);
        System.out.println("v7: " + v7);
        System.out.println("p: " + p);
        System.out.println("z: " + z);
    }
}
