package ma.enset.ga_string_sma;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;


public class PopulationContainer {
    public static void main(String[] args) throws jade.wrapper.ControllerException {

        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);



        //AgentController master = agentContainer.createNewAgent("master", "ma.enset.ga_string_sma.MasterAgent", new Object[]{});
        AgentController island = agentContainer.createNewAgent("island", "ma.enset.ga_string_sma.IslandAgent", new Object[]{});
        //AgentController agentThreatPopulation3 = agentContainer.createNewAgent("populationThreat3", "ma.enset.ga_string_sma.ThreatPopulationAgent", new Object[]{});
        //AgentController agentThreatPopulation4 = agentContainer.createNewAgent("populationThreat4", "ma.enset.ga_string_sma.ThreatPopulationAgent", new Object[]{});

        //master.start();
        //agentPopulation.start();
        //agentThreatPopulation1.start();
        island.start();
        //agentThreatPopulation3.start();
        //agentThreatPopulation4.start();

    }
}
