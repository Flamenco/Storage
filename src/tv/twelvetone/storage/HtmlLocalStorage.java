package tv.twelvetone.storage;

import tv.twelvetone.storage.iface.Storage;
import tv.twelvetone.storage.iface.StoragePermission;
import tv.twelvetone.storage.iface.StoragePersitance;
import tv.twelvetone.storage.iface.StorageSecurity;
import tv.twelvetone.storage.iface.StorageLocation;

public class HtmlLocalStorage implements Storage {

	@Override
	public StorageLocation getStorageLocation() {
		return StorageLocation.Persitant;
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
		return get(key, defVal.toString());
	}

	@Override
	public void put(String key, Object value) {
		put(key, value.toString());
	}

	@Override
	public String getString(String key, String defVal) {
		com.google.gwt.storage.client.Storage stg = com.google.gwt.storage.client.Storage.getLocalStorageIfSupported();
		String ret = stg.getItem(key);
		if (ret == null) {
			ret = defVal.toString();
		}
		return ret;
	}

	@Override
	public void put(String key, String value) {
		com.google.gwt.storage.client.Storage stg = com.google.gwt.storage.client.Storage.getLocalStorageIfSupported();
		stg.setItem(key, value.toString());
	}
}
