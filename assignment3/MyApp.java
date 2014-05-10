public class MyApp {

	public static void main(String[] args) {
		WindowManager windowSystem = new WindowManager(1000, 700);
		SimpleWindow sw = windowSystem.createNewWindow();
		windowSystem.moveWindow(sw,300,100);
	}

}
