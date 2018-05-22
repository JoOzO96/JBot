import java.awt.EventQueue;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.ClicanaTela;
import funcoes.Uteis;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Principal {
	private static Robot robot;
	static boolean continua;
	private JFrame frame;
	private static Thread thread;
	private static ClicanaTela tela;
	private static JComboBox cb_tipotreino;
	private static JComboBox cb_tipominerio;
	private String tipominerio;
	private String tipotreino;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
					continua = false;
					robot = new Robot();
					tela = new ClicanaTela();
					cb_tipominerio.setEnabled(false);
					cb_tipotreino.addItem("Metalurgia");
					cb_tipominerio.addItem("Bronze");
					cb_tipominerio.addItem("Ferro");
					cb_tipominerio.addItem("Aço");
					cb_tipominerio.addItem("Ouro");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 283, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				thread = new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						tela.clicanatela(robot, tipotreino, tipominerio);
					}
				};
				thread.start();
			}
		});
		btnNewButton.setBounds(44, 216, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Parar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.stop();
			}
		});
		btnNewButton_1.setBounds(152, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		cb_tipotreino = new JComboBox();
		cb_tipotreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipotreino = cb_tipotreino.getSelectedItem().toString();
				if (tipotreino.equals("Metalurgia")){
					cb_tipominerio.setEnabled(true);
				}
			}
		});
		cb_tipotreino.setBounds(44, 50, 197, 20);
		frame.getContentPane().add(cb_tipotreino);
		
		cb_tipominerio = new JComboBox();
		cb_tipominerio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipominerio = cb_tipominerio.getSelectedItem().toString();
			}
		});
		cb_tipominerio.setBounds(44, 118, 197, 20);
		frame.getContentPane().add(cb_tipominerio);
	}
	
	
	
}
