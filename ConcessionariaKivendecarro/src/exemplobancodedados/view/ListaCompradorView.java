package exemplobancodedados.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Window;
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
import javax.swing.SwingUtilities;

import control.CompradorController;
import exemplobancodedados.view.model.ListaCompradorTableModel;

public class ListaCompradorView extends JFrame implements ActionListener, KeyListener{

	private JLabel lblNome;
    private JTextField txtNome;
    private JButton btnPesquisar, btnAtualizar, btnApagar;    
    private JTable tblCompradores;
    private JPanel painelSuperior;
    
    public ListaCompradorView(){
        setTitle("Consulta de Compradores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializaComponentes();
        pack();
    }
    
    private void inicializaComponentes(){
        painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField(30);
        txtNome.setToolTipText("Digite o nome do comprador que deseja pesquisar.");
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this);
        btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(this);
        painelSuperior.add(btnAtualizar);
        painelSuperior.add(btnApagar);
        painelSuperior.add(lblNome);
        painelSuperior.add(txtNome);
        painelSuperior.add(btnPesquisar);
        
        getContentPane().add(painelSuperior, BorderLayout.NORTH);

        tblCompradores = new JTable(new ListaCompradorTableModel());
        JScrollPane scrollTable = new JScrollPane(tblCompradores);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        List<String[]> dadosDependentes = new CompradorController().listarCompradoresPorNome(nome);
        tblCompradores.setModel(new ListaCompradorTableModel(dadosDependentes));
        if (e.getSource() == btnAtualizar) {
            AtualizacaoCompradorView atualizacaoCompradorView = new AtualizacaoCompradorView();
            atualizacaoCompradorView.setVisible(true); 
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }else if (e.getSource() == btnApagar) {
            ApagaCompradorView apagaCompradorView = new ApagaCompradorView();
            apagaCompradorView.setVisible(true);
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        } 
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
