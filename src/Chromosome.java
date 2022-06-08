import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;


public class Chromosome {
    Main main = new Main();
    Reader3ammo reader3ammo = new Reader3ammo();

    private int[] genes;
    boolean isFitnessChanged = true;
    private double fitness=0;
    private int genesLength = 75;
    public Chromosome() {
        genes = new int[genesLength];

    }

    public int getGenesLength() {
        return genesLength;
    }

    public int[] getGenes() {
        isFitnessChanged = true;
        return genes;
    }

    public double getFitness() throws IOException {
        if(isFitnessChanged){
            fitness = recalculateFitness(); // get ingredients and user
            isFitnessChanged = false;
        }
        return fitness;
    }

    public Chromosome initializeChromosome(){
       // System.out.println("INSIDE INITIALIZE CHROMOSOME\n");

        for(int i=0;i<genes.length;i++){
            if(Math.random()>0.8) genes[i]=1;
            else genes[i]=0;
        }
     //   System.out.println("CHROMOSOME INITIALIZED\n");

        return this;

    }



    public String toString(){
        return Arrays.toString(this.genes);
    }


    public double recalculateFitness() throws IOException {
      //  System.out.println("INSIDE CALCULATE FITNESS\n");

        double totalProtein = 0;
        int totalCalorie = 0;


    //    System.out.println("INSIDE FITNESS CALCULATION LOOP\n");
        for(int i=0;i<genes.length;i++){

            if (genes[i] == 1) {
           //     System.out.println("INSIDE IFFFFF CALCULATION LOOP\n");

                totalProtein = totalProtein + reader3ammo.ingredients.get(i).getProtein();
                totalCalorie = totalCalorie + reader3ammo.ingredients.get(i).getCalorie();

             //   System.out.println("IF GENE IS 1\n");
              }

        }
         //  System.out.println("FITNESS CALCULATED\n");
            if( totalCalorie > main.maxCalorieIntake){
            /*    int differenceBetweenCalories = totalCalorie - main.maxCalorieIntake;
                if(differenceBetweenCalories> 20 ){

                    // ASK ABOUT THIS
                }
           */
             totalProtein = 0;

            }
        // if calorie intake is more than accepted return fitness is zero
       return totalProtein;
    }



}
