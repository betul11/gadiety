public class Ingredient {

    private String name;
    private int calorie;
    private double protein;
    private double gmWeight;
    private String gmDesc;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getGmWeight() {
        return gmWeight;
    }

    public void setGmWeight(double gmWeight) {
        this.gmWeight = gmWeight;
    }

    public String getGmDesc() {
        return gmDesc;
    }

    public void setGmDesc(String gmDesc) {
        this.gmDesc = gmDesc;
    }

    public Ingredient(String name, int calorie, double protein, double gmWeight, String gmDesc) {
        this.name = name;
        this.calorie = calorie;
        this.protein = protein;
        this.gmWeight = gmWeight;
        this.gmDesc = gmDesc;
    }
}
