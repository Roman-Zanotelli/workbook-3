import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

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

        try{
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
            String[] tokens = line.split("\\|");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            float price = Float.parseFloat(tokens[2]);
            inventory.add(new Product(id, name,price));
        }
            reader.close();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION OCCURRED EXITING EARLY");
            System.exit(1);
            return;
        }

        //inventory.sort(Comparator.comparing(product -> product.name)); //sort the pre-existing array
        //inventory.forEach(product -> System.out.println(product.toString())); //print out the initial inv

        TUI.run();

    }

    private static ArrayList<Product> getInventory() {
        return inventory;
    }

    private static class Product{
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

    static class TUI{
        static private Scanner scanner;
        private static void run(){
            scanner = new Scanner(System.in);
            while(true){
                printMenu();
                switch (printScanSelection()){
                    case 1 :
                        listAllProducts();
                        break;
                    case 2 :
                        findAllProductsByID();
                        break;
                    case 3 :
                        findAllProductsByPrice();
                        break;
                    case 4 :
                        addNewProduct();
                        break;
                    case 5 :
                        System.out.println("Ciao!!!");
                        return;
                }
            }

        }
        private static void printMenu(){
            System.out.printf("What do you want to do?\n" +
                    "\t1- List all products\n" +
                    "\t2- Lookup a product by its id\n" +
                    "\t3- Find all products within a price range\n" +
                    "\t4- Add a new product\n" +
                    "\t5- Quit the application\n");
        }
        private static int printScanSelection(){
            int res;
            do{
                System.out.print("Please Enter 1-5: ");
                while(!scanner.hasNextInt()){
                    scanner.nextLine();
                    System.out.print("Please Enter 1-5: ");
                }
                res = scanner.nextInt();
            }while(!(1 <= res && res <= 5));
            scanner.nextLine();
            return res;
        }
        private static void listAllProducts(){
            inventory.forEach(product -> System.out.println(product.toString()));
        }
        private static void findAllProductsByID(){

        }
        private static void findAllProductsByPrice(){

        }
        private static void addNewProduct(){


            inventory.sort(Comparator.comparing(product -> product.name)); //sort products when we add
        }
    }

}
