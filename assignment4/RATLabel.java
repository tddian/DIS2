// RAT LABEL

import RATWidget;

public class RATLabel extends RATWidget {
	
	// Constructors create the label. Use overloading for the defaults
	public void RATLabel(){
		RATLabel("Label");
	}
	public void RATLabel(String label){
		RATLabel(label,20,20);
	}
	public void RATLabel(String label, int x, int y){
		RATLabel(label,x,y,100,20);
	}
	public void RATLabel(String label, int x, int y, int width, int height, Color fgcolor){
		RATLabel(label,x,y,100,20,Color.Black);
	}
	public void RATLabel(String label, int x, int y, int width, int height, Color fgcolor, Color bgcolor){
		this.label = label;
		this.x = x;
		this.y = y;
		this.widht = widht;
		this.height = height;
		this.fgcolor = fgcolor;
		this.bgcolor = bgcolor;
	}


	

	


}