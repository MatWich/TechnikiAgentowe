import jade.core.behaviours.Behaviour;

public class ThreeStepBehaviour extends Behaviour {
    // Nie wiem co tu napisac jakies pomysly?
    private int step = 0;

    @Override
    public void action() {
        // co kazdy krok cos sie innego sie wypisuje no chyba ze sie skoncza kroki ༼ つ ◕_◕ ༽つ
        switch (step) {
            case 0 -> {
                step++;
                System.out.println("Krok 1");
            }
            case 1 -> {
                step++;
                System.out.println("Krok 2");
            }
            case 2 -> {
                step++;
                System.out.println("Krok 3");
                myAgent.doDelete();
            }
        }
    }

    @Override
    public boolean done() {
        // Jak sama nazwa klasy wskazuje po 3 krokach jest koniec
        return step == 3;
    }
}
