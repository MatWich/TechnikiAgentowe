import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class klasa_2_5 extends Agent {
    /* Two cyclic behaviours having fun */
    ThreadedBehaviourFactory threadedBehaviourFactory = new ThreadedBehaviourFactory();

    @Override
    protected void setup() {
        CyclicBehaviour cyclicBehaviour = new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("cyclic 1");
            }
        };
        CyclicBehaviour cyclicBehaviour1 = new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("cyclic 2");
            }
        };
        addBehaviour(threadedBehaviourFactory.wrap(cyclicBehaviour));
        addBehaviour(threadedBehaviourFactory.wrap(cyclicBehaviour1));
    }
}
