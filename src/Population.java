import java.io.IOException;
import java.util.Arrays;

public class Population {


    private Chromosome[] chromosomes;
    //private int chromosomesLength = 25;

    public Population(int chromosomesLength) {
        chromosomes = new Chromosome[chromosomesLength];

    }

    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    public Population initializePopulation(){
     //   System.out.println("INSIDE INITIALIZE POPULATION\n");
        for(int i=0; i<chromosomes.length ;i++){
            chromosomes[i]= new Chromosome().initializeChromosome();

        }

     //   System.out.println("POPULATION INITIALIZED\n");

        sortChromosomesByFitness();
        return this;
    }


    public void sortChromosomesByFitness(){
      //  System.out.println("SORTING CHROMOSOMES\n");

        Arrays.sort(chromosomes,(chromosome1,chromosome2) ->{
            int flag = 0;
            try {
                if(chromosome1.getFitness()>chromosome2.getFitness()) flag=-1;
                else if(chromosome1.getFitness()<chromosome2.getFitness()) flag = 1;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return flag;


        });

      //  System.out.println("CHROMOSOMES SORTED\n");


    }

}
