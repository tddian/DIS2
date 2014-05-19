// uses the swing utilites to launch asynchronously
// this should help with some bug of the GES.jar
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.lang.Math;

// Hi 
/* I don't think MyApp should implement RATMouseListner,
i think RATWidget should, and then call the callback method on the delegate (our main app - this).

ES:
Our main application should have a callback method, let's say "updateLabelTo(String newLabel)"

the buttons widget (RATButton) should implement the eventlistener.
on click, it should call our main application callback method as declared before,
 passing his own value (the string in different language depending on the button)

 this will require our widget to have a reference to our own app, which I was thinking
 of implementing as an internal delegate


*/
public class MyApp implements RATMouseListener {
	
    private RATLabel label;	
    private RATButton b1,b2,b3,b4;
    private static WindowSystem ws;
    private static WindowManager wm;
    private static SimpleWindow myAppWindow;
    
	// main - just launch the GUI drawing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {


		        // get the window system
		        ws = new WindowSystem(800,600);	// ws represent the desktop
		        // get a window manager and give him the reference to the ws
		        wm = new WindowManager(ws);			//

		        // tell the window system to use the windowManager for decoration
		        // TRY ME , IT'S FUN. COMMENT THIS LINE TO SEE THE APPLICATION STILL RUNNING, BUT WITHOUT WM
		        ws.setWindowManager(wm);

                new MyApp();
                new MyCalculator(ws);
            }
        });
    }

    // Create the user interface
//	static private void createAndShowGUI() {
     public MyApp() {

        // Create my app's window
		myAppWindow = ws.createNewWindow();
		ws.moveWindow(myAppWindow,100,200);

		// Create widgets, set id string for each so that in the listener callback  
		// we know which button is clicked. 
		label = new RATLabel("DIS II, assignment4",130,120,Color.BLACK,Color.WHITE);
		
		b1 = new RATButton("German",100,200);
		b1.setIdentifier("de");
		b2 = new RATButton("English",200,200);
		b2.setIdentifier("en");
		b3 = new RATButton("Francais",300,200);
		b3.setIdentifier("fr");
		b4 = new RATButton("Quit",320,250);
		b4.setIdentifier("q");

        b1.addListener(this);
        b2.addListener(this);
        b3.addListener(this);
        b4.addListener(this);

        // add them to the app
		myAppWindow.add(label);
		
		myAppWindow.add(b1);
		myAppWindow.add(b2);
		myAppWindow.add(b3);
		myAppWindow.add(b4);

	}

    @Override
    public void mouseClicked(String IDstr) {
        if (IDstr.equals("en")) {
            label.setLabel("Hello !");
            b4.setLabel("Quit");
        } else if (IDstr.equals("de")) {
            label.setLabel("Guten Tag !");
            b4.setLabel("Beenden");
        } else if (IDstr.equals("fr")) {
            label.setLabel("Bonjour !");
            b4.setLabel("Quitter");
        } else if (IDstr.equals("q")) {
            ws.closeWindow(myAppWindow);
        }
        ws.requestRepaint();
    }
}

class MyCalculator implements RATMouseListener {
    private WindowSystem ws;
    private String[] symbols = {
        "7","8","9","/",
        "4","5","6","*",
        "1","2","3","-",
        "0",".","=","+"
        };
    private RATLabel label;
    private double currentNum = 0;
    private double displayNum = 0;
    private String currentOperation = "";
    private boolean isDecimal = false;
    private int numDecimal = 0;
    
    public MyCalculator(WindowSystem ws) {
        this.ws = ws;
        // Create my app's window
		SimpleWindow myWindow = ws.createNewWindow();
		myWindow.setWidth(110);
		myWindow.setHeight(150);
		ws.moveWindow(myWindow,500,50);

		// Create widgets
		label = new RATLabel("0",10,30,Color.BLACK,Color.WHITE);
		myWindow.add(label);

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                RATButton b = new RATButton(symbols[i*4+j],10+j*22,50+i*22);
		        b.setIdentifier(symbols[i*4+j]);
		        b.addListener(this);
		        myWindow.add(b);
            }
        }
    }
    @Override
    public void mouseClicked(String IDstr) {
        System.out.println("!");
        double enteredNumer = 0;
        if (IDstr.equals("0")) {
            enteredNumer = 0;
        } else if (IDstr.equals("1")) {
            enteredNumer = 1;
        } else if (IDstr.equals("2")) {
            enteredNumer = 2;
        } else if (IDstr.equals("3")) {
            enteredNumer = 3;
        } else if (IDstr.equals("4")) {
            enteredNumer = 4;
        } else if (IDstr.equals("5")) {
            enteredNumer = 5;
        } else if (IDstr.equals("6")) {
            enteredNumer = 6;
        } else if (IDstr.equals("7")) {
            enteredNumer = 7;
        } else if (IDstr.equals("8")) {
            enteredNumer = 8;
        } else if (IDstr.equals("9")) {
            enteredNumer = 9;
        } else if (IDstr.equals("=")) { //compute
            if (currentOperation.equals("+")) {
                currentNum = currentNum + displayNum;            
            } else if (currentOperation.equals("-")) {
                currentNum = currentNum - displayNum;            
            } else if (currentOperation.equals("*")) {
                currentNum = currentNum * displayNum;            
            } else if (currentOperation.equals("/")) {
                currentNum = currentNum / displayNum;            
            }
            label.setLabel(String.valueOf(currentNum));
            ws.requestRepaint();
            
            // reset
            displayNum = 0;
            currentOperation = "";
            isDecimal = false;
            numDecimal = 0;
            return;
        } else if (IDstr.equals(".")) {
            if (!isDecimal) {
                isDecimal = true;
                label.setLabel(String.valueOf((int)displayNum)+".");
                ws.requestRepaint();
                return;
            } else {
                label.setLabel(String.valueOf(displayNum));
                ws.requestRepaint();
            }
        } else {    // + - * /
            currentOperation = IDstr;
            currentNum = displayNum;
            if (isDecimal) {
                label.setLabel(String.valueOf(currentNum));
            } else {
                label.setLabel(String.valueOf((int)currentNum));        
            }
            ws.requestRepaint();
            // reset
            displayNum = 0;            
            isDecimal = false;
            numDecimal = 0;
            return;
        }
        
        if (!isDecimal) {
            displayNum = displayNum*10 + enteredNumer;
        } else {
            numDecimal++;
            displayNum = displayNum + enteredNumer/Math.pow(10,numDecimal);
        }
        if (isDecimal) {
            label.setLabel(String.valueOf(displayNum));
        } else {
            label.setLabel(String.valueOf((int)displayNum));        
        }
        ws.requestRepaint();
   }
}
