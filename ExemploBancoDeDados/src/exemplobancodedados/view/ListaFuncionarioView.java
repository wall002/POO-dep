package exemplobancodedados.view;

import control.FuncionarioController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import exemplobancodedados.view.model.ListaFuncionarioTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ListaFuncionarioView extends JFrame implements ActionListener, KeyListener{
    
    private JLabel lblNome;
    private JTextField txtNome;
    private JButton btnPesquisar;    
    private JTable tblFuncionarios;
    private JPanel painelSuperior;
    
    public ListaFuncionarioView(){
        setTitle("Consulta de Funcionários");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializaComponentes();
        pack();
    }
    
    private void inicializaComponentes(){
        painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField(30);
        txtNome.setToolTipText("Digite o nome do funcionário que deseja pesquisar.");
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        painelSuperior.add(lblNome);
        painelSuperior.add(txtNome);
        painelSuperior.add(btnPesquisar);
        
        getContentPane().add(painelSuperior, BorderLayout.NORTH);

        tblFuncionarios = new JTable(new ListaFuncionarioTableModel());
        JScrollPane scrollTable = new JScrollPane(tblFuncionarios);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        List<String[]> dadosFuncionarios = new FuncionarioController().listarFuncionariosPorNome(nome);
        tblFuncionarios.setModel(new ListaFuncionarioTableModel(dadosFuncionarios));
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
