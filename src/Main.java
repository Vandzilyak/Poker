import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Card> koloda = getCards();
        List<Card> hand = getInitHand(koloda);

        Map<Card, Integer> cardCount = calculateCardCount(hand);

        Integer pair = 0;
        Integer set = 0;
        Integer kare = 0;

        for (Map.Entry<Card, Integer> entry : cardCount.entrySet()) {
            if (entry.getValue() == 2) {
                pair++;
            } else if (entry.getValue() == 3) {
                set++;
            } else if (entry.getValue() == 4) {
                kare++;
            } else if (entry.getValue() == 5) {
                throw new RuntimeException("-------Неправильна комбінація!!!------");
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
        } else {

            Collections.sort(hand, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.id.compareTo(o2.id);
                }
            });

            Boolean isStreat = true;
            Boolean isStreetLow = false;

            int size = hand.size();
            for (int i = 0; i < size - 1; i++) {
                if (hand.get(i).id != hand.get(i + 1).id - 1) {
                    isStreat = false;
                    break;
                }
                if (hand.get(0).id == 2 && hand.get(1).id == 3 && hand.get(2).id == 4 && hand.get(3).id == 5 && hand.get(4).id == 14) {
                    isStreetLow = true;
                }
            }

            if (isStreat) {
                System.out.println("STREAT");
            }
            if (isStreetLow) {
                System.out.println("STREAT_LOW");
            }
        }
    }

    private static Map<Card, Integer> calculateCardCount(List<Card> hand) {
        Map<Card, Integer> cardCount = new HashMap<Card, Integer>();

        for (Card card : hand) {
            if (!cardCount.containsKey(card)) {
                cardCount.put(card, 1);
            } else {
                Integer amount = cardCount.get(card);
                if (amount != null) {
                    amount++;
                    cardCount.put(card, amount);
                }
            }
        }
        return cardCount;
    }

    private static void printHand(List<Card> crd) {
        for (Card entry : crd) {
            System.out.println(entry.name + " " + entry.id);
        }
    }

    private static List<Card> getInitHand(List<Card> koloda) {
        System.out.println("Введіть 5 карт від 2-10 J Q K A");
        Scanner inp = new Scanner(System.in);
        List<Card> crd = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            String val = inp.next();
            for (Card item : koloda) {
                if (val.equalsIgnoreCase(item.name)) {
                    crd.add(item);
                }
            }
        }
        return crd;
    }

    private static List<Card> getCards() {
        Card card2 = new Card("2", 2);
        Card card3 = new Card("3", 3);
        Card card4 = new Card("4", 4);
        Card card5 = new Card("5", 5);
        Card card6 = new Card("6", 6);
        Card card7 = new Card("7", 7);
        Card card8 = new Card("8", 8);
        Card card9 = new Card("9", 9);
        Card card10 = new Card("10", 10);
        Card card11 = new Card("J", 11);
        Card card12 = new Card("Q", 12);
        Card card13 = new Card("K", 13);
        Card card14 = new Card("A", 14);

        List<Card> koloda = new ArrayList<Card>(13);
        koloda.add(card2);
        koloda.add(card3);
        koloda.add(card4);
        koloda.add(card5);
        koloda.add(card6);
        koloda.add(card7);
        koloda.add(card8);
        koloda.add(card9);
        koloda.add(card10);
        koloda.add(card11);
        koloda.add(card12);
        koloda.add(card13);
        koloda.add(card14);
        return koloda;
    }
}
