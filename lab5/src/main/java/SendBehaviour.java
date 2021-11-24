import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendBehaviour extends OneShotBehaviour {
    private final static String KILL_STRING = "delete";
    private final static String DEFAULT_MESSAGE_TO_SEND = "Content of a sent message";

    String msgContent = DEFAULT_MESSAGE_TO_SEND;

    public SendBehaviour(Agent a, String messageContent) {
        super(a);
        msgContent = messageContent;
    }


    @Override
    public void action() {
        int msgType = pickANumber() == 1 ? ACLMessage.CFP : ACLMessage.INFORM;
        ACLMessage msg = new ACLMessage(msgType);
        msg.setContent(msgContent);
        msg.addReceiver(new AID("AgentReceive", AID.ISLOCALNAME));
        myAgent.send(msg);
        myAgent.addBehaviour(new WaitBehaviour());
    }

    private int pickANumber() {
        return (int) Math.round(Math.random());
    }
}
