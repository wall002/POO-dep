package exemplobancodedados.view;

import java.awt.BorderLayout;
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
	JMenu mnFuncionario, mnDependente, mnSistema;
	JMenuItem miCadastrarFuncionario, miConsultaFuncionario, miCadastrarDependente, miConsultaDependente, miSair;

	private JLabel lblImageBackground;
	private JLabel lblCadastraFuncionario, lblConsultaFuncionario;
	private JLabel lblCadastraDependente, lblConsultaDependente;

	private JPanel painelSuperior, painelCentral;

	private BorderLayout layoutPrincipal;

	public PrincipalView() {
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
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

		mnFuncionario = new JMenu("Funcionario");
		miCadastrarFuncionario = new JMenuItem("Cadastrar");
		miCadastrarFuncionario.addActionListener(this);
		miConsultaFuncionario = new JMenuItem("Consultar");
		miConsultaFuncionario.addActionListener(this);
		mnFuncionario.add(miCadastrarFuncionario);
		mnFuncionario.add(new JSeparator());
		mnFuncionario.add(miConsultaFuncionario);

		mnDependente = new JMenu("Dependente");
		miCadastrarDependente = new JMenuItem("Cadastrar");
		miCadastrarDependente.addActionListener(this);
		miConsultaDependente = new JMenuItem("Consultar");
		miConsultaDependente.addActionListener(this);
		mnDependente.add(miCadastrarDependente);
		mnDependente.add(new JSeparator());
		mnDependente.add(miConsultaDependente);

		mb.add(mnSistema);
		mb.add(mnFuncionario);
		mb.add(mnDependente);

		setJMenuBar(mb);

		painelCentral = new JPanel();
		painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/img_background.jpg"));
		lblImageBackground = new JLabel();
		lblImageBackground.setIcon(icon); // coloca a imagem na label
		painelCentral.add(lblImageBackground);
		getContentPane().add(painelCentral, BorderLayout.CENTER);

		painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		painelSuperior.setPreferredSize(new Dimension(0, 150));
		getContentPane().add(painelSuperior, BorderLayout.NORTH);

		lblCadastraFuncionario = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_adicionar_funcionario.png")));
		lblCadastraFuncionario.setText("Cadastrar Funcionario");
		lblCadastraFuncionario.addMouseListener(this);
		lblConsultaFuncionario = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_procurar_funcionario.png")));
		lblConsultaFuncionario.setText("Consulta Funcionario");
		lblConsultaFuncionario.addMouseListener(this);
		lblCadastraDependente = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_adicionar_dependente.png")));
		lblCadastraDependente.setText("Cadastrar Dependente");
		lblCadastraDependente.addMouseListener(this);
		lblConsultaDependente = new JLabel(
				new ImageIcon(getClass().getResource("/imagens/ic_procurar_dependente.png")));
		lblConsultaDependente.setText("Consulta Dependente");
		lblConsultaDependente.addMouseListener(this);

		painelSuperior.add(lblCadastraFuncionario);
		painelSuperior.add(lblConsultaFuncionario);
		painelSuperior.add(lblCadastraDependente);
		painelSuperior.add(lblConsultaDependente);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miCadastrarFuncionario) {
			new CadastroFuncionarioView().setVisible(true);
		}else if (e.getSource() == miCadastrarDependente){
			new CadastroDependenteView().setVisible(true);
		} else if (e.getSource() == miConsultaFuncionario) {
			new ListaFuncionarioView().setVisible(true);
		} else if (e.getSource() == miConsultaDependente) {
			new ListaDependenteView().setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCadastraFuncionario) {
			new CadastroFuncionarioView().setVisible(true);
		} else if (e.getSource() == lblConsultaFuncionario) {
			new ListaFuncionarioView().setVisible(true);
		} else if (e.getSource() == lblCadastraDependente) {
			new CadastroDependenteView().setVisible(true);
		} else if (e.getSource() == lblConsultaDependente) {
			new ListaDependenteView().setVisible(true);
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
