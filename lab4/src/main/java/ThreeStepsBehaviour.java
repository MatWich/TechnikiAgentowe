import jade.core.behaviours.Behaviour;

public class ThreeStepsBehaviour extends Behaviour {
    private int step = 0;

    @Override
    public void action() {
        switch (step) {
            case 0 -> {
                System.out.println("Krok pierwszy");
                step++;
            }
            case 1 -> {
                System.out.println("Krok drugi");
                step++;
            }
            case 2 -> {
                System.out.println("Krok trzeci");
                step++;
                this.myAgent.removeBehaviour(this);
//                this.myAgent.doDelete();    // nie chce Cie juz tu
            }
        }

    }

    @Override
    public boolean done() {
        return step == 3;
    }
}
