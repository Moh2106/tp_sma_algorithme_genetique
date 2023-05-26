package ma.enset.ga_number;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AlgoGenetiqueApp {
    private static final int MAX_IT = 50;
    private static final int MAX_FITNESS = 6;

    public static void main(String[] args) {
        Population population = new Population();
        population.initialize_population();
        population.calculateFitness();
        population.sortIndividu();

        int it=0;
        System.out.println(Arrays.toString(population.getBestFitnessInd().getGenes()) + " Fitness " + population.getBestFitnessInd().getFitness());

        while (it<MAX_IT && population.getBestFitnessInd().getFitness() < MAX_FITNESS){
            population.selection();

            population.crossover();

            Random random = new Random();
            int nb = random.nextInt(101);

            if(nb < 50)
                population.mutation();

            population.calculateFitness();
            population.sortIndividu();

            System.out.println("POPULATION APRES MUTATION");

            System.out.println(Arrays.toString(population.getBestFitnessInd().getGenes()) + "Fitness " + population.getBestFitnessInd().getFitness());

            it++;
        }


        /*System.out.println("POPULATION");
        for (Individu ind:population.getIndividus()) {
            System.out.println(Arrays.toString(ind.getGenes()));
            System.out.println(ind.calculateFitness());
        }

        System.out.println("First Near "+ Arrays.toString(population.getFirstNear().getGenes()) + "Second Near : "+
               Arrays.toString(population.getSecondNear().getGenes()) );



        System.out.println("POPULATION APRES CROSS OVER");
        for (Individu ind:population.getIndividus()) {
            System.out.println(Arrays.toString(ind.getGenes()));
            System.out.println(ind.calculateFitness());
        }*/

    }
}
