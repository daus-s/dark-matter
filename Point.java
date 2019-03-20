public class Point
{
    private int x;
    private int y;
    private boolean filled;
    /*this tells the canvas whether or not A particle exists
     *at this point and whether it was empty space
     */
    private Particle particle;
    /*the particle at the point
     *
     */
    Point()
    {
        x = 0;
        y = 0;
        for (int i = 0; i < Control.particles.length; i++)
        {
            if (Control.particles[i].getX() == this.x && Control.particles[i].getY() == this.y)
            {
                filled = true;
                return;
            }
        }
        filled = false;
    }
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        for (int i = 0; i < Control.particles.length; i++)
        {
            if (Control.particles[i].getX() == this.x && Control.particles[i].getY() == this.y)
            {
                filled = true;
                particle = Control.particles[i];
                return;
            }
        }
        filled = false;
    }
    Point(int x, int y, Particle particle1)
    {
        this.x = x;
        this.y = y;
        this.particle = particle1;
        if (particle != null)
            filled = true;
        else
            filled = false;
    }

    public Particle getParticle()
    {
        return particle;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
    public void setFilled()
    {
        for (int i = 0; i < Control.particles.length; i++)
        {
            if (Control.particles[i].getX() == this.x && Control.particles[i].getY() == this.y)
            {
                filled = true;
                return;
            }
        }
    }
    public void setParticle(Particle particle)
    {
        this.particle = particle;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
