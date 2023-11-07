package exemplobancodedados.view;

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

import control.CompradorController;

public class CadastroCompradorView extends JFrame implements ActionListener{

	private JLabel lblNome, lblCpf, lblPlaca_Carro;
    private JTextField  txtNome, txtCpf, txtPlaca_Carro;
    private JPanel painelCenter, painelBottom;
    private JButton btnCadastrar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public CadastroCompradorView(){
        
        setTitle("Formulário de Cadastro de Comprador");
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
        
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(15,15, 100, 30);
        txtNome = new JTextField();
        txtNome.setBounds(115, 15, 170, 30);
        
        lblCpf = new JLabel("Cpf:");
        lblCpf.setBounds(15,50, 100, 30);        
        txtCpf = new JTextField();
        txtCpf.setBounds(115, 50, 170, 30);
            
        lblPlaca_Carro = new JLabel("Placa do Carro:");
        lblPlaca_Carro.setBounds(15, 85, 250, 30);
        txtPlaca_Carro = new JTextField();
        txtPlaca_Carro.setBounds(115, 85, 168, 30);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnCadastrar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));

        painelCenter.add(lblNome); 
        painelCenter.add(txtNome);
        painelCenter.add(lblCpf); 
        painelCenter.add(txtCpf);
        painelCenter.add(lblPlaca_Carro); 
        painelCenter.add(txtPlaca_Carro); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar){
            cadastrarComprador();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    }
    
    public void cadastrarComprador(){

        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String placa_Carro = txtPlaca_Carro.getText();
        CompradorController compradorController = new CompradorController();
        boolean resultado = compradorController.adicionarComprador(nome, cpf, placa_Carro);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Comprador Cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Cadastrar Comprador!");
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
