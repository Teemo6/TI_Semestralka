public class Stroj {
    private StrojStav stav;

    private boolean v1;
    private boolean v2;
    private boolean v3;
    private boolean v4;
    private boolean v5;
    private boolean v6;
    private boolean v7;

    public Stroj(){
        stav = StrojStav.S_0;

        v1 = false;
        v2 = false;
        v3 = false;
        v4 = false;
        v5 = false;
        v6 = false;
        v7 = false;
    }

    public void zmenStav(StrojStav novyStav){
        switch (novyStav){
            case S_0:
                if(this.stav == StrojStav.S_5A) {
                    this.stav = novyStav;
                    v5 = false;
                    v7 = false;
                }
                if(this.stav == StrojStav.S_5B) {
                    this.stav = novyStav;
                    v6 = false;
                    v7 = false;
                }
                if(this.stav == StrojStav.S_7) {
                    this.stav = novyStav;
                    v5 = false;
                    v6 = false;
                    v7 = false;
                }
                break;

            case S_1A:
                if(this.stav == StrojStav.S_0) {
                    this.stav = novyStav;
                    v1 = true;
                    v3 = true;
                }
                break;

            case S_2A:
                if(this.stav == StrojStav.S_1A) {
                    this.stav = novyStav;
                    v1 = false;
                    v3 = false;
                    v5 = true;
                }
                break;

            case S_3A:
                if(this.stav == StrojStav.S_2A) {
                    this.stav = novyStav;
                    v5 = false;
                    v2 = true;
                    v3 = true;
                }
                break;

            case S_4A:
                if(this.stav == StrojStav.S_3A) {
                    this.stav = novyStav;
                    v5 = true;
                    v7 = true;
                }
                break;

            case S_5A:
                if(this.stav == StrojStav.S_4A) {
                    this.stav = novyStav;
                    v2 = false;
                    v3 = false;
                }
                break;

            case S_1B:
                if(this.stav == StrojStav.S_0) {
                    this.stav = novyStav;
                    v1 = true;
                    v4 = true;
                }
                break;

            case S_2B:
                if(this.stav == StrojStav.S_1B) {
                    this.stav = novyStav;
                    v1 = false;
                    v4 = false;
                    v6 = true;
                }
                break;

            case S_3B:
                if(this.stav == StrojStav.S_2B) {
                    this.stav = novyStav;
                    v6 = false;
                    v2 = true;
                    v4 = true;
                }
                break;

            case S_4B:
                if(this.stav == StrojStav.S_3B) {
                    this.stav = novyStav;
                    v6 = true;
                    v7 = true;
                }
                break;

            case S_5B:
                if(this.stav == StrojStav.S_4B) {
                    this.stav = novyStav;
                    v2 = false;
                    v4 = false;
                }
                break;

            case S_6:
                if(this.stav == StrojStav.S_0) {
                    this.stav = novyStav;
                }
                break;

            case S_7:
                if(this.stav == StrojStav.S_6) {
                    this.stav = novyStav;
                    v5 = true;
                    v6 = true;
                    v7 = true;
                }
                break;
        }
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
    }
}
