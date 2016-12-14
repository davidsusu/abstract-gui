package hu.webarticum.abstract_gui.swing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.SwingUtilities;

import hu.webarticum.abstract_gui.framework.Environment;

public class SwingEnvironment implements Environment {
    
    private SwingFactory factory = null;
    
    public SwingFactory getFactory() {
        if (factory == null) {
            factory = new SwingFactory(this);
        }
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
        } catch(ClassNotFoundException e) {
            return false;
        } catch(NoSuchMethodException e) {
            return false;
        } catch(InvocationTargetException e) {
            return false;
        } catch(IllegalAccessException e) {
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
