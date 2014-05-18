// RAT LABEL
import java.awt.Color;


public class RATLabel extends RATWidget {

	// DEFAULTS
	private static final String defaultLabel = "EmptyLabel";
	private static final int defaultPadding = 2;
	
	// addition to the standard widget attributes
	public String label;
	public int padding;


	// constructors (overloading)
	public RATLabel(){
		super();
		this.label = defaultLabel;
		this.padding = defaultPadding;
		this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
		this.width = 7 * label.length() + 2*this.padding;	// 7 as standard characther width
	}
	public RATLabel(String label){
		super();
		this.padding = defaultPadding;
		this.label = label;
		this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
		this.width = 7 * label.length() + 2*this.padding;	// 7 as standard characther width
	}
	public RATLabel(String label, int x, int y){
		super();
		this.padding = defaultPadding;
		this.label = label;
		this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
		this.width = 7 * label.length() + 2*this.padding;	// 7 as standard characther width
		this.x = x;
		this.y = y;
	}
	public RATLabel(String label, int x, int y, Color fg){
		super();
		this.padding = defaultPadding;
		this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
		this.width = 7 * label.length() + 2*this.padding;	// 7 as standard characther width
		this.label = label;
		this.x = x;
		this.y = y;
		this.fgColor = fg;
	}
	public RATLabel(String label, int x, int y, Color fg, Color bg){
		super();
		this.padding = defaultPadding;
		this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
		this.width = 7 * label.length() + 2*this.padding;	// 7 as standard characther width
		this.label = label;
		this.x = x;
		this.y = y;
		this.fgColor = fg;
		this.bgColor = bg;
	}



	// HERE WE SHOULD HAVE A METHOD TO CALCULATE WIDTH BASED ON STRING length es: 6*string length + padding *2
	// and possibly the height, based on the default string height, plus the padding*2.
	// apparently for label the standar width is 10





	// public RATLabel(String label){
	// 	RATLabel();
	// 	this.label = label;
	// }
	// public RATLabel(String label, int x, int y){
	// 	RATLabel(label);
	// 	this.x = x;
	// 	this.y = y;
	// }


	// public void RATLabel(String label, int x, int y){
	// 	this(label,x,y,6*String.length(),20);
	// }
	// public void RATLabel(String label, int x, int y, int width, int height, Color fgcolor){
	// 	this(label,x,y,100,20,fgcolor,new Color(0,0,0,0));// give a default transparent background
	// }
	// public void RATLabel(String label, int x, int y, int width, int height, Color fgcolor, Color bgcolor){
	// 	this.label = label;
	// 	this.x = x;
	// 	this.y = y;
	// 	this.widht = widht;
	// 	this.height = height;
	// 	this.fgcolor = fgcolor;
	// 	this.bgcolor = bgcolor;
	// }


	

	


}