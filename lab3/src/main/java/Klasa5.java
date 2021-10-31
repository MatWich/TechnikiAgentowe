import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Scanner;

public class Klasa5 extends Klasa1 {
    // Jesli ten agent dostanie w wiadomości liczbe < 0 to sie usunie (zadziala tez jak wyslesz widomosc: delete)
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null && Integer.parseInt(msg.getContent().toString()) < 0)
                    myAgent.doDelete();

            }

        });
    }
}
