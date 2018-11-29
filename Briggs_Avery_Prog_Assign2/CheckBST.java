/*
*	CS2383
*	Programming Assignment 2
*   Nov 2018
*	Question 3
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to determine
*   whether a given binary tree
*   is also a binary search tree.
*   Program is set to check two
*   different pre-determined
*   trees.
*/

public class CheckBST{

    public static int[] orderA; // integer arrays capture visit output for each tree
    public static int[] orderB;
    public static Node[] treeA; // Node arrays hold the nodes for each tree
    public static Node[] treeB;
    public static Node rootA;   // roots for each tree
    public static Node rootB;
    public static int count;    // used for printing counter
    public static int n;        // keeps track of array size (number of array nodes)
    public static boolean whichTree; // 0 == tree A, 1 == tree B
    
    private static class Node{
        int iD;
        int data;
        Node parent;
        Node left;
        Node right;
    }

    public static void main(String[] args){
        int[] arrA = {12, 10, 19, 13, 15, 14, 18};
        int[] arrB = {13, 10, 19, 12, 15, 14, 18};
        whichTree = true;
        boolean isTreeABST = check_bst(arrA);
        System.out.println("Is Tree A a BST: " + isTreeABST);
        whichTree = false;
        boolean isTreeBBST = check_bst(arrB);
        System.out.println("Is Tree B a BST: " + isTreeBBST + "\n");
        whichTree = true;
        printArr(orderA);
        whichTree = false;
        printArr(orderB);
    }

    // check_bst is of O(n) because, only one loop can execute
    // per call, due to the condition, and the call to inOrder
    // is of O(n + m). Since they are called sequentially, the
    // total complexitiy is of O(n).
    public static boolean check_bst(int[] arr){
        n = arr.length;
        int i, min;
        if(whichTree){
            orderA = new int[n];
            treeA = initTreeA(arr);
            System.out.println("\narrA InOrder:");
            inOrder(rootA);
            min = orderA[0]; 
            for(i = 0; i < n; i++){
                if(min > orderA[i]){
                    return false;
                }
                min = orderA[i];
            }
        }
        else{
            orderB = new int[n];
            treeB = initTreeB(arr);
            System.out.println("\narrB InOrder:");
            inOrder(rootB);
            min = orderB[0]; 
            for(i = 0; i < n; i++){
                if(min > orderB[i]){
                    return false;
                }
                min = orderB[i];
            }
        }
        return true;
    }

    // Prints the contents of an array
    public static void printArr(int[] arr){
        int i;
        System.out.print("Array { ");
        for(i = 0; i < n; i++){
            System.out.print(arr[i] + ((i < n - 1)? ",":"") + " ");
        }
        System.out.println("}");
    }

    // Prints the data of a node and stores the value to the trees corresponding array 
    public static void visit(Node node, int i){
        if(count == 0){
            System.out.print("\t{ ");
        }
        System.out.print(node.data + ((i < n - 1)? ",":"") + " ");
        if(whichTree){
            orderA[i] = node.data;
        }
        else{
            orderB[i] = node.data;
        }
        if(count == n - 1){
            System.out.println("}");
            count = 0;
        }
        else{
            count++;
        }
    }

    public static void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            visit(node, count);
            inOrder(node.right);
        }
    }

    // Tree is hard coded using previous knowledge of how
    // it is supposed to be structured.
    public static Node[] initTreeA(int[] arr){
        int i;
        Node[] tree = new Node[n];
        Node node;
        for(i = 0; i < n; i++){
            node = new Node();
            node.data = arr[i];
            tree[i] = node;
        }
        tree[0].data = arr[0];
        tree[1].data = arr[1];
        tree[2].data = arr[2];
        tree[3].data = arr[3];
        tree[4].data = arr[4];
        tree[5].data = arr[5];
        tree[6].data = arr[6];

        tree[0].parent = null;
        tree[0].left = tree[1];
        tree[0].right = tree[2];

        tree[1].parent = tree[0];
        tree[1].left = null;
        tree[1].right = tree[3];

        tree[2].parent = tree[0];
        tree[2].left = tree[4];
        tree[2].right = null;
        
        tree[3].parent = tree[1];
        tree[3].left = null;
        tree[3].right = null;

        tree[4].parent = tree[2];
        tree[4].left = tree[5];
        tree[4].right = tree[6];

        tree[5].parent = tree[4];
        tree[5].left = null;
        tree[5].right = null;

        tree[6].parent = tree[4];
        tree[6].left = null;
        tree[6].right = null;

        rootA = tree[0];
        return tree;   
    }

    // Tree is hard coded using previous knowledge of how
    // it is supposed to be structured.
    public static Node[] initTreeB(int[] arr){
        int i;
        Node[] tree = new Node[n];
        Node node;
        for(i = 0; i < n; i++){
            node = new Node();
            node.data = arr[i];
            tree[i] = node;
        }
        tree[0].data = arr[0];
        tree[1].data = arr[1];
        tree[2].data = arr[2];
        tree[3].data = arr[3];
        tree[4].data = arr[4];
        tree[5].data = arr[5];
        tree[6].data = arr[6];

        tree[0].parent = null;
        tree[0].left = tree[1];
        tree[0].right = tree[2];

        tree[1].parent = tree[0];
        tree[1].left = null;
        tree[1].right = tree[3];

        tree[2].parent = tree[0];
        tree[2].left = tree[4];
        tree[2].right = null;
        
        tree[3].parent = tree[1];
        tree[3].left = null;
        tree[3].right = null;

        tree[4].parent = tree[2];
        tree[4].left = tree[5];
        tree[4].right = tree[6];

        tree[5].parent = tree[4];
        tree[5].left = null;
        tree[5].right = null;

        tree[6].parent = tree[4];
        tree[6].left = null;
        tree[6].right = null;

        rootB = tree[0];
        return tree;   
    }
}