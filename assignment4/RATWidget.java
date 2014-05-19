import java.awt.Color;

// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATWidget {

	// Definitions of some default values
	private static int defaultX = 50;
	private static int defaultY = 50;
	private static int defaultWidth = 100;
	private static int defaultHeight = 10;
	private static Color defaultBgColor = new Color(0,0,0,0);
	private static Color defaultFgColor = Color.BLACK;
	
	// COMMON ATTRIBUTES TO ALL WIDGETS (made public for easy access, instead of getter and setter //not safe)

	// position
	protected int x;
	protected int y;
	// dimensions
	protected int width;
	protected int height;
	// Background and foreground color
	protected Color bgColor;
	protected Color fgColor;
	// Identifier for recognization purpose
    protected String IDstr = "";
    
	
	
	public RATWidget(){
		this.x = defaultX;
		this.y = defaultY;
		this.width = defaultWidth;
		this.height = defaultHeight;
		this.fgColor = defaultFgColor;
		this.bgColor = defaultBgColor;
	}
	
    // check if it contains the point (x,y)
    public boolean contain(int pX, int pY) {
        return (this.x<pX) && (this.x+this.width>pX)
            && (this.y<pY) && (this.y+this.height>pY);
    }       
	
	
	
	// move the window to the specified coordinate
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

    // Getter and setter
    public void setIdentifier(String str) { IDstr = str; }
    public String getIdentifier() { return IDstr; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void setX(int inX) { x = inX; }
    public void setY(int inY) { y = inY; }
    public void setWidth(int inWidth) { width = inWidth; }
    public void setHeight(int inHeight) { height = inHeight; }
}




