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
    public boolean addEmployee( Employee e) {
        // Variables
        Connection con = null;
        PreparedStatement ps = null;
        boolean added = false;

        try{
            con = getConnection();

            /*(int employeeNumber, String lastName, String firstName, String extension,
                    String email, String officeCode, int reportsTo, String jobTitle)
                 */
            String query = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, e.getEmployeeNumber());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getFirstName());
            ps.setString(4, e.getExtension());
            ps.setString(5, e.getEmail());
            ps.setString(6, e.getOfficeCode());
            ps.setInt(7, e.getReportsTo());
            ps.setString(8, e.getJobTitle());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                added = true;
            }
        } catch (SQLException ex) {
            System.out.println("Exception occurred in the finally section of the addOrder() method:"
                    + " \n\t" +  ex.getMessage());
        }

        return added;
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
                employees.add(employee);

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
     * @param jobByTitle
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeByJobTitle(String jobByTitle) {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM employees WHERE jobTitle = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, jobByTitle);
            rs = ps.executeQuery();

            while (rs.next()) {

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
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getAllEmployeeByJobTitle() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the finally section of the getAllEmployeeByJobTitle() method: " + e.getMessage());
            }
        }

        return employees;
    }


    /**
     * @param reportsToThis
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeThatReportsTo(String reportsToThis) {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM employees WHERE reportsTo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,reportsToThis );
            rs = ps.executeQuery();

            while (rs.next()) {

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
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getAllEmployeeThatReportsTo() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the finally section of the getAllEmployeeThatReportsTo() method: " + e.getMessage());
            }
        }

        return employees;
    }

    /**
     * @param extentionStr
     * @return: List of employees
     */
    @Override
    public List<Employee> getAllEmployeeByExtension(String extentionStr) {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM employees WHERE extension = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,extentionStr );
            rs = ps.executeQuery();

            while (rs.next()) {

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
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getAllEmployeeByExtension() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the finally section of the getAllEmployeeByExtension() method: " + e.getMessage());
            }
        }

        return employees;
    }

    /**
     * @param officeCodeStr
     * @return: List of employees or null
     */
    @Override
    public List<Employee> getAllEmployeeByOfficeCode(String officeCodeStr) {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM employees WHERE officeCode = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,officeCodeStr );
            rs = ps.executeQuery();

            while (rs.next()) {

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
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getAllEmployeeByOfficeCode() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the finally section of the getAllEmployeeByOfficeCode() method: " + e.getMessage());
            }
        }

        return employees;
    }
    /*
     @Override
    public boolean addOrder(Order o) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean added = false;

        try {
            con = getConnection();

            String query = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, o.getOrderNumber());
            // Convert the LocalDate objects to java.sql.Date versions, so they can be understood by the database
            ps.setDate(2, Date.valueOf(o.getOrderDate()));
            ps.setDate(3, Date.valueOf(o.getRequiredDate()));

            // Because this could be null, we check it before we attempt to convert it
            LocalDate shippedDate = o.getShippedDate();
            if(shippedDate != null){
                ps.setDate(4, Date.valueOf(shippedDate));
            }else{
                ps.setDate(4, null);
            }

            ps.setString(5, o.getStatus());
            ps.setString(6, o.getComments());
            ps.setInt(7, o.getCustomerNumber());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                added = true;
            }
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Integrity constraint failed in the addOrder() method: " + e.getMessage());
            added = false;
        } catch (SQLException e) {
            System.out.println("Exception occurred in the addOrder() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the finally section of the addOrder() method: \n\t" +  e.getMessage());
            }
        }
        return added;
    }

    @Override
    public List<Order> getCustomerOrders(int custNum) {
        List<Order> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM orders WHERE customerNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, custNum);
            rs = ps.executeQuery();

            while (rs.next()) {
                int orderNum = rs.getInt("orderNumber");
                // Convert the java.sql.Date objects to LocalDate versions, so they can be stored in our Order objects
                LocalDate orderDate = rs.getDate("orderDate").toLocalDate();
                LocalDate reqDate = rs.getDate("requiredDate").toLocalDate();

                // Because this could be null, we check it before we convert it
                LocalDate shipDate = null;
                Date d = rs.getDate("shippedDate");
                if (d != null) {
                    shipDate = d.toLocalDate();
                }

                String status = rs.getString("status");
                String comments = rs.getString("comments");
                Order o = new Order(orderNum, orderDate, reqDate, shipDate, status, comments, custNum);
                orders.add(o);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getCustomerOrders() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the finally section of the getCustomerOrders() method: " + e.getMessage());
            }
        }
        return orders;
    }

    public static void main(String[] args) {
        OrderDao dao = new OrderDao("classicmodels");
        List<Order> orders = dao.getAllOrders();
        for(Order o: orders){
            System.out.println(o);
        }

        Order order = dao.getOrderById(10100);
        System.out.println("Located order: " + order);

        order = dao.getOrderById(101090);
        System.out.println("Located non-existent order: " + order);

        List<Order> custOrders = dao.getCustomerOrders(124);
        for(Order o: custOrders){
            System.out.println(o);
        }

        int orderNum = 10426;
        LocalDate orderDate = LocalDate.of(2023, Month.SEPTEMBER, 24);
        LocalDate requiredDate = LocalDate.of(2023, Month.OCTOBER, 10);
        LocalDate shippedDate = null;
        String status = "In Process";
        String comments = null;
        int custNum = 141;
        Order newOrder = new Order(orderNum, orderDate, requiredDate, shippedDate, status, comments, custNum);
        boolean added = dao.addOrder(newOrder);
        if(added){
            System.out.println("Order was added");}
        else{
            System.out.println("Order could not be added");
        }

        Order addedOrder = dao.getOrderById(orderNum);
        System.out.println("Added order: " + addedOrder);
    }
     */
}
