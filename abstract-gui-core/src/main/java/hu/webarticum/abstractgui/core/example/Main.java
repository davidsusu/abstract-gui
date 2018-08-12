package hu.webarticum.abstractgui.core.example;

import java.util.Locale;

import hu.webarticum.abstractgui.core.framework.BorderLayout;
import hu.webarticum.abstractgui.core.framework.Button;
import hu.webarticum.abstractgui.core.framework.Environment;
import hu.webarticum.abstractgui.core.framework.EnvironmentDetector;
import hu.webarticum.abstractgui.core.framework.Event;
import hu.webarticum.abstractgui.core.framework.EventListener;
import hu.webarticum.abstractgui.core.framework.Factory;
import hu.webarticum.abstractgui.core.framework.HtmlContent;
import hu.webarticum.abstractgui.core.framework.Label;
import hu.webarticum.abstractgui.core.framework.LinearLayout;
import hu.webarticum.abstractgui.core.framework.Metrics;
import hu.webarticum.abstractgui.core.framework.Panel;
import hu.webarticum.abstractgui.core.framework.TextField;
import hu.webarticum.abstractgui.core.framework.Window;
import hu.webarticum.abstractgui.core.framework.i18n.AbstractTextRepository;

public class Main {
    
    public static void main(String[] args) {
        final TestTextRepository textRepository = new TestTextRepository();
        
        final Environment environment = EnvironmentDetector.getDefaultEnvironment();
        final Factory factory = environment.getFactory();
        final Window window = factory.createWindow(textRepository.createMlPlainContent("windowtitle"));
        final Panel panel = window.getRootPanel();
        
        final Panel topPanel = factory.createPanel();
        topPanel.setLayout(factory.createLinearLayout(LinearLayout.Direction.VERTICAL));
        
        final Label topLabel = factory.createLabel(textRepository.createMlPlainContent("toplabel"));
        final Button topButton1 = factory.createButton(textRepository.createMlPlainContent("topbutton1"));
        final Button topButton2 = factory.createButton(textRepository.createMlPlainContent("topbutton2"));
        
        final Button aButton = factory.createButton(new HtmlContent("<i><u>FIX</u></i>"));

        final TextField inputField = factory.createTextField();
        inputField.setValue("initial");
        
        final Button anOtherButton = factory.createButton(textRepository.createFormatHtmlContent(textRepository.createMlHtmlContent("patterntext"), "fix", 12.34d));
        
        final Button langSwitcherButton = factory.createButton(textRepository.createMlHtmlContent("switchlang"));
        langSwitcherButton.on(Event.Type.ACTION, new EventListener() {
            
            @Override
            public void occured(Event event) {
                textRepository.setLocale(new Locale(textRepository.getLocale().toString().equalsIgnoreCase("hu") ? "en_US" : "hu"));
                window.refresh();
            }
            
        });
        
        final Panel centerPanel = factory.createPanel(factory.createAbsoluteLayout());
        centerPanel.add(inputField, new Metrics(25, 25));

        topPanel.add(topLabel);
        topPanel.add(topButton1);
        topPanel.add(topButton2);
        
        panel.add(topPanel, BorderLayout.Location.TOP);
        panel.add(aButton, BorderLayout.Location.LEFT);
        panel.add(centerPanel, BorderLayout.Location.CENTER);
        panel.add(anOtherButton, BorderLayout.Location.RIGHT);
        panel.add(langSwitcherButton, BorderLayout.Location.BOTTOM);
        
        window.open();
    }
    
    private static class TestTextRepository extends AbstractTextRepository {

        private Locale locale = new Locale("hu");
        
        @Override
        public String getText(Object key) {
            if (locale.toString().equalsIgnoreCase("hu")) {
                if (key.equals("windowtitle")) {
                    return "Tesztablak";
                } else if (key.equals("toplabel")) {
                    return "Felső szöveg";
                } else if (key.equals("topbutton1")) {
                    return "Felső gomb 1";
                } else if (key.equals("topbutton2")) {
                    return "Felső gomb 2";
                } else if (key.equals("patterntext")) {
                    return "HU (<u>%s</u>) (%.2f)";
                } else if (key.equals("switchlang")) {
                    return "<i>Nyelv váltása</i>";
                } else {
                    return "";
                }
            } else {
                if (key.equals("windowtitle")) {
                    return "Test window";
                } else if (key.equals("toplabel")) {
                    return "Top label";
                } else if (key.equals("topbutton1")) {
                    return "Top button 1";
                } else if (key.equals("topbutton2")) {
                    return "Top button 2";
                } else if (key.equals("patterntext")) {
                    return "EN (<u>%s</u>) (%.2f)";
                } else if (key.equals("switchlang")) {
                    return "<i>Switch language</i>";
                } else {
                    return "";
                }
            }
        }

        @Override
        public Locale getLocale() {
            return locale;
        }

        @Override
        public void setLocale(Locale locale) {
            this.locale = locale;
        }
        
    }
    
}