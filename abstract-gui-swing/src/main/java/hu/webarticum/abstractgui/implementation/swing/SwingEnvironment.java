package hu.webarticum.abstractgui.implementation.swing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.SwingUtilities;

import hu.webarticum.abstractgui.core.framework.Environment;

public class SwingEnvironment implements Environment {
    
    private final SwingFactory factory = new SwingFactory(this);
    
    public SwingFactory getFactory() {
        return factory;
    }
    
    @Override
    public boolean isAvailable() {
        try {
            Class.forName("javax.swing.JComponent");
            
            Class<?> graphicsClass = Class.forName("java.awt.GraphicsEnvironment");
            Method method = graphicsClass.getMethod("isHeadless");
            Object result = method.invoke(null);
            if (!(result instanceof Boolean)) {
                return false;
            }
            if ((boolean)(Boolean)result) {
                return false;
            }
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (InvocationTargetException e) {
            return false;
        } catch (IllegalAccessException e) {
            return false;
        }
        return true;
    }
    
    @Override
    public int getPriority() {
        return PRIORITY_NORMAL;
    }

    @Override
    public void invokeLater(Runnable runnable) {
        SwingUtilities.invokeLater(runnable);
    }

    @Override
    public void invokeAndWait(Runnable runnable) throws InterruptedException {
        try {
            SwingUtilities.invokeAndWait(runnable);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
}
