/**
 * Apr 6, 2009
 *
 */
package chapterTwo;

import javax.swing.JFrame;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class EmptyFrameViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(300, 400);
		frame.setTitle("An Empty Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
}
