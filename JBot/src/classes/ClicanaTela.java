package classes;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import funcoes.Uteis;

public class ClicanaTela {
	public void clicanatela(Robot robot, String tipotreino, String tipominerio) {
		while (true == true) {
			
//			SetDefault(robot, tipominerio);
			
			Uteis uteis = new Uteis();
			uteis.click(robot, 1632, 651);
			robot.delay(6000);
			uteis.click(robot, 869, 774);
			robot.delay(200);
			uteis.click(robot, 247, 481);
			robot.delay(6000);
			uteis.click(robot, 1073, 668);
//			robot.delay(60000);
////			robot.mouseMove(0, 0);
//			robot.delay(8000);
			robot.delay(13000);
		}
	}

	private void SetDefault(Robot robot, String tipominerio) {
		
		int yVARRE = 0;
		int xVARRE = 0;
		int yTELA = 0;
		int xTELA = 0;
		
		
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		BufferedImage print =  robot.createScreenCapture(new Rectangle(x, y));
//		File outputfile = new File("C:\\Cgeral\\image.jpg");
//		try {
//			ImageIO.write(print, "jpg", outputfile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		yTELA = print.getHeight();
//		xTELA = print.getWidth();
//		
//		for ()

	}
}
