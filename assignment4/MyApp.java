// uses the swing utilites to launch asynchronously
// this should help with some bug of the GES.jar
import javax.swing.SwingUtilities;

public class MyApp implements RATmouseListener {
	
	// main - just launch the GUI drawing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyApp myApp = new MyApp();
//                createAndShowGUI(); 
            }
        });
    }

    // Create the user interface
//	static private void createAndShowGUI() {
    public MyApp() {

		
		// THIS IS HOW I WOULD IMAGINE THE WORKFLOW
		// actual functions and classes are not implemented like that now
		// from what i have understood, having the WM extending the WS is not correct


		// get the window system
		WindowSystem ws = new WindowSystem(1000,700);	// ws represent the desktop
		// get a window decorator
		WindowManager wm = new WindowManager();			//
		
		//tell the window system to use the windoManager for decoration
		ws.setWindowManager(wm);

		// create my desktop, just a basic solid window.
		SimpleWindow myAppWindow = createWindow(500,500);
		// tell the window to become visible, aka paint itself
		myAppWindow.paint();

		// create widget
		RATLabel label = new RATLabel("Label Text");
		// add them to the app
		myAppWindow.add(label);









		

	}

    @Override
    public void mouseClicked() {}
}
