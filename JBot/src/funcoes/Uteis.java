package funcoes;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Uteis {

	public void click(Robot robot, int x, int y){
		robot.mouseMove(x, y);
		robot.delay(15);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	}
	
	public void SetDefault() {
		URL url1 = null;
		BufferedImage bufferedImageTeste = null;
		BufferedImage bufferedImageCarvao = null;
		int yVARRE = 0;
		int xVARRE = 0;
		int yTELA = 0;
		int xTELA = 0;
		
		
		yTELA = Toolkit.getDefaultToolkit().getScreenSize().height;
        xTELA = Toolkit.getDefaultToolkit().getScreenSize().width;
//		BufferedImage print =  robot.createScreenCapture(new Rectangle(x, y));
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
        
        try {
			url1 = new URL(this.getClass().getClassLoader().getResource("image") + "/Carvao.png");
			bufferedImageCarvao = ImageIO.read(url1);
			url1 = new URL(this.getClass().getClassLoader().getResource("image") + "/Teste.png");
			bufferedImageTeste = ImageIO.read(url1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for (xVARRE = 0; xVARRE < bufferedImageCarvao.getWidth() ; xVARRE++) {
			for (yVARRE = 0; yVARRE < bufferedImageCarvao.getHeight() ; yVARRE++) {
				System.out.println(xVARRE + "*" + yVARRE + " " + bufferedImageCarvao.getRGB(xVARRE, yVARRE));
			}
		}
        
        
	}
}
