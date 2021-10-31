package agent;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class TimerBehaviour extends TickerBehaviour {
    //  Behaviour for TimeAgent will make it doDelete afer time runs out
    int time;

    public TimerBehaviour(Agent a, long period, int time) {
        super(a, period);
        this.time = time;
    }

    @Override
    protected void onTick() {
        // after every period it will decrease time that is left for agent
        if (time != 0) {
            System.out.println(time + "seconds left");
            time--;
        } else {
            System.out.println("timer expired");
            myAgent.doDelete();
        }
    }
}
