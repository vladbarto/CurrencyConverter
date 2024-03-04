public class BNRModel {
    public static double[][] conversii;
    public static double rezultat;
    public BNRModel(){
        this.conversii = new double[3][3];
        this.conversii[0][0] = this.conversii[1][1] = this.conversii[2][2] = 1;
        this.conversii[0][1] = 4.902;
        this.conversii[0][2] = 1.0615;
        this.conversii[1][0] = 0.204;
        this.conversii[1][2] = 0.2165;
        this.conversii[2][0] = 0.9421;
        this.conversii[2][1] = 4.618;
    }
    public static int determineCoinIndex(String text){
        switch(text){
            case "EUR" : return 0;
            case "RON" : return 1;
            case "USD" : return 2;
            default: return 3;
        }
    }

    public static double[][] getConversii() {
        return conversii;
    }
    public static void conversie(String input, double value){
        rezultat = Double.parseDouble(input);
        rezultat *= value;
    }

    public String getRezultat() {
        return Double.toString(rezultat);
    }
}
