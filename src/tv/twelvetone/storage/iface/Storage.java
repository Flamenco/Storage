package tv.twelvetone.storage.iface;

public interface Storage {
	StorgeLocation getStorageLocation();

	StorageSecurity getStorageSecurity();

	StoragePersitance getStoragePersitance();

	StoragePermission getStoragePermission();

	Object get(String key, Object defVal);
	String getString(String key, String defVal);

	void put(String key, Object value);
	void put(String key, String value);
}
