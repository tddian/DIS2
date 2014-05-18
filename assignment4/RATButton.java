import java.util.ArrayList;
import java.awt.Color;



/* RATButton
 * A RATButton should be able to respond to mouse events, and allow other 
 * objects to receive notifications when it is pressed.
 */
 
public class RATButton extends RATLabel {
    
    // DEFAULTS
    private static final String defaultLabel = "EmptyButton";
    private static final int defaultPadding = 4;
    private static final int defaultBorderSize = 2;
    private static final Color defaultBgColor = Color.DARK_GRAY;
    private static final Color defaultFgColor = Color.CYAN;

    // additional parameters
    public int borderSize;


    
    // list of mouse listener to respond to
    private ArrayList<RATMouseListener> listeners;




    // constructors (overloading)
    public RATButton(){
        super();
        this.label = defaultLabel;
        this.padding = defaultPadding;
        this.borderSize = defaultBorderSize;
    }
    public RATButton(String label){
        super(label);
        this.padding = defaultPadding;
        this.borderSize = defaultBorderSize;
        this.label = label;
        this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
    }
    public RATButton(String label, int x, int y){
        super();
        this.padding = defaultPadding;
        this.borderSize = defaultBorderSize;
        this.label = label;
        this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
        this.x = x;
        this.y = y;
    }
    public RATButton(String label, int x, int y, Color fg){
        super();
        this.padding = defaultPadding;
        this.borderSize = defaultBorderSize;
        this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
        this.label = label;
        this.x = x;
        this.y = y;
        this.fgColor = fg;
    }
    public RATButton(String label, int x, int y, Color fg, Color bg){
        super();
        this.padding = defaultPadding;
        this.borderSize = defaultBorderSize;
        this.height = 10 + 2*this.defaultPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
        this.label = label;
        this.x = x;
        this.y = y;
        this.fgColor = fg;
        this.bgColor = bg;
    }
    
    public void addListener(RATMouseListener l) { listeners.add(l); }
}
