package hu.webarticum.abstract_gui.framework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainContent implements TextualContent {
    
    private final String text;
    
    private String html = null;
    
    public PlainContent(String text) {
        this.text = text;
    }
    
    @Override
    public String toHtml() {
        if (html == null) {
            html = textToHtml(text);
        }
        return html;
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    @Override
    public boolean isPlain() {
        return true;
    }
    
    public static String textToHtml(String text) {
        StringBuffer htmlBuilder = new StringBuffer();
        Pattern pattern = Pattern.compile("  +|[&<>\"]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String token = matcher.group();
            char tokenChar = token.charAt(0);
            String replacement;
            switch (tokenChar) {
                case ' ': replacement = generateSpaces(token.length()); break;
                case '&': replacement = "&amp;"; break;
                case '<': replacement = "&lt;"; break;
                case '>': replacement = "&gt;"; break;
                case '"': replacement = "&quot;"; break;
                default: replacement = token;
            }
            matcher.appendReplacement(htmlBuilder, replacement);
        }
        matcher.appendTail(htmlBuilder);
        return htmlBuilder.toString();
    }
    
    private static String generateSpaces(int length) {
        StringBuilder resultBuilder = new StringBuilder(" ");
        int repeats = (length - 1) / 2;
        if (length - (repeats * 2) > 1) {
            resultBuilder.append("&nbsp;");
        }
        for (int i = 0; i < repeats; i++) {
            resultBuilder.append("&nbsp; ");
        }
        return resultBuilder.toString();
    }
    
}
