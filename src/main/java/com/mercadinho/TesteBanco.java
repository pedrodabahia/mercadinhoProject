import repository.DatabaseConfig;
import java.sql.Connection;

public class TesteBanco {
    public static void main(String[] args) {
        Connection connection = DatabaseConfig.getConnection();

        if (connection != null) {
            System.out.println("Banco de dados encontrado com sucesso!");
        }
    }
}
