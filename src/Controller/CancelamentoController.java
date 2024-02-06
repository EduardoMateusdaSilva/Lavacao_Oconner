package Controller;

import Model.Agendamento;
import Model.DAO.AgendamentoDAO;
import View.Cancelamento;
import View.MenuPrinc;

public class CancelamentoController {
    
    private final Cancelamento view;

    public CancelamentoController(Cancelamento view) {
        this.view = view;
    }
    
    
    public void CancelarAgendamento(){
        
        int ID;
        String id;
        
        id = view.getCampoId().getText();
        
        ID = Integer.parseInt(id);
        
        
        Agendamento objAgenda = new Agendamento(ID);
        objAgenda.setId(ID);
        
        AgendamentoDAO objAgendamentoDAO = new AgendamentoDAO();
        objAgendamentoDAO.FazerCancelamentoAgendamento(objAgenda);
        
    }
    
    
    
    
    
    
    public void voltarMenuPrinc(){
        MenuPrinc objFrmPrincpalView = new MenuPrinc();
        objFrmPrincpalView.setVisible(true);
        view.dispose();
    }
}
    
   
