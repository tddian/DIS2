// 
// @author dian


// Our SimpleWindow
// just keep track of it's own coordinates and dimension
// so it contain basic stuff.. mostly getter and setter for those properties
public class SimpleWindow {

private int mX, mY, mWidth, mHeight;

    public SimpleWindow() {
        mX = 0;
        mY = 0;
        mWidth = 0;
        mHeight = 0;
    }

    public SimpleWindow(int inX, int inY, int inWidth, int inHeight) {
        mX = inX;
        mY = inY;
        mWidth = inWidth;
        mHeight = inHeight;
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
