package Controller;

import Model.DAO.ServicoDAO;
import Model.Servico;
import View.CadastroServ;
import View.MenuPrinc;

public class CadastroServController {
    
    private final CadastroServ view;

    public CadastroServController(CadastroServ view) {
        this.view = view;
    
    }
    
    public void cadastrarServico(){
        
        String nome_serv, valor_serv, descricao_serv;
        
        nome_serv = view.getCampoServico().getText();
        valor_serv = view.getCampoValor().getText();
        descricao_serv = view.getCampoDescricao().getText();
        
        Servico servico = new Servico(nome_serv, descricao_serv, valor_serv);
        servico.setNome(nome_serv);
        servico.setValor(valor_serv);
        servico.setDescricao(descricao_serv);

        ServicoDAO objServicoDAO = new ServicoDAO();
        objServicoDAO.adicionarServico(servico);

    }
    
    public void voltarMenuPrinc(){
        MenuPrinc objFrmPrincpalView = new MenuPrinc();
        objFrmPrincpalView.setVisible(true);
        view.dispose();
    }
    
    
    
}
