class Aeroplane
{
    public void fly()
    {
        System.out.println("Areoplpane is flying");
    }

    public void takeOff()
    {
        System.out.println("Areoplane is going to take off");
    }
}

class CargoPlane extends Aeroplane
{
    public void fly()
    {
        System.out.println("Cargoplane is flying");
    }

    public void takeOff()
    {
        System.out.println("CargoPlane take off");
    }
}

class FighterPlane extends Aeroplane
{
    public void fly()
    {
        System.out.println("FighterPlane is flying");
    }

    public void takeOff()
    {
        System.out.println("FighterPlane is going to take off");
    }
}
public class Polymorphism {
    public static void main(String[]args)
    {
        CargoPlane cp=new CargoPlane();

        FighterPlane fp=new FighterPlane();

        Aeroplane a=new Aeroplane();

        a.fly();
        a.takeOff();
        System.out.println("-------------------------------------");
        //cp=fp; --> not allowed

        a=fp;
        a.fly();
        a.takeOff();
        System.out.println("-------------------------------------");

        a=cp;
        a.fly();
        a.takeOff();
        System.out.println("-------------------------------------");
    }
}
