//Object-Oriented Application to find Area of Few Shapes
//Implementing---> Encapsulation, Inheritence, Polymorphism, Abstraction

import java.util.Scanner;

//Abstraction is achieving

abstract class Shape
{
    float area;
    abstract void acceptInput();
    abstract void compute();

    //Displaying the result
    public void disp()
    {
        System.out.println("Area :"+area);
        System.out.println("***********************************************");
    }
}

class Square extends Shape
{
    //Achieving Encapsulation by preventing direct access 
    private float length;

    //Taking input from user 
    //Indirect access
    public void acceptInput()
    {
        System.out.println("Finding Area of Square:-");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of square: ");
        length=sc.nextFloat();

    }

    //Computing the Area
    public void compute()
    {
        area=length*length;
    }

}

class Rectangle extends Shape
{
    //Achieving Encapsulation by preventing direct access
    private float length;
    private float breadth;

    //Taking input from user
    //Indirect access
    public void acceptInput()
    {
        System.out.println("Finding Area of Rectangle:-");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of rectangle: ");
        length=sc.nextFloat();
        System.out.println("Enter the bredth of Rectangle: ");
        breadth=sc.nextFloat();

    }

    //Computing the Area
    public void compute()
    {
        area=length*breadth;
    }
}

class Circle extends Shape
{
    //Achieving Encapsulation by preventing direct access
    private float radius;

    //Taking input from user
    //By Indirect access
    public void acceptInput()
    {
        System.out.println("Finding Area of Circle:-");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the radius of circle: ");
        radius=sc.nextFloat();

    }

    //Computing the Area
    public void compute()
    {
        area=3.141f*radius*radius;
    }
}

public class Launch2 
{
    public static void main(String[] args) 
    {
        Square s=new Square();
        Rectangle r=new Rectangle();
        Circle c=new Circle();

        Geometry g=new Geometry();

        g.permit(s);      //for square object
        g.permit(r);      //for rectangle object
        g.permit(c);      //for circle object
    }
}

class Geometry
{
    //Achieveing polymorphism with Advantages --> Code reduction and code flexibity
    public void permit(Shape ref)
    {
        ref.acceptInput();
        ref.compute();
        ref.disp();
    }
}