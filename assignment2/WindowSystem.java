//package assignment2;

import java.awt.Color;
import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/**
 * @author dian
 * 
 * Extend your WindowSystem class to handle drawing in a resolution 
 * independent way, using an “abstract coordinate system” with values 
 * between 0.0 and 1.0. To draw a line in the abstract coordinate system.
 * 
 * You will need to override the handlePaint() in your WindowSystem class, 
 * and do all of your drawing in there. The handlePaint() method is inherited 
 * from GraphicsEventSystem, and currently does nothing.
 * 
 * You will need to augment your WindowSystem class so that it has the ability 
 * to keep track of a collection of SimpleWindow objects.
 */

public class WindowSystem extends GraphicsEventSystem {

	private int mWidth;
	private int mHeight;
	private ArrayList<SimpleWindow> simpleWindows;
	
	public WindowSystem(int width, int height) {
		super(width, height);
		mHeight = height;
		mWidth = width;
		simpleWindows = new ArrayList<SimpleWindow>();
	}

	protected void handlePaint() {
		this.setColor(Color.BLACK);
		// Your test program should display a single line from (0.2, 0.3) to 
		// (0.8, 0.7) on your “desktop”
		this.drawLine(0.2f, 0.3f, 0.8f, 0.7f);
	}

	/*	
	 * Function to draw a line in the abstract coordinate system,
	 * accepting float values ranging from 0.0 to 1.0
	 */	
	void drawLine(float StartX, float StartY,float EndX, float EndY) {
		double originX = mWidth * StartX;
		double originY = mHeight * StartY;
		double destinationX = mWidth * EndX;
		double destinationY = mHeight * EndY;
		super.drawLine(originX, originY, destinationX, destinationY);
	}
	
}
