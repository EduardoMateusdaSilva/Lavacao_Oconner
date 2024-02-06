package Controller;

import java.sql.*;
import View.MenuPrinc;
import View.Login;
import Model.DAO.UsuarioDAO;
import Model.Funcionario;
import javax.swing.JOptionPane;

public class LoginController {

    private final Login view;
//    private Object objFrmPrincpalView;            // desnecessario

    public LoginController(Login view) {
        this.view = view;
    }

    public void entraNoSistema() {

        try {
            String usuario_nome, senha_usuario;
            usuario_nome = view.getCampologin1().getText();
            senha_usuario = view.getCamposenha().getText();

            // Cria um objeto Usuario com as informações de usuário e senha.
            Funcionario pessoa = new Funcionario(usuario_nome, senha_usuario);
            pessoa.setEmail(usuario_nome);
            pessoa.setSenha(senha_usuario);

            // Cria um objeto UsuarioDAO para realizar operações no banco de dados.
            UsuarioDAO objUsuarioDao = new UsuarioDAO();
            ResultSet rsUsuarioDAO = objUsuarioDao.autenticaUsuario(pessoa);

            if (rsUsuarioDAO.next()) {
                // Se houver um resultado na consulta, redireciona para a próxima tela.
                MenuPrinc objFrmPrincpalView = new MenuPrinc();
                objFrmPrincpalView.setVisible(true);
                view.dispose();
               
            }
            else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretos!"); // Exibe uma mensagem de erro.
            }
             
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro); // Trata exceções do banco de dados e exibe mensagens de erro.
        }
       
    }
}


//            try {
//            String usuario_nome, senha_usuario;
//            usuario_nome = campologin1.getText();
//            senha_usuario = camposenha.getText();
//
//            // Cria um objeto Usuario com as informações de usuário e senha.
//            Funcionario pessoa = new Funcionario(usuario_nome, senha_usuario);
//            pessoa.setEmail(usuario_nome);
//            pessoa.setSenha(senha_usuario);
//
//            // Cria um objeto UsuarioDAO para realizar operações no banco de dados.
//            UsuarioDAO objUsuarioDao = new UsuarioDAO();
//            ResultSet rsUsuarioDAO = objUsuarioDao.autenticaUsuario(pessoa);
//
//            if (rsUsuarioDAO.next()) {
//                // Se houver um resultado na consulta, redireciona para a próxima tela.
//                MenuPrinc objFrmPrincpalView = new MenuPrinc();
//                objFrmPrincpalView.setVisible(true);
//                //objFrmPrincpalView.dispose(); // Fecha a tela de login.
//            } else {
//                JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretos!"); // Exibe uma mensagem de erro.
//            }
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, erro); // Trata exceções do banco de dados e exibe mensagens de erro.
//        }
