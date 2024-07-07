class AeroPlane
{
    public void fly()
    {
        System.out.println("Aeroplane is flying");
    }

    public void takeOff()
    {
        System.out.println("Aeroplane is take off");
    }
}

class CargoPLane extends AeroPlane
{
    public void fly()
    {
        System.out.println("CargoPlane is flying");
    }

    public void takeOff()
    {                          
        System.out.println("CargoPlane is take off");
    }

}

class PassengerPlane extends AeroPlane
{
    public void fly()
    {
        System.out.println("PassengerPlane is flying");
    }

    public void takeOff()
    {
        System.out.println("PassengerPlane is take off");
    }

}

class FighterPlane extends AeroPlane
{
    public void fly()
    {
        System.out.println("FighterPLane is flying");
    }

    public void takeOff()
    {
        System.out.println("FighterPlane is take off");
    }
}

class AirPort
{
    public void poly(AeroPlane ref)
    {
        ref.takeOff();
        ref.fly();
        System.out.println("----------------------------");
    }
}



public class Polymorphism2 {
    public static void main(String[] args)
    {
        CargoPLane cp=new CargoPLane();

        FighterPlane fp=new FighterPlane();

        PassengerPlane pp=new PassengerPlane();

        AirPort a=new AirPort();

        a.poly(cp);
        a.poly(pp);
        a.poly(fp);

    }
}
