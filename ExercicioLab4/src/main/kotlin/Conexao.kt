import java.sql.Connection
import java.sql.DriverManager

class Conexao {
    companion object {
        private final val USUARIO = "root"
        private final val SENHA = "root"
        private final val URL = "jdbc:mariadb://localhost:3306/dbtabajara"
        private final val DRIVER = "org.mariadb.jdbc.Driver"

        fun abrir() : Connection {
            Class.forName(DRIVER)

            var conn: Connection = DriverManager.getConnection(URL, USUARIO, SENHA)

            return conn
        }
    }
}