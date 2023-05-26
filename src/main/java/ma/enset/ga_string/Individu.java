package ma.enset.ga_string;

import java.util.Random;

public class Individu implements Comparable {
    private char genes[] = new char[GAUtils.CHROMOSOME_SIZE];
    private int fitness;

    public Individu() {
        Random random = new Random();
        for (int i=0; i<genes.length; i++){
            int index = random.nextInt(GAUtils.CHARATERS.length());
            char c = GAUtils.CHARATERS.charAt(index);
            genes[i] = c;
        }
    }

    public char[] getGenes() {
        return genes;
    }

    public void setGenes(char[] genes) {
        this.genes = genes;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void calculateIndFitness(){
        fitness = 0;

        for (int i =0; i<genes.length; i++){
            if (genes[i] == GAUtils.SOLUTION.charAt(i)){
                fitness +=1;
            }
        }
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
