public class MultipleParticleException extends Exception
{
    /*occurs when two particles are in the same position
     *and was not prevented by collision prevention protocols
     */
    MultipleParticleException(int i, int j, Particle p1, Particle p2)
    {
        System.out.println("two particles in location [" + i + "," + j + "] with particles" + p1.toString() + "&" + p2.toString());
    }
}
