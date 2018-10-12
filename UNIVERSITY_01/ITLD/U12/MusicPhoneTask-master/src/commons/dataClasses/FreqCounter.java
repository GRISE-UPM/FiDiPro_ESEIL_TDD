package commons.dataClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class FreqCounter {

	HashMap<String, Integer> data;

	public FreqCounter() {
		data = new HashMap<>();
	}

	public void add(String item) {
		data.put(item, getCount(item) + 1);
	}

	public int getCount(String item) {
		if (data.containsKey(item)) {
			return data.get(item);
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns the data sorted asc.
	 * @return
	 */
	public LinkedHashMap<String, Integer> getSortedData()
	{
		return sortHashMapByValuesD(data);
	}
	
	//From stack overflow
	public LinkedHashMap<String, Integer> sortHashMapByValuesD(HashMap<String, Integer> passedMap) {
		   List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
		   List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
		   Collections.sort(mapValues);
		   Collections.sort(mapKeys);

		   LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		   Iterator<Integer> valueIt = mapValues.iterator();
		   while (valueIt.hasNext()) {
		       Integer val = valueIt.next();
		       Iterator<String> keyIt = mapKeys.iterator();

		       while (keyIt.hasNext()) {
		           String key = keyIt.next();
		           Integer comp1 = passedMap.get(key);
		           Integer comp2 = val;

		           if (comp1.equals(comp2)){
		               passedMap.remove(key);
		               mapKeys.remove(key);
		               sortedMap.put(key, val);
		               break;
		           }

		       }

		   }
		   return sortedMap;
		}
}
