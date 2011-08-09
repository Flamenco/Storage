package tv.twelvetone.storage;

import java.util.HashMap;

import tv.twelvetone.storage.iface.Storage;
import tv.twelvetone.storage.iface.StoragePermission;
import tv.twelvetone.storage.iface.StoragePersitance;
import tv.twelvetone.storage.iface.StorageSecurity;
import tv.twelvetone.storage.iface.StorgeLocation;


public class RamStorage implements Storage{

	private HashMap<String, String> map;

	public RamStorage() {
		map = new HashMap<String, String>();
	}

	@Override
	public StorgeLocation getStorageLocation() {
		return StorgeLocation.Volatile;
	}

	@Override
	public StorageSecurity getStorageSecurity() {
		return StorageSecurity.None;
	}

	@Override
	public StoragePersitance getStoragePersitance() {
		return StoragePersitance.Program;
	}

	@Override
	public StoragePermission getStoragePermission() {
		return StoragePermission.Private;
	}

	@Override
	public Object get(String key, Object defVal) {
		return get(key,defVal.toString());
	}

	@Override
	public String getString(String key, String defVal) {
		String val = map.get(key);
		if (val == null){
			val = defVal;
		}
		return val;
	}

	@Override
	public void put(String key, Object value) {
		map.put(key, value.toString());
	}

	@Override
	public void put(String key, String value) {
		map.put(key,value);
	}

}
