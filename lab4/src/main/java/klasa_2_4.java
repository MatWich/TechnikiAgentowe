import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;

public class klasa_2_4 extends Agent {
    /* Example of usage of SequentialBehaviour */
    @Override
    protected void setup() {
        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Pierwszy krok");
            }
        });
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Drugi krok");
            }
        });
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Trzeci krok");
            }
        });
        addBehaviour(sequentialBehaviour);
//        doDelete();
    }
}
