package agent;

import jade.core.Agent;

public class HelloWorldAgent extends Agent {
    // This class creates the Agent that print some message on console
    @Override
    protected void setup() {
        System.out.println("Witaj! Jestem pierwszym agentem moje ID to: " + this.getAID());
        doDelete();
    }

    @Override
    protected void takeDown() {
        System.out.println("Bye from Agent" + this.getAID());
    }
}
