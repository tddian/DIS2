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
            wm.drawWindowDecoration(sw);
            
            // need to check if the window has children/widgets and paint them
            if (sw.hasWidgets()) {
                for (RATWidget child: sw.getWidgets()) {
                                System.out.println("printing widget");

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
                sw.getX()+b.x,
                sw.getY()+b.y,
                sw.getX()+b.x+b.width,
                sw.getY()+b.y+b.height);    

            // draw the label
            this.setColor(l.fgColor);
            this.drawString(l.label,
                        sw.getX()+b.x+b.padding,
                        sw.getY()+b.y+b.height-b.padding);
            // decorate it
            if (wm!=null) wm.decorateWidget(w);

        }
        // case of RATLabel 
        else if (w instanceof RATLabel) {
            // cast to access all his methods
            RATLabel l = (RATLabel)w;
            
            // shall this go into the WM ?
            // print the background honoring the colors ()
            this.setColor(l.bgColor);
            fillRect(
                sw.getX()+l.x,
                sw.getY()+l.y,
                sw.getX()+l.x+l.width,
                sw.getY()+l.y+l.height);    

            // draw the label
            this.setColor(l.fgColor);
            this.drawString(l.label,
                        sw.getX()+l.x+l.padding,
                        sw.getY()+l.y+l.height-l.padding);


        }
        
        



        // System.out.println("done filling widget "+ (sw.getX()+w.x) + ( sw.getY()+w.y )+ (sw.getX()+w.x+w.width)+ (sw.getY()+w.y+w.height));
    }
    



    // The window system, keep reference of the WM used by the app
    // so when it draw, it tell the wm to decorate the windows when it's done
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

}
