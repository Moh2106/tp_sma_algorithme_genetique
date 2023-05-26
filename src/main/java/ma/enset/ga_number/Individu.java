package ma.enset.ga_number;

import java.util.Arrays;
import java.util.Random;

public class Individu implements Comparable {
    private int genes[] = new int[6];
    private int fitness;

    public Individu() {
        Random random = new Random();
        for (int i=0; i<genes.length;i++) {
            genes[i] = random.nextInt(2);
        }
    }

    public int[] getGenes() {
        return genes;
    }

    public int getFitness() {
        return fitness;
    }


    public int calculateFitness(){
        fitness=0;
        for (int fit:genes) {
            if (fit==1) fitness++;
        }

        return fitness;
    }

    @Override
    public int compareTo(Object o) {
        Individu individu = (Individu) o;
        if (this.fitness > individu.fitness)
            return 1;
        else if (this.fitness < individu.fitness)
            return -1;
        else
            return 0;
    }

}
