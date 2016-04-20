/**
 * Apr 6, 2009
 *
 */
package chapterTwo;

import javax.swing.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class RectangleViewer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("Two rectangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RectangleComponent component = new RectangleComponent();
		frame.add(component);
		
		frame.setVisible(true);
	}

}
