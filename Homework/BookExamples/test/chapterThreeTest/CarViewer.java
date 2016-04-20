/**
 * Apr 6, 2009
 *
 */
package chapterThreeTest;

import javax.swing.*;

import chapterThree.CarComponent;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class CarViewer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(300, 400);
		frame.setTitle("Two cars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CarComponent component = new CarComponent();
		frame.add(component);
		
		frame.setVisible(true);
	}

}
