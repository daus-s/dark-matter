public class MassRangeException extends Exception
{
    MassRangeException(String type, int mass)
    {
        if (type.equalsIgnoreCase("luminous") || type.equalsIgnoreCase("dark"))
            if (mass==0)
                System.out.println("massless particle");
            if (mass > 0 && type.equalsIgnoreCase("dark"))
                System.out.println("dark matter with positive mass");
            if (mass > 0 && type.equalsIgnoreCase("luminous"))
                System.out.println("luminous matter with negative mass");
        else
            System.out.println("error in input string:type");
    }
}
