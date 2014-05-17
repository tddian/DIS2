import java.awt.Color;

// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATwidget {
	
	// position
	public int x;
	public int y;
	// dimensions
	public int width;
	public int height;
	// label
	public String label;
	
	// Background and foreground color
	public Color bgColor;
	public Color fgColor;
	
	
	// move the window to the specified coordinate
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		this.paint();
	}

	
	// paint itself. // I don't know how to call this method.
	public void paint() { }
	
	


	// setters and getters;

}



