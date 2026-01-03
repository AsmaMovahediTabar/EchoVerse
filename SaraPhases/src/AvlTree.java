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
    
    public Node rightRotate(Node y){
        Node x = y.left;
        Node rightSubTreeOfx = x.right;
        x.right = y;
        y.left = rightSubTreeOfx;
        y.height = Math.max(height(y.left) , height(y.right)) + 1;
        x.height = Math.max(height(x.left) , height(x.right)) + 1;
        return x;
    }
    
    public Node leftRotate(Node y){
        Node x = y.right;
        Node leftSubTreeOfx = x.left;
        x.left = y;
        y.right = leftSubTreeOfx;
        y.height = Math.max(height(y.left) , height(y.right)) + 1;
        x.height = Math.max(height(x.left) , height(x.right)) + 1;
        return x;
    }
    
    public Node insert(Node node , int channelID){
        if(node == null){return new Node(channelID);}
        if(channelID > node.chanelIDE){
            node.right = insert(node.right , channelID);
        }
        else if(channelID < node.chanelIDE){
            node.left = insert(node.left , channelID);
        }
        else{  return node;}
        node.height = 1 + Math.max(height(node.left) , height(node.right));
        int balance = balanced(node);
        if (balance > 1 && channelID < node.left.chanelIDE) {
           return rightRotate(node);
        }
        if (balance < -1 && channelID > node.right.chanelIDE) {
            return leftRotate(node);
        }
        if (balance > 1 && channelID > node.left.chanelIDE) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && channelID < node.right.chanelIDE) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
    public void insert(int channelID){
        root = insert(root , channelID);
    }
}
