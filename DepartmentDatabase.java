import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DepartmentDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost/departments";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/datavalley","root"," ");

            // Create a Department object
            Department dept = new Department(101, "Software Engineering");

            // Insert the Department object into the database using a PreparedStatement
            String sql = "INSERT INTO department (id, name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dept.getId());
            stmt.setString(2, dept.getName());
            stmt.executeUpdate();

            // Close the resources
            stmt.close();
            conn.close();

            System.out.println("Department successfully added to the database.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
