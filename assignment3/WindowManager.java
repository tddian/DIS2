import java.awt.Color;

/**
 * @Task 2. Window Manager
 * 
In this next part, you will implement a basic window manager that adds mouse 
input. In particular, you should implement a WindowManager class which adds a 
titlebar and a close button to all windows. The basic features your window 
manager should have are:

• Show a titlebar and close button for each window.
• Allow the user to move a window by dragging it around.
• Allow the user to close a window by clicking on the close button.

 */


public class WindowManager extends WindowSystem {
    
    private int titlebarHeight = 20;
    private int closeButtonWidth = 16;
    private int closeButtonPadding = 2;
    private WindowSystem ws;
	public WindowManager(int width, int height) {
        super(width,height);
    }
    
    /* Override the function drawWindow(), which is called by handlePaint() */
    @Override
    protected void drawWindow(SimpleWindow sw) {
        super.drawWindow(sw);   // Draw the basic window as WindowSystem does.
        
        // Then draw the titlebar
        this.setColor(Color.BLACK);
        fillRect(
            sw.getX(),
            sw.getY(),
            sw.getX()+sw.getWidth(),
            sw.getY()+titlebarHeight);
        
        // Next is the close button
        this.setColor(Color.RED);
        fillRect(
            sw.getX()+closeButtonPadding,
            sw.getY()+closeButtonPadding,
            sw.getX()+closeButtonPadding+closeButtonWidth,
            sw.getY()+closeButtonPadding+closeButtonWidth);

    }

    public void handleMouseClicked(int x, int y) {
        SimpleWindow sw = getWindowAtPosition(x,y);
        if (sw!=null && isPointInCloseButton(sw,x,y)) {
            super.closeWindow(sw);
            requestRepaint();
        }
    }
    
    public void handleMouseDragged(int x, int y) {
        System.out.print(String.valueOf(x)+", "+String.valueOf(y)+"\n");    
    }

    private boolean isPointInCloseButton(SimpleWindow sw, int x, int y) {
        return 
            x>sw.getX()+closeButtonPadding 
            && y>sw.getY()+closeButtonPadding 
            && x<sw.getX()+closeButtonPadding+closeButtonWidth
            && y<sw.getY()+closeButtonPadding+closeButtonWidth ;
    }

    private boolean isPointInTitlebar(SimpleWindow sw, int x, int y) {
        return 
            x>sw.getX() 
            && y>sw.getY() 
            && x<sw.getX()+sw.getWidth()
            && y<sw.getY()+titlebarHeight ;
    }

}
