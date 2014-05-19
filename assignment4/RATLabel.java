// RAT LABEL
import java.awt.Color;


public class RATLabel extends RATWidget {

	// DEFAULTS
	private static  String defaultLabelText = "EmptyLabel";
	private static  int defaultLabelPadding = 2;
	
	// addition to the standard widget attributes
	public String label;
	public int padding;


	// constructors (overloading)
	public RATLabel(){
		super();
		this.label = defaultLabelText;
		this.padding = defaultLabelPadding;
		this.height = 10 + 2*this.defaultLabelPadding; // 10 is the standard height for a drawString
	}
	public RATLabel(String label){
		this();
		this.label = label;
		this.height = 10 + 2*this.defaultLabelPadding; // 10 is the standard height for a drawString
	}
	public RATLabel(String label, int x, int y){
		this(label);
		this.x = x;
		this.y = y;
	}
	public RATLabel(String label, int x, int y, Color fg){
		this(label,x,y);
		this.fgColor = fg;
	}
	public RATLabel(String label, int x, int y, Color fg, Color bg){
		this(label,x,y,fg);
		this.bgColor = bg;
	}

    // Getters and setters
    public void setLabel(String str) { label = str; }

	// HERE WE SHOULD HAVE A METHOD TO CALCULATE WIDTH BASED ON STRING length es: 6*string length + padding *2
	// and possibly the height, based on the default string height, plus the padding*2.
	// apparently for label the standar width is 10
    @Override
    public int getWidth() {
        return width = 8 * label.length() + 2*this.padding;	// 8 as standard characther width
    }


}
