package io.github.furstenheim.util;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

// Methods missing from jsoup
public class NodeUtils {
    public static boolean isNodeType1 (Node element) {
        return element instanceof Element;
    }
    public static boolean isNodeType3 (@NotNull Node element) {
        return element.nodeName().equals("text") || element.nodeName().equals("#text");
    }
    // CDATA section node
    public static boolean isNodeType4 (Node element) {
        return false;
    }
}
