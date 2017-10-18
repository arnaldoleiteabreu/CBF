import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField numero;
	private JTextField data;
	private JTextField rg;
	private JTextField nacionalidade;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela2 frame = new Janela2();
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
	public Janela2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 51, 86, 14);
		contentPane.add(lblNmero);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 95, 166, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 136, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setBounds(10, 182, 111, 14);
		contentPane.add(lblNacionalidade);
		
		nome= new JTextField();
		nome.setBounds(10, 25, 221, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(10, 64, 46, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		
		data = new JTextField();
		data.setBounds(10, 107, 86, 20);
		contentPane.add(data);
		data.setColumns(10);
		
		rg = new JTextField();
		rg.setBounds(10, 151, 86, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		
		nacionalidade = new JTextField();
		nacionalidade.setBounds(10, 195, 132, 20);
		contentPane.add(nacionalidade);
		nacionalidade.setColumns(10);
		
		EstatisticaDoJogador estatistica= new EstatisticaDoJogador(0,0,0,0,0,0);
		SistemaList sistema= new SistemaList();
		Jogador jog= new Jogador(nome.getText().toString(),numero.getText(),data.getText(), rg.getText(), nacionalidade.getText(), estatistica);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {	
				try {
					sistema.cadastraJogador(jog);
					JOptionPane.showMessageDialog(null, "Cadastrado");
				} catch (JogadorJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				dispose();
			}
		});
		
		btnCadastrar.setBounds(102, 226, 117, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(229, 226, 111, 23);
		btnVoltar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Janela1 janela1= new Janela1();
				janela1.setVisible(true);
				

				
			}
			
		});
		contentPane.add(btnVoltar);
	}
}
