public class Klasa8 extends Klasa1 {
    // Klasa dodajaca jeden Behaviour nic wiecej tu nie ma ¯\_(ツ)_/¯
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new TimeBehaviour(this, 1000, 100));
    }
}
