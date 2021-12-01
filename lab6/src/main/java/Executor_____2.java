import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

public class Executor_____2 extends Agent {
    // creating a power of given number and reply the result to the sender
    DFAgentDescription dfd = new DFAgentDescription();

    @Override
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " registering service \"");
        try {
            dfd.setName(getAID());
            ServiceDescription sd = new ServiceDescription();
            sd.setName(getLocalName());
            sd.setType("POTEGA_2");
            dfd.addServices(sd);

            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(msg.getContent());
                    ACLMessage reply = msg.createReply();
                    if (msg.getPerformative() == ACLMessage.REQUEST) {
                        int number = Integer.parseInt(msg.getContent());
                        number *= number;
                        System.out.println("Multiplied number: " + number);
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent(String.valueOf(number));
                    }
                    reply.addReceiver(msg.getSender());
                    myAgent.send(reply);
                } else {
                    block();
                }
            }
        });
    }
}
