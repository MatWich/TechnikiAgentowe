public class Main {
    public static void main(String[] args) {
        String[] args3 = {"-gui", "PolskiAgent:PolishAgent"};
        String[] args2 = {"-gui", "ZeroOneAgent:ZeroOneAgent"};
        String[] args1 = {"-gui", "Janusz:ReSender"};

        jade.Boot.main(args1);
        //jade.Boot.main(args2);
        //jade.Boot.main(args3);
    }
}
