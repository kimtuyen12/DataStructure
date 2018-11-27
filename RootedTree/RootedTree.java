package assignment3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RootedTree {

    private final String PADDING_STRING = "0-";
    public TreeNode<String> root = null;
    

    public RootedTree(TreeNode<String> node) {
            this();
            root = node;
            node.parent = null;
    }

    public RootedTree(String filename) throws IOException {
            this();
            load(filename);
    }

    public RootedTree() {

    }

    public void save(String filename) throws IOException {
            LineWriter writer = new LineWriter();
            writer.open(filename);
            recursiveSave(writer, "", root);
            writer.close();
    }

    private void recursiveSave(LineWriter writer, String padding, TreeNode<String> current) {
            if(current != null) {
                    writer.println(padding + current.element.toString());
                    for(TreeNode<String> child : current.children) {
                            recursiveSave(writer, padding + PADDING_STRING, child);
                    }
            }
    }

    public void load(String filename) throws IOException {
            LineReader reader = new LineReader();
            reader.open(filename);
            root = new TreeNode<String>(reader.next());
            loadRecursively(reader, root, 0);
            reader.close();
    }

    private void loadRecursively(LineReader reader, TreeNode<String> current, int level) throws IOException {
            while(reader.hasNext()) {
                    String line = reader.peek();

                    String[] split = line.split(PADDING_STRING);
                    int newLevel = split.length - 1;
                    String newString = split[newLevel];

                    if(newLevel > level + 1 || newLevel <= 0) {
                            throw new IOException("Invalid data format.");
                    }
                    else if(newLevel == level + 1) {
                            TreeNode<String> node = new TreeNode<String>(newString);
                            current.addChild(node);
                            reader.next();
                            loadRecursively(reader, node, newLevel);
                    }
                    else {
                            return;
                    }
            }
    }

    // Problem 2 (15 pts): Fill in the getLeafNodes method.  This method should return
    // a list consisting of all of the leaf nodes in the rooted tree.
    // Note: You are allowed to add helper methods and use recursion.
    public List<TreeNode<String>> getLeafNodes(){
        List<TreeNode<String>> leafNodes = new ArrayList<TreeNode<String>>();
        recursiveLeafNode(leafNodes,root);
        return leafNodes;
    }

    public void recursiveLeafNode (List<TreeNode<String>> leafNodes, TreeNode<String> currentNode){
        if (currentNode.children.isEmpty()){
            leafNodes.add(currentNode);
        } else {
            for (TreeNode<String> temp: currentNode.children ){
                recursiveLeafNode(leafNodes,temp);
            }
        }
    }

    // Problem 3 (20 pts): Fill in the getAncestry method.  This method should return
    // a list that represents a path of nodes from a node whose label is equal to 
    // element to the root node.
    // Note: You are allowed to add helper methods, use recursion, and use the 
    // SimpleStack class.
    public List<TreeNode<String>> getAncestry(String element){
        List<TreeNode<String>> listAncestry = new ArrayList<TreeNode<String>>();
        findAncestor(listAncestry, root, element);
        return listAncestry;
    }
    
    public void findAncestor (List<TreeNode<String>> listAncestry, TreeNode<String> currentNode, String element){
        currentNode = findNode(currentNode, element);
        if(currentNode != null){
            listAncestry.add(currentNode);
            while (currentNode != root){
                currentNode = currentNode.parent;
                listAncestry.add(currentNode);
            }
        }
    }
    
    public TreeNode<String> findNode (TreeNode<String> currentNode, String element){
        if (currentNode.toString().equals(element)){
            return currentNode;
        } else {
            for(TreeNode<String> child : currentNode.children){
                TreeNode<String> resultNode = findNode(child, element);
                if (resultNode != null){
                    return resultNode;
                }
            }
        }
        return null;
    }
    
}
