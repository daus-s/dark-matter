public class Constant
{
    public static final double T = 1;
    /*Defined as the number of SI seconds per update
     *  -precision increases with decrease in 'T'
     *  -see runtime decrease in overview
     */
    public static final int G = 1;
    public static final int R = 7;
    /*G is the universal gravitational constant: will be malleable with sliders in future updates
     *T is the number of seconds between updates
     *R is the ratio of dark to luminous particles 1l:6d s.t. 1+6=7 so for every 7 particles 1 is luminous and 6 are dark
     *    -however on A side note this is based solely on empirical data and not on theory so it will also be manipulable
     */
    public static final int A = 1;
    //the smaller this is the easier debugging will be
    public static final int N = (int)Math.pow(R, A);
    public static final int SIZE = (int)Math.pow(10, A);
    /*N~=1*Ea or 1*10^A
     *SIZE~=R*Ea or R*10^A
     */

     /*Arrays moved to actuall launcher. Strictly defined by software that is based on these
      *numbers.
      */



    //initial positions
    public static final int INITIALX = (SIZE-(int)Math.sqrt(N))/2;
    public static final int INITIALY = (SIZE-(int)Math.sqrt(N))/2;
    /*based on personal calculations R,N. defined in
     */


     public static final long INIT_TIME = SimulationLauncher.initTime();
     /*The time that the program begins on to use for mod in updateing logs
      */
    public static final int LOG_TIME = 10; //frames
}
