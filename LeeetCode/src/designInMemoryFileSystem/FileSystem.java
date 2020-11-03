package designInMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {
    TrieNode root;

    public FileSystem() {
        root = new TrieNode("");
    }

    public List<String> ls(String path) {
        return findNode(path).getList();
    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }

    private TrieNode findNode(String path) {
        String[] files = path.split("/");
        TrieNode current = root;
        for (String file : files) {
            if (file.isEmpty()) continue;
            current.children.putIfAbsent(file, new TrieNode(file));
            current = current.children.get(file);
        }
        return current;
    }


    class TrieNode {
        Map<String, TrieNode> children;
        StringBuilder file;
        String name;

        String getContent() {
            return file.toString();
        }

        void addContent(String content) {
            file.append(content);
        }

        boolean isFile() {
            return file.length() > 0;
        }

        List<String> getList() {
            List<String> output = new ArrayList<>();
            if (isFile()) {
                output.add(name);
            } else {
                output.addAll(children.keySet());
            }
            return output;
        }

        TrieNode(String name) {
            this.name = name;
            file = new StringBuilder();
            children = new TreeMap<>();
        }
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
//        fs.ls("/");
//        fs.mkdir("/a/b/c");
//        fs.addContentToFile("/a/b/c/d", "hello");
//        System.out.println(fs.ls("/"));
//        System.out.println(fs.readContentFromFile("/a/b/c/d"));

        fs.mkdir("/zijzllb");

    }

    /*
    ["FileSystem","mkdir","ls","ls","mkdir","ls","ls","addContentToFile","readContentFromFile","ls","readContentFromFile"]
[[],["/zijzllb"],["/"],["/zijzllb"],["/r"],["/"],["/r"],["/zijzllb/hfktg","d"],["/zijzllb/hfktg"],["/"],["/zijzllb/hfktg"]]
     */
}
