package dias.gabriel;

public class Basico02 {
    public static void main(String[] args) {
        int ano=2021;
//        if (ano%2==0){
//            System.out.println("ano par");
//        }
//        if (ano%2==1){
//            System.out.println("ano impar");
//        }
        if (ano%2==0){
            System.out.println("ano par");
        }else {
            System.out.println("impar");
        }
        switch (ano){
            case 2020:
                System.out.println("vish");
                break;
            case 1999:
                System.out.println("ave");
            default:
                System.out.println("te amo");
                break;
        }
    }
}
