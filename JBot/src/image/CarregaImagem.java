package image;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.PrintJob;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.peer.ButtonPeer;
import java.awt.peer.CanvasPeer;
import java.awt.peer.CheckboxMenuItemPeer;
import java.awt.peer.CheckboxPeer;
import java.awt.peer.ChoicePeer;
import java.awt.peer.DesktopPeer;
import java.awt.peer.DialogPeer;
import java.awt.peer.FileDialogPeer;
import java.awt.peer.FontPeer;
import java.awt.peer.FramePeer;
import java.awt.peer.LabelPeer;
import java.awt.peer.ListPeer;
import java.awt.peer.MenuBarPeer;
import java.awt.peer.MenuItemPeer;
import java.awt.peer.MenuPeer;
import java.awt.peer.PanelPeer;
import java.awt.peer.PopupMenuPeer;
import java.awt.peer.ScrollPanePeer;
import java.awt.peer.ScrollbarPeer;
import java.awt.peer.TextAreaPeer;
import java.awt.peer.TextFieldPeer;
import java.awt.peer.WindowPeer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

public class CarregaImagem {
	public void carrega() {
		BufferedImage bufferedImage = null;
		try {
			URL url = this.getClass().getClassLoader().getResource("image/Carvao.png");

			bufferedImage = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		
		scaneiaImagem(bufferedImage);

	}

	private void scaneiaImagem(BufferedImage bufferedImageCarvao) {
		BufferedImage bufferedImage = null;
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		int widthTela = (int) toolkit.getScreenSize().getWidth();
		int heightTela = (int) toolkit.getScreenSize().getHeight();
		
		try {
			URL url = this.getClass().getClassLoader().getResource("image/Print.png");

			bufferedImage = ImageIO.read(url);
//			bufferedImage = new Robot().createScreenCapture(new Rectangle(0, 0, widthTela ,heightTela));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[][] teste = new int[bufferedImageCarvao.getWidth()][bufferedImageCarvao.getHeight()];
		for (int x = 0; x < bufferedImageCarvao.getWidth(); x++) {
			
			for (int y = 0; y < bufferedImageCarvao.getHeight(); y++) {
				teste[x][y] = bufferedImageCarvao.getRGB(x, y);
			}
			
		}
		String qualquer = null;
		for (int x = 0; x < bufferedImageCarvao.getWidth(); x++) {
			
			for (int y = 0; y < bufferedImageCarvao.getHeight(); y++) {
				qualquer = qualquer + " " + teste[x][y];
			}
			qualquer = qualquer + "\n";
		}
		
		System.out.println(qualquer);
	}
}
