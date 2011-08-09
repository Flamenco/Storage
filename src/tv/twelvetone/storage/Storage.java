package tv.twelvetone.storage;

public interface Storage {
	StorgeLocation getStorageLocation();
	StorageSecurity getStorageSecurity();
	StoragePersitance getStoragePersitance();
	StorageAccess getStorageAccess();
}
