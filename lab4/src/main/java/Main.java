public class Main {
    /* This class is for those who are as lazy as I am and for those who just don't like manage many configurations */
    public static void main(String[] args) {
        /* params for every task */
        String[] args_task_1 = {"-gui", "AgentBlock:klasa_1_2"};
        String[] args_task_4_week_4 = {"-gui", "StepAgent:klasa_4"};
        String[] args_task_2 = {"-gui", "ParallelAgent:klasa_2_3"};
        String[] args_task_3 = {"-gui", "SeqAgent:klasa_2_4"};
        String[] args_task_4 = {"-gui", "DoubleCyclicAgent:klasa_2_5"};

        jade.Boot.main(args_task_4_week_4);

    }
}
