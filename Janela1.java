import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Janela1 extends JFrame  {

	private JPanel contentPane;
	private JButton bntCadastrar;
	private JButton bntRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela1 frame = new Janela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmAdicionargolsOu = new JMenuItem("Adicionar (Gols ou Cart\u00F5es)");
		mnOpes.add(mntmAdicionargolsOu);
		
		JMenuItem mntmAdicionarTime = new JMenuItem("Adicionar Time");
		mnOpes.add(mntmAdicionarTime);
		
		JMenuItem mntmAdicionarJogadorAo = new JMenuItem("Adicionar Jogador ao Time");
		mnOpes.add(mntmAdicionarJogadorAo);
		
		JMenu mnPesquisarJogador = new JMenu("Pesquisar Jogador");
		menuBar.add(mnPesquisarJogador);
		
		JMenuItem mntmPeloNome = new JMenuItem("Pelo Nome");
		mnPesquisarJogador.add(mntmPeloNome);
		
		JMenuItem mntmPeloNumero = new JMenuItem("Pelo Numero");
		mnPesquisarJogador.add(mntmPeloNumero);
		
		JMenuItem mntmPeloRg = new JMenuItem("Pelo RG");
		mnPesquisarJogador.add(mntmPeloRg);
		
		JMenuItem mntmPeloTime = new JMenuItem("Pelo Time");
		mnPesquisarJogador.add(mntmPeloTime);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SistemaList sistema= new SistemaList();
		JButton btnCadastrar = new JButton("Cadastrar Jogador");
		btnCadastrar.setBounds(130, 74, 163, 39);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Janela2 janela2= new Janela2();
				janela2.setLocationRelativeTo(null);
				janela2.setVisible(true);
				janela2.setResizable(false);
				
				
				
			}
			
		});
		contentPane.add(btnCadastrar);
		
		
		JButton btnRemoverJogador = new JButton("Remover Jogador");
		btnRemoverJogador.setBounds(130, 130, 163, 39);
		contentPane.add(btnRemoverJogador);
		btnRemoverJogador.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Janela3 janela3= new Janela3();
				janela3.setLocationRelativeTo(null);
				janela3.setVisible(true);
				janela3.setResizable(false);
				
				
			}
			
		});
	}

}
