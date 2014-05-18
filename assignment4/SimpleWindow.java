import java.util.ArrayList;

// Our SimpleWindow
// just keep track of it's own coordinates and dimension
// so it contain basic stuff.. mostly getter and setter for those properties
public class SimpleWindow {

    private int mX, mY, mWidth, mHeight;

    private ArrayList<RATWidget> widgets;
    private ArrayList<SimpleWindow> children;

    public SimpleWindow() {
        mX = 0;
        mY = 0;
        mWidth = 100;
        mHeight = 100;
        widgets = new ArrayList<RATWidget>();
        children = new ArrayList<SimpleWindow>();

    }

    public SimpleWindow(int inX, int inY, int inWidth, int inHeight) {
        mX = inX;
        mY = inY;
        mWidth = inWidth;
        mHeight = inHeight;
        widgets = new ArrayList<RATWidget>();
        children = new ArrayList<SimpleWindow>();

    }


    // ADD A WIDGET TO THE WINDOW
    public void add(RATWidget w) {
        widgets.add(w);
    }


    // widget management
    // does the window has widgets?
    public boolean hasWidgets(){
        return (this.widgets.size() != 0);
    }
    // return the list of widgets
    public ArrayList<RATWidget> getWidgets(){
        return this.widgets;
    }


    public int getX() { return mX; }
    public int getY() { return mY; }
    public int getWidth() { return mWidth; }
    public int getHeight() { return mHeight; }
    public void setX(int inX) { mX = inX; }
    public void setY(int inY) { mY = inY; }
    public void setWidth(int inWidth) { mWidth = inWidth; }
    public void setHeight(int inHeight) { mHeight = inHeight; }
}
