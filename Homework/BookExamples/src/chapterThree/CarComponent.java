/**
 * Apr 6, 2009
 *
 */
package chapterThree;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class CarComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Car car1 = new Car(0, 0);
		
		int x = getWidth() - 60;
		int y = getHeight() - 30;
		
		Car car2 = new Car(x,y);
		
		car1.draw(g2);
		car2.draw(g2);
	}
}
