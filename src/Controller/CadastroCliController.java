package Controller;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import View.CadastroCli;
import View.MenuPrinc;


public class CadastroCliController {
    
    private final CadastroCli view;

    public CadastroCliController(CadastroCli view) {
        this.view = view;
    }
    
    public void cadastrarCliente(){
        
        String nome_cliente, dataNasc_cliente, cpf_cliente, genero_cliente, telefone_cliente, endereco_cliente, email_cliente, cep_cliente, complemento_cliente;
        nome_cliente = view.getCampoNome().getText();
        dataNasc_cliente = view.getCampoDataNascimento().getText();
        cpf_cliente = view.getCampoCPF().getText();
        genero_cliente = (String) view.getCampoGenero().getSelectedItem();
        telefone_cliente = view.getCampoTelefone().getText();
        endereco_cliente = view.getCampoEndereco().getText();
        email_cliente = view.getCampoEmail().getText();
        cep_cliente = view.getCampoCep().getText();
        complemento_cliente = view.getCampoComplemento().getText();
        
        char letraGenero_cliente = genero_cliente.charAt(0);
        genero_cliente = letraGenero_cliente+"";
        

        Cliente pessoa = new Cliente(nome_cliente, genero_cliente, dataNasc_cliente, cpf_cliente, telefone_cliente, email_cliente, cep_cliente, endereco_cliente, complemento_cliente);
        pessoa.setNome(nome_cliente);
        pessoa.setDataNascimento(dataNasc_cliente);
        pessoa.setCpf(cpf_cliente);
        pessoa.setSexo(genero_cliente);
        pessoa.setTelefone(telefone_cliente);
        pessoa.setEndereco(endereco_cliente);
        pessoa.setEmail(email_cliente);
        pessoa.setCep(cep_cliente);
        pessoa.setComplemento(complemento_cliente);

        ClienteDAO objClienteDAO = new ClienteDAO();
        objClienteDAO.adicionarCliente(pessoa);

    }
    
    public void voltarMenuPrinc(){
        MenuPrinc objFrmPrincpalView = new MenuPrinc();
        objFrmPrincpalView.setVisible(true);
        view.dispose();
    }
    
    
    
}
