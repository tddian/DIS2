import java.awt.Color;
import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;

// author dian


// BASIC WINDOW SYSTEM

// This class implements the basic of drawing the windows
// and managing their status and memory

public class WindowSystem extends GraphicsEventSystem {

    // dimension of our desktop
	private int mWidth;
	private int mHeight;
    // array to store the windows active and miminized
	private ArrayList<SimpleWindow> simpleWindows;
    // MINIMIZE NOT FULLY IMPLEMENTED YET
	private ArrayList<SimpleWindow> minimizedWindows

    // constructor - just initialize our desktop
	public WindowSystem(int width, int height) {
		super(width, height);
		mHeight = height;
		mWidth = width;
		simpleWindows = new ArrayList<SimpleWindow>();

        // MINIMIZE NOT FULLY IMPLEMENTED YET
        minimizedWindows = new ArrayList<SimpleWindow>();
	}


    // this is the function called by the repaint method
	protected void handlePaint() {
        
        // Draw all the windows	    
        int num_window = simpleWindows.size();
        for(int i=0; i<num_window; i++) {
            SimpleWindow sw = simpleWindows.get(i);
            this.drawWindow(sw);
         }
	}


    /* Draw a SimpleWindow as a simple rectangular */
    protected void drawWindow(SimpleWindow sw) {
        this.setColor(Color.LIGHT_GRAY);
        fillRect(
            sw.getX(),
            sw.getY(),
            sw.getX()+sw.getWidth(),
            sw.getY()+sw.getHeight());
    }

    // Create a new window at default position and size 
    public SimpleWindow createNewWindow() {
        SimpleWindow sw = new SimpleWindow(0,0,200,200);
        simpleWindows.add(sw);
        return sw;
    }

    // Move a window 
    public void moveWindow(SimpleWindow sw, int inX, int inY) {
        sw.setX(inX);
        sw.setY(inY);
        this.requestRepaint();
    }


     // Bring a window to top 
    public void bringWindowToTop(SimpleWindow sw) {
        // bringing a window to top simply require putting it as first of the array
        simpleWindows.remove(sw);
        simpleWindows.add(sw);
        // then redraw all windows
        this.requestRepaint();
    }
    


    // Return the top SimpleWindow at given position (x,y). Return null otherwise 
    public SimpleWindow getWindowAtPosition(int x, int y) {
        int num_window = simpleWindows.size();
        // iterate through windows until we find one that contain the point.
        // this work because the order of the windows in our array is kept
        // synchronize with the top-down order of the windows in the screen
        for(int i=num_window-1; i>=0; i--) {
            SimpleWindow sw = simpleWindows.get(i);
            if (isPointInside(sw,x,y)) {
                return sw;
            }
        }
        return null;
    }



    // Close the windows. We just remove it from the array
    public void closeWindow(SimpleWindow sw) {
        simpleWindows.remove(sw);
    }

    // Close the windows. We just remove it from the array
    public void minimizeWindow(SimpleWindow sw) {
        simpleWindows.remove(sw);
        minimizedWindows.add(sw);
        this.requestRepaint();
    }

    public void restoreWindow(SimpleWindow sw) {
        simpleWindows.remove(sw);
    }

    // check if the given windows contain the point at coordinates (x,y)
    private boolean isPointInside(SimpleWindow sw, int x, int y) {
        return (sw.getX()<x) && (sw.getX()+sw.getWidth()>x)
            && (sw.getY()<y) && (sw.getY()+sw.getHeight()>y);
    }       

}
