package exemplobancodedados.view;

import control.CarroController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AtualizacaoCarroView extends JFrame implements ActionListener{
    

    private JLabel lblPlaca, lblModelo, lblAno, lblCor;
    private JTextField txtPlaca, txtModelo, txtAno, txtCor;
    private JPanel painelCenter, painelBottom;
    private JButton btnAtualizar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public AtualizacaoCarroView(){
        
        setTitle("Formulário de Atualização de Carro");
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
        		+ " do carro que você vai atualizar:");
        lblPlaca.setBounds(15,15, 255, 30);        
        txtPlaca = new JTextField();
        txtPlaca.setBounds(15, 50, 250, 30);
        
        lblModelo = new JLabel("Novo Modelo:");
        lblModelo.setBounds(15,85, 100, 30);        
        txtModelo = new JTextField();
        txtModelo.setBounds(115, 85, 250, 30);
        
        lblAno = new JLabel("Novo Ano:");
        lblAno.setBounds(15,120, 100, 30);
        txtAno = new JTextField();
        txtAno.setBounds(115, 120, 100, 30);
            
        lblCor = new JLabel("Nova Cor:");
        lblCor.setBounds(15, 155, 100, 30);
        txtCor = new JTextField();
        txtCor.setBounds(115, 155, 100, 30);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnAtualizar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));
        
        painelCenter.add(lblPlaca); 
        painelCenter.add(txtPlaca);
        painelCenter.add(lblModelo); 
        painelCenter.add(txtModelo);
        painelCenter.add(lblAno); 
        painelCenter.add(txtAno); 
        painelCenter.add(lblCor); 
        painelCenter.add(txtCor);  

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAtualizar){
            atualizarCarro();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    
    }
    
    public void atualizarCarro(){
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());
        String cor = txtCor.getText();
        CarroController carroController = new CarroController();
        boolean resultado = carroController.atualizarCarro(placa, modelo, ano, cor);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Carro Atualizado!");
            listarCarros();  // Atualize a lista de carros após a operação de atualização
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Atualizar Carro!");
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