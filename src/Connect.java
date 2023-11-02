import java.sql.*;

public class Connect {

    private final String url;
    private final String user;
    private final String pass;

    public Connect() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        this.user = "postgres";
        this.pass = "Nikita797";
    }

    public String[][] allSelect(String select) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            System.err.println(e.getMessage());
            return new String[0][0];
        }

        final int rowSize = 5;
        final int columnSize = 3;

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(select);
            String[][] obj = new String[rowSize][columnSize];

            if (result.next()) {
                for (int i = 1; i <= rowSize; i++) {
                    for (int j = 0; j < columnSize; j++) {
                        obj[i - 1][j] = result.getString(j + 1);
                    }
                    result.next();
                }
            }

            return obj;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.err.println(e.getMessage());
            return new String[0][0];
        }
    }
}
