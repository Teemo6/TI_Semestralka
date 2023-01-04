import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stroj stroj = new Stroj();
        int vstupCislo;

        while (true){

            try{
                vstupCislo = sc.nextInt();
            } catch (InputMismatchException e) {
                continue;
            }

            if(vstupCislo < 0){
                break;
            }

            StrojVstup.convert(vstupCislo).ifPresent(stroj::vstup_znaku);
        }
    }
}
