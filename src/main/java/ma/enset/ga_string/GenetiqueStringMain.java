package ma.enset.ga_string;

import java.util.Arrays;
import java.util.List;

public class GenetiqueStringMain {
    //private static final int MAX_IT = 200;
    private static final int MAX_FITNESS = 7;

    public static void main(String[] args) {
        Population population = new Population();
        System.out.println("*** INITIALIZE POPULATION ***");
        population.initialize_population();

        population.calculateFitness();
        population.sortIndividu();

        /*for (Individu ind: population.getIndividus()) {
            System.out.println(ind.getGenes());
            System.out.println("Fitness : "+ ind.getFitness());
        }

        System.out.println("********** AFTER SELECTION ******************");
        population.selection();

        for (Individu ind: population.getIndividus()) {
            System.out.println(ind.getGenes());
            System.out.println("Fitness : "+ ind.getFitness());
        }

        System.out.println("********** SHOW ME DETAILS ******************");
        System.out.println(population.getFirstNear().getGenes());
        System.out.println("Fitness : " +population.getFirstNear().getFitness());
        System.out.println(population.getSecondNear().getGenes());
        System.out.println("Fitness : " +population.getFirstNear().getFitness());
        //System.out.println();
        System.out.println("********** AFTER CROSSOVER ******************");
        //System.out.println(population.);
        population.crossover();
        for (Individu ind: population.getIndividus()) {
            System.out.println(ind.getGenes());
            System.out.println("Fitness : "+ ind.getFitness());
        }*/

        int it=0;
        while (it<GAUtils.MAX_IT && population.getBestFitnessInd().getFitness()< MAX_FITNESS){
            population.selection();
            population.crossover();
            population.mutation();
            population.calculateFitness();

            population.sortIndividu();
            System.out.println("it = " + it + " " +Arrays.toString(population.getBestFitnessInd().getGenes()) + " Fitness : "+population.getBestFitnessInd().getFitness());
            it++;
        }

    }
}
