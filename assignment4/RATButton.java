import java.util.ArrayList;
import java.awt.Color;



/* RATButton
 * A RATButton should be able to respond to mouse events, and allow other 
 * objects to receive notifications when it is pressed.
 */
 
public class RATButton extends RATLabel {

    // // list of mouse listener to respond to
    private ArrayList<RATMouseListener> listeners;

    // // delegate application of which call the callbacks
    // private Object delegate = null;
    
    
    // // Empty Constructor for RATButton
    // public void RATButton() {
    //     this("Button", 50, 50, 100, 30, Color.BLACK, Color.BLUE);
    // }
    // public void RATButton(String label) {
    //     this(label, 50, 50, 100, 30, Color.BLACK, Color.BLUE);
    // }
    // public void RATButton(String label,int x, int y) {
    //     this(label, x, y, 100, 30, Color.BLACK, Color.BLUE);
    // }
    // public void RATButton(String label,int x, int y,int width, int height) {
    //     this(label, x, y, width, height, Color.BLACK, Color.CYAN);
    // }
    // // Constructor for RATButton
    // public void RATButton(String label, int x, int y, int width, int height, Color fgcolor, Color bgcolor) {
    //     super(label,x,y,width,height,fgcolor,bgcolor);
    //     listeners = new ArrayList<RATMouseListener>();
    // }
    
    public void addListener(RATMouseListener l) { listeners.add(l); }
}
