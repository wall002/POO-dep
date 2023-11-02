package exemplobancodedados.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.DependenteController;
import exemplobancodedados.view.model.ListaDependenteTableModel;

public class ListaDependenteView extends JFrame implements ActionListener, KeyListener{

	private JLabel lblNome;
    private JTextField txtNome;
    private JButton btnPesquisar;    
    private JTable tblDependentes;
    private JPanel painelSuperior;
    
    public ListaDependenteView(){
        setTitle("Consulta de Dependentes");
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

        tblDependentes = new JTable(new ListaDependenteTableModel());
        JScrollPane scrollTable = new JScrollPane(tblDependentes);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        List<String[]> dadosDependentes = new DependenteController().listarDependentesPorNome(nome);
        tblDependentes.setModel(new ListaDependenteTableModel(dadosDependentes));
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
