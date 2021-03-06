import java.awt.Color;

// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATwidget {
	
	// bound of the window.
	// in case this is a subview (es handle of slider) it must know where to stop
	// a child should not get off the parent window (set on addSubWindow)
	// public buoundTopLeftX;
	// public buoundTopLeftY;
	// public buoundBottomRightX;
	// public buoundBottomRightY;


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

	// paint itself. 
	public void paint(){
		ws.handlePaint(this);
	};


	// setters and getters;

}



