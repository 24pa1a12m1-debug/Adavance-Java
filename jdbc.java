import java.sql.*;

public class jdbc {

    static final String URL =
            "jdbc:mysql://localhost:3306/college";

    static final String USER = "root";

    static final String PASSWORD = "password";

    public static void main(String args[]) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected Successfully");

            insertStudent(con);

            updateStudent(con);

            deleteStudent(con);

            displayStudents(con);

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }

    }

    static void insertStudent(Connection con)
            throws SQLException {

        String sql =
                "INSERT INTO student VALUES(4,'Suresh','Bangalore')";

        Statement st = con.createStatement();

        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record inserted");

    }

    static void updateStudent(Connection con)
            throws SQLException {

        String sql =
                "UPDATE student SET address='Hyderabad' WHERE rollno=2";

        Statement st = con.createStatement();

        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record updated");

    }

    static void deleteStudent(Connection con)
            throws SQLException {

        String sql =
                "DELETE FROM student WHERE rollno=3";

        Statement st = con.createStatement();

        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record deleted");

    }

    static void displayStudents(Connection con)
            throws SQLException {

        Statement st = con.createStatement();

        ResultSet rs =
                st.executeQuery("SELECT * FROM student");

        System.out.println();

        System.out.println("Student Records");

        while(rs.next()) {

            System.out.println(
                    rs.getInt("rollno") + " "
                            + rs.getString("name") + " "
                            + rs.getString("address"));

        }

    }

}
