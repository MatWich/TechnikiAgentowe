public class Klasa4 extends Klasa1 {
    // Ta klasa dodaje tylko jednego Beha
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new ThreeStepBehaviour());
    }
}
