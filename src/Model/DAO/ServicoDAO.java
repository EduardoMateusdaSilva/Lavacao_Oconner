package Model.DAO;

import Model.Servico;
import java.sql.*;
import javax.swing.JOptionPane;

public class ServicoDAO {
    Connection conexao;
    
    public int adicionarServico(Servico objServico) {
        
        conexao = new Conexao().conectaBD();
        
        try {
            
            String sql = "INSERT INTO Servicos (nomeServ, valorServ, descServ) VALUES\n( ?, ?, ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);

        
            pstm.setString(1, objServico.getNome()); 
            pstm.setString(2, objServico.getValor());
            pstm.setString(3,objServico.getDescricao());

            return pstm.executeUpdate();


        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return 0;
        }
        
        
    }
    
    
    
}
