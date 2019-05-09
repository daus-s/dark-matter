public class LuminousMatter implements Particle, Mass, Runnable
{
    private int mass;
    //cartesian points
    private int x;
    private int y;

    private Vector velocity;

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
        /*Vf=Vi+at, where velocity is updated every T seconds and in general form Vf = integral(A*dt,t1,t2) t2-t1=.1
         */
        return new Vector(velocity.getValue() + acceleration().getValue()* Constant.T, Math.atan((velocity.Y()+acceleration().Y()*Constant.T)/(velocity.X()+acceleration().X()*Constant.T)));
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
        for (int i = 0; i < SimulationLauncher.particles.length; i++)
        {
            if (SimulationLauncher.particles[i] instanceof Mass)
            {
                force += Constant.G * SimulationLauncher.particles[i].getMass() * this.mass / //Gmm
                        Math.pow(
                                SimulationLauncher.radius(this.getX(), this.getY(), SimulationLauncher.particles[i].getX(), SimulationLauncher.particles[i].getY())//pythagorean theorem
                                , 2);//r^(2)
            }
        }
        return new Vector(force,360);
    }
    public void run()
    {
        setPosition(SimulationLauncher.X(),SimulationLauncher.Y());
    }
    public void changePosition()
    {
        x += velocity.X()*Constant.T;
        y += velocity.Y()*Constant.T;
    }
    public void start()
    {
        run();
    }

}
