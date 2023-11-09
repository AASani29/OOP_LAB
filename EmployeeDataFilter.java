import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class EmployeeDataFilter
{

    public static List<Employee> filterByAge(List<Employee> employees, int ageThreshold)
    {
        return employees.stream()
                .filter(employee -> employee.getAge() > ageThreshold)
                .toList();
    }

    public static Map<String, List<Employee>> groupByPostalCode(List<Employee> employees)
    {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPostalCode));
    }

    public static double calculateAverageRemuneration(List<Employee> employees)
    {
        return employees.stream()
                .mapToDouble(Employee::getRemuneration)
                .average()
                .orElse(0.0);
    }

    public static Employee findHighestRemuneration(List<Employee> employees)
    {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getRemuneration))
                .orElse(null);
    }

    public static boolean hasManager(List<Employee> employees)
    {
        return employees.stream()
                .anyMatch(employee -> "Manager".equals(employee.getDesignation()));
    }

    public static List<Employee> sortByAgeAscending(List<Employee> employees)
    {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();
    }

    public static List<Employee> sortByAgeDescending(List<Employee> employees)
    {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .toList();
    }

    public static Employee findYoungestEmployee(List<Employee> employees)
    {
        return employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public static long countUptownEmployees(List<Employee> employees)
    {
        return employees.stream()
                .filter(employee -> "Uptown".equals(employee.getDistrict()))
                .count();
    }

    public static List<String> getDistinctPostalCodes(List<Employee> employees)
    {
        return employees.stream()
                .map(Employee::getPostalCode)
                .distinct()
                .toList();
    }

    public static double calculateTotalRemuneration(List<Employee> employees)
    {
        return employees.stream()
                .mapToDouble(Employee::getRemuneration)
                .reduce(0, Double::sum);
    }

    public static boolean areAllEmployeesAdults(List<Employee> employees)
    {
        return employees.stream()
                .allMatch(employee -> employee.getAge() > 18);
    }

    public static List<Employee> skipEmployees(List<Employee> employees, int numberToSkip)
    {
        return employees.stream()
                .skip(numberToSkip)
                .toList();
    }

    public static double calculateAverageAgeInDowntown(List<Employee> employees)
    {
        return employees.stream()
                .filter(employee -> "Downtown".equals(employee.getDistrict()))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);
    }

    public static List<Employee> getTop3HighestRemunerations(List<Employee> employees)
    {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getRemuneration).reversed())
                .limit(3)
                .toList();
    }


    public static void displayEmployees(List<Employee> employees)
    {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Employee " + (i + 1) + ":");
            displayEmployeeDetails(employees.get(i));
            System.out.println();
        }
    }

    private static void displayEmployeeDetails(Employee employee)
    {
        System.out.println("  firstName: " + employee.getFirstName());
        System.out.println("  lastName: " + employee.getLastName());
        System.out.println("  postalCode: " + employee.getPostalCode());
        System.out.println("  street: " + employee.getStreet());
        System.out.println("  district: " + employee.getDistrict());
        System.out.println("  age: " + employee.getAge());
        System.out.println("  designation: " + employee.getDesignation());
        System.out.println("  remuneration: " + employee.getRemuneration());
    }
}









