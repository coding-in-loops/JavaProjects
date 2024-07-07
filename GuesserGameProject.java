import java.util.Scanner;
//Console based Core java Project --> Guesser the number

class Guesser
{
    int guessNum;
    // Take input from the Guesser
    public int takeNumGuesser()
    {
        System.out.println("Guesser guess a number");
        Scanner sc=new Scanner(System.in);
        guessNum=sc.nextInt();
        return guessNum;
    }
}

class Player
{
    int playerNum;
    //Take input from the Players
    public int takeNumPlayer()
    {
        System.out.println("Player guess a number");
        Scanner sc=new Scanner(System.in);
        playerNum=sc.nextInt();
        return playerNum;
    }
}

class Umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    //Collecting number from Guesser
    public void collectNumGuesser()
    {
        Guesser g=new Guesser();
        numFromGuesser=g.takeNumGuesser();
    }

    //Collecting number from Player
    public void collectNumPlayer()
    {
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();

        numFromPlayer1=p1.takeNumPlayer();
        numFromPlayer2=p2.takeNumPlayer();
        numFromPlayer3=p3.takeNumPlayer();
    }

    //Compare the number entered by Guesser and Players
    public void compare()
    {
        //If number guessed by Guesser and Player 1 equals
        if(numFromPlayer1==numFromGuesser)
        {
            if(numFromPlayer2==numFromGuesser && numFromPlayer3==numFromGuesser)
            {
                System.out.println("All Players won the game!");
            }
            else if(numFromPlayer2==numFromGuesser)
            {
                System.out.println("Player 1 and Player 2 won the game!");
            }
            else if(numFromPlayer3==numFromGuesser)
            {
                System.out.println("Player 1 and Player 3 won the game!");
            }
            else
            {
                System.out.println("Player 1 won the game!");
            }
        }

        else if(numFromPlayer2==numFromGuesser)
        {
            if(numFromPlayer3==numFromGuesser)
            {
                System.out.println("Player 2 and Player 3 won the game!");
            }
            else
            {
                System.out.println("Player 2 won the game!");
            }
        }

        else if(numFromPlayer3==numFromGuesser)
        {
            System.out.println("Player 3 won the game!");
        }

        else
        {
            System.out.println("No Player won the game!");
        }
    }
}

public class GuesserGameProject
{
    public static void main(String[] args)
    {
        //Object Creation of Umpire classs
        Umpire u=new Umpire();

        //Method calling
        u.collectNumGuesser();
        u.collectNumPlayer();
        u.compare();
    }
}