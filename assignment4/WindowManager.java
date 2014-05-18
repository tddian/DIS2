import java.awt.Color;



// WINDOW MANAGER
// in our implementation we decide to sacrifice flexibility since the
// project is still small and avoid overhead in communication between
// components.
// This means that the WM is built ON TOP of the WS, and as such it
// hinerits from it.

// then it will override the some basic methods and add the decoration's ones

// it manage the decorations and the position of the windows

public class WindowManager {
    
    private WindowSystem ws;
    
    // various dimensions, used to calculate position of the decorations
    private final int titlebarHeight = 20;
    private final int buttonWidth = 16;
    private final int buttonMargin = 2;
    private final int borderSize = 2;

    
    // instance variables used to handle the mouse events
    private int lastX;
    private int lastY;
    private SimpleWindow draggedWindow = null;
    // private SimpleWindow resizedWindow = null;


    // just call the WS constructor, we will later override and extend it
	public WindowManager(WindowSystem windowSystem) {
        ws = windowSystem;
    }

    // drawWindowDecoration should be called externally only by handlePaint() from the associated WindowSystem
    public void drawWindowDecoration(SimpleWindow sw) {
        // add the WM decoration (assuming standard colors)
        this.drawTitlebar(sw);
//        this.drawMinimizeButton(sw);
        this.drawCloseButton(sw);
        this.drawWindowBorders(sw);
    }

    // draw the decoration for a widget. for now only the border of the buttons
    public void drawWidgetDecoration(RATWidget w) {
        this.drawWidgetBorders(sw);
    }

    // draw the Titlebar, defaults are color=BLACK and title="untitled"
    private void drawTitlebar(SimpleWindow sw){
        drawTitlebar(sw,"Untitled",Color.BLACK);
    }
    private void drawTitlebar(SimpleWindow sw, String title){
        drawTitlebar(sw,title,Color.BLACK);
    }
    private void drawTitlebar(SimpleWindow sw, String title, Color color){
        ws.setColor(color);
        ws.fillRect(
            sw.getX(),
            sw.getY(),
            sw.getX()+sw.getWidth(),
            sw.getY()+titlebarHeight);
        //draw the title, in white
        ws.setColor(Color.YELLOW);
        ws.drawString(
            title,
            sw.getX()+buttonMargin*4+buttonWidth*2,
            sw.getY()+titlebarHeight-buttonMargin);
    }

    // draw the Close button, with an X in it, standard color is RED with black lines
    private void drawCloseButton(SimpleWindow sw){
        drawCloseButton(sw,Color.RED);
    }
    private void drawCloseButton(SimpleWindow sw, Color color){
        ws.setColor(color);
        // this is the 2nd button, after minimizing. so calculate the right spacing
        ws.fillRect(
            sw.getX()+2*buttonMargin+buttonWidth,
            sw.getY()+buttonMargin,
            sw.getX()+2*buttonMargin+2*buttonWidth,
            sw.getY()+buttonMargin+buttonWidth);
        // symbol just an x
        ws.setColor(Color.BLACK);
        ws.drawString("X",
            sw.getX()+4*buttonMargin+buttonWidth,
            sw.getY()+titlebarHeight-2*buttonMargin);
    }


//    // MINIMIZE NOT FULLY IMPLEMENTED YET
//    // draw minimizeButton, standard color YELLOW
//    private void drawMinimizeButton(SimpleWindow sw){
//        drawMinimizeButton(sw, Color.YELLOW);
//    }
//    private void drawMinimizeButton(SimpleWindow sw, Color color){
//        this.setColor(color);
//        fillRect(
//            sw.getX()+buttonMargin,
//            sw.getY()+buttonMargin,
//            sw.getX()+buttonMargin+buttonWidth,
//            sw.getY()+buttonMargin+buttonWidth);
//        this.setColor(Color.BLACK);
//        drawString("_",
//            sw.getX()+3*buttonMargin,
//            sw.getY()+titlebarHeight-3*buttonMargin);
//    }


    // add the borders to the window (standar color BLACK standard size 4)
    private void drawWindowBorders(SimpleWindow sw){
        drawWindowBorders(sw,4,Color.BLACK);
    }
    private void drawWindowBorders(SimpleWindow sw, int size){
        drawWindowBorders(sw,size,Color.BLACK);
    }
    private void drawWindowBorders(SimpleWindow sw, int size, Color color){
        ws.setColor(color);
        for(int i=0; i<size;i++) {        // for better version
            ws.drawRect(
                sw.getX()+i,
                sw.getY()+titlebarHeight-1,     // make it overlap with titlebar
                sw.getX()+sw.getWidth()-i-1,    // inset given by width of border 
                sw.getY()+sw.getHeight()-i-1);  // inset given by width of border 
        }
    }


    // draw the widget borders - used in buttons
    // use the standard colors and parameters included in the widget
    public void drawWidgetBorders(RATWidget w){
        ws.setColor(w.fgColor);
        for(int i=0; i<w.borderWidth;i++) {        // for better version
            ws.drawRect(
                sw.getX()+i,
                sw.getY()+titlebarHeight-1,     // make it overlap with titlebar
                sw.getX()+sw.getWidth()-i-1,    // inset given by width of border 
                sw.getY()+sw.getHeight()-i-1);  // inset given by width of border 
        }


    }




//    // Mouse handling Functions

//    //If we receive a click find the visible window under it (if any)
//    // then check if it is in one of the buttons and handle it 
//    @Override
//    public void handleMouseClicked(int x, int y) {
//        SimpleWindow sw = getWindowAtPosition(x,y);
//        if (sw!=null && isPointInCloseButton(sw,x,y)) {
//            super.closeWindow(sw);
//            requestRepaint();
//        }
//        // if (sw!=null && isPointInMinimizeButton(sw,x,y)) {
//        //     super.minimizeWindow(sw);
//        //     requestRepaint();
//        // }

//    }
//    @Override
//    public void handleMouseDragged(int x, int y) {
//        System.out.print("Mouse dragging.. "+String.valueOf(x)+", "+String.valueOf(y)+"\n");
//        
//        // DRAGGIN WINDOW
//        if (draggedWindow!=null) {
//            super.moveWindow(
//                draggedWindow,
//                draggedWindow.getX()+x-lastX,
//                draggedWindow.getY()+y-lastY);
//            lastX = x;
//            lastY = y;
//        } 
//        //RESIZING WINDOW
//        // else if (resizedWindow!=null) {
//        //     super.moveWindow(
//        //         draggedWindow,
//        //         draggedWindow.getX()+x-lastX,
//        //         draggedWindow.getY()+y-lastY);
//        //     lastX = x;
//        //     lastY = y;
//        // }            

//    }
//    @Override
//    public void handleMousePressed(int x, int y) {
//        System.out.print("Mouse pressed.. "+String.valueOf(x)+", "+String.valueOf(y)+"\n"); 
//        SimpleWindow sw = getWindowAtPosition(x,y);
//        if (sw!=null) {
//            // Bring the pointed window to top.
//            super.bringWindowToTop(sw);
//        }
//        
//        if (sw!=null 
//            && isPointInTitlebar(sw,x,y) 
//            && !isPointInCloseButton(sw,x,y) 
//            && !isPointInMinimizeButton(sw,x,y)) {
//            // Record the pressed point and window, for later use for dragging.
//            lastX = x;
//            lastY = y;
//            draggedWindow = sw;
//        }
//    // MINIMIZE NOT FULLY IMPLEMENTED YET

//    }
//    @Override
//    public void handleMouseReleased(int x, int y) {
//        System.out.print("Mouse released.. "+String.valueOf(x)+", "+String.valueOf(y)+"\n");        
//        draggedWindow = null;
//    }
//    @Override
//    public void handleMouseMoved(int x, int y) {
////        System.out.print("Mouse moving..");        
//    }

//    
//    
//    // functions to know if the mouse is inside the closing button of this window
//    private boolean isPointInCloseButton(SimpleWindow sw, int x, int y) {
//        return 
//            (x>sw.getX()+2*buttonMargin+buttonWidth)
//            && (y>sw.getY()+buttonMargin) 
//            && (x<sw.getX()+2*buttonMargin+2*buttonWidth)
//            && (y<sw.getY()+buttonMargin+buttonWidth) ;
//    }

//    // functions to know if the mouse is inside the titlebar of this windows
//    private boolean isPointInTitlebar(SimpleWindow sw, int x, int y) {
//        return 
//            (x>sw.getX())
//            && (y>sw.getY())
//            && (x<sw.getX()+sw.getWidth())
//            && (y<sw.getY()+titlebarHeight) ;
//    }


//    // MINIMIZE NOT FULLY IMPLEMENTED YET
//    // functions to know if the mouse is inside the minimizing of this windows
//    private boolean isPointInMinimizeButton(SimpleWindow sw, int x, int y) {
//        return 
//            (x>sw.getX()+buttonMargin)
//            && (y>sw.getY()+buttonMargin) 
//            && (x<sw.getX()+buttonMargin+buttonWidth)
//            && (y<sw.getY()+buttonMargin+buttonWidth) ;
//    }

}
