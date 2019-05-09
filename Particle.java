public interface Particle
{
    /*
     *int mass; 1 for this simulation: one Atomic Mass
     *boolean modifier; true false
     *int x; the x coordinate
     *int y; the y coordinate
     */
    int getMass();
    void setMass(int mass);

    int getX();
    void setX(int x);

    int getY();
    void setY(int y);

    Vector velocity();
    Vector acceleration();

    Vector getForce();

    void start();
    String toString();
}
