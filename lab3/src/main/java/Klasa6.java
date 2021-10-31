import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Klasa6 extends Klasa1 {
    // Wypisuje gdy Behaviour zaczyna i konczy dzialanie
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null && Integer.parseInt(msg.getContent().toString()) < 0) {
                    myAgent.doDelete();
                    this.onEnd();
                }
//                onEnd(); // jak chcesz zakonczyc od razu i zobaczyc czy dziala

            }

            @Override
            public void onStart() {
                System.out.println("Zachowanie startuje");
            }

            @Override
            public int onEnd() {
                myAgent.doDelete();
                System.out.println("zachowanie zakonczone");
                return 0;
            }
        });
    }
}
