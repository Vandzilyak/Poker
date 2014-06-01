import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] crd = new String[5];
        System.out.println("Please enter a vowel, lowercase!");
        for (int i = 0; i < 5; i++) {
            if (!sc.hasNext("[akqjt23456789]")) {
                System.out.println("That's not a vowel!");
                return;
            } else {
                crd[i] = sc.next();
            }
        }
        for (int i=0; i<5; i++){
            System.out.println(crd[i]+" ");
        }
    }
}
