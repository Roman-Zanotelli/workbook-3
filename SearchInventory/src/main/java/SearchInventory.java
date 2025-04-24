import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchInventory {
    static ArrayList<Product> inventory = new ArrayList<>();
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("CSV FILE NOT FOUND, CHECK src/main/resources/inventory.csv EXISTS");
            System.exit(1);
            return;
        }

        try{for (String line = reader.readLine(); line != null; line = reader.readLine()){
            String[] tokens = line.split("\\|");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            float price = Float.parseFloat(tokens[2]);
            inventory.add(new Product(id,name,price));
        }} catch (IOException e) {
            System.out.println("IO EXCEPTION OCCURRED EXITING EARLY");
            System.exit(1);
        }
        inventory.sort(Comparator.comparing(product -> product.name));
        inventory.forEach(product -> System.out.println(product.toString()));
    }
    public static ArrayList<Product> getInventory() {
        return inventory;
    }
    public static class Product{
        int id;
        String name;
        float price;
        Product(int id, String name, float price){
            this.id = id;
            this.name = name;
            this.price = price;
        }
        @Override
        public String toString(){
            return String.format("Product ID: %d | Product Name: %s | Product Price: %.2f", this.id, this.name, this.price);
        }
    }
}
