import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class ZeroOneAgent extends Agent {
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new SendBehaviour(this, "Content of a sent message"));
    }


}
