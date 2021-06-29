import java.util.*;
class game {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        System.out.println("Game Bull and Cows :");
        System.out.println("______________________");

        player1();
        player2();



        }



    public static String getNumber() {
        ArrayList<String> possib = new ArrayList<String>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 1; c <= 9; c++) {
                    if (c == b || c == a) continue;
                    for (int d = 1; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        String cnt = ""+a+b+c+d;
                        possib.add(cnt);
                    }
                }
            }
        }
        String guess = possib.get((int)(Math.random() * possib.size()));
        return guess;
    }

    public static int feedback(String answer,String guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            int index = answer.indexOf(guess.charAt(i));
            if (index == i) bulls++;
            else if (index >= 0) cows++;
        }
        return bulls * 10 + cows;
    }
    public static void player1(){
        Scanner in =new Scanner(System.in);
        final String target = getNumber();
        System.out.println("Enter name for player1 : ");
        String name1 ;
        name1 = in.next();

        for (int i = 1; i <= 100; i++) {
            System.out.print(i+". ");
            String guess = in.next();
            int feedback = feedback(target, guess);
            System.out.println(guess+" - "+(feedback/10)+" bulls, "+(feedback%10)+" cows");
            if (feedback == 40) {System.out.println("CONGRATULATIONS! YOU WIN!"); return;}
        }
        System.out.println("You have run out of moves. The number was - "+target);
    }
    public static void player2(){
        Scanner in =new Scanner(System.in);
        final String target = getNumber();
        String name2;
        name2 = in.next();
        System.out.println("Enter name for player2 :");
        Scanner in1 = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            System.out.print(i+". ");
            String guess = in.next();
            int feedback = feedback(target, guess);
            System.out.println(guess+" - "+(feedback/10)+" bulls, "+(feedback%10)+" cows");
            if (feedback == 40) {System.out.println("CONGRATULATIONS! YOU WIN!"); return;}
        }
        System.out.println("You have run out of moves. The number was - "+target);
    }

}