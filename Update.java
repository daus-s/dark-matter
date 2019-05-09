public class Update implements Runnable
{
    Update()
    {
        System.out.println("updater setup");
    }
    void logic()
    {
        long deltaTime = System.currentTimeMillis();
        deltaTime = deltaTime - Constant.INIT_TIME;

        if (deltaTime/1000%Constant.T==0)
        {
            SimulationLauncher.display.updateFilled();
        }

        if (deltaTime/1000%Constant.LOG_TIME*Constant.T==0)
        {
            new OutputLog().toString();
            //TODO: 5-6-2019 send to python interpreter to be analyzed.
        }
        logic();
    }

    public void run()
    {
        logic();
    }

    void start()
    {
        run();
    }
}
