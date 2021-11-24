import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class PolishBehaviour extends CyclicBehaviour {
    private final static String POLISH_LANGUAGE = "Polish";
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null && msg.getLanguage().equalsIgnoreCase(POLISH_LANGUAGE))
            System.out.println(msg.getContent());
    }
}
