
// BASE ABSTRACT CLASS
// This class define the basic attribute and function for the basic widget


abstract class RATWidget {
	
	// position
	int posX;
	int posY;
	// dimensions
	int width;
	int height;
	// label
	String label;
	
	// Background and foreground color
	Color bgColor;
	Color fgColor;
	
	
	// move the window to the specified coordinate
	moveTo(int x, int y);
	
	// paint itself.
	show();
	
	
}



