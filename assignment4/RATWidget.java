import java.awt.Color;

// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATWidget {

	// Definitions of some default values
	private static final int defaultX = 50;
	private static final int defaultY = 50;
	private static final int defaultWidth = 100;
	private static final int defaultHeight = 10;
	
	// COMMON ATTRIBUTES TO ALL WIDGETS (made public for easy access, instead of getter and setter //not safe)

	// position
	public int x;
	public int y;
	// dimensions
	public int width;
	public int height;
	// Background and foreground color
	public Color bgColor;
	public Color fgColor;
	// delegate on which call the callback methods
	public Object delegate;
	
	
	public RATWidget(){
		this.x = defaultX;
		this.y = defaultY;
		this.width = defaultWidth;
		this.height = defaultHeight;
		this.delegate = null;
		this.fgColor = Color.BLACK;
		this.bgColor = new Color(0,0,0,0);
	}
	

	
	
	
	// move the window to the specified coordinate
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}


	
}



