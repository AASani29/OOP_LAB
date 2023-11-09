public class Employee {
    public String firstName;
    public String lastName;
    public String postalCode;
    public String street;
    public String district;
    public int age;
    public String designation;
    public double remuneration;

    public Employee(String firstName, String lastName, String postalCode, String street, String district, int age, String designation, double remuneration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.street = street;
        this.district = district;
        this.age = age;
        this.designation = designation;
        this.remuneration = remuneration;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    public double getRemuneration() {
        return remuneration;
    }

    @Override
    public String toString() {
        return "Employee :\n" +
                "  firstName: " + firstName + "\n"+
                "  lastName: " + lastName + "\n" +
                "  postalCode: " + postalCode + "\n" +
                "  street: " + street + "\n" +
                "  district: " + district + "\n" +
                "  age: " + age + "\n" +
                "  designation: " + designation + "\n"+
                "  remuneration: " + remuneration + "\n";
    }
}