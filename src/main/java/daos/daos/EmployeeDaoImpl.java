package daos.daos;

import daos.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends Dao implements EmployeeDao{

    // Constructor
    public EmployeeDaoImpl(String databaseName) {
        super(databaseName);
    }
    // Override Methods
    @Override
    public boolean addEmployee(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
        return false;
    }
    /**
     * @param
     * @return
     */
    @Override
    public List<Employee> getAllEmployees(){
        // Variables
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            // Get connect to DB
            con = getConnection();
            //Prepare Query & Execute Query
            String query = "SELECT * FROM employees";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                /*int employeeNumber, String lastName, String firstName, String extension,
                    String email, String officeCode, int reportsTo, String jobTitle)
                 */
                int employeeNumber = rs.getInt("employeeNumber");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstname");
                String extension = rs.getString("extension");
                String email = rs.getString("email");
                String officeCode =rs.getString("email");
                int reportsTo = rs.getInt("reportTo");
                String jobTitle = rs.getString("jobTitle");

                Employee employee = new Employee(employeeNumber,lastName,firstName,
                        extension,email,officeCode,reportsTo,jobTitle );

            }

        }catch (SQLException e) {
            System.out.println("Exception occurred in the getAllOrders() method: " + e.getMessage());
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the finally section of the getAllOrders() method: " + e.getMessage());
            }

        }
        return employees;
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
