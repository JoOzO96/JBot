package funcoes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.renderable.RenderableImageOp;

public class Uteis {

	public void click(Robot robot, int x, int y){
		robot.mouseMove(x, y);
		robot.delay(100);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(5);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	}
}
