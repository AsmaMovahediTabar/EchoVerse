package src;

public class AvlTree {
    private Node root;
    
    public int height(Node node){
        if(node == null){return -1;}
        return node.height;
    }
    
    public int balanced(Node node){
        if(node == null){return -1;}
        return height(node.left) - height(node.right);
    }
}
