import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class klasa_1_2 extends Agent {

    @Override
    protected void setup() {
        super.setup();
        // addBehaviour(
        FSMBehaviour fsm = new FSMBehaviour(this) {
            public int onEnd() {
                System.out.println("FSM behavior now will delete agent");
                myAgent.doDelete();
                return super.onEnd();
            }
        };
        fsm.registerFirstState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("A");
            }
        }, "A");
        fsm.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("B");
            }
        }, "B");

        fsm.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("C");
            }
        }, "C");

        fsm.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("D");
            }
        }, "D");

        fsm.registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("E");
            }
        }, "E");

        fsm.registerDefaultTransition("A", "B");
        fsm.registerTransition("B", "C", 1);
        fsm.registerTransition("B", "D", 0);
        fsm.registerDefaultTransition("C", "D");
        fsm.registerTransition("D", "A", 1);
        fsm.registerTransition("D", "E", 0);
        addBehaviour(fsm);

    }


}
