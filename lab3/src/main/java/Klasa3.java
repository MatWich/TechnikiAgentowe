import jade.core.behaviours.CyclicBehaviour;

public class Klasa3 extends Klasa1 {
    // Powinien byc nieskonczony ale wole go sobie usunac po kilku chwilach zeby mmi nie spamil w konsoli
    int timesBeforeDeath = 10;
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                if (timesBeforeDeath < 0)
                    doDelete();
                System.out.println("Wykonuje");
                timesBeforeDeath--;
            }
        });
    }
}
