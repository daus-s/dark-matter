public class DarkMatter implements Particle, Mass, Runnable
{
    private int mass;
    //cartesian points
    private int x;
    private int y;

    private Vector velocity;

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
        return new Vector(velocity.getValue() + acceleration().getValue()* Constant.T, Math.atan((velocity.Y()+acceleration().Y())/(velocity.X()+acceleration().X())));
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

        for (int i = 0; i < SimulationLauncher.particles.length; i++)
        {
            double angle = this.y-SimulationLauncher.particles[i].getY()/this.x-SimulationLauncher.particles[i].getX();
            if (SimulationLauncher.particles[i] instanceof Mass)
            {
                double force = Constant.G * SimulationLauncher.particles[i].getMass() * this.mass / //Gmm
                        Math.pow(
                                SimulationLauncher.radius(this.getX(), this.getY(), SimulationLauncher.particles[i].getX(), SimulationLauncher.particles[i].getY())//pythagorean theorem
                                , 2);//r^(2)
                forceX += force * Math.cos(Math.atan(angle));
                forceY += force * Math.sin(Math.atan(angle));
            }
        }
        return new Vector(SimulationLauncher.pythagoreanTheorem(forceX,forceY), Math.atan(forceY/forceX));
    }

    public void run()
    {
        setPosition(SimulationLauncher.X,SimulationLauncher.Y);
        SimulationLauncher.field[this.y][this.x].setParticle(this);
        SimulationLauncher.field[this.y][this.x].setFilled();
    }

    public void changePosition()
    {
        x += velocity.X();
        y += velocity.Y();
    }

    public void start()
    {
        run();
    }
}
