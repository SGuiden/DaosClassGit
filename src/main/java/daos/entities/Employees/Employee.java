package daos.entities.Employees;

import java.util.Objects;

/*Table structure for table employees */
/*DROP TABLE IF EXISTS employees;
        CREATE TABLE employees (
        employeeNumber int(11) NOT NULL,
        lastName varchar(50) NOT NULL,
        firstName varchar(50) NOT NULL,
        extension varchar(10) NOT NULL,
        email varchar(100) NOT NULL,
        officeCode varchar(10) NOT NULL,
        reportsTo int(11) default NULL,
        jobTitle varchar(50) NOT NULL,
        PRIMARY KEY  (employeeNumber)
        );
*/
public class Employee {
    // Properties
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;

    // Constructors
    public Employee(){}

    public Employee(int employeeNumber, String lastName, String firstName,
                    String extension, String email, String officeCode,
                    int reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }
    // Getters

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getExtension() {
        return extension;
    }

    public String getEmail() {
        return email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    // Setters

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    // Good Practice Methodes


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeNumber() == employee.getEmployeeNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
