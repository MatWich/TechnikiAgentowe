import jade.core.behaviours.Behaviour;

public class Klasa7 extends Klasa4 {
    // Tak wiem dało sie ładniej to zrobić ale nie chciało mi się
    // Klasa dodaje Beha po czym ten Beh jedno krokowy dodaje kolejnego Beha po czym kończy sie zabawa
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new Behaviour() {
            private int step = 0;
            @Override
            public void action() {
                if (step == 0) {
                    System.out.println("Pierwsze");
                    step++;
                    myAgent.addBehaviour(new Behaviour() {
                        private int step = 0;
                        @Override
                        public void action() {
                            if (step == 0) {
                                step++;
                                System.out.println("Drugie");
                            }
                        }

                        @Override
                        public boolean done() {
                            return step == 1;
                        }
                    });
                }
            }

            @Override
            public boolean done() {
                return step == 1;
            }
        });
    }
}
