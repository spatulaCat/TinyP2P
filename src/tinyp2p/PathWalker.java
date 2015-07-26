package tinyp2p;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author (._.)
 */
import java.io.PrintStream;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class PathWalker {
    public static class Node {
        private final Map<String, Node> children = new TreeMap<>();

        public Node getChild(String name) {
            if (children.containsKey(name))
                return children.get(name);
            Node result = new Node();
            children.put(name, result);
            return result;
        }

        public Map<String, Node> getChildren() {
            return Collections.unmodifiableMap(children);
        }
    }

    private final Node root = new Node();

    private static final Pattern PATH_SEPARATOR = Pattern.compile("\\\\");
    public void addPath(String path) {
        String[] names = PATH_SEPARATOR.split(path);
        Node node = root;
        for (String name : names)
            node = node.getChild(name);
    }

    private static void printHtml(Node node, PrintStream out) {
        Map<String, Node> children = node.getChildren();
        if (children.isEmpty())
            return;
        out.println("<ul>");
        for (Map.Entry<String, Node> child : children.entrySet()) {
            out.print("<li>");
            out.print(child.getKey());
            printHtml(child.getValue(), out);
            out.println("</li>");
        }
        out.println("</ul>");
    }

    public void printHtml(PrintStream out) {
        printHtml(root, out);
    }

    public static void main(String[] args) {
        PathWalker self = new PathWalker();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine())
            self.addPath(scanner.nextLine());
        self.printHtml(System.out);
    }
}