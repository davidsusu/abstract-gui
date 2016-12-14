package hu.webarticum.abstract_gui;

import hu.webarticum.abstract_gui.framework.Environment;
import hu.webarticum.abstract_gui.framework.EnvironmentDetector;
import hu.webarticum.abstract_gui.framework.Factory;
import hu.webarticum.abstract_gui.framework.HtmlContent;
import hu.webarticum.abstract_gui.framework.Panel;

import java.util.Locale;

import hu.webarticum.abstract_gui.framework.ActionListener;
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
        final Window window = factory.createWindow(textRepository.createMlPlainContent("w1"));
        final Panel panel = window.getRootPanel();
        
        final Button button1 = factory.createButton(textRepository.createMlPlainContent("t1"));
        final Button button2 = factory.createButton(textRepository.createMlPlainContent("t2"));
        final Button button3 = factory.createButton(new HtmlContent("<i><u>FIX</u></i>"));
        final Button button4 = factory.createButton(new FormatHtmlContent(textRepository.createMlHtmlContent("h1"), "fix"));
        final Button button5 = factory.createButton(textRepository.createMlHtmlContent("h2"));
        
        button5.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed() {
                textRepository.setLocale(new Locale(textRepository.getLocale().toString().equalsIgnoreCase("hu_HU") ? "en_US" : "hu_HU"));
                window.refresh();
            }
            
        });

        panel.add(button1, BorderLayout.AREA_TOP);
        panel.add(button2, BorderLayout.AREA_LEFT);
        panel.add(button3, BorderLayout.AREA_CENTER);
        panel.add(button4, BorderLayout.AREA_RIGHT);
        panel.add(button5, BorderLayout.AREA_BOTTOM);
        
        window.open();
    }
    
    private static class TestTextRepository extends AbstractTextRepository {
        
        private Locale locale = new Locale("hu_HU");
        
        @Override
        public String getText(Object key) {
            if (locale.toString().equalsIgnoreCase("hu_HU")) {
                if (key.equals("w1")) {
                    return "Tesztablak";
                } else if (key.equals("t1")) {
                    return "Első";
                } else if (key.equals("t2")) {
                    return "Második";
                } else if (key.equals("h1")) {
                    return "HU (<u>%s</u>)";
                } else if (key.equals("h2")) {
                    return "<i>Nyelv váltása</i>";
                } else {
                    return "";
                }
            } else {
                if (key.equals("w1")) {
                    return "Test window";
                } else if (key.equals("t1")) {
                    return "First";
                } else if (key.equals("t2")) {
                    return "Second";
                } else if (key.equals("h1")) {
                    return "EN (<u>%s</u>)";
                } else if (key.equals("h2")) {
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
