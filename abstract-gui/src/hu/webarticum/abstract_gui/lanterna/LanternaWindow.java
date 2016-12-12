package hu.webarticum.abstract_gui.lanterna;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;
import hu.webarticum.abstract_gui.framework.Window;

public class LanternaWindow extends AbstractLanternaEnvironmentMember implements Window {

    private TextualContent titleContent;
    
    static private Map<LanternaEnvironment, MultiWindowTextGUI> sharedGuis = new HashMap<LanternaEnvironment, MultiWindowTextGUI>();
    
    private boolean isAttachedToScreen = false;
    
    private BasicWindow basicWindow = null;
    
    private LanternaPanel rootPanel;
    
    LanternaWindow(LanternaEnvironment environment, String title) {
        this(environment, new PlainContent(title));
    }
    
    LanternaWindow(LanternaEnvironment environment, TextualContent titleContent) {
        super(environment);
        
        this.titleContent = titleContent;
        rootPanel = environment.getFactory().createPanel();
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
                basicWindow = getNativeWindow();
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

    @Override
    public void refresh() {
        basicWindow.setTitle(titleContent.toString());
        rootPanel.refresh();
    }
    
    public BasicWindow getNativeWindow() {
        if (basicWindow == null) {
            basicWindow = new BasicWindow(titleContent.toString());
            basicWindow.setComponent(rootPanel.getNativeComponent());
        }
        return basicWindow;
    }

}
