
public class PatternProgramming {
    public static void main(String [] args){
        int n=11;

        // Solid Square
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(" a ");
            }
            System.out.println();
        }

       System.out.println();
       System.out.println();


        //Hollow square

        for (int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(i==0 || j==0 || i==4 || j==4)
                {
                    System.out.print(" 7 ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
      
        System.out.println();
        System.out.println();


        // A pattern
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0|| j==0|| i==(n-1)/2 || j==n-1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();    
        }

        System.out.println();
        System.out.println();

        
        //H pattern
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0 || i==(n-1)/2 || j==n-1 )
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        //I pattern
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==(n-1)/2 || i==(n-1))
                {
                    System.out.print(" * ");
                }
                else 
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        //E pattern
        for(int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(j==0 || i==0|| i==(n-1)/2 || i==n-1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        //F pattern
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0|| j==0 || i==(n-1)/2)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        //T pattern 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0|| j==(n-1)/2)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        // L pattern 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==n-1 || j==0)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        // Little hard patterns

        //A in Half lines

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==(n-1)/2 && j<=(n-1)/2 || i==0 && j>0 && j<(n-1)/2 || j==0 && i>0 || j==(n-1)/2 && i>0)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        //D in half lines

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0 || i==0&& j>0  && j<(n-1)/2 || i==n-1 && j<(n-1)/2 || j==(n-1)/2&& i<n-1 && i>0 ) 
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        //N pattern
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j || j==0 || j==n-1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        //X pattern
        for(int i=0;i<n;i++)
        {
            for(int j=0;j< n;j++)
            {
                if(i==j || i+j==n-1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
}
