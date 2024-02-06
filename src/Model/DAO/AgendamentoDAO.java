package Model.DAO;

import DTO.AgendamentoDTO;
import Model.Agendamento;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AgendamentoDAO {
    
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoDTO> lista = new ArrayList<>();
    
    public int adicionarAgendamento(Agendamento objAgendamento) {
        
        conexao = new Conexao().conectaBD();
        
        try {
                            // conferir informações na tabela. tabela nao criada. 
            String sql = "INSERT INTO Agendamentos (nomeClient, servico, valor, data, hora, obs) VALUES\n(?, ?, ?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sql);

          
            pstm.setString(1, objAgendamento.getNome_cliente()); 
            pstm.setString(2, objAgendamento.getNome_servico());
            pstm.setString(3, objAgendamento.getValor());
            pstm.setString(4, objAgendamento.getData());
            pstm.setString(5, objAgendamento.getHora());
            pstm.setString(6, objAgendamento.getObservacao());
            
            return pstm.executeUpdate();

            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return 0;
        }
        
        
    }
    
    public ArrayList<AgendamentoDTO> PesquisarAgendamento(){
        
        String sql = "Select * from agendamentos";
        conexao = new Conexao().conectaBD();
        
        try {
            
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                AgendamentoDTO objAgendamentoDTO = new AgendamentoDTO();
                objAgendamentoDTO.setID(rs.getInt("ID"));
                objAgendamentoDTO.setNomeClient(rs.getString("nomeClient"));
                objAgendamentoDTO.setServico(rs.getString("servico"));
                objAgendamentoDTO.setValor(rs.getString("valor"));
                objAgendamentoDTO.setData(rs.getString("data"));
                objAgendamentoDTO.setHora(rs.getString("hora"));
                objAgendamentoDTO.setObs(rs.getString("obs"));
                
                lista.add(objAgendamentoDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return lista;
    }
    
    
    public int FazerCancelamentoAgendamento(Agendamento objAgendamento){
        
        conexao = new Conexao().conectaBD();
        
        try {
            String sql = "delete from agendamentos where ID = ? ";
            pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, objAgendamento.getId()); 
            
            return pstm.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "agendamentoDAO "+erro);
            return 0;
        }      
    }
    
    
    
    
}
