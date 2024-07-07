import java.util.Scanner;
import java.util.Random;

class Game {
    public int n;
    public int computer;
    public int counter = 0;

    Game() {
        Random rdm = new Random();
        computer = rdm.nextInt(1, 100);
        System.out.println("Computer has generated the number....");
    }

    public int isCorrect() {
        if (n == computer) {
            return 0;
        } else {
            return -1;
        }

    }

    public void counter() {
        counter++;

    }

    public void isGreater() {
        if (n > computer) {

            System.out.println("Entered number is greater than computer generated number!!");
            System.out.println("Please enter lowest number");
        }

    }

    public void isSmaller() {
        if (n < computer) {
            System.out.println("Entered number is smaller than computer generated number!!");
            System.out.println("Please enter greater number..");
        }

    }

    public void giveInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

    }

}

public class GuessTheNumber {
    public static void main(String[] args) {
        Game x = new Game();

        System.out.println("Enter the number from 1 to 100:");
        System.out.println("Enter the Number ::::::::::");
        x.giveInput();
        x.counter();

        while (x.isCorrect() == -1 &&  x.counter!=0) {
            x.isGreater();
            x.isSmaller();
            System.out.println("Number of tries are:" + (x.counter));
            System.out.println("Enter the Number ::::::::::");
            x.giveInput();
            x.counter();

        }
        if (x.isCorrect() == 0) {
            System.out.println("Congratulations!!!");
            System.out.println("Number matches with computer generated number!!");

        }

    }
}
