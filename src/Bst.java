
import java.util.ArrayList;
import java.util.List;


public class Bst<Tip extends Comparable> implements Seznam<Tip> {

    

    class ElementBST {

        public Tip value;
        public ElementBST left, right;

        public ElementBST(Tip e) {
            this(e, null, null);
        }

        public ElementBST(Tip e, ElementBST lt, ElementBST rt) {
            value = e;
            left = lt;
            right = rt;
        }
    }

    ElementBST rootNode;
    private Tip minNodeValue;

    public Bst() {
        rootNode = null;
    }

    private boolean member(Tip e) {
        return member(e, rootNode);
    }

    private boolean member(Tip e, ElementBST node) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.value) == 0) {
            return true;
        } else if (e.compareTo(node.value) < 0) {
            return member(e, node.left);
        } else {
            return member(e, node.right);
        }
    }

    private void insert(Tip e) {
        rootNode = insertLeaf(e, rootNode);
    }

    private void delete(Tip e) {
        rootNode = delete(e, rootNode);
    }

    private ElementBST insertLeaf(Tip e, ElementBST node) {
        if (node == null) {
            node = new ElementBST(e);
        } else if (e.compareTo(node.value) < 0) {
            node.left = insertLeaf(e, node.left);
        } else if (e.compareTo(node.value) > 0) {
            node.right = insertLeaf(e, node.right);
        } else {
            throw new java.lang.IllegalArgumentException(); //element ze obstaja
        }
        return node;
    }

    // TO DO
    private ElementBST delete(Tip e, ElementBST node) {
        int c = e.compareTo(node.value);
        //System.out.printf(e+"<<e  node>> "+node.value+"\n");
        if(c==0){            
            if(node.right == null && node.left==null){
                node = null;
            }
            else if(node.right != null && node.left!=null){
                deleteMin(node.right);
                node.value = minNodeValue;
            }
            else if(node.left == null){
                node = node.right;
            }    
            else{
                node = node.left;
            }
                
        }
        else if(c<0){//levo
            node.left = delete(e,node.left);
        }
        else{
            //System.out.println("I was here");
            node.right = delete(e,node.right);
            
        }
        return node;
    }

    private ElementBST deleteMin(ElementBST node) {
        if(node.left != null){
            return deleteMin(node.left);
        }
        minNodeValue = node.value;
        delete(minNodeValue, rootNode);
        return node;
    }

    private int getDepth(ElementBST node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    private int countNodes(ElementBST node) {
        if (node == null) {
            return 0;
        }
        int i = 1 + countNodes(node.left) + countNodes(node.right);
        return i;
    }

    @Override
    public void add(Tip e) {
        insert(e);
    }

    @Override
    public Tip removeFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Tip el = rootNode.value;
        delete(rootNode.value);
        return el;
    }

    @Override
    public Tip getFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return rootNode.value;
    }

    @Override
    public int size() {
        int i = countNodes(rootNode);
        return i;
    }

    @Override
    public int depth() {
        return getDepth(rootNode);
    }

    @Override
    public boolean isEmpty() {
        return (rootNode == null);
    }

    @Override
    public Tip remove(Tip e) {
        if (!this.exists(e)) {
            throw new java.util.NoSuchElementException();
        } else {
            delete(e);
        }
        return e;
    }

    @Override
    public boolean exists(Tip e) {
        return member(e);
    }
    
        @Override
    public List<Tip> asList() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return inorder(rootNode);
    }
    
    private List<Tip> inorder(ElementBST node){
        List<Tip> list = new ArrayList<Tip>();
        if(node.left != null){
            list.addAll(inorder(node.left));
        }
        list.add(node.value);
        if(node.right != null){
            list.addAll(inorder(node.right));
        }
        return list;
        
    }
    
    /*@Override
    public void print() {
        print(rootNode, 0);
    }
    private void print(ElementBST node, int numTabs) {
        if (node == null)
        return;
        print(node.right, numTabs+1);
        for (int i = 0; i < numTabs; i++)
            System.out.print('\t');
        
        System.out.println(node.value);
        print(node.left, numTabs + 1);
    }
*/}
