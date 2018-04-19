package start;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage stor = new Storage();
		TxtReader r = new TxtReader(stor);
		r.read("C:\\Users\\Alexander\\git\\prg3\\Verwaltung\\src\\data.txt");
		UserDialog dialog = new UserDialog(stor);
		dialog.start();
	}

}
