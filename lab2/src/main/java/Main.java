public class Main {
    public static void main(String[] args) {
        System.out.println("My main method");
        String[] args1 = {"-gui", "AgentSelfDestruct:com.agent.TimeAgent"};     // Agent that will delete it self overtime
        String[] args2 = {"-container", "Agent1:com.agent.HelloWorldAgent"};    // Agent that will delete itself right after he say hello
        // start both agents
        jade.Boot.main(args1);
        jade.Boot.main(args2);
    }
}
