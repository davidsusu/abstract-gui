package hu.webarticum.abstractgui.core.framework.text;

import java.util.Map;

public class MapTextRepository implements TextRepository {

	private Map<Object, Text> map;
	
	
	public MapTextRepository(Map<Object, Text> map) {
		this.map = map;
	}

	@Override
	public Text get(Object key) {
		return map.get(key);
	}
	
}
