import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // Implementação do padrão Singleton
    private static ConexaoBD instancia;
    private Connection conexao;

    private ConexaoBD() {
        try {
            String url = "jdbc:mysql://localhost:3306/mercadinho";
            String usuario = "root";
            String senha = "";
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Garante que só uma instância da conexão será usada
    public static ConexaoBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}
