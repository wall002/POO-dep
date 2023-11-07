package exemplobancodedados.view;

import control.CarroController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import exemplobancodedados.view.model.ListaCarroTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ListaCarroView extends JFrame implements ActionListener, KeyListener{
    
    private JLabel lblModelo;
    private JTextField txtModelo;
    private JButton btnPesquisar, btnAtualizar, btnApagar;    
    private JTable tblCarros;
    private JPanel painelSuperior;
    
    public ListaCarroView(){
        setTitle("Consulta de Carros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializaComponentes();
        pack();
    }
    
    private void inicializaComponentes(){
        painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        lblModelo = new JLabel("Modelo: ");
        txtModelo = new JTextField(30);
        txtModelo.setToolTipText("Digite o modelo do carro que deseja pesquisar.");
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this);
        btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(this);
        painelSuperior.add(btnAtualizar);
        painelSuperior.add(btnApagar);
        painelSuperior.add(lblModelo);
        painelSuperior.add(txtModelo);
        painelSuperior.add(btnPesquisar);
        
        getContentPane().add(painelSuperior, BorderLayout.NORTH);

        tblCarros = new JTable(new ListaCarroTableModel());
        JScrollPane scrollTable = new JScrollPane(tblCarros);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String modelo = txtModelo.getText();
        List<String[]> dadosCarros = new CarroController().listarCarrosPorModelo(modelo);
        tblCarros.setModel(new ListaCarroTableModel(dadosCarros));
        if (e.getSource() == btnAtualizar) {
            AtualizacaoCarroView atualizacaoCarroView = new AtualizacaoCarroView();
            atualizacaoCarroView.setVisible(true);
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }else if (e.getSource() == btnApagar) {
            ApagaCarroView apagaCarroView = new ApagaCarroView();
            apagaCarroView.setVisible(true);
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
