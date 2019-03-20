public class DarkMatter implements Particle, Mass, Runnable
{
    private int mass;
    //cartesian points
    private int x;
    private int y;

    private double velocity;

    //constructors
    DarkMatter()
    {
        x = 0;
        y = 0;
        mass = -1;
    }
    DarkMatter(int x, int y, int mass, double velocity)
    {
        this.mass = mass;
        this.x = x;
        this.y = y;
        if (mass > 0)
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
        double forceX = 0.0;
        double forceY = 0.0;

        for (int i = 0; i < Control.particles.length; i++)
        {
            double angle = this.y-Control.particles[i].getY()/this.x-Control.particles[i].getX();
            if (Control.particles[i] instanceof Mass)
            {
                double force = Control.G * Control.particles[i].getMass() * this.mass / //Gmm
                        Math.pow(
                                Control.radius(this.getX(), this.getY(), Control.particles[i].getX(), Control.particles[i].getY())//pythagorean theorem
                                , 2);//r^(2)
                forceX += force * Math.cos(Math.atan(angle));
                forceY += force * Math.sin(Math.atan(angle));
            }
        }
        return new Vector(Control.pythagoreanTheorem(forceX,forceY),Math.atan(forceY/forceX));
    }

    public void run()
    {
        setPosition(Control.X(),Control.Y());
        Control.field[this.y][this.x].setParticle(this);
        Control.field[this.y][this.x].setFilled();
    }

    public void changePosition()
    {
        x += velocity().getValue()*Control.T*Math.cos(velocity().getAngle());
        y += velocity*Control.T;
    }

    public void start()
    {
        run();
    }
}
