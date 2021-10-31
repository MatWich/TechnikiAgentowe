import jade.core.behaviours.OneShotBehaviour;

public class Klasa2 extends Klasa1 {
    // Klasa z jednorazowym Behem ktory wypisuje w konsoli slowo ╰(*°▽°*)╯
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("wykonuje");
                myAgent.doDelete();
            }
        });
    }
}
