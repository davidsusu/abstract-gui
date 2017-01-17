package hu.webarticum.abstract_gui.framework;

import java.util.Arrays;
import java.util.Iterator;

/**
 * A clearable view of a character array
 * 
 * @author David Horvath
 */

public class SecureString implements CharSequence {
    
    private final char[] characters;
    
    private final int start;
    
    private final int length;

    public SecureString(Iterator<Character> iterator) {
        this(iterateCharacters(iterator));
    }

    public SecureString(char[] characters) {
        this(characters, 0, characters.length);
    }
    
    public SecureString(char[] characters, int start, int length) {
        this.characters = characters;
        this.start = start;
        this.length = length;
    }
    
    private static char[] iterateCharacters(Iterator<Character> iterator) {
        final int BUFFER_CAPACITY = 10;
        char[] characters = new char[0];
        char[] buffer = new char[BUFFER_CAPACITY];
        int bufferSize = 0;
        while (iterator.hasNext()) {
            buffer[bufferSize] = iterator.next();
            bufferSize++;
            if (bufferSize == BUFFER_CAPACITY) {
                characters = moveBuffer(characters, buffer, bufferSize);
                bufferSize = 0;
            }
        }
        if (bufferSize > 0) {
            characters = moveBuffer(characters, buffer, bufferSize);
        }
        return characters;
    }
    
    private static char[] moveBuffer(char[] characters, char[] buffer, int bufferSize) {
        char[] result = Arrays.copyOf(characters, characters.length + bufferSize);
        for (int i = 0; i < bufferSize; i++) {
            result[characters.length + i] = buffer[i];
        }
        Arrays.fill(characters, ' ');
        Arrays.fill(buffer, 0, bufferSize, ' ');
        return result;
    }
    
    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        return characters[start + index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new SecureString(characters, this.start + start, end - start);
    }
    
    @Override
    public String toString() {
        return "@secure";
    }
    
    public void clear() {
        Arrays.fill(characters, start, start + length, ' ');
    }
    
    @Override
    protected void finalize() throws Throwable {
        clear();
        super.finalize();
    }
    
}
