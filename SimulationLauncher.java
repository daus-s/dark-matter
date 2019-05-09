public class SimulationLauncher
{
    public static final Point[][] field = new Point[Constant.SIZE][Constant.SIZE];
    public static Particle[] particles = new Particle[Constant.N];

    //XY indices
    public static int X = 0;
    public static int Y = 0;

    public static Screen display = new Screen();
    public static Update updater = new Update();


    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        particlesInit(); fieldInit(); updater.start();
	      for (int i = 0; i < Constant.N; i++)
        {
            particles[i].start();
        }
        long finish = System.currentTimeMillis();
        System.out.print("Δt="+(finish-start));
        display.updateFilled();
    }

    public static int X()
    {
        if (X<Math.sqrt(Constant.N))
        {
            X++;
        }
        else
        {
            Y++;
            X = 0;
        }
        return X + Constant.INITIALX;
    }

    public static int Y()
    {
        return Y + Constant.INITIALY;
    }
    private static void fieldInit()
    {
        for (int i = 0; i < Constant.SIZE; i++)
        {
            for (int j = 0; j < Constant.SIZE; j++)
            {
                field[i][j] = new Point(j,i);
            }
        }
    }

    private static void particlesInit()
    {
        for (int i = 0; i < particles.length; i++)
        {
            if (i % Constant.R == 0)
                particles[i] = new LuminousMatter();
            else
                particles[i] = new DarkMatter();
        }
    }
    //*************************************************
    //U   U TTTTT I   L   I  TTTTT Y   Y
    //U   U   T   I   L   I    T    Y Y
    //U   U   T   I   L   I    T     Y
    //U   U   T   I   L   I    T     Y
    // UUU    T   I   LLL I    T     Y
    //*************************************************
    /*These methods are the static methods used in
     *the rest of the code base
     */
    public static long initTime()
    {
        return System.currentTimeMillis();
    }
    public static double radius(int x, int y, int x2, int y2)
    {
        return pythagoreanTheorem(x-x2,y-y2);
    }

    public static double pythagoreanTheorem(double h, double v)
    {
        return Math.sqrt(h*h+v*v);
    }
    public static double rSQ(int x, int y, int x2, int y2) //note: order doesnt matter as -- ==> +
    {
        return (x-x2)*(x-x2)+(y-y2)*(y-y2);
    }
    public static Object[][] copy2DArray(Object[][] array)
    {
        Object[][] copy = new Object[array.length][array[0].length];
        for (int i = 0 ; i < array.length; i++)
        {
            for (int j = 0; j < array[j].length; j++)
            {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }
}
