import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("src/main/resources/DataFiles/employees.csv");
        } catch (FileNotFoundException ignored) {
            System.out.println("File Not Found Please Check \"src/main/resources/DataFiles/employees.csv\" Actually Exists");
            return;
        }
        BufferedReader buff = new BufferedReader(reader);
        try {
            buff.readLine(); //discard the first line (not an actual employee)
            for(String line = buff.readLine(); line != null ; line = buff.readLine()){

                //splits line into ID, Name, HoursWorked, PayRate
                String[] tokens = line.split("\\|");

                //Parse tokens into respective data types
                int employeeID = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                float hoursWorked = Float.parseFloat(tokens[2]);
                float payRate = Float.parseFloat(tokens[3]);

                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);
                System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
        }catch (IOException ignored){

        }
    }
}
