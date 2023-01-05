public class Stroj {
    private final StrojStav[][] tab_prechodu = new StrojStav[StrojStav.values().length + 1][StrojVstup.values().length + 1];
    private final int[][] tab_vystupu = new int[StrojStav.values().length + 1][StrojVstup.values().length + 1];

    private StrojStav stav;
    private StrojVstup vstup;

    private boolean change;

    private boolean v1;
    private boolean v2;
    private boolean v3;
    private boolean v4;
    private boolean v5;
    private boolean v6;
    private boolean v7;

    private boolean p;
    private boolean z;

    public Stroj(){}

    public void inic_tab(){
        // TABULKA PRECHODU
        // Pocatecni stav
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.AB_01.getIndex()] = StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.AB_10.getIndex()] = StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.AB_11.getIndex()] = StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.LA2_1.getIndex()] = StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.LA4_1.getIndex()] = StrojStav.S_1;
        tab_prechodu[StrojStav.S_1.getIndex()] [StrojVstup.RUC.getIndex()]   = StrojStav.S_2;
        tab_prechodu[StrojStav.S_2.getIndex()] [StrojVstup.LA2_0.getIndex()] = StrojStav.S_3;
        tab_prechodu[StrojStav.S_3.getIndex()] [StrojVstup.LA4_0.getIndex()] = StrojStav.S_4;
        tab_prechodu[StrojStav.S_0.getIndex()] [StrojVstup.AB_00.getIndex()] = StrojStav.S_4;

        // Sanitace A
        tab_prechodu[StrojStav.S_4.getIndex()] [StrojVstup.N_A.getIndex()]   = StrojStav.S_5A;
        tab_prechodu[StrojStav.S_5A.getIndex()][StrojVstup.LA1_1.getIndex()] = StrojStav.S_6A;
        tab_prechodu[StrojStav.S_6A.getIndex()][StrojVstup.LA2_0.getIndex()] = StrojStav.S_7A;
        tab_prechodu[StrojStav.S_7A.getIndex()][StrojVstup.LA1_1.getIndex()] = StrojStav.S_8A;
        tab_prechodu[StrojStav.S_8A.getIndex()][StrojVstup.Q_0.getIndex()]   = StrojStav.S_9A;
        tab_prechodu[StrojStav.S_9A.getIndex()][StrojVstup.LA2_0.getIndex()] = StrojStav.S_4;

        // Sanitace B
        tab_prechodu[StrojStav.S_4.getIndex()] [StrojVstup.N_B.getIndex()]   = StrojStav.S_5B;
        tab_prechodu[StrojStav.S_5B.getIndex()][StrojVstup.LA3_1.getIndex()] = StrojStav.S_6B;
        tab_prechodu[StrojStav.S_6B.getIndex()][StrojVstup.LA4_0.getIndex()] = StrojStav.S_7B;
        tab_prechodu[StrojStav.S_7B.getIndex()][StrojVstup.LA3_1.getIndex()] = StrojStav.S_8B;
        tab_prechodu[StrojStav.S_8B.getIndex()][StrojVstup.Q_0.getIndex()]   = StrojStav.S_9B;
        tab_prechodu[StrojStav.S_9B.getIndex()][StrojVstup.LA4_0.getIndex()] = StrojStav.S_4;

        // TABULKA TRANSFORMACI

        // TABULKA VYSTUPU
        // Pocatecni stav
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.AB_01.getIndex()] = 1;
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.AB_10.getIndex()] = 1;
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.AB_11.getIndex()] = 1;
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.LA2_1.getIndex()] = 1;
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.LA4_1.getIndex()] = 1;
        tab_vystupu[StrojStav.S_1.getIndex()] [StrojVstup.RUC.getIndex()]   = 2;
        tab_vystupu[StrojStav.S_2.getIndex()] [StrojVstup.LA2_0.getIndex()] = 3;
        tab_vystupu[StrojStav.S_3.getIndex()] [StrojVstup.LA4_0.getIndex()] = 4;
        tab_vystupu[StrojStav.S_0.getIndex()] [StrojVstup.AB_00.getIndex()] = 5;

        // Sanitace A
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_A.getIndex()]   = 6;
        tab_vystupu[StrojStav.S_5A.getIndex()][StrojVstup.LA1_1.getIndex()] = 7;
        tab_vystupu[StrojStav.S_6A.getIndex()][StrojVstup.LA2_0.getIndex()] = 8;
        tab_vystupu[StrojStav.S_7A.getIndex()][StrojVstup.LA1_1.getIndex()] = 9;
        tab_vystupu[StrojStav.S_8A.getIndex()][StrojVstup.Q_0.getIndex()]   = 10;
        tab_vystupu[StrojStav.S_9A.getIndex()][StrojVstup.LA2_0.getIndex()] = 11;

        // Sanitace B
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_B.getIndex()]   = 12;
        tab_vystupu[StrojStav.S_5B.getIndex()][StrojVstup.LA3_1.getIndex()] = 13;
        tab_vystupu[StrojStav.S_6B.getIndex()][StrojVstup.LA4_0.getIndex()] = 14;
        tab_vystupu[StrojStav.S_7B.getIndex()][StrojVstup.LA3_1.getIndex()] = 15;
        tab_vystupu[StrojStav.S_8B.getIndex()][StrojVstup.Q_0.getIndex()]   = 16;
        tab_vystupu[StrojStav.S_9B.getIndex()][StrojVstup.LA4_0.getIndex()] = 17;
    }

    public void inic_stav(){
        stav = StrojStav.S_0;

        change = true;

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

    public void vstup_znaku(StrojVstup vstup){
        this.vstup = vstup;
    }

    public void transf_akce(){
        StrojStav tab_stav = tab_prechodu[stav.getIndex()][vstup.getIndex()];
        if(tab_stav != null){
            this.stav = tab_stav;
            change = true;
            return;
        }
        change = false;
    }

    public void vyst_akce(){
        int vystup = tab_vystupu[stav.getIndex()][vstup.getIndex()];
        if(vystup != 0){
            System.out.println("Výstup: ");
        }
        switch (vystup) {
            // Pocatecni stav
            case 1 -> {
                z = true;

                System.out.println(StrojVystup.Z_1.getPopis());
            }
            case 2 -> {
                v5 = true;
                v7 = true;

                System.out.println(StrojVystup.V5_1.getPopis());
                System.out.println(StrojVystup.V7_1.getPopis());
            }
            case 3 -> {
                v5 = false;
                v6 = true;

                System.out.println(StrojVystup.V5_0.getPopis());
                System.out.println(StrojVystup.V6_1.getPopis());
            }
            case 4 -> {
                v6 = false;
                v7 = false;
                z = false;

                System.out.println(StrojVystup.V6_0.getPopis());
                System.out.println(StrojVystup.V7_0.getPopis());
                System.out.println(StrojVystup.Z_0.getPopis());
            }

            case 5 ->{

            }

            // Sanitace A
            case 6 -> {
                v1 = true;
                v3 = true;

                System.out.println(StrojVystup.V1_1.getPopis());
                System.out.println(StrojVystup.V3_1.getPopis());
            }
            case 7 -> {
                v1 = false;
                v3 = false;
                v5 = true;
                p = true;

                System.out.println(StrojVystup.V1_0.getPopis());
                System.out.println(StrojVystup.V3_0.getPopis());
                System.out.println(StrojVystup.V5_1.getPopis());
                System.out.println(StrojVystup.P_1.getPopis());
            }
            case 8 -> {
                v5 = false;
                p = false;
                v2 = true;
                v3 = true;

                System.out.println(StrojVystup.V5_0.getPopis());
                System.out.println(StrojVystup.P_0.getPopis());
                System.out.println(StrojVystup.V2_1.getPopis());
                System.out.println(StrojVystup.V3_1.getPopis());
            }
            case 9 -> {
                v5 = true;
                v7 = true;

                System.out.println(StrojVystup.V5_1.getPopis());
                System.out.println(StrojVystup.V7_1.getPopis());
            }
            case 10 -> {
                v2 = false;
                v3 = false;

                System.out.println(StrojVystup.V2_0.getPopis());
                System.out.println(StrojVystup.V3_0.getPopis());
            }
            case 11 -> {
                v5 = false;
                v7 = false;

                System.out.println(StrojVystup.V5_0.getPopis());
                System.out.println(StrojVystup.V7_0.getPopis());
            }

            // Sanitace B
            case 12 -> {
                v1 = true;
                v4 = true;

                System.out.println(StrojVystup.V1_1.getPopis());
                System.out.println(StrojVystup.V4_1.getPopis());
            }
            case 13 -> {
                v1 = false;
                v4 = false;
                v6 = true;
                p = true;

                System.out.println(StrojVystup.V1_0.getPopis());
                System.out.println(StrojVystup.V4_0.getPopis());
                System.out.println(StrojVystup.V6_1.getPopis());
                System.out.println(StrojVystup.P_1.getPopis());
            }
            case 14 -> {
                v6 = false;
                p = false;
                v2 = true;
                v4 = true;

                System.out.println(StrojVystup.V6_0.getPopis());
                System.out.println(StrojVystup.P_0.getPopis());
                System.out.println(StrojVystup.V2_1.getPopis());
                System.out.println(StrojVystup.V4_1.getPopis());
            }
            case 15 -> {
                v6 = true;
                v7 = true;

                System.out.println(StrojVystup.V6_1.getPopis());
                System.out.println(StrojVystup.V7_1.getPopis());
            }
            case 16 -> {
                v2 = false;
                v4 = false;

                System.out.println(StrojVystup.V2_0.getPopis());
                System.out.println(StrojVystup.V4_0.getPopis());
            }
            case 17 -> {
                v6 = false;
                v7 = false;

                System.out.println(StrojVystup.V6_0.getPopis());
                System.out.println(StrojVystup.V7_0.getPopis());
            }
        }
    }

    public void prompt(){
        switch (stav) {
            // Pocatecni stav
            case S_0 -> {
                System.out.println("+------------------------------------+");
                System.out.println(center("Stav " + stav));
                System.out.println(center(stav.getPopis()));
                System.out.println("+------------------------------------+");
                System.out.println(center("Zadejte hladinu nádrží"));
                System.out.println("+------------------------------------+");
                System.out.println("|       1 = A prázdná, B prázdná     |");
                System.out.println("|       2 = A prázdná, B plná        |");
                System.out.println("|       3 = A plná, B prázdná        |");
                System.out.println("|       4 = A plná, B plná           |");
                System.out.println("+------------------------------------+");
            }

            case S_1 -> {
                System.out.println("+------------------------------------+");
                System.out.println(center("Stav " + stav));
                System.out.println(center(stav.getPopis()));
                System.out.println("+------------------------------------+");
                System.out.println(center(StrojVstup.RUC.getIndex() + " = " + StrojVstup.RUC.getPopis()));
                System.out.println("+------------------------------------+");
            }

            case S_2 -> printStav("V nádrži A se nachází kapalina", StrojVstup.LA2_0, StrojVstup.LA2_1);

            case S_3 -> printStav("V nádrži B se nachází kapalina", StrojVstup.LA4_0, StrojVstup.LA4_1);

            case S_4 -> printStav("Zvolte nádrž pro sanitaci", StrojVstup.N_A, StrojVstup.N_B);

            // Smycka A
            case S_5A -> printStav("Nádrž A je plná louhu", StrojVstup.LA1_0, StrojVstup.LA1_1);

            case S_6A -> printStav("V nádrži A již není louh", StrojVstup.LA2_0, StrojVstup.LA2_1);

            case S_7A -> printStav("Nádrž A je plná vody", StrojVstup.LA1_0, StrojVstup.LA1_1);

            case S_8A -> printStav("Hodnota pH na výtoku klesla", StrojVstup.Q_0, StrojVstup.Q_1);

            case S_9A -> printStav("Z nádrže A vytelka všechna voda", StrojVstup.LA2_0, StrojVstup.LA2_1);

            // Smycka B
            case S_5B -> printStav("Nádrž B je plná louhu", StrojVstup.LA3_0, StrojVstup.LA3_1);

            case S_6B -> printStav("V nádrži B již není louh", StrojVstup.LA4_0, StrojVstup.LA4_1);

            case S_7B -> printStav("Nádrž B je plná vody", StrojVstup.LA3_0, StrojVstup.LA3_1);

            case S_8B -> printStav("Hodnota pH na výtoku klesla", StrojVstup.Q_0, StrojVstup.Q_1);

            case S_9B -> printStav("Z nádrže B vytelka všechna voda", StrojVstup.LA4_0, StrojVstup.LA4_1);
        }
    }

    public static String center(String string) {
        int cap = 38;
        StringBuilder sb = new StringBuilder(cap);
        sb.append("|");
        sb.setLength((cap - string.length()) / 2);
        sb.append(string);
        sb.setLength(cap - 1);
        sb.append("|");
        return sb.toString().replace('\0', ' ');
    }



    public void printStav(String prompt, StrojVstup vstup1, StrojVstup vstup2){
        System.out.println("+------------------------------------+");
        System.out.println(center("Stav " + stav));
        System.out.println(center(stav.getPopis()));
        System.out.println("+------------------------------------+");
        System.out.println(center(vstup1.getIndex() + " = " + vstup1.getPopis()));
        System.out.println(center(vstup2.getIndex() + " = " + vstup2.getPopis()));
        System.out.println("+------------------------------------+");
    }

    public void printStroj(){
        System.out.println("+-------------+");
        System.out.println("| Stav: "     + stav + "   |");
        System.out.println("| Ventil 1: " + (v1 ? "1" : "0") + " |");
        System.out.println("| Ventil 2: " + (v2 ? "1" : "0") + " |");
        System.out.println("| Ventil 3: " + (v3 ? "1" : "0") + " |");
        System.out.println("| Ventil 4: " + (v4 ? "1" : "0") + " |");
        System.out.println("| Ventil 5: " + (v5 ? "1" : "0") + " |");
        System.out.println("| Ventil 6: " + (v6 ? "1" : "0") + " |");
        System.out.println("| Ventil 7: " + (v7 ? "1" : "0") + " |");
        System.out.println("| Čerpadlo: " + (p  ? "1" : "0") + " |");
        System.out.println("| Žárovka:  " + (z  ? "1" : "0") + " |");
        System.out.println("+-------------+");
    }

    public StrojStav getStav(){
        return stav;
    }

    public boolean changed(){
        return change;
    }

    public void setChanged(boolean what){
        change = what;
    }
}
