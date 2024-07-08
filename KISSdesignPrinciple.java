public class KISSdesignPrinciple {
    //KISS -> Keep It Simple Stupid
    static boolean jump=true;
    static boolean run=true;
    static boolean fly=false;
    static boolean weapon=false;
    /*
     * Lets suppose a game in which player can jump,fly,run and can have weapons
     * Suppose we have various mode nad we have to print the type of mode :-
     * 1.) God mode: All 4 powers
     * 2.) Legend mode: Run and weapons
     * 3.) else regular mode
     */

     //Bad implementation
    public static void withoutUsingKISSPrinciple(){
        if(jump==true){
            if(run==true){
                if(fly==true){
                    if(weapon==true){
                        System.out.println("God mode activated");
                    }
                }
            }
        }
        else if(run==true){
            if(weapon==true){
                System.out.println("Legend mode activated");
            }
        }
        else{
            System.out.println("Regular mode activated");
        }
    }


    //Implementing KISS design principle
    public static void withUsingKISSPrinciple(){
        //Complex code changes to simple and easy to understand code
        if(jump && run && fly && weapon){
            System.out.println("God mode activated");
        }
        else if(run && weapon){
            System.out.println("Legend mode activated");
        }
        else {
            System.out.println("Regular mode activated");
        }
    }
    public static void main(String[] args) {
        withoutUsingKISSPrinciple();
        withUsingKISSPrinciple();
    }
}
