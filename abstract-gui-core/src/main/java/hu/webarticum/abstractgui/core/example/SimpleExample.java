package hu.webarticum.abstractgui.core.example;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import hu.webarticum.abstractgui.core.framework.BorderContainer;
import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Environment;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.Factory;
import hu.webarticum.abstractgui.core.framework.FreeContainer;
import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.Metrics;
import hu.webarticum.abstractgui.core.framework.TextField;
import hu.webarticum.abstractgui.core.framework.VerticalContainer;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.text.FormattedText;
import hu.webarticum.abstractgui.core.framework.text.HtmlText;
import hu.webarticum.abstractgui.core.framework.text.LocalizedMultilingualTextRepository;
import hu.webarticum.abstractgui.core.framework.text.MapTextRepository;
import hu.webarticum.abstractgui.core.framework.text.PlainText;
import hu.webarticum.abstractgui.core.framework.text.SimpleMultilingualTextRepository;
import hu.webarticum.abstractgui.core.framework.text.Text;

public class SimpleExample implements Runnable {
    
    private final Environment environment;
    
    private final BorderContainer container;
	

    public SimpleExample(Environment environment) {
        this.environment = environment;
        this.container = null;
    }

    public SimpleExample(BorderContainer container) {
        this.environment = container.getEnvironment();
        this.container = container;
    }
    
	
	@Override
    public void run() {
    	final Locale hu = new Locale("hu");
    	final Locale en = new Locale("en_US");
    	
    	final SimpleMultilingualTextRepository repository = new SimpleMultilingualTextRepository();
    	
    	final Map<Object, Text> huTextMap = new HashMap<Object, Text>();
    	huTextMap.put("windowtitle", new PlainText("Tesztablak"));
    	huTextMap.put("toplabel", new PlainText("Felső szöveg"));
    	huTextMap.put("topbutton1", new PlainText("Felső gomb 1"));
    	huTextMap.put("topbutton2", new PlainText("Felső gomb 2"));
    	huTextMap.put("topcounterbutton", new HtmlText("<b>Számláló:<b> <u style=\"color:red;\">%s</u>"));
    	huTextMap.put("patterntext", new HtmlText("HU (<u>%s</u>) (%.2f)"));
    	huTextMap.put("switchlang", new HtmlText("<i>Nyelv váltása</i>"));
    	repository.put(hu, new MapTextRepository(huTextMap));
        
    	final Map<Object, Text> enTextMap = new HashMap<Object, Text>();
    	enTextMap.put("windowtitle", new PlainText("Test window"));
    	enTextMap.put("toplabel", new PlainText("Top label"));
    	enTextMap.put("topbutton1", new PlainText("Top button 1"));
    	enTextMap.put("topbutton2", new PlainText("Top button 2"));
    	enTextMap.put("topcounterbutton", new HtmlText("<b>Counter:<b> <u style=\"color:red;\">%s</u>"));
    	enTextMap.put("patterntext", new HtmlText("EN (<u>%s</u>) (%.2f)"));
    	enTextMap.put("switchlang", new HtmlText("<i>Switch language</i>"));
    	repository.put(en, new MapTextRepository(enTextMap));
    	
    	final LocalizedMultilingualTextRepository localizedRepository = new LocalizedMultilingualTextRepository(repository);
    	localizedRepository.setLocale(hu);
    	
        final Factory factory = environment.getFactory();
        final BorderContainer wrapperContainer;
        final Window window;
        if (container == null) {
            wrapperContainer = factory.createBorderContainer();
            window = factory.createWindow(wrapperContainer, localizedRepository.getDynamic("windowtitle"));
        } else {
            wrapperContainer = container;
            window = null;
        }
        
        final VerticalContainer topPanel = factory.createVerticalContainer();
        
        final Label topLabel = factory.createLabel(localizedRepository.getDynamic("toplabel"));
        final Button topButton1 = factory.createButton(localizedRepository.getDynamic("topbutton1"));
        final Button topButton2 = factory.createButton(localizedRepository.getDynamic("topbutton2"));

        final AtomicInteger counter = new AtomicInteger(0);
        final Button topCounterButton = factory.createButton(new FormattedText(localizedRepository.getDynamic("topcounterbutton"), counter));
        topCounterButton.on(Event.Type.ACTION, new EventListener() {
			
			@Override
			public void occured(Event event) {
				counter.incrementAndGet();
				topCounterButton.refresh();
			}
			
		});

        final Button aButton = factory.createButton(new HtmlText("<i><u>FIX</u></i>"));

        final TextField inputField = factory.createTextField();
        inputField.setValue("initial");

        final Button anOtherButton = factory.createButton(new FormattedText(localizedRepository.getDynamic("patterntext"), "fix", 12.34d));
        
        final Button langSwitcherButton = factory.createButton(localizedRepository.getDynamic("switchlang"));
        langSwitcherButton.on(Event.Type.ACTION, new EventListener() {
            
            @Override
            public void occured(Event event) {
            	localizedRepository.setLocale(localizedRepository.getLocale().equals(hu) ? en : hu);
            	if (window != null) {
            	    window.refresh();
            	} else {
            	    wrapperContainer.refresh();
            	}
            }
            
        });
        
        final FreeContainer centerContainer = factory.createFreeContainer();
        centerContainer.add(inputField, new Metrics(25, 25));

        topPanel.add(topLabel);
        topPanel.add(topButton1);
        topPanel.add(topButton2);
        topPanel.add(topCounterButton);
        
        wrapperContainer.addTop(topPanel);
        wrapperContainer.addLeft(aButton);
        wrapperContainer.addCenter(centerContainer);
        wrapperContainer.addRight(anOtherButton);
        wrapperContainer.addBottom(langSwitcherButton);
        
        if (window != null) {
            window.open();
        }
    }
	
}
