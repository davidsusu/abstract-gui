package hu.webarticum.abstract_gui;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.EnvironmentDetector;
import hu.webarticum.abstract_gui.framework.Event;
import hu.webarticum.abstract_gui.framework.EventListener;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.HtmlContent;
import hu.webarticum.abstract_gui.framework.Label;
import hu.webarticum.abstract_gui.framework.Panel;
import hu.webarticum.abstract_gui.framework.TextField;

import java.util.Locale;

import hu.webarticum.abstract_gui.framework.BorderLayout;
import hu.webarticum.abstract_gui.framework.Button;
import hu.webarticum.abstract_gui.framework.Window;
import hu.webarticum.abstract_gui.framework.i18n.AbstractTextRepository;
import hu.webarticum.abstract_gui.framework.i18n.FormatHtmlContent;

public class Main {
    
    public static void main(String[] args) {
        final TestTextRepository textRepository = new TestTextRepository();
        
        final Environment environment = EnvironmentDetector.getDefaultEnvironment();
        final Factory factory = environment.getFactory();
        final Window window = factory.createWindow(textRepository.createMlPlainContent("windowtitle"));
        final Panel panel = window.getRootPanel();
        
        final Label topLabel = factory.createLabel(textRepository.createMlPlainContent("toplabel"));
        
        final Button aButton = factory.createButton(new HtmlContent("<i><u>FIX</u></i>"));

        final TextField inputField = factory.createTextField();
        inputField.setValue("initial");
        
        final Button anOtherButton = factory.createButton(new FormatHtmlContent(textRepository.createMlHtmlContent("patterntext"), "fix"));
        
        final Button langSwitcherButton = factory.createButton(textRepository.createMlHtmlContent("switchlang"));
        langSwitcherButton.on("click", new EventListener() {
            
            @Override
            public void occured(Event event) {
                textRepository.setLocale(new Locale(textRepository.getLocale().toString().equalsIgnoreCase("hu_HU") ? "en_US" : "hu_HU"));
                window.refresh();
            }
            
        });

        panel.add(topLabel, BorderLayout.AREA_TOP);
        panel.add(aButton, BorderLayout.AREA_LEFT);
        panel.add(inputField, BorderLayout.AREA_CENTER);
        panel.add(anOtherButton, BorderLayout.AREA_RIGHT);
        panel.add(langSwitcherButton, BorderLayout.AREA_BOTTOM);
        
        window.open();
    }
    
    private static class TestTextRepository extends AbstractTextRepository {
        
        private Locale locale = new Locale("hu_HU");
        
        @Override
        public String getText(Object key) {
            if (locale.toString().equalsIgnoreCase("hu_HU")) {
                if (key.equals("windowtitle")) {
                    return "Tesztablak";
                } else if (key.equals("toplabel")) {
                    return "Felső szöveg";
                } else if (key.equals("patterntext")) {
                    return "HU (<u>%s</u>)";
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
                } else if (key.equals("patterntext")) {
                    return "EN (<u>%s</u>)";
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
