public class LuminousMatter implements Particle, Mass, Runnable
{
    private int mass;
    //cartesian points
    private int x;
    private int y;

    private double velocity;
    private double angle;

    //constructors
    LuminousMatter()
    {
        x = 0;
        y = 0;
        mass = 1;
    }
    LuminousMatter(int x, int y, int mass, double velocity)
    {
        this.mass = mass;
        this.x = x;
        this.y = y;
        if (mass < 0)
            mass *= -1;
    }
    //getters & setters
    public int getMass()
    {
        return mass;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setMass(int mass)
    {
        this.mass = mass;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    //utility, non defined values as getters
    public Vector velocity()
    {
        /*Vf=Vi+at, where velocity is updated every.1 seconds and in general form Vf = integral(A*dt,t1,t2) t2-t1=.1
         */
        return new Vector(velocity + acceleration().getValue()* Control.T,acceleration().getAngle());
    }
    public Vector acceleration()
    {
        /*A = F/m from F = ma updated only on "gravity" where G = 1 as predefined
         */
        return new Vector(
                getForce().getValue()/this.mass,
                getForce().getAngle());
    }
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector getForce()
    {
        double force = 0.0;
        for (int i = 0; i < Control.particles.length; i++)
        {
            if (Control.particles[i] instanceof Mass)
            {
                force += Control.G * Control.particles[i].getMass() * this.mass / //Gmm
                        Math.pow(
                                Control.radius(this.getX(), this.getY(), Control.particles[i].getX(), Control.particles[i].getY())//pythagorean theorem
                                , 2);//r^(2)
            }
        }
        return new Vector(force,360);
    }
    public void run()
    {
        setPosition(Control.X(),Control.Y());
    }
    public void changePosition()
    {
        x += velocity*Control.T*Math.cos(velocity().getAngle());
        y += velocity*Control.T*Math.sin(velocity().getAngle());
    }
    public void start()
    {
        run();
    }

}
