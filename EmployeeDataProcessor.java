import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDataProcessor
{

    private static List<Employee> readEmployeeData(String filePath)
    {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line = br.readLine();

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                String firstName = data[0];
                String lastName = data[1];
                String postalCode = data[2];
                String street = data[3];
                String district = data[4];
                int age = Integer.parseInt(data[5]);
                String designation = data[6];
                double remuneration = Double.parseDouble(data[7]);

                Employee employee = new Employee(firstName, lastName, postalCode, street, district, age, designation, remuneration);
                employees.add(employee);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to read the file", e);
        }

        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = readEmployeeData("employee_data.csv");

        //task 2
        List<Employee> employeesOver30 = EmployeeDataFilter.filterByAge(employees, 30);
        System.out.println("Employees older than 30: ");
        EmployeeDataFilter.displayEmployees(employeesOver30);

        //task 3
        Map<String, List<Employee>> employeesByPostalCode = EmployeeDataFilter.groupByPostalCode(employees);
        System.out.println("Employees grouped by Postal Code: \n" + employeesByPostalCode);


        //task 4
        double averageRemuneration = EmployeeDataFilter.calculateAverageRemuneration(employees);
        System.out.println("Average Remuneration: " + averageRemuneration);


        //task 5
        Employee highestRemunerationEmployee = EmployeeDataFilter.findHighestRemuneration(employees);
        System.out.println("Employee with the highest remuneration: " + highestRemunerationEmployee);


        //task 6
        boolean hasManager = EmployeeDataFilter.hasManager(employees);
        System.out.println("At least one employee is a Manager: " + hasManager);


        //task 7
        List<Employee> sortedByAgeAscending = EmployeeDataFilter.sortByAgeAscending(employees);
        System.out.println("Sorted by Age (Ascending): " );
        EmployeeDataFilter.displayEmployees(sortedByAgeAscending);


        List<Employee> sortedByAgeDescending = EmployeeDataFilter.sortByAgeDescending(employees);
        System.out.println("Sorted by Age (Descending): ");
        EmployeeDataFilter.displayEmployees(sortedByAgeDescending);


        //task 8
        Employee youngestEmployee = EmployeeDataFilter.findYoungestEmployee(employees);
        System.out.println("Youngest Employee: " + youngestEmployee);


        //task 9
        long uptownEmployeesCount = EmployeeDataFilter.countUptownEmployees(employees);
        System.out.println("Number of employees in Uptown district: " + uptownEmployeesCount);


        //task 10
        List<String> distinctPostalCodes = EmployeeDataFilter.getDistinctPostalCodes(employees);
        System.out.println("Distinct Postal Codes: " + distinctPostalCodes);


        //task 11
        double totalRemuneration = EmployeeDataFilter.calculateTotalRemuneration(employees);
        System.out.println("Total Remuneration: " + totalRemuneration);


        //task 12
        boolean allAdults = EmployeeDataFilter.areAllEmployeesAdults(employees);
        System.out.println("All employees are adults: " + allAdults);


        //task 13
        List<Employee> skippedEmployees = EmployeeDataFilter.skipEmployees(employees,3);
        System.out.println("Skipped Employees: " );
        EmployeeDataFilter.displayEmployees(skippedEmployees);

        //task 14
        double averageAgeDowntown = EmployeeDataFilter.calculateAverageAgeInDowntown(employees);
        System.out.println("Average Age in Downtown District: " + averageAgeDowntown);


        //task 15
        List<Employee> top3HighestRemunerations = EmployeeDataFilter.getTop3HighestRemunerations(employees);
        System.out.println("Top 3 Highest Remunerations: " );
        EmployeeDataFilter.displayEmployees(top3HighestRemunerations);


    }

}