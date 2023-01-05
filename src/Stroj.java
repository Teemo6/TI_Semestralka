import jdk.swing.interop.SwingInterOpUtils;

public class Stroj {
    private final StrojStav[][] tab_prechodu = new StrojStav[StrojStav.values().length][StrojVstup.values().length];
    private final int[][] tab_vystupu = new int[StrojStav.values().length][StrojVstup.values().length];

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
        tab_prechodu[StrojStav.S_0.getIndex()][StrojVstup.LA2_1.getIndex()] =  StrojStav.S_1;
        tab_prechodu[StrojStav.S_0.getIndex()][StrojVstup.LA4_1.getIndex()] =  StrojStav.S_1;
        tab_prechodu[StrojStav.S_1.getIndex()][StrojVstup.RUC.getIndex()]   =  StrojStav.S_2;
        tab_prechodu[StrojStav.S_2.getIndex()][StrojVstup.LA2_0.getIndex()] =  StrojStav.S_3;
        tab_prechodu[StrojStav.S_3.getIndex()][StrojVstup.LA4_0.getIndex()] =  StrojStav.S_4;

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
        tab_vystupu[StrojStav.S_0.getIndex()][StrojVstup.LA2_1.getIndex()] = 1;
        tab_vystupu[StrojStav.S_0.getIndex()][StrojVstup.LA4_1.getIndex()] = 1;
        tab_vystupu[StrojStav.S_1.getIndex()][StrojVstup.RUC.getIndex()]   = 2;
        tab_vystupu[StrojStav.S_2.getIndex()][StrojVstup.LA2_0.getIndex()] = 3;
        tab_vystupu[StrojStav.S_3.getIndex()][StrojVstup.LA4_0.getIndex()] = 4;

        // Sanitace A
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_A.getIndex()]   = 5;
        tab_vystupu[StrojStav.S_5A.getIndex()][StrojVstup.LA1_1.getIndex()] = 6;
        tab_vystupu[StrojStav.S_6A.getIndex()][StrojVstup.LA2_0.getIndex()] = 7;
        tab_vystupu[StrojStav.S_7A.getIndex()][StrojVstup.LA1_1.getIndex()] = 8;
        tab_vystupu[StrojStav.S_8A.getIndex()][StrojVstup.Q_0.getIndex()]   = 9;
        tab_vystupu[StrojStav.S_9A.getIndex()][StrojVstup.LA2_0.getIndex()] = 10;

        // Sanitace B
        tab_vystupu[StrojStav.S_4.getIndex()] [StrojVstup.N_B.getIndex()]   = 11;
        tab_vystupu[StrojStav.S_5B.getIndex()][StrojVstup.LA3_1.getIndex()] = 12;
        tab_vystupu[StrojStav.S_6B.getIndex()][StrojVstup.LA4_0.getIndex()] = 13;
        tab_vystupu[StrojStav.S_7B.getIndex()][StrojVstup.LA3_1.getIndex()] = 14;
        tab_vystupu[StrojStav.S_8B.getIndex()][StrojVstup.Q_0.getIndex()]   = 15;
        tab_vystupu[StrojStav.S_9B.getIndex()][StrojVstup.LA4_0.getIndex()] = 16;
    }

    public void inic_stav(){
        stav = StrojStav.S_0;

        System.out.println(StrojVystup.V1_0.getPopis());
        System.out.println(StrojVystup.V2_0.getPopis());
        System.out.println(StrojVystup.V3_0.getPopis());
        System.out.println(StrojVystup.V4_0.getPopis());
        System.out.println(StrojVystup.V5_0.getPopis());
        System.out.println(StrojVystup.V6_0.getPopis());
        System.out.println(StrojVystup.V7_0.getPopis());
        System.out.println(StrojVystup.P_0.getPopis());
        System.out.println(StrojVystup.Z_0.getPopis());

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

            // Sanitace A
            case 5 -> {
                v1 = true;
                v3 = true;

                System.out.println(StrojVystup.V1_1.getPopis());
                System.out.println(StrojVystup.V3_1.getPopis());
            }
            case 6 -> {
                v1 = false;
                v3 = false;
                v5 = true;
                p = true;

                System.out.println(StrojVystup.V1_0.getPopis());
                System.out.println(StrojVystup.V3_0.getPopis());
                System.out.println(StrojVystup.V5_1.getPopis());
                System.out.println(StrojVystup.P_1.getPopis());
            }
            case 7 -> {
                v5 = false;
                p = false;
                v2 = true;
                v3 = true;

                System.out.println(StrojVystup.V5_0.getPopis());
                System.out.println(StrojVystup.P_0.getPopis());
                System.out.println(StrojVystup.V2_1.getPopis());
                System.out.println(StrojVystup.V3_1.getPopis());
            }
            case 8 -> {
                v5 = true;
                v7 = true;

                System.out.println(StrojVystup.V5_1.getPopis());
                System.out.println(StrojVystup.V7_1.getPopis());
            }
            case 9 -> {
                v2 = false;
                v3 = false;

                System.out.println(StrojVystup.V2_0.getPopis());
                System.out.println(StrojVystup.V3_0.getPopis());
            }
            case 10 -> {
                v5 = false;
                v7 = false;

                System.out.println(StrojVystup.V5_0.getPopis());
                System.out.println(StrojVystup.V7_0.getPopis());
            }

            // Sanitace B
            case 11 -> {
                v1 = true;
                v4 = true;

                System.out.println(StrojVystup.V1_1.getPopis());
                System.out.println(StrojVystup.V4_1.getPopis());
            }
            case 12 -> {
                v1 = false;
                v4 = false;
                v6 = true;
                p = true;

                System.out.println(StrojVystup.V1_0.getPopis());
                System.out.println(StrojVystup.V4_0.getPopis());
                System.out.println(StrojVystup.V6_1.getPopis());
                System.out.println(StrojVystup.P_1.getPopis());
            }
            case 13 -> {
                v6 = false;
                p = false;
                v2 = true;
                v4 = true;

                System.out.println(StrojVystup.V6_0.getPopis());
                System.out.println(StrojVystup.P_0.getPopis());
                System.out.println(StrojVystup.V2_1.getPopis());
                System.out.println(StrojVystup.V4_1.getPopis());
            }
            case 14 -> {
                v6 = true;
                v7 = true;

                System.out.println(StrojVystup.V6_1.getPopis());
                System.out.println(StrojVystup.V7_1.getPopis());
            }
            case 15 -> {
                v2 = false;
                v4 = false;

                System.out.println(StrojVystup.V2_0.getPopis());
                System.out.println(StrojVystup.V4_0.getPopis());
            }
            case 16 -> {
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
                System.out.println("+----------------------------+");
                System.out.println(center("Stav " + stav));
                System.out.println(center(stav.getPopis()));
                System.out.println("+----------------------------+");
                System.out.println(center("Zadejte hladinu nádrží"));
                System.out.println("+----------------------------+");
                System.out.println("|  1 = A prázdná, B prázdná  |");
                System.out.println("|  2 = A prázdná, B plná     |");
                System.out.println("|  3 = A plná, B prázdná     |");
                System.out.println("|  4 = A plná, B plná        |");
                System.out.println("+----------------------------+");
            }
        }
    }

    public static String center(String string) {
        int cap = 30;
        StringBuilder sb = new StringBuilder(cap);
        sb.append("|");
        sb.setLength((cap - string.length()) / 2);
        sb.append(string);
        sb.setLength(cap - 1);
        sb.append("|");
        return sb.toString().replace('\0', ' ');
    }

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
        System.out.println("----------------");
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
