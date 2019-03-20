import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen extends JFrame
{
    private BufferedImage canvas = new BufferedImage(Control.SIZE,Control.SIZE,BufferedImage.TYPE_INT_BGR);

    Screen()
    {
        setResizable(false);
        canvas.createGraphics();
        canvas.getGraphics();
        for (int i = 0; i < Control.SIZE ; i++)
        {
            for (int j = 0; j < Control.SIZE; j++)
            {
                canvas.setRGB(j, i, 0);
            }
        }
        setSize(Control.SIZE,Control.SIZE);
        setPreferredSize(new Dimension(Control.SIZE,Control.SIZE));
        pack();
        getContentPane().add(new JLabel(new ImageIcon(canvas)));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateFilled();
    }
    private void updateFilled()
    {
        Point[][] field = Control.field;
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
