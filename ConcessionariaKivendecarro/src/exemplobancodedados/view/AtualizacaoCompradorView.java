package exemplobancodedados.view;

import control.CarroController;
import control.CompradorController;

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

public class AtualizacaoCompradorView extends JFrame implements ActionListener{
    

    private JLabel lblId, lblNome, lblCpf, lblPlaca_Carro;
    private JTextField txtId, txtNome, txtCpf, txtPlaca_Carro;
    private JPanel painelCenter, painelBottom;
    private JButton btnAtualizar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public AtualizacaoCompradorView(){
        
        setTitle("Formulário de Atualização de Comprador");
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
        		+ " do comprador que você vai atualizar:");
        lblId.setBounds(15,15, 270, 30);        
        txtId = new JTextField();
        txtId.setBounds(15, 50, 250, 30);
        
        lblNome = new JLabel("Novo Nome:");
        lblNome.setBounds(15,85, 100, 30);        
        txtNome = new JTextField();
        txtNome.setBounds(115, 85, 250, 30);
        
        lblCpf = new JLabel("Novo Cpf:");
        lblCpf.setBounds(15,120, 100, 30);
        txtCpf = new JTextField();
        txtCpf.setBounds(115, 120, 100, 30);
            
        lblPlaca_Carro = new JLabel("Nova Placa do Carro:");
        lblPlaca_Carro.setBounds(15, 155, 200, 30);
        txtPlaca_Carro = new JTextField();
        txtPlaca_Carro.setBounds(155, 155, 120, 30);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnAtualizar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));
        
        painelCenter.add(lblId); 
        painelCenter.add(txtId);
        painelCenter.add(lblNome); 
        painelCenter.add(txtNome);
        painelCenter.add(lblCpf); 
        painelCenter.add(txtCpf); 
        painelCenter.add(lblPlaca_Carro); 
        painelCenter.add(txtPlaca_Carro);  

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAtualizar){
            atualizarComprador();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    
    }
    
    public void atualizarComprador(){
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String placa_Carro = txtPlaca_Carro.getText();
        CompradorController compradorController = new CompradorController();
        boolean resultado = compradorController.atualizarComprador(id, nome, cpf, placa_Carro);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Comprador Atualizado!");
            listarCarros();  // Atualize a lista de carros após a operação de atualização
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Atualizar Comprador!");
        }
        
    }

    private void listarCarros() {
        CompradorController compradorController = new CompradorController();
        java.util.List<String[]> compradoresDados = compradorController.listarCompradores();
        for(String[] dados : compradoresDados){
            System.out.println(dados[0]+"\t"+dados[1]+"\t"+dados[2]+"\t"+dados[3]);
        }
    }
}