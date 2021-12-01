import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionInitiator;

import java.util.Iterator;
import java.util.Random;

public class Commissioner extends Agent {
    @Override
    protected void setup() {
        Random generator = new Random();
        int x = generator.nextInt(101);
        System.out.println(x);
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription templateSd = new ServiceDescription();
        templateSd.setType("POTEGA");
        template.addServices(templateSd);

        SearchConstraints sc = new SearchConstraints();
        // We want to receive 10 results at most
        sc.setMaxResults(10L);

        addBehaviour(new SubscriptionInitiator(this, DFService.createSubscriptionMessage(this, getDefaultDF(), template, sc)) {
            protected void handleInform(ACLMessage inform) {
                outerloop:
                while (true) {
                    System.out.println("Agent " + getLocalName() + ": Notification received from DF");
                    try {
                        DFAgentDescription[] results = DFService.decodeNotification(inform.getContent());
                        if (results.length > 0) {
                            DFAgentDescription dfd = results[0];
                            AID provider = dfd.getName();
                            Iterator it = dfd.getAllServices();
                            while (it.hasNext()) {
                                ServiceDescription sd = (ServiceDescription) it.next();
                                if (sd.getType().equals("POTEGA")) {
                                    System.out.println("- Service \"" + sd.getName() + "\" provided by agent " + provider.getName());
                                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                                    msg.addReceiver(new AID("Wykonawca1", AID.ISLOCALNAME));
                                    msg.setContent(String.valueOf(x));
                                    send(msg);
                                    addBehaviour(new CyclicBehaviour() {
                                        @Override
                                        public void action() {
                                            ACLMessage msg = receive();
                                            if (msg != null) {
                                                if (msg.getPerformative() == ACLMessage.INFORM) {
                                                    int number = Integer.parseInt(msg.getContent());
                                                    System.out.println(number);
                                                    doDelete();
                                                }
                                            } else {
                                                block();
                                            }
                                        }
                                    });
                                    break outerloop;
                                }
                            }
                        }
                        System.out.println();
                    } catch (FIPAException fe) {
                        fe.printStackTrace();
                    }
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
