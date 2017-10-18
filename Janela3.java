import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Janela3 extends JFrame {

	private JPanel contentPane;
	private JTextField rg;
	private JButton btnVoltar;
	private JButton btnRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela3 frame = new Janela3();
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
	public Janela3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRgDoJogador = new JLabel("RG do jogador para remover:");
		lblRgDoJogador.setBounds(10, 11, 184, 14);
		contentPane.add(lblRgDoJogador);
		
		rg = new JTextField();
		rg.setBounds(10, 26, 73, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		SistemaList sistema= new SistemaList();
		
	    btnRemover = new JButton("Remover");
		btnRemover.setBounds(61, 187, 133, 23);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
		
					try {
						sistema.removeJogador(rg.getText().toString());
						JOptionPane.showMessageDialog(null, "Jogador removido!");
					} catch (JogadorNaoExisteException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				dispose();
				
			}
			
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(243, 187, 128, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Janela1 janela1= new Janela1();
				janela1.setVisible(true);
				
				
			}
			
		});
				
	}

}
