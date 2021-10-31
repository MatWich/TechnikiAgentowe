import jade.core.Agent;

public class Klasa1 extends Agent {
    // Basic Agent
    @Override
    protected void setup() {
        System.out.println("Startuje");
    }

    @Override
    protected void takeDown() {
        System.out.println("Zaraz sie usune");
    }
}
