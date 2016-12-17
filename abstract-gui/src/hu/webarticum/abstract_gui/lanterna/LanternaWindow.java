package hu.webarticum.abstract_gui.lanterna;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;

import hu.webarticum.abstract_gui.framework.PlainContent;
import hu.webarticum.abstract_gui.framework.TextualContent;
import hu.webarticum.abstract_gui.framework.Window;

public class LanternaWindow extends AbstractLanternaEnvironmentMember implements Window {

    private TextualContent titleContent;
    
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
            MultiWindowTextGUI gui = getEnvironment().getGui();
            basicWindow = getNativeWindow();
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
