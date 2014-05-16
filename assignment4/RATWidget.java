
// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATWidget {
	
	// position
	public int posX;
	public int posY;
	// dimensions
	public int width;
	public int height;
	// label
	public String label;
	
	// Background and foreground color
	Color bgColor;
	Color fgColor;
	
	
	// move the window to the specified coordinate
	public void moveTo(int x, int y);
	
	// paint itself.
	public void show();
	
	


	// setters and getters;

}



