import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Screen extends JFrame
{
    private BufferedImage canvas = new BufferedImage(Constant.SIZE,Constant.SIZE,BufferedImage.TYPE_INT_BGR);
    private boolean reset = false;

    Screen()
    {
        setResizable(false);
        canvas.createGraphics();
        canvas.getGraphics();
        for (int i = 0; i < Constant.SIZE ; i++)
        {
            for (int j = 0; j < Constant.SIZE; j++)
            {
                canvas.setRGB(j, i, 0);
            }
        }
        setSize(Constant.SIZE,Constant.SIZE);
        setPreferredSize(new Dimension(Constant.SIZE,Constant.SIZE));
        pack();
        getContentPane().add(new JLabel(new ImageIcon(canvas)));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // if (reset)
        //     updateFilled();
        // reset = true;

    }
    public void updateFilled()
    {
        //Point[][] field = (Point[][])SimulationLauncher.copy2DArray(SimulationLauncher.field);
        Point[][] field = SimulationLauncher.field;
        System.out.println(Arrays.deepToString(field));
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[i].length; j++)
            {
                if(field[i][j].isFilled())
                {
                    if(field[i][j].getParticle().getClass() == DarkMatter.class)
                        canvas.setRGB(j,i,new Color(112,0,146).getRGB());
                    if(field[i][j].getParticle().getClass() == LuminousMatter.class)
                        canvas.setRGB(j,i,new Color(199,228,255).getRGB());
                }
            }
        }
        repaint();
    }
}
