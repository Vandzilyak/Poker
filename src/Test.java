import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    private static HashMap<String, Integer> mp = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] crd = new String[5];
        System.out.println("Введіть 5 карт 2-9 A-туз K-король Q-дама J-валет T-десять");
        for (int i = 0; i < 5; i++) {
            if (!sc.hasNext("[akqjtAKQJT23456789]")) {
                System.out.println("Немає такої карти - " + sc.next());
                return;
            } else {
                crd[i] = sc.next();
            }
        }
        checkMap(crd);

    }

    public static void checkMap(String[] str) {
        for (String st : str) {
            if (!mp.containsKey(st)) {
                mp.put(st, 1);
            } else {
                Integer ct = mp.get(st);
                if (ct != null) {
                    ct++;
                    mp.put(st, ct);
                }
            }
        }

        Integer pair = 0;
        Integer set = 0;
        Integer kare = 0;

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            System.out.print(mp.entrySet() + " ");
            if (entry.getValue() == 2) {
                pair++;
            } else if (entry.getValue() == 3) {
                set++;
            } else if (entry.getValue() == 4) {
                kare++;
            }
        }

        if (pair == 1 && set == 1) {
            System.out.println("FULL HOUSE");
        } else if (pair == 1) {
            System.out.println("PAIR");
        } else if (pair == 2) {
            System.out.println("TOO PAIR");
        } else if (set == 1) {
            System.out.println("SET");
        } else if (kare == 1) {
            System.out.printf("KARE");
        }
    }
}