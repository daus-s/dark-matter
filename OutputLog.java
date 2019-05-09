public class OutputLog
{
/*This code is designed not for human reading. The computer interprets the data imiediatley.
 */
    private int t;
    public String toString()
    {
        return "t=" + t +"\n" + field() + "\n" + dashes() + "\n" + particles();
    }
    public static String field()
    {
        String output = "";
        for (int i = 0; i < SimulationLauncher.field.length;i++)
        {
            for (int j = 0; j < SimulationLauncher.field[i].length;j++)
            {
                if(SimulationLauncher.field[i][j].isFilled()) //TODO:maybe replace by adding char field to particle?
                {
                    if (SimulationLauncher.field[i][j].getParticle().getClass()==LuminousMatter.class)
                    {
                        output += "[+]";
                    }
                    else if (SimulationLauncher.field[i][j].getParticle().getClass()==DarkMatter.class)
                    {
                         output += "[-]";
                    }
                }
                else output += "[]";
            }
            output += "\n";
        }
        return output;
    }
    public static String dashes()
    {
      String output = "";
      for(int i = 0; i < Constant.N; i++)
          output += "-";
      return output;
    }
    public static String particles()
    {
        String output = "";
        for (int i = 0; i < SimulationLauncher.particles.length; i++)
        {
            output += "[" + i + "]" + SimulationLauncher.particles.toString()+"\n";
        }
        return output;
    }
}
