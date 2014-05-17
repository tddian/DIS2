// RAT LABEL

import java.awt.Color;

public class RATlabel extends RATwidget {
	
	// Constructors create the label. Use overloading for the defaults
	public RATlabel(){
		this("Label");
	}
	public RATlabel(String label){
		this(label,20,20);
	}
	public RATlabel(String label, int x, int y){
		this(label,x,y,100,20);
	}
	public RATlabel(String label, int x, int y, int width, int height){
		this(label,x,y,100,20,Color.WHITE,Color.BLACK);
	}
	public RATlabel(String label, int x, int y, int width, int height, Color fgcolor, Color bgcolor){
		this.label = label;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fgColor = fgcolor;
		this.bgColor = bgcolor;
	}

	


}
