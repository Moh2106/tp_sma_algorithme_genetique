package ma.enset.ga_string_sma;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;
import java.util.List;

public class MasterAgent extends jade.core.Agent {
    private static List<Individu> individus = new ArrayList<>();

    public static List<Individu> getIndividus() {
        return individus;
    }

    public static void setIndividus(List<Individu> individus) {
        MasterAgent.individus = individus;
    }

    @Override
    protected void setup() {

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receiver = receive();

                if (receiver != null){
                    String messageRecu = receiver.getContent();
                    System.out.println("Best Individu");
                    System.out.println(messageRecu);
                    System.out.println(receiver);
                } else block();
            }
        });



    }
}
