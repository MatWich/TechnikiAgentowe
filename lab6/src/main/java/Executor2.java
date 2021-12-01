import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class Executor2 extends Agent {
    DFAgentDescription dfd = new DFAgentDescription();

    @Override
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " registering service \"");
        try {
            dfd.setName(getAID());
            ServiceDescription sd = new ServiceDescription();
            sd.setName(getLocalName());
            sd.setType("POTEGA_2");
            // Agents that want to use this service need to "know" the weather-forecast-ontology
            //sd.addOntologies("weather-forecast-ontology");
            // Agents that want to use this service need to "speak" the FIPA-SL language
            //sd.addLanguages(FIPANames.ContentLanguage.FIPA_SL);
            //sd.addProperties(new Property("country", "Italy"));
            dfd.addServices(sd);

            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this, dfd);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }
}
