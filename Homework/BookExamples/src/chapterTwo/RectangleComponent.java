/**
 * Apr 6, 2009
 *
 */
package chapterTwo;

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
public class RectangleComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		//Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		//Construct a rectangle and draw it
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		
		//Move rectangle 15 units to the right and 25 unites down
		box.translate(15, 25);
		
		//Draw moved rectangle
		g2.draw(box);
	}
}
