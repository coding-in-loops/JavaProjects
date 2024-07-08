class UserDatabase{
    private static UserDatabase instance;
    //Make the constructor Private Because object is creating using constructor
    private UserDatabase(){

    }
    //synchronized -> ensure that in multithreaded environment single instance willl create
    public static synchronized UserDatabase getInstance(){
        if(instance==null){
            return instance=new UserDatabase();
        }else {
            return instance;
        }
    }
}
public class SingletonDesignPattern {
    public static void main(String[] args) {
        UserDatabase userDatabase1=UserDatabase.getInstance();
        UserDatabase userDatabase2=UserDatabase.getInstance();
        System.out.println(userDatabase1);
        System.out.println(userDatabase2);
    }
}
