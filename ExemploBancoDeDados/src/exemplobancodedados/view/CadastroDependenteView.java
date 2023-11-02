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

import control.DependenteController;

public class CadastroDependenteView extends JFrame implements ActionListener{

	private JLabel lblCodigoDoFuncionario, lblNome, lblMesada;
    private JTextField  txtCodigoDoFuncionario, txtNome, txtMesada;
    private JPanel painelCenter, painelBottom;
    private JButton btnCadastrar, btnCancelar;    
    
    private BorderLayout layoutPai;
    private FlowLayout layoutBottom;
   
    public CadastroDependenteView(){
        
        setTitle("Formulário de Cadastro de Dependente");
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
        
        lblCodigoDoFuncionario = new JLabel("Codigo do Funcionario:");
        lblCodigoDoFuncionario.setBounds(15,15, 150, 30);
        txtCodigoDoFuncionario = new JTextField();
        txtCodigoDoFuncionario.setBounds(175, 15, 190, 30);
        
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(15,50, 100, 30);        
        txtNome = new JTextField();
        txtNome.setBounds(115, 50, 170, 30);
            
        lblMesada = new JLabel("Mesada:");
        lblMesada.setBounds(15, 85, 50, 30);
        txtMesada = new JTextField();
        txtMesada.setBounds(115, 85, 168, 30);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        painelBottom.add(btnCadastrar);
        painelBottom.add(btnCancelar);
        painelBottom.setBackground(new Color(200,200,200));

        painelCenter.add(lblCodigoDoFuncionario); 
        painelCenter.add(txtCodigoDoFuncionario);
        painelCenter.add(lblNome); 
        painelCenter.add(txtNome);
        painelCenter.add(lblMesada); 
        painelCenter.add(txtMesada); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar){
            cadastrarDependente();
            //listarFuncionarios();
        }else if (e.getSource() == btnCancelar){
            dispose();
        }
    }
    
    public void cadastrarDependente(){

        int codigoDoFuncionario = Integer.parseInt(txtCodigoDoFuncionario.getText());
        String nome = txtNome.getText();
        double mesada = Double.parseDouble(txtMesada.getText());
        DependenteController dependenteController = new DependenteController();
        boolean resultado = dependenteController.adicionarDependente(codigoDoFuncionario, nome, mesada);
        if (resultado){
            JOptionPane.showMessageDialog(null,"Dependente Cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null,"Problema ao Cadastrar Dependente!");
        }
    }

    private void listarDependentes() {
        DependenteController dependenteController = new DependenteController();
        java.util.List<String[]> dependentesDados = dependenteController.listarDependentes();
        for(String[] dados : dependentesDados){
            System.out.println(dados[0]+"\t"+dados[1]+"\t"+dados[2]+"\t"+dados[3]);
        }
    }
	
}
