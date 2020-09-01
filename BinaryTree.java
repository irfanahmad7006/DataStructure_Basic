import java.util.LinkedList;
import java.util.Queue;
/* Node Structure

  public class Node {
    Node left; //Left_Reference
    int data; //Data
    Node right; //Right_Reference

    Node(int value) { //Defining Constructor
        this.data = value; //Storing the value in the current node

        left = null; // Although it is not required, this for understanding purpose as in java both left & right variable will intialized with null by default.

        right = null; // Although it is not required, this for understanding purpose as in java both left & right variable will intialized with null by default.
    }
}

*/


public class BinaryTree {

    public static void main(String agrs[]) {
        //The below line of codes is to make you visualise, how binary tree is made.

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
/* This is how a tree would look like

						1
					    /       \
					   2	     3
					  / \       / \
					 4   5	   6   7


*/
        System.out.println("printInorder ====>");
        printInorder(root); //This will print out in inorder form.
        // printInorder Output : 4,2,5,1,6,3,7
        System.out.println("\nprintPreorder ====>");
        printPreorder(root); //This will print out in pre-order form.
        // printInorder Output : 1,2,4,5,3,6,7
        System.out.println("\nprintPostorder ====>");
        printPostorder(root); //This will print out in Postorder form. (left right root)
        // printInorder Output : 4,5,2,6,7,3,1
        System.out.println("\nprintLevel ====>");
        printLevel(root,0,1); //This will print specific level.
        // printLevel Output : 4,5,6,7
        System.out.println("\nprintLevelBasic ====>");
        printLevelOrderBasic(root);
        // printLevelBasic Output : 1,2,3,4,5,6,7

        System.out.println("\nprintLevelOrderInOneLine ====>");
        levelOrderTraversal(root);


    }

    static void printInorder(Node node) { //Time: O(n) Space:O(height of tree)
        //This method will print out in inorder form.
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data +",");
        printInorder(node.right);
    }

    static void printPreorder(Node node) { //Time: O(n) Space:O(height of tree)
        //This method will print out in pre order form.
        if (node == null) {
            return;
        }
        System.out.print(node.data +",");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    static void printPostorder(Node node) { //Time: O(n) Space:O(height of tree)
        //This method will print out in post order form.
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data +",");
    }

    static int findHeightOfTree(Node node) { //Time: O(n)
        //This method will return the heigh of the tree, it will count number of longest linked path
        if (node == null) {
            return -1; //this could be 0, if considering the number of nodes as longest path
        }
        int leftHeight = findHeightOfTree(node.left);
        int rightHeight = findHeightOfTree(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void printLevel(Node node, int level, int desiredLevel) { //Time: O(n)
        //This method will print the desired level
        if (node == null) {
            return;
        }
        if (level == desiredLevel) {
            System.out.print(" " + node.data + "=>");
        }

        printLevel(node.left, level + 1, desiredLevel);
        printLevel(node.right, level + 1, desiredLevel);
    }

    static void printLevelOrderBasic(Node node) { //Time: O(n2)
        int h = findHeightOfTree(node);
        for (int i = 0; i <= h; i++) {
            printLevel(node, 0, i);
        }
    }

    static void levelOrderTraversal(Node node){ //Time: O(n) as we will visit every node Space:O(n) as every node will be stored in queue
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node nodePop = queue.poll();
            System.out.print(nodePop.data+"->");
            if(nodePop.left != null){
                queue.add(nodePop.left);
            }
            if(nodePop.right != null){
                queue.add(nodePop.right);
            }
        }
    }





}
