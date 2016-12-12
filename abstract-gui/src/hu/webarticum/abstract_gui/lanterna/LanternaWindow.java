package hu.webarticum.abstract_gui.lanterna;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.Composite;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import hu.webarticum.abstract_gui.framework.Window;

public class LanternaWindow extends AbstractLanternaComponent implements Window {
    
    static private Map<LanternaEnvironment, MultiWindowTextGUI> sharedGuis = new HashMap<LanternaEnvironment, MultiWindowTextGUI>();
    
    private boolean isAttachedToScreen = false;
    
    private final BasicWindow basicWindow;
    
    private LanternaPanel rootPanel;
    
    LanternaWindow(LanternaEnvironment environment, String title) {
        super(environment);
        
        basicWindow = new BasicWindow(title);
        rootPanel = environment.getFactory().createPanel();
        basicWindow.setComponent(rootPanel.getNativeComponent());
    }
    
    @Override
    public void open() {
        if (!isAttachedToScreen) {
            LanternaEnvironment environment = getEnvironment();
            MultiWindowTextGUI gui;
            if (sharedGuis.containsKey(environment)) {
                gui = sharedGuis.get(environment);
            } else {
                Screen screen;
                try {
                    screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                try {
                    screen.startScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
                sharedGuis.put(environment, gui);
            }
            
            // XXX
            gui.addWindowAndWait(basicWindow);
            
            isAttachedToScreen = true;
        } else {
            basicWindow.setVisible(true);
        }
    }

    @Override
    public LanternaPanel getRootPanel() {
        return rootPanel;
    }

    // XXX
    @Override
    public Component getNativeComponent() {
        return null;
    }
    
    public Composite getNativeComposite() {
        return basicWindow;
    }

}
