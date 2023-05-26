package ma.enset.ga_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Population {

    // Pour enregistrer les individus
    private List<Individu> individus = new ArrayList<>();

    // Initialisation de mon individu principale : L'individu qui servira de comparaison
    private static final String MAIN_INDIVIDU = "bonjour";

    private Individu firstNear;
    private Individu secondNear;
    public Population() {

    }

    public Individu getFirstNear() {
        return firstNear;
    }

    public void setFirstNear(Individu firstNear) {
        this.firstNear = firstNear;
    }

    public Individu getSecondNear() {
        return secondNear;
    }

    public void setSecondNear(Individu secondNear) {
        this.secondNear = secondNear;
    }

    public List<Individu> getIndividus() {
        return individus;
    }

    public void setIndividus(List<Individu> individus) {
        this.individus = individus;
    }

    // Cette méthode va permettre d'initialiser une population
    public void initialize_population(){
        for (int i=0;i<GAUtils.POPULATION_SIZE; i++){
            individus.add(new Individu());
        }
    }


    // Cette méthode va permettre de calculer le fitness d'un individu
    public void calculateFitness(){
        for (int i=0;i<GAUtils.POPULATION_SIZE;i++){
            individus.get(i).calculateIndFitness();
        }

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
        int pointDeCroisement = random.nextInt(GAUtils.CHROMOSOME_SIZE - 2);
        pointDeCroisement++;

        System.out.println("Point de croisement" +pointDeCroisement);

        for (int i=0; i<firstNear.getGenes().length; i++){
            individu1.getGenes()[i] = firstNear.getGenes()[i];
            individu2.getGenes()[i] = secondNear.getGenes()[i];
        }

        for (int i=0 ; i<pointDeCroisement; i++){
            /*char tmp;
            tmp = individu2.getGenes()[i];
            individu2.getGenes()[i] = individu1.getGenes()[i];
            individu1.getGenes()[i] = tmp;*/
            individu1.getGenes()[i] = secondNear.getGenes()[i];
            individu2.getGenes()[i] = firstNear.getGenes()[i];
        }

        individus.set(individus.size()-2, individu2);
        individus.set(individus.size() -1, individu1);

        individu1.calculateIndFitness();
        individu2.calculateIndFitness();

//        System.out.println("Individus 1");
//        System.out.println(individu1.getGenes());
//        System.out.println("Individus 2");
//        System.out.println(individu2.getGenes());
//        individus.add(individu1);
//        individus.add(individu2);
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
