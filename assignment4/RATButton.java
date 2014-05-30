import java.util.ArrayList;
import java.awt.Color;



/* RATButton
 * A RATButton should be able to respond to mouse events, and allow other 
 * objects to receive notifications when it is pressed.
 */
 
public class RATButton extends RATLabel {
    
    // DEFAULTS
    private static String defaultButtonText = "EmptyButton";
    private static int defaultButtonPadding = 4;
    private static int defaultButtonBorderSize = 2;
    private static Color defaultButtonBgColor = Color.DARK_GRAY;
    private static Color defaultButtonFgColor = Color.CYAN;

    // additional parameters
    public int borderSize;

    // list of mouse listener to respond to
    private ArrayList<RATMouseListener> listeners;




    // constructors (overloading)
    public RATButton(){
        super();
        // override default
        this.label = defaultButtonText;
        this.padding = defaultButtonPadding;
        this.borderSize = defaultButtonBorderSize;
        this.fgColor = defaultButtonFgColor;
        this.bgColor = defaultButtonBgColor;
        this.height = 10 + 2*this.defaultButtonPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
        
        listeners = new ArrayList<RATMouseListener>();
    }
    public RATButton(String label){
        this();
        this.label = label;
        this.height = 10 + 2*this.defaultButtonPadding; // 10 is the standard height for a drawString
        this.width = 7 * label.length() + 2*this.padding;   // 7 as standard characther width
        listeners = new ArrayList<RATMouseListener>();
    }
    public RATButton(String label, int x, int y){
        this(label);
        this.x = x;
        this.y = y;
        listeners = new ArrayList<RATMouseListener>();
    }
    public RATButton(String label, int x, int y, Color fg){
        this(label, x, y);
        this.fgColor = fg;
        listeners = new ArrayList<RATMouseListener>();
    }
    public RATButton(String label, int x, int y, Color fg, Color bg){
        this(label, x, y, fg);
        this.bgColor = bg;
        listeners = new ArrayList<RATMouseListener>();
    }
    
    public void addListener(RATMouseListener l) { listeners.add(l); }
    public void clicked() { // called by WM when this button instance is clicked.
        for (int i=0; i<listeners.size(); i++) {
            listeners.get(i).mouseClicked(this.getIdentifier());
        }
    }
}
