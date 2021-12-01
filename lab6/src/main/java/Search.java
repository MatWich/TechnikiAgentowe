

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import java.util.Iterator;

public class Search extends Agent {
    protected void setup() {
        // Search for services of type "weather-forecast"
        System.out.println("Agent "+getLocalName()+" searching for services of type \"POTEGA_2\"");
        try {
            // Build the description used as template for the search
            DFAgentDescription template = new DFAgentDescription();
            ServiceDescription templateSd = new ServiceDescription();
            templateSd.setType("POTEGA_2");
            template.addServices(templateSd);

            SearchConstraints sc = new SearchConstraints();
            // We want to receive 10 results at most
            sc.setMaxResults(10L);

            DFAgentDescription[] results = DFService.search(this, template, sc);
            if (results.length > 0) {
                System.out.println("Agent "+getLocalName()+" found the following POTEGA_2 services:");
                for (DFAgentDescription dfd : results) {
                    AID provider = dfd.getName();
                    // The same agent may provide several services; we are only interested
                    // in the weather-forcast one
                    Iterator it = dfd.getAllServices();
                    while (it.hasNext()) {
                        ServiceDescription sd = (ServiceDescription) it.next();
                        if (sd.getType().equals("POTEGA_2")) {
                            System.out.println("- Service \"" + sd.getName() + "\" provided by agent " + provider.getName());
                        }
                    }
                }
            }
            else {
                System.out.println("Agent "+getLocalName()+" did not find any POTEGA_2 service");
            }
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }
}
