package hu.webarticum.abstractgui.core.util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {

    static HashMap<String, String> replacements = new HashMap<String, String>();
    static {
        replacements.put("quot", "\"");
        replacements.put("amp", "&");
        replacements.put("lt", "<");
        replacements.put("gt", ">");
        replacements.put("nbsp", " ");
        replacements.put("iexcl", "\u00A1");
        replacements.put("cent", "\u00A2");
        replacements.put("pound", "\u00A3");
        replacements.put("curren", "\u00A4");
        replacements.put("yen", "\u00A5");
        replacements.put("brvbar", "\u00A6");
        replacements.put("sect", "\u00A7");
        replacements.put("uml", "\u00A8");
        replacements.put("copy", "\u00A9");
        replacements.put("ordf", "\u00AA");
        replacements.put("laquo", "\u00AB");
        replacements.put("not", "\u00AC");
        replacements.put("shy", "\u00AD");
        replacements.put("reg", "\u00AE");
        replacements.put("macr", "\u00AF");
        replacements.put("deg", "\u00B0");
        replacements.put("plusmn", "\u00B1");
        replacements.put("sup2", "\u00B2");
        replacements.put("sup3", "\u00B3");
        replacements.put("acute", "\u00B4");
        replacements.put("micro", "\u00B5");
        replacements.put("para", "\u00B6");
        replacements.put("middot", "\u00B7");
        replacements.put("cedil", "\u00B8");
        replacements.put("sup1", "\u00B9");
        replacements.put("ordm", "\u00BA");
        replacements.put("raquo", "\u00BB");
        replacements.put("frac14", "\u00BC");
        replacements.put("frac12", "\u00BD");
        replacements.put("frac34", "\u00BE");
        replacements.put("iquest", "\u00BF");
        replacements.put("Agrave", "\u00C0");
        replacements.put("Aacute", "\u00C1");
        replacements.put("Acirc", "\u00C2");
        replacements.put("Atilde", "\u00C3");
        replacements.put("Auml", "\u00C4");
        replacements.put("Aring", "\u00C5");
        replacements.put("AElig", "\u00C6");
        replacements.put("Ccedil", "\u00C7");
        replacements.put("Egrave", "\u00C8");
        replacements.put("Eacute", "\u00C9");
        replacements.put("Ecirc", "\u00CA");
        replacements.put("Euml", "\u00CB");
        replacements.put("Igrave", "\u00CC");
        replacements.put("Iacute", "\u00CD");
        replacements.put("Icirc", "\u00CE");
        replacements.put("Iuml", "\u00CF");
        replacements.put("ETH", "\u00D0");
        replacements.put("Ntilde", "\u00D1");
        replacements.put("Ograve", "\u00D2");
        replacements.put("Oacute", "\u00D3");
        replacements.put("Ocirc", "\u00D4");
        replacements.put("Otilde", "\u00D5");
        replacements.put("Ouml", "\u00D6");
        replacements.put("times", "\u00D7");
        replacements.put("Oslash", "\u00D8");
        replacements.put("Ugrave", "\u00D9");
        replacements.put("Uacute", "\u00DA");
        replacements.put("Ucirc", "\u00DB");
        replacements.put("Uuml", "\u00DC");
        replacements.put("Yacute", "\u00DD");
        replacements.put("THORN", "\u00DE");
        replacements.put("szlig", "\u00DF");
        replacements.put("agrave", "\u00E0");
        replacements.put("aacute", "\u00E1");
        replacements.put("acirc", "\u00E2");
        replacements.put("atilde", "\u00E3");
        replacements.put("auml", "\u00E4");
        replacements.put("aring", "\u00E5");
        replacements.put("aelig", "\u00E6");
        replacements.put("ccedil", "\u00E7");
        replacements.put("egrave", "\u00E8");
        replacements.put("eacute", "\u00E9");
        replacements.put("ecirc", "\u00EA");
        replacements.put("euml", "\u00EB");
        replacements.put("igrave", "\u00EC");
        replacements.put("iacute", "\u00ED");
        replacements.put("icirc", "\u00EE");
        replacements.put("iuml", "\u00EF");
        replacements.put("eth", "\u00F0");
        replacements.put("ntilde", "\u00F1");
        replacements.put("ograve", "\u00F2");
        replacements.put("oacute", "\u00F3");
        replacements.put("ocirc", "\u00F4");
        replacements.put("otilde", "\u00F5");
        replacements.put("ouml", "\u00F6");
        replacements.put("divide", "\u00F7");
        replacements.put("oslash", "\u00F8");
        replacements.put("ugrave", "\u00F9");
        replacements.put("uacute", "\u00FA");
        replacements.put("ucirc", "\u00FB");
        replacements.put("uuml", "\u00FC");
        replacements.put("yacute", "\u00FD");
        replacements.put("thorn", "\u00FE");
        replacements.put("yuml", "\u00FF");
        replacements.put("Alpha", "\u0391");
        replacements.put("Beta", "\u0392");
        replacements.put("Gamma", "\u0393");
        replacements.put("Delta", "\u0394");
        replacements.put("Epsilon", "\u0395");
        replacements.put("Zeta", "\u0396");
        replacements.put("Eta", "\u0397");
        replacements.put("Theta", "\u0398");
        replacements.put("Iota", "\u0399");
        replacements.put("Kappa", "\u039A");
        replacements.put("Lambda", "\u039B");
        replacements.put("Mu", "\u039C");
        replacements.put("Nu", "\u039D");
        replacements.put("Xi", "\u039E");
        replacements.put("Omicron", "\u039F");
        replacements.put("Pi", "\u03A0");
        replacements.put("Rho", "\u03A1");
        replacements.put("Sigma", "\u03A3");
        replacements.put("Tau", "\u03A4");
        replacements.put("Upsilon", "\u03A5");
        replacements.put("Phi", "\u03A6");
        replacements.put("Chi", "\u03A7");
        replacements.put("Psi", "\u03A8");
        replacements.put("Omega", "\u03A9");
        replacements.put("alpha", "\u03B1");
        replacements.put("beta", "\u03B2");
        replacements.put("gamma", "\u03B3");
        replacements.put("delta", "\u03B4");
        replacements.put("epsilon", "\u03B5");
        replacements.put("zeta", "\u03B6");
        replacements.put("eta", "\u03B7");
        replacements.put("theta", "\u03B8");
        replacements.put("iota", "\u03B9");
        replacements.put("kappa", "\u03BA");
        replacements.put("lambda", "\u03BB");
        replacements.put("mu", "\u03BC");
        replacements.put("nu", "\u03BD");
        replacements.put("xi", "\u03BE");
        replacements.put("omicron", "\u03BF");
        replacements.put("pi", "\u03C0");
        replacements.put("rho", "\u03C1");
        replacements.put("sigmaf", "\u03C2");
        replacements.put("sigma", "\u03C3");
        replacements.put("tau", "\u03C4");
        replacements.put("upsilon", "\u03C5");
        replacements.put("phi", "\u03C6");
        replacements.put("chi", "\u03C7");
        replacements.put("psi", "\u03C8");
        replacements.put("omega", "\u03C9");
        replacements.put("thetasym", "\u03D1");
        replacements.put("upsih", "\u03D2");
        replacements.put("piv", "\u03D6");
        replacements.put("bull", "\u2022");
        replacements.put("hellip", "\u2026");
        replacements.put("prime", "\u2032");
        replacements.put("Prime", "\u2033");
        replacements.put("oline", "\u203E");
        replacements.put("frasl", "\u2044");
        replacements.put("weierp", "\u2118");
        replacements.put("image", "\u2111");
        replacements.put("real", "\u211C");
        replacements.put("trade", "\u2122");
        replacements.put("alefsym", "\u2135");
        replacements.put("larr", "\u2190");
        replacements.put("uarr", "\u2191");
        replacements.put("rarr", "\u2192");
        replacements.put("darr", "\u2193");
        replacements.put("harr", "\u2194");
        replacements.put("crarr", "\u21B5");
        replacements.put("lArr", "\u21D0");
        replacements.put("uArr", "\u21D1");
        replacements.put("rArr", "\u21D2");
        replacements.put("dArr", "\u21D3");
        replacements.put("hArr", "\u21D4");
        replacements.put("forall", "\u2200");
        replacements.put("part", "\u2202");
        replacements.put("exist", "\u2203");
        replacements.put("empty", "\u2205");
        replacements.put("nabla", "\u2207");
        replacements.put("isin", "\u2208");
        replacements.put("notin", "\u2209");
        replacements.put("ni", "\u220B");
        replacements.put("prod", "\u220F");
        replacements.put("sum", "\u2211");
        replacements.put("minus", "\u2212");
        replacements.put("lowast", "\u2217");
        replacements.put("radic", "\u221A");
        replacements.put("prop", "\u221D");
        replacements.put("infin", "\u221E");
        replacements.put("ang", "\u2220");
        replacements.put("and", "\u2227");
        replacements.put("or", "\u2228");
        replacements.put("cap", "\u2229");
        replacements.put("cup", "\u222A");
        replacements.put("int", "\u222B");
        replacements.put("there4", "\u2234");
        replacements.put("sim", "\u223C");
        replacements.put("cong", "\u2245");
        replacements.put("asymp", "\u2248");
        replacements.put("ne", "\u2260");
        replacements.put("equiv", "\u2261");
        replacements.put("le", "\u2264");
        replacements.put("ge", "\u2265");
        replacements.put("sub", "\u2282");
        replacements.put("sup", "\u2283");
        replacements.put("nsub", "\u2284");
        replacements.put("sube", "\u2286");
        replacements.put("supe", "\u2287");
        replacements.put("oplus", "\u2295");
        replacements.put("otimes", "\u2297");
        replacements.put("perp", "\u22A5");
        replacements.put("sdot", "\u22C5");
        replacements.put("lceil", "\u2308");
        replacements.put("rceil", "\u2309");
        replacements.put("lfloor", "\u230A");
        replacements.put("rfloor", "\u230B");
        replacements.put("lang", "\u2329");
        replacements.put("rang", "\u232A");
        replacements.put("loz", "\u25CA");
        replacements.put("spades", "\u2660");
        replacements.put("clubs", "\u2663");
        replacements.put("hearts", "\u2665");
        replacements.put("diams", "\u2666");
        replacements.put("OElig", "\u0152");
        replacements.put("oelig", "\u0153");
        replacements.put("Scaron", "\u0160");
        replacements.put("scaron", "\u0161");
        replacements.put("Yuml", "\u0178");
        replacements.put("circ", "\u02C6");
        replacements.put("tilde", "\u02DC");
        replacements.put("ensp", "\u2002");
        replacements.put("emsp", "\u2003");
        replacements.put("thinsp", "\u2009");
        replacements.put("zwnj", "\u200C");
        replacements.put("zwj", "\u200D");
        replacements.put("lrm", "\u200E");
        replacements.put("rlm", "\u200F");
        replacements.put("ndash", "\u2013");
        replacements.put("mdash", "\u2014");
        replacements.put("lsquo", "\u2018");
        replacements.put("rsquo", "\u2019");
        replacements.put("sbquo", "\u201A");
        replacements.put("ldquo", "\u201C");
        replacements.put("rdquo", "\u201D");
        replacements.put("bdquo", "\u201E");
        replacements.put("dagger", "\u2020");
        replacements.put("Dagger", "\u2021");
        replacements.put("permil", "\u2030");
        replacements.put("lsaquo", "\u2039");
        replacements.put("rsaquo", "\u203A");
        replacements.put("euro", "\u20AC");
    }
    
    public static String htmlToPlain(String html) {
        StringBuffer textBuilder = new StringBuffer();
        Pattern pattern = Pattern.compile("(\\s+)|(&(?:(\\w+)|#(\\d+)|#x([a-fA-F0-9]+));)|(<!--.*?-->)|(<(/)?([\\w\\-:]+)\\b([^>\"]|\"[^\"]*\"|'[^']*')*>)");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String whiteSpaceToken = matcher.group(1);
            String entityToken = matcher.group(2);
            String commentToken = matcher.group(6);
            String tagToken = matcher.group(7);
            String replacement;
            if (whiteSpaceToken != null) {
                replacement = " ";
            } else if (entityToken != null) {
                String entityName = matcher.group(3);
                String entityDecimal = matcher.group(4);
                String entityHexa = matcher.group(5);
                if (entityName != null) {
                    if (replacements.containsKey(entityName)) {
                        replacement = replacements.get(entityName);
                    } else {
                        replacement = entityToken;
                    }
                } else if (entityDecimal != null) {
                    replacement = Character.toString((char)Integer.parseInt(entityDecimal));
                } else {
                    replacement = Character.toString((char)Integer.parseInt(entityHexa, 16));
                }
            } else if (commentToken != null) {
                replacement = "";
            } else if (tagToken != null) {
                boolean isCloseTag = (matcher.group(8) != null);
                String tagName = matcher.group(9);
                if (isCloseTag) {
                    if (tagName.equals("p") || tagName.equals("div") || tagName.equals("blockquote")) {
                        replacement = "\n";
                    } else {
                        replacement = "";
                    }
                } else {
                    if (tagName.equals("p") || tagName.equals("div") || tagName.equals("blockquote")) {
                        replacement = "\n";
                    } else if (tagName.equals("br")) {
                        replacement = "\n";
                    } else if (tagName.equals("hr")) {
                        replacement = "\n\n-------\n\n";
                    } else {
                        replacement = "";
                    }
                }
            } else {
                replacement = "";
            }
            matcher.appendReplacement(textBuilder, replacement);
        }
        matcher.appendTail(textBuilder);
        return textBuilder.toString();
    }
    
    public static String plainToHtml(String text) {
        StringBuffer htmlBuilder = new StringBuffer();
        Pattern pattern = Pattern.compile("  +|[&<>\"]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String token = matcher.group();
            char tokenChar = token.charAt(0);
            String replacement;
            switch (tokenChar) {
                case ' ': replacement = generateHtmlSpaces(token.length()); break;
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
    
    public static String generateHtmlSpaces(int length) {
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
