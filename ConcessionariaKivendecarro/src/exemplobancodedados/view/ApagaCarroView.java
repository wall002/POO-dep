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

import control.CarroController;
import exemplobancodedados.view.model.ListaCarroTableModel;

public class ApagaCarroView extends JFrame implements ActionListener{
    

    private JLabel lblPlaca;
    private JTextField txtPlaca;
    private JPanel painelCenter, painelBottom;
    private JButton btnApagar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public ApagaCarroView(){
        
        setTitle("Formulário para Apagar um Carro");
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
        
        lblPlaca = new JLabel("Insira a placa"
        		+ " do carro que você vai apagar:");
        lblPlaca.setBounds(15,15, 250, 30);        
        txtPlaca = new JTextField();
        txtPlaca.setBounds(15, 50, 250, 30);

        btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnApagar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));
        
        painelCenter.add(lblPlaca); 
        painelCenter.add(txtPlaca);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnApagar){
            apagarCarro();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    
    }
    
    public void apagarCarro(){
        String placa = txtPlaca.getText();
        CarroController carroController = new CarroController();
        boolean resultado = carroController.apagarCarro(placa);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Carro Apagado!");
            listarCarros();
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Apagar Carro!");
        }
    }

    private void listarCarros() {
        CarroController carroController = new CarroController();
        java.util.List<String[]> carrosDados = carroController.listarCarros();
        for(String[] dados : carrosDados){
            System.out.println(dados[0]+"\t"+dados[1]+"\t"+dados[2]+"\t"+dados[3]);
        }
    }
}
