import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader csvReader = new CSVReader();
        String[][] recipes = csvReader.getRecipes();
        //print first row
        System.out.println(recipes[1][0]);
    }
}