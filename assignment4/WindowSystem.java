import java.awt.Color;
import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;

// author dian


// BASIC WINDOW SYSTEM

// This class implements the basic of drawing the windows
// and managing their status and memory

public class WindowSystem extends GraphicsEventSystem {

    // corresponding window manager
    public WindowManager wm = null;

    // dimension of our desktop
	private int mWidth;
	private int mHeight;
    // array to store the windows active and miminized
	private ArrayList<SimpleWindow> simpleWindows;
    // MINIMIZE NOT FULLY IMPLEMENTED YET
	// private ArrayList<SimpleWindow> minimizedWindows;

    // constructor - just initialize our desktop
	public WindowSystem(int width, int height) {
		super(width, height);
		mHeight = height;
		mWidth = width;
		simpleWindows = new ArrayList<SimpleWindow>();

        // MINIMIZE NOT FULLY IMPLEMENTED YET
        // minimizedWindows = new ArrayList<SimpleWindow>();
	}


    // this is the function called by the repaint method
	protected void handlePaint() {
        
        // Draw all the windows in memory
        int num_window = simpleWindows.size();
        for(int i=0; i<num_window; i++) {
            SimpleWindow sw = simpleWindows.get(i);
            System.out.println("printing windows");
            // draw the window
            this.drawWindow(sw);
            if (wm!=null) {
                wm.drawWindowDecoration(sw); 
            }
            
            // need to check if the window has children/widgets and paint them
            if (sw.hasWidgets()) {
                for (RATWidget child: sw.getWidgets()) {
                    this.drawWidgetInWindow(child,sw);
                }
            }

            
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
        // System.out.println("done printing window");
    }
    

    // draw a widget in a window
    // should be careful about the relative positioning
    protected void drawWidgetInWindow(RATWidget w, SimpleWindow sw) {
        
        // need to check what widget it is
        // case of RATButton
        if (w instanceof RATButton) {
            // cast to access all his methods
            RATButton b = (RATButton)w;
            
            // shall this go into the WM ?
            // print the background honoring the colors ()
            this.setColor(b.bgColor);
            fillRect(
                sw.getX()+b.getX(),
                sw.getY()+b.getY(),
                sw.getX()+b.getX()+b.getWidth(),
                sw.getY()+b.getY()+b.getHeight());    

            // draw the label
            this.setColor(b.fgColor);
            this.drawString(b.label,
                        sw.getX()+b.getX()+b.padding,
                        sw.getY()+b.getY()+b.getHeight()-b.padding);
            // decorate it
            if (wm!=null) wm.drawWidgetDecorationInWindow(w,sw);

        }
        // case of RATLabel 
        else if (w instanceof RATLabel) {
            // cast to access all his methods
            RATLabel l = (RATLabel)w;
            
            // shall this go into the WM ?
            // print the background honoring the colors ()
            this.setColor(l.bgColor);
            fillRect(
                sw.getX()+l.getX(),
                sw.getY()+l.getY(),
                sw.getX()+l.getX()+l.getWidth(),
                sw.getY()+l.getY()+l.getHeight());    

            // draw the label
            this.setColor(l.fgColor);
            this.drawString(l.label,
                        sw.getX()+l.getX()+l.padding,
                        sw.getY()+l.getY()+l.getHeight()-l.padding);


        }
    }
    



    // The window system keeps the reference of the WM used by the app
    // It then passes the mouse events to the corresponding WM
    // and it tells WM when to draw decoration
    public void setWindowManager(WindowManager windowManager) {
        wm = windowManager;
    }





// Create a new window at default position and size 
    public SimpleWindow createNewWindow() {
        SimpleWindow sw = new SimpleWindow(0,0,400,300);
        simpleWindows.add(sw);
        return sw;
    }
    // // Create a new window at default position and size 
    // public SimpleWindow createNewWindow() {
    //     SimpleWindow sw = new SimpleWindow();
    //     simpleWindows.add(sw);
    //     return sw;
    // }
    // // Create a new window at default position and size 
    // public SimpleWindow createNewWindow(int width, int height) {
    //     SimpleWindow sw = new SimpleWindow(0,0,width,height);
    //     sw.setWidth(width);
    //     sw.setHeight(height);
    //     simpleWindows.add(sw);
    //     return sw;
    // }





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

    // // Minimize the window
    // public void minimizeWindow(SimpleWindow sw) {
    //     simpleWindows.remove(sw);
    //     minimizedWindows.add(sw);
    //     this.requestRepaint();
    // }

    public void restoreWindow(SimpleWindow sw) {
        simpleWindows.remove(sw);
    }

    // check if the given windows contain the point at coordinates (x,y)
    private boolean isPointInside(SimpleWindow sw, int x, int y) {
        return (sw.getX()<x) && (sw.getX()+sw.getWidth()>x)
            && (sw.getY()<y) && (sw.getY()+sw.getHeight()>y);
    }       


    // Mouse handling Functions
    // pass the event to non-null WM.

    @Override
    public void handleMouseClicked(int x, int y) {
        if (wm!=null) { wm.handleMouseClicked(x,y); }
    }
    @Override
    public void handleMouseDragged(int x, int y) {
        if (wm!=null) { wm.handleMouseDragged(x,y); }
    }
    @Override
    public void handleMousePressed(int x, int y) {
        if (wm!=null) { wm.handleMousePressed(x,y); }
    }
    @Override
    public void handleMouseReleased(int x, int y) {
        if (wm!=null) { wm.handleMouseReleased(x,y); }
    }
    @Override
    public void handleMouseMoved(int x, int y) {
        if (wm!=null) { wm.handleMouseMoved(x,y); }
    }
    
    
}
