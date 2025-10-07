package daos.daos;

import daos.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    // Method to Add new employee detail to database
    public boolean addEmployee(int employeeNumber, String lastName, String firstName,
                               String extension, String email, String officeCode,
                               int reportsTo, String jobTitle);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeByID(int employeeNumber);

    public Employee deleteEmployeeByID(int employeeNumber);

    public Employee upDateEmployeeDetail(int employeeNumber);
    public List<Employee> getAllEmployeeByJobTitle(String jobTitle);
    public List<Employee> getAllEmployeeThatReportsTo(String reportsTo);
    public List<Employee> getAllEmployeeByExtension(String extention);
    public List<Employee> getAllEmployeeByOfficeCode(String officeCode);

}
