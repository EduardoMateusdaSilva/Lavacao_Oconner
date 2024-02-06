package Model.DAO;

import java.sql.Connection;
import javax.swing.JOptionPane; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class Conexao {

    public Connection conectaBD() {


        Connection conector = null; // Declara uma variável para armazenar a conexão.

        try {
            String url = "jdbc:mysql://localhost:3306/lavacaooconner?user=root&password=" ;


            conector = DriverManager.getConnection(url);


        } catch (SQLException erro) {


            JOptionPane.showMessageDialog(null, erro.getMessage());


        }

        return conector;

    }
}

