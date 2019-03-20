import java.util.Calendar;

public class Control
{
    public static final double T = .1;
    public static final int G = 1;
    public static final int R = 7;
    /*G is the universal gravitational constant: will be malleable with sliders in future updates
     *T is the number of seconds between updates
     *R is the ratio of dark to luminous particles 1l:6d s.t. 1+6=7 so for every 7 particles 1 is luminous and 6 are dark
     *    -however on A side note this is based solely on empirical data and not on theory so it will also be manipulable
     */
    public static final int A = 3;
    public static final int N = (int)Math.pow(R, A);
    public static final int SIZE = (int)Math.pow(10, A);
    /*N~=1*Ea or 1*10^A
     *SIZE~=R*Ea or R*10^A
     */

    public static final Point[][] field = new Point[SIZE][SIZE];

    public static Particle[] particles = new Particle[N];

    //XY indices
    public static int X = 0;
    public static int Y = 0;

    //initial positions
    public static final int INITIALX = (SIZE-(int)Math.sqrt(N))/2;
    public static final int INITIALY = (SIZE-(int)Math.sqrt(N))/2;
    /*based on personal calculations R,N. defined in
     */
    public static double percent = 0;

    private static int o = 0;

    private static final double SETUPOPERATIONS = (N+SIZE*SIZE+2*particles.length);

    public static PreSimGUI loading = new PreSimGUI();

    public static void main(String[] args)
    {
        loading.run();
        Calendar calendar = Calendar.getInstance();
        long start = System.currentTimeMillis();
        //array initializations
        particlesInit(); fieldInit();

        for (int i = 0; i < N; i++)
        {
            o++;
            particles[i].start();
        }
        long finish = System.currentTimeMillis();
        System.out.print("Δt="+(finish-start));
        System.out.print("field:" + "\n" + debug(field) + "\n" + "particles:" + "\n" + debug(particles));
        Screen screen = new Screen();//visible representation of field
    }

    public static int X()
    {
        if (X<Math.sqrt(N))
        {
            X++;
        }
        else
        {
            Y++;
            X = 0;
        }
        return X + INITIALX;
    }
    public static int Y()
    {
        return Y + INITIALY;
    }

    public static double radius(int x, int y, int x2, int y2)
    {
        return pythagoreanTheorem(x-x2,y-y2);
    }
    public static double pythagoreanTheorem(double h, double v)
    {
        return Math.sqrt(h*h+v*v);
    }

    private static void fieldInit()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                field[i][j] = new Point(j,i);
                //System.out.print(".");
                o++;
            }
            //System.out.println();
        }
    }
    private static void particlesInit()
    {
        for (int i = 0; i < particles.length; i++)
        {
            if (i % R == 0)
                particles[i] = new LuminousMatter();
            else
                particles[i] = new DarkMatter();
            o++;
        }
    }
    /*
    private static String debug(Object[][] array)
    {
        String toString = "";
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                toString += "[" + array[i][j].toString() + "]";
            }
            if (i != array.length-1)
                toString += "\n";
        }
        return toString;
    }
    */
    private static String debug(Object[] array)
    {
        String toString = "";
        for (int i = 0; i < array.length; i++)
        {
            toString += "[" + array[i].toString() + "]";
        }
        return toString;
    }
    public static void repaint()
    {
        percent = (double)100*o/SETUPOPERATIONS;
        loading.loadingPercent.setText(percent+"");
        loading.repaint();
    }
}
