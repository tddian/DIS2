import java.awt.Color;
import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/**
 * @author dian
 * 
Start by expanding your WindowSystem class so that applications can make use of    
your windows, and so that your windows will be shown on the screen. To 
accomplish this, you will need to add the following features:

• Allow applications to create SimpleWindows that are associated with a
WindowSystem. 
• Display SimpleWindows on your “desktop” when they are created. 

The drawing here should be kept very basic – windows should be drawn as simple,
solid boxes in some color (e.g., grey) against the desktop, which should be 
drawn in some other color (e.g., black). Any fancy window dressing (should you 
choose to implement any) should be saved for the window manager (see next part).
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
	
        /* 
         * Draw all the SimpleWindows	    
         */
        int num_window = simpleWindows.size();
        for(int i=0; i<num_window; i++) {
            SimpleWindow sw = simpleWindows.get(i);
            this.setColor(Color.LIGHT_GRAY);
            fillRect(sw.getX(),sw.getY(),sw.getX()+sw.getWidth(),sw.getY()+sw.getHeight());            
            this.setColor(Color.BLACK);
            drawRect(sw.getX(),sw.getY(),sw.getX()+sw.getWidth(),sw.getY()+sw.getHeight());            
         }
	}

    /* Create a new window */
    public SimpleWindow createNewWindow() {
        SimpleWindow sw = new SimpleWindow(20,20,100,200);
        simpleWindows.add(sw);
        return sw;
    }

    /* Move a window */
    public void moveWindow(SimpleWindow sw, int inX, int inY) {
        sw.setX(inX);
        sw.setY(inY);
        this.requestRepaint();
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
