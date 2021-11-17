import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class klasa_2_3 extends Agent {
    /* Example of usage of ParallelBehavior class */
    @Override
    protected void setup() {
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Pierwszy krok");
            }
        });
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Drugi krok");
            }
        });
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Trzeci krok");
            }
        });
        addBehaviour(parallelBehaviour);
//        doDelete();
    }
}
