package hu.webarticum.abstract_gui.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text {
	
	public enum TYPE {
		PLAIN, HTML, BBCODE, MARKDOWN
	};
	
	protected TYPE originalType;
	
	protected Map<TYPE, String> textVersions = new HashMap<TYPE, String>();
	
	static public Text fromPlain(String text) {
		return new Text(text, TYPE.PLAIN);
	}

	static public Text fromHtml(String html) {
		return new Text(html, TYPE.HTML);
	}

	static public Text fromBbcode(String bbcode) {
		return new Text(bbcode, TYPE.BBCODE);
	}

	static public Text fromMarkdown(String markdown) {
		return new Text(markdown, TYPE.MARKDOWN);
	}
	
	static public String convert(String text, TYPE fromType, TYPE toType) {
		// TODO
		return "";
	}

	public Text(String text) {
		this(text, TYPE.PLAIN);
	}
	
	public Text(String text, TYPE type) {
		this.originalType = type;
		this.textVersions.put(type, text);
	}
	
	public TYPE getOriginalType() {
		return originalType;
	}

	public String getOriginalContent() {
		return textVersions.get(originalType);
	}
	
	public String getText() {
		return getText(TYPE.PLAIN);
	}

	public String getText(TYPE type) {
		ensureType(type);
		return textVersions.get(type);
	}
	
	protected void ensureType(TYPE type) {
		if (!textVersions.containsKey(type)) {
			String newText = convert(textVersions.get(originalType), originalType, type);
			textVersions.put(type, newText);
		}
	}
	
	// FIXME: styles etc.?
	protected class Internal {
		
		List<Object> entries = new ArrayList<Object>();
		
		class Begin {
			
			String type = "";
			
			Map<String, String> attributes = new HashMap<String, String>();
			
		}
		
		class End {
			
			Begin begin;
			
		}
		
		// TODO
		
	}
	
}
