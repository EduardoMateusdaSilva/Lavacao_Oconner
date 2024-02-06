package Controller;

import Model.DAO.UsuarioDAO;
import Model.Funcionario;
import View.CadastroFunc;
import View.MenuPrinc;

public class CadastroFuncController {
    
    private final CadastroFunc view;

    public CadastroFuncController(CadastroFunc view) {
        this.view = view;
        
    }
    
    public void cadastrarFuncionario(){
        
        String nome_func, dataNasc_func, cpf_func, genero_func, telefone_func, endereco_func, email_func, cep_func, complemento_func, senha_func, nivelAcesso_func;
        nome_func = view.getCampoNome().getText();
        dataNasc_func = view.getCampoDataNascimento().getText();
        cpf_func = view.getCampoCPF().getText();
        genero_func = (String) view.getCampoGenero().getSelectedItem();
        telefone_func = view.getCampoTelefone().getText();
        endereco_func = view.getCampoEndereco().getText();
        email_func = view.getCampoEmail().getText();
        cep_func = view.getCampoCEP().getText();
        complemento_func = view.getCampoComplemento().getText();
        senha_func = view.getCampoSenha().getText();
        nivelAcesso_func = (String) view.getCampoNivelAcesso().getSelectedItem();
        
        char letraGenero_cliente = genero_func.charAt(0);
        genero_func = letraGenero_cliente+"";
        

        Funcionario pessoa = new Funcionario(nome_func, genero_func, dataNasc_func, cpf_func, telefone_func, email_func, cep_func, endereco_func, complemento_func, senha_func, nivelAcesso_func);
        pessoa.setNome(nome_func);
        pessoa.setDataNascimento(dataNasc_func);
        pessoa.setCpf(cpf_func);
        pessoa.setSexo(genero_func);
        pessoa.setTelefone(telefone_func);
        pessoa.setEndereco(endereco_func);
        pessoa.setEmail(email_func);
        pessoa.setCep(cep_func);
        pessoa.setComplemento(complemento_func);
        pessoa.setSenha(senha_func);
        pessoa.setNivelAcesso(nivelAcesso_func);

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.adicionarFuncionario(pessoa);

    }
    
    public void voltarMenuPrinc(){
        MenuPrinc objFrmPrincpalView = new MenuPrinc();
        objFrmPrincpalView.setVisible(true);
        view.dispose();
    }
    
    
    
}
