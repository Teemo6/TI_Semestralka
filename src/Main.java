import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int vstupCislo;
        String next;

        Scanner sc = new Scanner(System.in);
        Stroj stroj = new Stroj();

        // Inicializace automatu
        stroj.inic_stav();
        stroj.inic_tab();

        // Smycka pro vstup
        while (true){
            // Vypis na obrazovku
            if(stroj.changed()) {
                stroj.prompt();
            }
            System.out.print("Vstup: ");
            next = sc.next();

            // Nacti cislo
            try{
                vstupCislo = Integer.parseInt(next);
            } catch (NumberFormatException e) {
                stroj.setChanged(false);
                continue;
            }

            // Cislo zaporny, ukonci
            if(vstupCislo < 0){
                break;
            }

            // Predej vstup automatu
            StrojVstup.convert(vstupCislo).ifPresent(v -> {
                System.out.println("       " + v);
                stroj.vstup_znaku(v);
                System.out.println();
            });
            stroj.vyst_akce();
            stroj.transf_akce();
        }
        System.out.println("Ukončuji program");
        sc.close();
    }
}
