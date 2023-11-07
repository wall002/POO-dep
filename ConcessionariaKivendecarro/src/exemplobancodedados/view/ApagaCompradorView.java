package exemplobancodedados.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.CompradorController;
import exemplobancodedados.view.model.ListaCarroTableModel;

public class ApagaCompradorView extends JFrame implements ActionListener{
    

    private JLabel lblId;
    private JTextField txtId;
    private JPanel painelCenter, painelBottom;
    private JButton btnApagar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public ApagaCompradorView(){
        
        setTitle("Formulário para Apagar um Comprador");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
        Container container = getContentPane(); 

        layoutPai = new BorderLayout();
        container.setLayout(layoutPai);
        
        painelCenter = new JPanel();
        painelCenter.setLayout(null);
        
        painelBottom = new JPanel();
        layoutBottom = new FlowLayout(FlowLayout.LEFT, 25,15);
        painelBottom.setLayout(layoutBottom);
        
        container.add(painelCenter, BorderLayout.CENTER);
        container.add(painelBottom, BorderLayout.SOUTH);
        
        lblId = new JLabel("Insira o id"
        		+ " do comprador que você vai apagar:");
        lblId.setBounds(15,15, 270, 30);        
        txtId = new JTextField();
        txtId.setBounds(15, 50, 250, 30);

        btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnApagar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));
        
        painelCenter.add(lblId); 
        painelCenter.add(txtId);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnApagar){
            apagarComprador();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    
    }
    
    public void apagarComprador(){
        int id = Integer.parseInt(txtId.getText());
        CompradorController compradorController = new CompradorController();
        boolean resultado = compradorController.apagarComprador(id);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Comprador Apagado!");
            listarCompradores();
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Apagar Comprador!");
        }
    }

    private void listarCompradores() {
        CompradorController compradorController = new CompradorController();
        java.util.List<String[]> compradoresDados = compradorController.listarCompradores();
        for(String[] dados : compradoresDados){
            System.out.println(dados[0]+"\t"+dados[1]+"\t"+dados[2]+"\t"+dados[3]);
        }
    }
}
