/**
 * Apr 6, 2009
 *
 */
package chapterTwo;

import java.awt.Component;

import javax.swing.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class FaceViewer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("An Alien Face");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FaceComponent component = new FaceComponent();
		frame.add(component);
		
		frame.setVisible(true);
	}

}
