// uses the swing utilites to launch asynchronously
// this should help with some bug of the GES.jar
import javax.swing.SwingUtilities;

public class MyApp {
	
	// main - just launch the GUI drawing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    // create the desktop and do tomething inside
	static private void createAndShowGUI() {

		//Create the WM, Which in our design is a layer on TOP
		//of WS. as such asking the windowManager is like asking
		//the WS directly for a window. (WS will keep track of them)
		WindowManager wm = new WindowManager(1000, 700);
		
		// create 3 windows and put them around the desktop
		SimpleWindow sw = wm.createNewWindow();
		wm.moveWindow(sw,200,100);
		
		sw = wm.createNewWindow();
		wm.moveWindow(sw,300,250);
		
		sw = wm.createNewWindow();
		wm.moveWindow(sw,400,350);

	}

}
