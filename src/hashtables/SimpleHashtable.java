package hashtables;

import lists.Employee;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        // linear probing
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            // if our hashedKey is occupied, and we are the end of array
            // we wrap to zero index, in other case we just increment,
            // and we'll check if it still is occupied in while cycle (we did first probe)
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            // try to find not next not occupied hashedKey below

            // about hashedKey != stopIndex
            // when looping in while we can wrap from last index to zero
            // and continue iterating to find hashedKey till we reach original
            // hashedKey (we already looped everything after it, so we stop while)
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                // add this % (mod) to avoid out of bound exception (if
                // hashedKey value is 9+1 and hashtable length is 10 we'll get 0 with mod)
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        // if linear probing fails (because full array)
        if (occupied(hashedKey)) {
            System.out.println("Sorry, but no");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        // rehashing
        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[oldHashTable.length];
        for (StoredEmployee storedEmployee : oldHashTable) {
            if (storedEmployee != null) {
                put(storedEmployee.key, storedEmployee.employee);
            }
        }

        return employee;
    }


    // we also use linear probing here
    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // first probe
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        // loop and try to find hashedKey with key value we are looking to
        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
