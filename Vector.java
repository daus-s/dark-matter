public class Vector
{
    private double value;
    private double angle; // out of 360(/360)

    Vector(double value, double angle)
    {
        this.value = value;
        this.angle = angle;
    }
    Vector(Vector vector)
    {
        this.value = vector.getValue();
        this.angle = vector.getAngle();
    }

    public double getAngle()
    {
        return angle;
    }

    public double getValue()
    {
        return value;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double divide(double divisor)
    {
        return this.value/divisor;
    }
}
