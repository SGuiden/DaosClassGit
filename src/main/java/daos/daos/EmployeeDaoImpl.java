package daos.daos;

import daos.entities.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    /**
     * @param employeeNumber
     * @param lastName
     * @param firstName
     * @param extension
     * @param email
     * @param officeCode
     * @param reportsTo
     * @param jobTitle
     * @return
     */
    @Override
    public boolean addEmployee(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
        return false;
    }

    /**
     * @param employeeNumber
     * @return
     */
    @Override
    public Employee getEmployeeByID(int employeeNumber) {
        return null;
    }

    /**
     * @param employeeNumber
     * @return
     */
    @Override
    public Employee deleteEmployeeByID(int employeeNumber) {
        return null;
    }

    /**
     * @param employeeNumber
     * @return: List of employees
     */
    @Override
    public Employee upDateEmployeeDetail(int employeeNumber) {
        return null;
    }

    /**
     * @param jobTitle
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeByJobTitle(String jobTitle) {
        return null;
    }

    /**
     * @param reportsTo
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeThatReportsTo(String reportsTo) {
        return null;
    }

    /**
     * @param extention
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeByExtension(String extention) {
        return null;
    }

    /**
     * @param officeCode
     * @return: List of employees or null
     */
    @Override
    public List<Employee> getAllEmployeeByOfficeCode(String officeCode) {
        return null;
    }
}
