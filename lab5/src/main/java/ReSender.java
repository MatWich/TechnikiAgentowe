import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReSender extends Agent {

    private MessageTemplate template = MessageTemplate.or(
            MessageTemplate.MatchPerformative(ACLMessage.CFP), MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " is ready.");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msgRequest = myAgent.receive(template);

                if (msgRequest != null) {
                    System.out.println("Message matching custom template received:");
                    if (msgRequest.getPerformative() == ACLMessage.CFP) {
                        ACLMessage msgToSend = new ACLMessage(msgRequest.getPerformative());
                        msgToSend.setContent(msgRequest.getContent());
                        myAgent.send(msgToSend);
                    } else
                        System.out.println(msgRequest.getContent());
                } else {
                    block();
                }
            }
        });
    }
}
