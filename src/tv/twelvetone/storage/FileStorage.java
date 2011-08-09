package tv.twelvetone.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import tv.twelvetone.storage.iface.Storage;
import tv.twelvetone.storage.iface.StoragePermission;
import tv.twelvetone.storage.iface.StoragePersitance;
import tv.twelvetone.storage.iface.StorageSecurity;
import tv.twelvetone.storage.iface.StorgeLocation;

public class FileStorage implements Storage {

	private HashMap<String, String> map;
	private File f;

	public FileStorage(String localPath) throws IOException {
		f = new File(localPath);
		if (f.exists() == false){
			f.createNewFile();
		}
		load();
	}

	private void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			map = (HashMap<String, String>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (map == null) {
			map = new HashMap<String, String>();
		}

	}

	protected void store() throws IOException {
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(map);
	}

	@Override
	public StorgeLocation getStorageLocation() {
		return StorgeLocation.Persitant;
	}

	@Override
	public StorageSecurity getStorageSecurity() {
		return StorageSecurity.None;
	}

	@Override
	public StoragePersitance getStoragePersitance() {
		return StoragePersitance.Computer;
	}

	@Override
	public StoragePermission getStoragePermission() {
		return StoragePermission.Shared;
	}

	@Override
	public Object get(String key, Object defVal) {
		return get(key, defVal.toString());
	}

	@Override
	public String getString(String key, String defVal) {
		String val = map.get(key);
		if (val == null) {
			val = defVal.toString();
		}
		;
		return val;
	}

	@Override
	public void put(String key, Object value) {
		put(key, value.toString());
	}

	@Override
	public void put(String key, String value) {
		map.put(key, value);
		try {
			store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
