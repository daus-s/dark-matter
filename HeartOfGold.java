public class HeartOfGold implements Particle
{
    /*Based on the heart of gold spaceship in hitchhikers guide to the galaxy.
     *It also implements a "random" position function, but rather than a
     *random position, not reasonably possible, it relies on the derivative
     *to be a pseudo random function. see proof of random-average velocity
     *proof in google docs for logic behind using a random velocity.
     *This is not scientifically accurate so it will be inaccurate
     *and can be toggle on and off at the beginning of each simulation.
     */
    private int mass;
    //cartesian points
    private int x;
    private int y;

    private double velocity;//pixels per unit
    private double angle;//radians

    public int getMass()
    {
        return this.mass;
    }
    public void setMass(int mass)
    {
        this.mass = mass;
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    /*heart of gold particle must have carefully defined
     *position function dependent on randomized velocity
     */
    public void setX(int x)
    {
        /*heart of gold particle must have carefully defined
         *position function dependent on randomized velocity
         */
        this.x += velocity().getValue()*Math.cos(velocity().getAngle());
        //update velocity
    }

    public void setY(int y)
    {
        this.y += velocity().getValue()*Math.sin(velocity().getAngle());
    }

    public Vector velocity()
    {
        long time = System.currentTimeMillis();
        if (time % 2 == 0)
            return new Vector(Math.random() * Control.SIZE,360*Math.random());
        if (time % 2 == 1)
            return new Vector(Math.random() * -1 * Control.SIZE,360*Math.random());
        else throw new NumberFormatException();
    }

    public Vector acceleration()
    {
        return new Vector(getForce().divide(getMass()), getForce().getAngle());
    }

    public Vector getForce()
    {
        return new Vector(0,0);
    }

    public void start()
    {

    }
}
