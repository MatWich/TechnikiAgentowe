package agent;

import jade.core.Agent;

public class TimeAgent extends Agent {
    // This Agent will delete itself after this.time seconds
    int time = 120;      //x times
    int period = 1000;      // 1s

    @Override
    protected void setup() {
        System.out.println("Hello im a time Agent");
        addBehaviour(new com.agent.TimerBehaviour(this, period, time));
    }


}
