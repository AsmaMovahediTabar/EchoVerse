package src.phase1;

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
        if(channelID > node.channelID){
            node.right = insert(node.right , channelID);
        }
        else if(channelID < node.channelID){
            node.left = insert(node.left , channelID);
        }
        else{return node;}
        node.height = 1 + Math.max(height(node.left) , height(node.right));
        int balance = balanced(node);
        if (balance > 1 && channelID < node.left.channelID) {
            return rightRotate(node);
        }
        if (balance < -1 && channelID > node.right.channelID) {
            return leftRotate(node);
        }
        if (balance > 1 && channelID > node.left.channelID) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && channelID < node.right.channelID) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void insert(int channelID){
        root = insert(root , channelID);
    }

    public boolean search(Node node , int channelID){
        if(node == null){return false;}
        if(channelID == node.channelID){return true;}
        if(channelID > node.channelID){return search(node.right , channelID);}
        return search(node.left , channelID);
    }

    public boolean search(int channelID){
        return search(root , channelID);
    }

    public Node minValueNodeInRightSubtree(Node node){
        Node cur = node;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }

    public Node delete(Node node , int channelID){
        if(node == null){return node;}
        if(channelID > node.channelID){node.right = delete(node.right , channelID);}
        else if(channelID < node.channelID){node.left = delete(node.left , channelID);}
        else{
            if(node.left == null || node.right == null){
                Node temp = (node.left != null) ? node.left : node.right;
                return temp;
            }
            else{
                Node temp = minValueNodeInRightSubtree(node.right);
                node.channelID = temp.channelID;
                node.right = delete(node.right , temp.channelID);
            }
        }
        if(node == null){return node;}
        node.height = 1 + Math.max(height(node.left) , height(node.right));
        int balance = balanced(node);
        if (balance > 1 && balanced(node.left) >= 0){
            return rightRotate(node);
        }
        if (balance > 1 && balanced(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && balanced(node.right) <= 0)
            return leftRotate(node);
        if (balance < -1 && balanced(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(int channelID){
        root = delete(root , channelID);
    }
    
    public void disPlay(){
        if(root == null){
            System.out.println("Is empty!");
            return;
        }
        disPlay(root);
    }
    
    public void disPlay(Node node){
        if (node == null) {
            return;
        }
        if(node.left == null && node.right == null){
            return;
        }
        System.out.print(node.channelID + " ");
        if (node.left != null) {
            System.out.print(node.left.channelID);
        } else {
            System.out.print("-1");
        }
        System.out.print(",");

        if (node.right != null) {
            System.out.print(node.right.channelID);
        } else {
            System.out.print("-1");
        }
        System.out.println();
        disPlay(node.left);
        disPlay(node.right);
    }
}
