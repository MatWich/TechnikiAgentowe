import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class PolishAgent extends Agent {
    /* PolishAgent only speaks polish so don't even try talking to him in other languages ☺*/
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new PolishBehaviour());
    }
}
