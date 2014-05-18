// uses the swing utilites to launch asynchronously
// this should help with some bug of the GES.jar
import javax.swing.SwingUtilities;
import java.awt.Color;

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
// public class MyApp implements RATMouseListener {
public class MyApp {
	
	// main - just launch the GUI drawing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI(); 
            }
        });
    }

    // Create the user interface
	static private void createAndShowGUI() {
    // public MyApp() {


		// get the window system
		WindowSystem ws = new WindowSystem(800,600);	// ws represent the desktop
		// get a window manager and give him the reference to the ws
		WindowManager wm = new WindowManager(ws);			//
		


		// tell the window system to use the windowManager for decoration
		 ws.setWindowManager(wm);

        // Create my app's window
		SimpleWindow myAppWindow = ws.createNewWindow();
		ws.moveWindow(myAppWindow,100,200);

		// System.out.println(" s "+myAppWindow.getX()+myAppWindow.getY()+myAppWindow.getWidth()+myAppWindow.getHeight() );
		// Create widgets
		RATLabel l1 = new RATLabel("Hallo");
		RATLabel l2 = new RATLabel("Hallo",100,100);
		RATLabel l3 = new RATLabel("Hallo",120,110,Color.YELLOW);
		RATLabel l4 = new RATLabel("Hallo",130,120,Color.WHITE,Color.GREEN);

		// RATButton button = new RATButton("Button Text",100,100);



        // add them to the app
        // System.out.println(" s "+label.x+" s "+label.y+" s "+label.width+" s "+label.height );
		myAppWindow.add(l1);
		myAppWindow.add(l2);
		myAppWindow.add(l3);
		myAppWindow.add(l4);
		// myAppWindow.add(button);
        


		//delegate method which call the painting function
		// public void handlePaint(Object o){
		// 	if 
		// 	// ?
		// 	ws.handlePaint();
		// }




	}

    // @Override
    // public void mouseClicked() {}
}
