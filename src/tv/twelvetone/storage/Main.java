package tv.twelvetone.storage;

import java.io.IOException;
import java.util.Random;

import tv.twelvetone.storage.iface.Storage;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Storage On GIT");
		
		//HtmlLocalStorage stg = new HtmlLocalStorage();
		Storage stg;
		
		stg = new RamStorage();
		testStorage(stg);
		
		try {
			stg = new FileStorage("testStorage");
			testStorage(stg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static void testStorage(Storage stg) {
		String curValue = stg.getString("a", "default");
		System.out.printf("Current value: %s\r\n", curValue);
		Random r= new Random();
		stg.put("a", r.nextInt());
		String newValue = stg.getString("a", "default");
		System.out.printf("New value: %s\r\n", newValue);
	}
}
