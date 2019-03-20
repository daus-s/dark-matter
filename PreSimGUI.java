import javax.swing.*;
import java.awt.*;

public class PreSimGUI extends JFrame implements Runnable
{
    PreSimGUI setup;

    private JSlider dark;
    {
        dark = new JSlider();
        dark.setMinimum(4);
        dark.setMaximum(40);
        dark.setValue(4);
    }
    private JSlider luminous;
    {
        luminous = new JSlider();
        luminous.setMinimum(1);
        luminous.setMaximum(dark.getValue()/4);
        luminous.setValue(1);

    }
    private JSlider gravitational = new JSlider();
    {
        gravitational.setMinimum(0);
        gravitational.setMaximum(10);
        gravitational.setValue(1);
    }
    private FlowLayout layout = new FlowLayout();

    protected JTextArea loadingPercent = new JTextArea();
    {
        loadingPercent.setText("loading" + 100*Control.percent + "%");
    }
    private JFrame loadingScreen = new JFrame();
    {
        loadingScreen.add(loadingPercent);
    }
    PreSimGUI()
    {
        setLayout(layout);
        setVisible(true);
        while(Control.percent!=100)
        {
            Control.repaint();
        }
        remove(loadingPercent);
        add(dark);
        add(luminous);
        add(gravitational);
    }

    public void run()
    {
        setup = new PreSimGUI();
    }
}
