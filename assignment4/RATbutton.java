import java.util.ArrayList;
import java.awt.Color;



/* RATbutton
 * A RATbutton should be able to respond to mouse events, and allow other 
 * objects to receive notifications when it is pressed.
 */
 
public class RATbutton extends RATlabel {

    private ArrayList<RATmouseListener> listeners;
    
    // Constructors for RATbutton
    public RATbutton(String label) {
        super(label);
        listeners = new ArrayList<RATmouseListener>();
    }
    // Constructors for RATbutton
    public RATbutton(String label, int x, int y, int width, int height, Color fgcolor, Color bgcolor) {
        super(label,x,y,width,height,fgcolor,bgcolor);
        listeners = new ArrayList<RATmouseListener>();
    }
    
    public void addListener(RATmouseListener l) { listeners.add(l); }
}
