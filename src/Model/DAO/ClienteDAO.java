package Model.DAO;

import Model.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;



public class ClienteDAO {
    
    Connection conexao; 

    public ClienteDAO() {
    }
    
    public int adicionarCliente(Cliente objCliente) {
        
        conexao = new Conexao().conectaBD();
        
        try {

            String sql = "INSERT INTO Clientes (nomeClient, sexoClient, dataNascClient, cpfClient, telefoneClient, emailClient, cepClient, enderecoClient, complementoClient) VALUES\n( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
          
            pstm.setString(1, objCliente.getNome()); 
            pstm.setString(2, objCliente.getSexo());
            pstm.setString(3, objCliente.getDataNascimento());
            pstm.setString(4, objCliente.getCpf());
            pstm.setString(5, objCliente.getTelefone());
            pstm.setString(6, objCliente.getEmail());
            pstm.setString(7, objCliente.getCep());
            pstm.setString(8, objCliente.getEndereco());
            pstm.setString(9, objCliente.getComplemento());
            
            return pstm.executeUpdate();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return 0;
        }
        
        
    }

    
    
}
