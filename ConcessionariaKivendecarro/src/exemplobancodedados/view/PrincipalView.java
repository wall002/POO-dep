package exemplobancodedados.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PrincipalView extends JFrame implements ActionListener, MouseListener {

	JMenuBar mb;
	JMenu mnCarro, mnComprador, mnSistema;
	JMenuItem miCadastrarCarro, miConsultaCarro, miCadastrarComprador, miConsultaComprador, miSair;

	private JLabel lblImageBackground;
	private JLabel lblCadastraCarro, lblConsultaCarro;
	private JLabel lblCadastraComprador, lblConsultaComprador;

	private JPanel painelSuperior, painelCentral;

	private BorderLayout layoutPrincipal;

	public PrincipalView() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		inicializaComponentes();
		
	}

	public void inicializaComponentes() {

		mb = new JMenuBar();

		mnSistema = new JMenu("Agenda");
		miSair = new JMenuItem("Sair");

		mnSistema.add(miSair);

		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mnCarro = new JMenu("Carro");
		miCadastrarCarro = new JMenuItem("Cadastrar");
		miCadastrarCarro.addActionListener(this);
		miConsultaCarro = new JMenuItem("Consultar");
		miConsultaCarro.addActionListener(this);
		mnCarro.add(miCadastrarCarro);
		mnCarro.add(new JSeparator());
		mnCarro.add(miConsultaCarro);
		

		mnComprador = new JMenu("Comprador");
		miCadastrarComprador = new JMenuItem("Cadastrar");
		miCadastrarComprador.addActionListener(this);
		miConsultaComprador = new JMenuItem("Consultar");
		miConsultaComprador.addActionListener(this);
		mnComprador.add(miCadastrarComprador);
		mnComprador.add(new JSeparator());
		mnComprador.add(miConsultaComprador);

		mb.add(mnSistema);
		mb.add(mnCarro);
		mb.add(mnComprador);

		setJMenuBar(mb);

		painelCentral = new JPanel();
		painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
		painelCentral.setBackground(new Color(255, 245, 238)); 
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/img_background3.jpg"));
		lblImageBackground = new JLabel();
		lblImageBackground.setIcon(icon); // coloca a imagem na label
		painelCentral.add(lblImageBackground);
		getContentPane().add(painelCentral, BorderLayout.CENTER);

		painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		painelSuperior.setPreferredSize(new Dimension(0, 130));
		painelSuperior.setBackground(new Color(255, 245, 238)); 
		getContentPane().add(painelSuperior, BorderLayout.NORTH);

		lblCadastraCarro = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_adicionar_carro.png")));
		lblCadastraCarro.setText("Cadastrar Carro");
		lblCadastraCarro.setForeground(Color.PINK);
		lblCadastraCarro.addMouseListener(this);
		lblConsultaCarro = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_procurar_carro.png")));
		lblConsultaCarro.setText("Consultar Carros");
		lblConsultaCarro.setForeground(Color.PINK);
		lblConsultaCarro.addMouseListener(this);
		lblCadastraComprador = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_adicionar_dependente.png")));
		lblCadastraComprador.setText("Cadastrar Comprador");
		lblCadastraComprador.setForeground(Color.PINK);
		lblCadastraComprador.addMouseListener(this);
		lblConsultaComprador = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_procurar_dependente.png")));
		lblConsultaComprador.setText("Consultar Compradores");
		lblConsultaComprador.setForeground(Color.PINK);
		lblConsultaComprador.addMouseListener(this);

		painelSuperior.add(lblCadastraCarro);
		painelSuperior.add(lblConsultaCarro);
		painelSuperior.add(lblCadastraComprador);
		painelSuperior.add(lblConsultaComprador);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miCadastrarCarro) {
			new CadastroCarroView().setVisible(true);
		}else if (e.getSource() == miCadastrarComprador){
			new CadastroCompradorView().setVisible(true);
		} else if (e.getSource() == miConsultaCarro) {
			new ListaCarroView().setVisible(true);
		} else if (e.getSource() == miConsultaComprador) {
			new ListaCompradorView().setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCadastraCarro) {
			new CadastroCarroView().setVisible(true);
		} else if (e.getSource() == lblConsultaCarro) {
			new ListaCarroView().setVisible(true);
		} else if (e.getSource() == lblCadastraComprador) {
			new CadastroCompradorView().setVisible(true);
		} else if (e.getSource() == lblConsultaComprador) {
			new ListaCompradorView().setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
