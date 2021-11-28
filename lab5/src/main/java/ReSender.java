import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReSender extends Agent {

//    private MessageTemplate template = MessageTemplate.or(
//            MessageTemplate.MatchPerformative(ACLMessage.CFP), MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
//            MessageTemplate.MatchPerformative(ACLMessage.NOT_UNDERSTOOD));

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " is ready.");

        addBehaviour(new CyclicBehaviour(this) {

            public void action() {
                ACLMessage msgRequest = myAgent.receive();

                if (msgRequest != null) {
//                    System.out.println("Message matching custom template received:");
                    if (msgRequest.getPerformative() == ACLMessage.CFP) {
                        System.out.println(msgRequest.getContent());
                        ACLMessage msgToSend = new ACLMessage(msgRequest.getPerformative());
                        msgToSend.setContent("one more time");
                        msgToSend.addReceiver(msgRequest.getSender());
                        myAgent.send(msgToSend);
                    } else if (msgRequest.getPerformative() == ACLMessage.REQUEST) {
                        System.out.println(msgRequest.getContent());
                        ACLMessage response = new ACLMessage(ACLMessage.INFORM);
                        response.setContent("done");
                        response.addReceiver(msgRequest.getSender());
                        send(response);
                    } else {
                        ACLMessage response = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
                        response.setContent("anything here");
                        response.addReceiver(msgRequest.getSender());
                        send(response);
                    }
                } else {
                    block();
                }
            }

        });
    }
}
