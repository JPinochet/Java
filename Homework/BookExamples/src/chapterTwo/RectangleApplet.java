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
public class RectangleApplet extends JApplet
{
	public void pant(Graphics g)
	{
		//Prepare for extended graphics
		Graphics2D g2 = (Graphics2D) g;
		
		//Construct a rectangle and draw it
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		
		//Move rectangle 15 units to the right and 25 units down
		box.translate(15, 25);
		
		//Draw move rectangle
		g2.draw(box);
	}
}
