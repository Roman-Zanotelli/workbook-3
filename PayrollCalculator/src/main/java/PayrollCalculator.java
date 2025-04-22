import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Please Enter a File Name to Scan: ");
        String path_in = scanner.nextLine().trim();
        //Setting up the reader
        FileReader reader;
        try {
            reader = new FileReader("src/main/resources/DataFiles/" + path_in);
        } catch (FileNotFoundException ignored) {
            System.out.printf("File Not Found Please Check \"src/main/resources/DataFiles/%s\" Actually Exists", path_in);
            return;
        }

        FileWriter writer;
        System.out.print("Please Enter a File Name to Save: ");
        try {
            writer = new FileWriter("target/classes/DataFiles/" + scanner.nextLine().trim());
        } catch (IOException e) {
            return;
        }


        //Setting up buffered reader & writer
        BufferedReader buff_r = new BufferedReader(reader);
        BufferedWriter buff_w = new BufferedWriter(writer);
        try {
            buff_r.readLine(); //discard the first line (not an actual employee)
            buff_w.write("id|name|gross pay\n");
            for(String line = buff_r.readLine(); line != null ; line = buff_r.readLine()){

                //splits line into ID, Name, HoursWorked, PayRate
                String[] tokens = line.split("\\|");

                //Parse tokens into respective data types
                int employeeID = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                float hoursWorked = Float.parseFloat(tokens[2]);
                float payRate = Float.parseFloat(tokens[3]);

                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);
                buff_w.write(String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
            }
            buff_w.close();
        }catch (IOException ignored){
            System.out.print("Exception!");
        }
    }
}
