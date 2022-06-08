import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int maxCalorieIntake;

    public static void main(String[] args) throws IOException {
        Reader3ammo reader = new Reader3ammo();
        reader.CSVReaderMethod();


        boolean pregnancySit=false;


        Scanner s = new Scanner(System.in);
        System.out.println("Welcome! Please enter your age.");
        int age = s.nextInt();

        System.out.println("Please select your gender: press 1 (for Female)/or 2 (for Male)");
        int gender = s.nextInt();

        if(gender==1){

            System.out.println("Are you pregnant? (y/n)");
            s.nextLine();
            String pregnancy = s.nextLine();
            if(pregnancy=="y"){
                pregnancySit=true;



            }else if(pregnancy=="n"){



            }

        }else if(gender==2){

        }

        System.out.println("Please enter your weight in kg");
        int weight = s.nextInt();

        calculateMaxCalorie(age,gender,pregnancySit,weight);

        Population population = new Population(GeneticAlgorithm.populationSize).initializePopulation();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        System.out.println("------------------------");
        System.out.println("Generation #0"+"| Fittest chromosome fitness:"+population.getChromosomes()[0].getFitness());
        printPopulation(population,"MODIFY LATER! MAYBE PUT INGREDIENTS");

        int generationNumber = 0;
        int minimumProteinIntake = 400;
        while (population.getChromosomes()[0].getFitness()<minimumProteinIntake && generationNumber<10){
            generationNumber++;
            System.out.println("\n ---------------------------");
            population = geneticAlgorithm.evolve(population);
            population.sortChromosomesByFitness();
            System.out.println("Generation #"+ generationNumber+ " | Fittest chromosome fitness:"+population.getChromosomes()[0].getFitness());
            printPopulation(population,"MODIFY LATER! MAYBE PUT INGREDIENTS");

        }


    }

    public static void calculateMaxCalorie(int age, int gender, boolean pregnancy, int weight){
         maxCalorieIntake=2400;
    }

    public static void printPopulation(Population population, String heading) throws IOException {
        System.out.println(heading);
        System.out.println("------------------------");
        for(int i=0;i<population.getChromosomes().length;i++){

            System.out.println("Chromosome #" +i+":"+ Arrays.toString(population.getChromosomes()[i].getGenes())+
             "| Fitness" + population.getChromosomes()[i].getFitness());
        }



    }
}
