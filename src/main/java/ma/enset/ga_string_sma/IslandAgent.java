package ma.enset.ga_string_sma;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import ma.enset.ga_string.GAUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IslandAgent extends Agent {
    List<Individu> individus = new ArrayList<>();
    private Individu firstNear;
    private Individu secondNear;
    @Override
    protected void setup() {

        initialize_population();
        calculateFitness();
        sortIndividu();

        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();

        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            int it = 0;
            @Override
            public void action() {
                while (it < GAUtils.MAX_IT || getBestFitnessInd().getFitness() == GAUtils.CHROMOSOME_SIZE){
                    selection();
                    crossover();
                    mutation();
                    calculateFitness();
                    sortIndividu();
                    System.out.println(getBestFitnessInd().getGenes());
                    System.out.println(getBestFitnessInd().getFitness());
                    it++;
                }
            }
        });

        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = new ACLMessage(ACLMessage.QUERY_IF);
//                String message = getBestFitnessInd().getGenes();
//                String contenu = getBestFitnessInd().getGenes();
//                System.out.println(contenu + getBestFitnessInd().getFitness());
                getBestFitnessInd().getGenes().toString();
                aclMessage.setContent(getBestFitnessInd().getGenes().toString());
                aclMessage.addReceiver(new AID("master", AID.ISLOCALNAME));
                send(aclMessage);
            }
        });

        addBehaviour(sequentialBehaviour);


    }

    public void initialize_population(){
        for (int i = 0; i< GAUtils.POPULATION_SIZE; i++){
            individus.add(new Individu());
        }
    }

    // Cette méthode va permettre de calculer le fitness d'un individu
    public void calculateFitness(){
        for (int i=0;i<GAUtils.POPULATION_SIZE;i++){
            individus.get(i).calculateIndFitness();
        }

    }

    @Override
    public String toString() {
        return "IslandAgent{" +
                "individus=" + individus +
                '}';
    }

    public void sortIndividu(){
        Collections.sort(individus, Collections.reverseOrder());
    }

    // selection des meilleures individus
    public void selection(){
        //sortIndividu();
        firstNear = individus.get(0);
        secondNear = individus.get(1);
    }

    // croisement des meilleurs individus
    public void crossover(){
        Individu individu1 = new Individu();
        Individu individu2 = new Individu();

        Random random = new Random();
        int pointDeCroisement = random.nextInt(GAUtils.CHROMOSOME_SIZE);

        System.out.println("Point de croisement" +pointDeCroisement);

        for (int i=0; i<firstNear.getGenes().length; i++){
            individu1.getGenes()[i] = firstNear.getGenes()[i];
            individu2.getGenes()[i] = secondNear.getGenes()[i];
        }

        for (int i=0 ; i<pointDeCroisement; i++){
            individu1.getGenes()[i] = secondNear.getGenes()[i];
            individu2.getGenes()[i] = firstNear.getGenes()[i];
        }

        individus.set(individus.size()-2, individu2);
        individus.set(individus.size() -1, individu1);

        individu1.calculateIndFitness();
        individu2.calculateIndFitness();

    }

    public void mutation(){
        Random random = new Random();
        int percent = random.nextInt(101);
        int index1 = random.nextInt(GAUtils.CHROMOSOME_SIZE);

        if (percent>50){
            char c1 = GAUtils.CHARATERS.charAt(index1);
            individus.get(individus.size()-1).getGenes()[index1] = c1;
        }

        int index2 = random.nextInt(GAUtils.CHROMOSOME_SIZE);

        if (percent>50){
            char c2 = GAUtils.CHARATERS.charAt(index2);
            individus.get(individus.size()-1).getGenes()[index2] = c2;
        }


    }

    public Individu getBestFitnessInd(){
        return individus.get(0);
    }
}
