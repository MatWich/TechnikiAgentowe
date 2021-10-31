import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;

public class TimeBehaviour extends TickerBehaviour {
    // Klasa odlicza czas (zm time) period powinno sie podawac 1000 ms == 1sec
    // co 2 sekundy wypisuje maly tick
    // co 5 sekund dopoki pozostaly czas jest wiekszy niz 50 sekund wypisuje duzy tick
    private int time;

    public TimeBehaviour(Agent a, long period, int time) {
        super(a, period);
        this.time = time;
    }

    @Override
    protected void onTick() {
        if (time != 0) {
            time--;
            if (time % 2 == 0)
                System.out.println("Time: " + time + "s mały tick");
            if (time % 5 == 0 && time > 50) // nie ma sensu tworzyc kolejnego tickerBehaviour zeby osobno
                // wypisywac big TICK
                System.out.println("Time: " + time + "sduzy tick");
        } else {
            myAgent.doDelete();
        }
    }
}
