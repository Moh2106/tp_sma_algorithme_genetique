package ma.enset.ga_number;

import java.util.*;

public class Population {
    private List<Individu> individus = new ArrayList<>();
    private Individu firstNear;
    private Individu secondNear;

    public Individu getFirstNear() {
        return firstNear;
    }

    public Individu getSecondNear() {
        return secondNear;
    }

    public List<Individu> getIndividus() {
        return individus;
    }

    public void initialize_population(){
        for (int i=0;i<10;i++){
            individus.add(new Individu());
        }
    }

    public void calculateFitness(){
        for (int i=0; i<individus.size(); i++){
            individus.get(i).calculateFitness();
        }
    }

    public void sortIndividu(){
        Collections.sort(individus, Collections.reverseOrder());
    }

    public void selection(){
        firstNear = individus.get(0);
        secondNear = individus.get(1);
    }

    public void crossover(){
        Individu individu1 = new Individu();
        Individu individu2 = new Individu();

        for (int i = 0; i<individu1.getGenes().length; i++){
            individu1.getGenes()[i] = firstNear.getGenes()[i];
            individu2.getGenes()[i] = secondNear.getGenes()[i];
        }

        Random random = new Random();
        int pointCroisement = random.nextInt(5);
        pointCroisement++;

        System.out.println("pointCroisement " + pointCroisement);

        for (int i=0; i<pointCroisement; i++){
            int tmp;
            tmp = individu2.getGenes()[i];
            individu2.getGenes()[i] = individu1.getGenes()[i];
            individu1.getGenes()[i] = tmp;
        }

        individus.add(individu1);
        individus.add(individu2);
    }

    public void mutation(){
        Random random = new Random();
        int index = random.nextInt(6);

        if (individus.get(individus.size() - 2).getGenes()[index] == 1){
            individus.get(individus.size() - 2).getGenes()[index] = 0;
        }else {
            individus.get(individus.size() - 2).getGenes()[index] = 1;
        }

        // Second index

        int index1 = random.nextInt(6);


        if (individus.get(individus.size() - 1).getGenes()[index1] == 1){
            individus.get(individus.size() - 1).getGenes()[index1] = 0;
        }else {
            individus.get(individus.size() - 1).getGenes()[index1] = 1;
        }
    }

    public Individu getBestFitnessInd(){
        return individus.get(0);
    }

}
