public class MyApp {

	public static void main(String[] args) {
		WindowSystem windowSystem = new WindowSystem(1000, 700);
		SimpleWindow sw = windowSystem.createNewWindow();
		windowSystem.moveWindow(sw,300,100);
	}

}
