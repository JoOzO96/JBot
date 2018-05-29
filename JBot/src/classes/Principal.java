package classes;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.SliderUI;

import funcoes.Uteis;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import javax.swing.DefaultComboBoxModel;

public class Principal {
	private static Robot robot;
	static boolean continua;
	private JFrame frame;
	private static Thread thread;
	private static ClicanaTela tela;
	private static JComboBox cb_tipotreino;
	private static JComboBox cb_tipominerio;
	private static JComboBox comboBox;
	private String tipominerio;
	private Long totalMinerio;
	private String tipotreino;
	private Long preset;
	public static JTextField tx_total;
	public static JTextField tx_minerios;
	public static JTextField tx_tempo;

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
					// CarregaImagem carregaImagem = new CarregaImagem();
					// carregaImagem.carrega();
					Principal window = new Principal();

					window.frame.setVisible(true);
					Uteis uteis = new Uteis();
					continua = false;
					robot = new Robot();
					tela = new ClicanaTela();
					cb_tipominerio.setEnabled(false);
//					cb_tipotreino.addItem("Metalurgia");
//					cb_tipominerio.addItem("Bronze");
//					cb_tipominerio.addItem("Ferro");
//					cb_tipominerio.addItem("Aço");
//					cb_tipominerio.addItem("Ouro");
//					cb_tipominerio.addItem("Mithril");
					comboBox.addItem("1");
					comboBox.addItem("2");
					tx_total.setText(String.valueOf(0));

					// uteis.SetDefault();

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
		frame.setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				thread = new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						clicanatela(robot, tipotreino, tipominerio, totalMinerio);
						// Login(robot);
					}
				};
				thread.start();
			}
		});
		btnNewButton.setBounds(44, 216, 89, 23);
		frame.getContentPane().add(btnNewButton);

		tx_total = new JTextField();
		tx_total.setBounds(44, 185, 63, 20);
		frame.getContentPane().add(tx_total);
		tx_total.setColumns(10);

		JButton btnNewButton_1 = new JButton("Parar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.stop();
			}
		});
		btnNewButton_1.setBounds(152, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		cb_tipotreino = new JComboBox();
		cb_tipotreino.setModel(new DefaultComboBoxModel(new String[] {"Metalurgia"}));
		cb_tipotreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipotreino = cb_tipotreino.getSelectedItem().toString();
				if (tipotreino.equals("Metalurgia")) {
					cb_tipominerio.setEnabled(true);
				}
			}
		});
		cb_tipotreino.setBounds(44, 50, 197, 20);
		frame.getContentPane().add(cb_tipotreino);

		cb_tipominerio = new JComboBox();
		cb_tipominerio
				.setModel(new DefaultComboBoxModel(new String[] {"Bronze", "Ferro", "A\u00E7o", "Ouro", "Mithril"}));
		cb_tipominerio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipominerio = cb_tipominerio.getSelectedItem().toString();
			}

		});
		cb_tipominerio.setBounds(44, 118, 197, 20);
		frame.getContentPane().add(cb_tipominerio);

		tx_minerios = new JTextField();
		tx_minerios.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				totalMinerio = Long.parseLong(tx_minerios.getText().toString());
			}
		});
		tx_minerios.setText("0");
		tx_minerios.setColumns(10);
		tx_minerios.setBounds(44, 149, 63, 20);
		frame.getContentPane().add(tx_minerios);

		tx_tempo = new JTextField();
		tx_tempo.setText("0");
		tx_tempo.setColumns(10);
		tx_tempo.setBounds(120, 185, 63, 20);
		frame.getContentPane().add(tx_tempo);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preset = Long.parseLong(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(117, 149, 66, 20);
		frame.getContentPane().add(comboBox);

	}

	public void clicanatela(Robot robot, String tipotreino, String tipominerio, Long totalMinerio) {
		boolean segue = true;
		Long total = 0L;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Date dataInicio = new Date();
		int widthTela = (int) toolkit.getScreenSize().getWidth();
		int heightTela = (int) toolkit.getScreenSize().getHeight();

		while (segue) {

			int y = 0;
			int x = 0;
			// SetDefault(robot, tipominerio);
			Random random = new Random();
			if (widthTela == 1366 && heightTela == 768) {
				x = ThreadLocalRandom.current().nextInt(112, 140);
				y = ThreadLocalRandom.current().nextInt(235, 287);
			} else if (widthTela == 1920 && heightTela == 1080) {
				x = ThreadLocalRandom.current().nextInt(378, 419);
				y = ThreadLocalRandom.current().nextInt(400, 445);
			}
			Uteis uteis = new Uteis();
			uteis.click(robot, x, y);
			// robot.delay(1000);
			robot.delay(6200);

			if (preset == 1) {
				robot.keyPress(KeyEvent.VK_1);
				robot.delay(100);
				robot.keyRelease(KeyEvent.VK_1);
				robot.delay(500);
			} else {
				robot.keyPress(KeyEvent.VK_2);
				robot.delay(100);
				robot.keyRelease(KeyEvent.VK_2);
				robot.delay(500);
			}
			if (widthTela == 1366 && heightTela == 768) {
				x = ThreadLocalRandom.current().nextInt(1272, 1320);
				y = ThreadLocalRandom.current().nextInt(379, 445);
			} else if (widthTela == 1920 && heightTela == 1080) {
				x = ThreadLocalRandom.current().nextInt(1558, 1745);
				y = ThreadLocalRandom.current().nextInt(528, 607);
			}
			uteis.click(robot, x, y);
			robot.delay(6000);
			robot.keyPress(KeyEvent.VK_SPACE);

			if (tipominerio.equals("Bronze")) {
				robot.delay(33800);
				total = total + 14;
			} else if (tipominerio.equals("Mithril")) {
				robot.delay(13800);
				total = total + 5;
			} else if (tipominerio.equals("Aço")) {
				robot.delay(22200);
				total = total + 9;
			} else if (tipominerio.equals("Ouro")) {
				try {
					Thread.sleep(68800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				total = total + 28;
			}

			if (total >= totalMinerio) {
				segue = false;
			}
			long tempo = ThreadLocalRandom.current().nextInt(25000, 36000);
			if ((System.currentTimeMillis() - dataInicio.getTime()) <= tempo) {
				long tempoPausa = ThreadLocalRandom.current().nextInt(9000, 12000);

				try {
					Thread.sleep(tempoPausa);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Login(robot);

			}
		}
	}

	private void Login(Robot robot2) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int widthTela = (int) toolkit.getScreenSize().getWidth();
		int heightTela = (int) toolkit.getScreenSize().getHeight();
		String senha = "jose2alcides";
		char[] charSenha = senha.toCharArray();
		if (widthTela == 1366 && heightTela == 768) {
			robot.mouseMove(617, 387);
		} else if (widthTela == 1920 && heightTela == 1080) {
			robot.mouseMove(895, 496);
		}
		robot.delay(15);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		for (int i = 0; i < senha.length(); i++) {
			robot.delay(30);
			robot2.keyPress(KeyEvent.getExtendedKeyCodeForChar(charSenha[i]));
			robot.delay(30);
			robot2.keyRelease(KeyEvent.getExtendedKeyCodeForChar(charSenha[i]));
			robot.delay(30);
		}
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.delay(30);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(4000);
		
		if (widthTela == 1366 && heightTela == 768) {
			robot.mouseMove(ThreadLocalRandom.current().nextInt(609, 757), ThreadLocalRandom.current().nextInt(543, 563));
		} else if (widthTela == 1920 && heightTela == 1080) {
			robot.mouseMove(ThreadLocalRandom.current().nextInt(877, 1038), ThreadLocalRandom.current().nextInt(545, 566));
		}
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		robot.delay(10000);
		if (widthTela == 1366 && heightTela == 768) {
			robot.mouseMove(ThreadLocalRandom.current().nextInt(1173, 1187), ThreadLocalRandom.current().nextInt(67, 85));
		} else if (widthTela == 1920 && heightTela == 1080) {
			robot.mouseMove(ThreadLocalRandom.current().nextInt(1727, 1743), ThreadLocalRandom.current().nextInt(69, 87));
		}
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);

	}
}
