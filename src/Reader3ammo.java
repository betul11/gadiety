import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Vector;

import com.opencsv.CSVReader;

public class Reader3ammo {
    public static Vector<Ingredient> ingredients = new Vector<>();


    private int getHeaderLocation(String[] headers, String columnName) {
        return Arrays.asList(headers).indexOf(columnName);
    }

    public void CSVReaderMethod() throws IOException {

        CSVReader reader = null;
        try
        {
        reader = new CSVReader(new FileReader("F:\\ABBREV_75.csv"));

        String [] nextLine;

            nextLine = reader.readNext();
            int columnPosition1 = getHeaderLocation(nextLine, "Shrt_Desc");
            int columnPosition2 = getHeaderLocation(nextLine, "Energ_Kcal");
            int columnPosition3 = getHeaderLocation(nextLine, "Protein_(g)");
            int columnPosition4 = getHeaderLocation(nextLine, "GmWt");
            int columnPosition5 = getHeaderLocation(nextLine, "GmWt_Desc");

            int i = 0;
            while ((nextLine = reader.readNext()) != null && columnPosition1 > -1
            && columnPosition2 > -1 && columnPosition3 > -1 && columnPosition4 > -1 && columnPosition5 > -1)

        {
            try {
                String shrt_desc = nextLine[columnPosition1];
                int energ_kcal=Integer.parseInt(nextLine[columnPosition2]);
                double protein_g =Double.parseDouble(nextLine[columnPosition3]);
                double gmwt =Double.parseDouble(nextLine[columnPosition4]);
                String gmwt_desc = nextLine[columnPosition5];
                ingredients.add(i, new Ingredient(shrt_desc,energ_kcal,protein_g,gmwt,gmwt_desc));
            } catch (NumberFormatException nfe) {
                // Handle the condition when str is not a number.
            }
           /*  System.out.print(ingredients.get(i).getName());
            System.out.print("\n");

            System.out.print(ingredients.get(i).getCalorie());
            System.out.print("\n");   */
            i++;

        }
    }
       catch (Exception e)
    {
        e.printStackTrace();
    }









}
}






