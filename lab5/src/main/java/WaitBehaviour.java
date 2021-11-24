import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class WaitBehaviour extends CyclicBehaviour {
    /* Simple behaviour that is waiting for vaule that kills an agent or to append new behaviour */
    private final static String KILL_STRING = "delete";
    private final static String DEFAULT_MESSAGE_TO_SEND = "Content of a sent message";

    @Override
    public void action() {
        ACLMessage message = myAgent.receive();
        if (message != null) {
            if (message.getContent().equalsIgnoreCase(KILL_STRING)) {
                myAgent.doDelete();
            } else {
                System.out.println("Received message:" + message);

                myAgent.addBehaviour(new SendBehaviour(myAgent, DEFAULT_MESSAGE_TO_SEND));
                myAgent.removeBehaviour(this);
            }
        } else
            block();
    }
}
