package Model.DAO;

import Model.Funcionario;
import java.sql.*; 
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conexao; 

    
    public ResultSet autenticaUsuario(Funcionario objUsuario) {
        conexao = new Conexao().conectaBD();

        try {
            String sql = "select * from Funcionarios where emailFunc = ? and passFunc = ?"; 
            PreparedStatement pstm = conexao.prepareStatement(sql); 

            // Define os parâmetros na consulta SQL.
            pstm.setString(1, objUsuario.getEmail()); 
            pstm.setString(2, objUsuario.getSenha()); 

            ResultSet rs = pstm.executeQuery();

            return rs; 

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);

            return null;
        }
    }
                                                        // conferir esse parametro passado, comparar com objUsuario
    public int adicionarFuncionario(Funcionario objFuncionario) {
        
        conexao = new Conexao().conectaBD();
        
        try {

            String sql = "INSERT INTO Funcionarios (nomeFunc, sexoFunc, dataNascFunc, cpfFunc, telefoneFunc, emailFunc, cepFunc, enderecoFunc, complementoFunc, passFunc, nivelAcessoFunc) VALUES\n( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
          
            pstm.setString(1, objFuncionario.getNome()); 
            pstm.setString(2, objFuncionario.getSexo());
            pstm.setString(3, objFuncionario.getDataNascimento());
            pstm.setString(4, objFuncionario.getCpf());
            pstm.setString(5, objFuncionario.getTelefone());
            pstm.setString(6, objFuncionario.getEmail());
            pstm.setString(7, objFuncionario.getCep());
            pstm.setString(8, objFuncionario.getEndereco());
            pstm.setString(9, objFuncionario.getComplemento());
            pstm.setString(10, objFuncionario.getSenha());
            pstm.setString(11, objFuncionario.getNivelAcesso());
            return pstm.executeUpdate();


        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return 0;
        }
        
        
    }
}
