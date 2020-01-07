
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabina
 * @param <Tip>
 */
public class Drevo23 <Tip extends Comparable> implements Seznam<Tip>{


    class Element23 {

        public Object[] values;
        public int el;
        public ArrayList<Element23> childs;
        public Element23 parent;

        public Element23(Tip e) {            
            this(e,null);
        }
        public Element23(Tip e,Element23 parent) {
            values = new Object[3];
            childs = new ArrayList<>();
            this.el = 0;
            addValue(e);
            
            this.parent = parent;
        }

        public void addValue(Tip e){
            
            this.values[this.el] = e;
            this.el++;
            for (int i = 0; i < this.el ; i++) {
                Tip t = (Tip)this.values[i];
                for (int j = i+1; j < this.el; j++) {
                    if(t.compareTo(this.values[j]) > 0){
                        Tip tmp =(Tip) this.values[i];
                        this.values[i] = this.values[j];                                
                        this.values[j] = tmp;
                    }
                }
            }
        }
        
        public Tip removeValue(int i){
            
          
            Tip e = (Tip) this.values[i];
            this.values[i] = null;
            this.el--;
            int c = 0;
            for (int j = 0; j < 3; j++) {
                if(this.values[j] != null && c!=j){
                    this.values[c] = this.values[j];
                    this.values[j] = null;
                    c++;
                }
                else if(this.values[j] != null){
                    c++;
                }
            }
            
            return e;
        }
        public int elNum(){
            return this.el;
        }
        public Tip leftValue(){
            return (Tip)this.values[0];
        }
        public Tip rightValue(){
            return (Tip)this.values[1];
        }
    }
    int size=0;
    int depth=0;
    Element23 rootNode;
    
    public Drevo23() {
        rootNode = null;
    }
    public void insert(Tip e){
        if(rootNode == null){
            rootNode = new Element23(e);
            this.size++;
        }
        else{
           insert(e,rootNode,rootNode.parent);
           this.size++;
        }
        
    }
    public Element23 insert(Tip e,Element23 node,Element23 nodeParent){
        for (int i = 0; i < node.elNum(); i++) {
            if( e.compareTo(node.values[i]) == 0){
                throw new java.util.NoSuchElementException();
            }            
        }
        if(node.childs.size() == 3){
            if(e.compareTo(node.leftValue()) < 0){
                insert(e,node.childs.get(0),node);
            }
            else if(e.compareTo(node.leftValue()) > 0 && e.compareTo(node.rightValue()) < 0){
                insert(e,node.childs.get(1),node);
            }
            else{
                insert(e,node.childs.get(2),node);
            }

        }
        else if(node.childs.size() == 2){
            if(e.compareTo(node.leftValue()) < 0){
                insert(e,node.childs.get(0),node);
            } 
            else{
                insert(e,node.childs.get(1),node);
            }
        }
        
        else{
            node.addValue(e);
            if(node.elNum() > 2){
                if(leftRotation(node, nodeParent));
                else if(rightRotation(node, nodeParent));
                else{
                    fixStructure(node, nodeParent);
                }
            }
        }
        
        return node;
    }
    public boolean leftRotation(Element23 node, Element23 nodeParent){
        if(nodeParent == null){
            return false;
        }
        else if(nodeParent.childs.size() == 3){
            //if middle child exists and it has less then 2 elements
            if(nodeParent.childs.get(2) == node){
                if(nodeParent.childs.get(1).elNum() < 2){
                    //remove most right element of parent and add it to middle
                    nodeParent.childs.get(1).addValue(nodeParent.removeValue(nodeParent.elNum()-1));
                    //remove most left element and add it to parent
                    nodeParent.addValue(node.removeValue(0));
                    
                    return true;
                }
                return false;
            }
            else if(nodeParent.childs.get(1) == node){
                if(nodeParent.childs.get(0).elNum() < 2){
                    //remove most left element of parent and add it to left
                    nodeParent.childs.get(0).addValue(nodeParent.removeValue(0));
                    //remove most left element and add it to parent
                    nodeParent.addValue(node.removeValue(0));
                    
                    return true;
                }
            }
        }
        else if(nodeParent.childs.size() == 2){
            if(nodeParent.childs.get(0).elNum() < 2){
                    //remove most left element of parent and add it to left
                    nodeParent.childs.get(0).addValue(nodeParent.removeValue(0));
                    //remove most left element and add it to parent
                    nodeParent.addValue(node.removeValue(0));
                    
                    return true;
            }
        }
        return false;
        
    }
    public boolean rightRotation(Element23 node, Element23 nodeParent){
        if(nodeParent == null){
            return false;
        }
        else if(nodeParent.childs.size() == 3){
        
            //if middle child exists and it has less then 2 elements
            if(nodeParent.childs.get(0) == node){            
                if(nodeParent.childs.get(1).elNum() < 2){
                    //remove most left element of parent and add it to middle
                    nodeParent.childs.get(1).addValue(nodeParent.removeValue(0));
                    //remove most right element and add it to parent
                    nodeParent.addValue(node.removeValue(node.elNum()-1));
                    
                    return true;
                }
                
            }
            else if(nodeParent.childs.get(1) == node){            
                if(nodeParent.childs.get(2).elNum() < 2){
                    //remove most left element of parent and add it to middle
                    nodeParent.childs.get(2).addValue(nodeParent.removeValue(nodeParent.elNum()-1));
                    //remove most right element and add it to parent
                    nodeParent.addValue(node.removeValue(node.elNum()-1));
                    
                    return true;
                }
            }
        }
        else if(nodeParent.childs.size() == 2){        
            if(nodeParent.childs.get(1).elNum() < 2){
                    //remove most right element of parent and add it to right
                    nodeParent.childs.get(1).addValue(nodeParent.removeValue(nodeParent.elNum()-1));
                    //remove most right element and add it to parent
                    nodeParent.addValue(node.removeValue(node.elNum()-1));
                    
                    return true;
            }
        }
        return false;
    }
    public Element23 fixStructure(Element23 node, Element23 nodeParent){
        if(nodeParent == null){
            this.depth++;
            nodeParent = new Element23(node.removeValue(1));
            nodeParent.childs.add(0,new Element23(node.removeValue(0),nodeParent));
            nodeParent.childs.add(1,new Element23(node.removeValue(0),nodeParent));
            if(node.childs.size() == 4){
                nodeParent.childs.get(0).childs.add(node.childs.get(0));
                nodeParent.childs.get(0).childs.add(node.childs.get(1));
                nodeParent.childs.get(1).childs.add(node.childs.get(2));
                nodeParent.childs.get(1).childs.add(node.childs.get(3));
            }            
            
            rootNode = nodeParent;
            return rootNode;
            
        }
        else if(nodeParent.elNum() == 1){
            nodeParent.addValue(node.removeValue(1));
            if(nodeParent.childs.get(0) == node){
                nodeParent.childs.add(0,new Element23(node.removeValue(0),nodeParent));
                if(node.childs.size() == 4){
                    
                    nodeParent.childs.get(0).childs.add(node.childs.get(0));
                    nodeParent.childs.get(0).childs.add(node.childs.get(1));
                    node.childs.remove(0);
                    node.childs.remove(0);
                    
                    //nodeParent.childs.get(1).childs.clear();
                }
            }
            else{
                nodeParent.childs.add(1,new Element23(node.removeValue(0),nodeParent)); 
                if(node.childs.size() == 4){
                    
                    nodeParent.childs.get(1).childs.add(node.childs.get(0));
                    nodeParent.childs.get(1).childs.add(node.childs.get(1));
                    node.childs.remove(0);
                    node.childs.remove(0);
                    //nodeParent.childs.get(2).childs.clear();
                }
                
                
                
            }
            return nodeParent;
        }
        else if(nodeParent.elNum() == 2){
            
            nodeParent.addValue(node.removeValue(1));            
            if(nodeParent.childs.get(0) == node){
                nodeParent.childs.add(0,new Element23(node.removeValue(0),nodeParent));               
                
                if(node.childs.size() == 4){
                    
                    nodeParent.childs.get(0).childs.add(node.childs.get(0));
                    nodeParent.childs.get(0).childs.add(node.childs.get(1));
                    node.childs.remove(0);
                    node.childs.remove(0);
                }
            }
            else if(nodeParent.childs.get(1) == node){                
                nodeParent.childs.add(1,new Element23(node.removeValue(0),nodeParent));                            
                
                if(node.childs.size() == 4){
                    
                    nodeParent.childs.get(1).childs.add(node.childs.get(0));
                    nodeParent.childs.get(1).childs.add(node.childs.get(1));
                    node.childs.remove(0);
                    node.childs.remove(0);
                }
            }
            else if(nodeParent.childs.get(2) == node){                
                nodeParent.childs.add(2,new Element23(node.removeValue(0),nodeParent));
               
                if(node.childs.size() == 4){                    
                    nodeParent.childs.get(2).childs.add(node.childs.get(0));
                    nodeParent.childs.get(2).childs.add(node.childs.get(1));
                    node.childs.remove(0);
                    node.childs.remove(0);
                }
            }
            fixStructure(nodeParent,nodeParent.parent);
            
            
        }
        return nodeParent;
    }
    
    @Override
    public void add(Tip e) {
        insert(e);
    }
    
    public Tip delete(Tip e, Element23 node){
        for (int i = 0; i < node.elNum(); i++) {
            if( e.compareTo(node.values[i]) == 0){
                Tip tmp = (Tip) node.values[i];
                node.removeValue(i);
                this.size--;
                if(node.childs.size() < 0){
                   if(node.elNum() == 0){
                        if(delLeftRotation(node, node.parent));
                        else if(delRightRotation(node, node.parent));                        
                    }
                }
                
                
                return tmp;
            }            
        }
        if(node.childs.size() == 3){
            if(e.compareTo(node.leftValue()) < 0){
                delete(e,node.childs.get(0));
            }
            else if(e.compareTo(node.leftValue()) > 0 && e.compareTo(node.rightValue()) < 0){
                delete(e,node.childs.get(1));
            }
            else if(e.compareTo(node.rightValue()) > 0){
                delete(e,node.childs.get(2));
            }
        }
        else if(node.childs.size() == 2){
            if(e.compareTo(node.leftValue()) < 0){
                delete(e,node.childs.get(0));
            } 
            else if(e.compareTo(node.leftValue()) > 0){
                delete(e,node.childs.get(1));
            }
            
        }
        else{
            return null;
        }
        return null;
    }
    
    
    
    public boolean delLeftRotation(Element23 node, Element23 nodeParent){
        if(nodeParent == null){
            return false;
        }
        else if(nodeParent.childs.size() == 3){
            
            if(nodeParent.childs.get(2) == node){
                if(nodeParent.childs.get(1).elNum() > 1){
                    //remove most right element of parent and add it to middle
                    node.addValue(nodeParent.removeValue(nodeParent.elNum()-1));
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(1).removeValue(0));
                    
                    return true;
                }
                return false;
            }
            else if(nodeParent.childs.get(1) == node){
                if(nodeParent.childs.get(0).elNum() > 1){
                    //remove most left element of parent and add it to left
                    node.addValue(nodeParent.removeValue(0));
                    
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(0).removeValue(nodeParent.elNum()-1));                    
                    
                    return true;
                }
            }
        }
        else if(nodeParent.childs.size() == 2){
            if(nodeParent.childs.get(0).elNum() > 1){
                    //remove most left element of parent and add it to left
                    node.addValue(nodeParent.removeValue(nodeParent.elNum()-1));
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(1).removeValue(0));
                    
                    return true;
            }
        }
        return false;
    }
    
    
    public boolean delRightRotation(Element23 node, Element23 nodeParent){
        if(nodeParent == null){
            return false;
        }
        else if(nodeParent.childs.size() == 3){
            
            if(nodeParent.childs.get(0) == node){
                if(nodeParent.childs.get(1).elNum() > 1){
                    //remove most right element of parent and add it to middle
                    node.addValue(nodeParent.removeValue(0));
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(1).removeValue(0));
                    
                    return true;
                }
                return false;
            }
            else if(nodeParent.childs.get(1) == node){
                if(nodeParent.childs.get(2).elNum() > 1){
                    //remove most left element of parent and add it to left
                    node.addValue(nodeParent.removeValue(node.elNum()-1));
                    
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(2).removeValue(0));                    
                    
                    return true;
                }
            }
        }
        else if(nodeParent.childs.size() == 2){
            if(nodeParent.childs.get(1).elNum() > 1){
                    //remove most left element of parent and add it to left
                    node.addValue(nodeParent.removeValue(0));
                    //remove most left element and add it to parent
                    nodeParent.addValue(nodeParent.childs.get(1).removeValue(0));
                    
                    return true;
            }
        }
        return false;
    }
    
    public Tip search(Tip e, Element23 node){
        for (int i = 0; i < node.elNum(); i++) {
            if( e.compareTo(node.values[i]) == 0){                
                return (Tip)node.values[i];
            }            
        }
        if(node.childs.size() == 3){
            if(e.compareTo(node.leftValue()) < 0){
                return search(e,node.childs.get(0));
            }
            else if(e.compareTo(node.leftValue()) > 0 && e.compareTo(node.rightValue()) < 0){
                return search(e,node.childs.get(1));
            }
            else if(e.compareTo(node.rightValue()) > 0){
                return search(e,node.childs.get(2));
            }
        }
        else if(node.childs.size() == 2){
            if(e.compareTo(node.leftValue()) < 0){
                return search(e,node.childs.get(0));
            } 
            else if(e.compareTo(node.leftValue()) > 0){
                return search(e,node.childs.get(1));
            }
            
        }
        return null;
    }
    
    
    public List<Tip> preOrder(Element23 node){
        List<Tip> list = new ArrayList<Tip>();
        for (int i = 0; i < node.elNum(); i++) {
            list.add((Tip)node.values[i]);
        }
        if(node.childs.size() > 1){
            if(node.childs.get(0) != null){
                list.addAll(preOrder(node.childs.get(0)));
            } 
            if(node.childs.get(1) != null){
                list.addAll(preOrder(node.childs.get(1)));
            } 
            if(node.childs.size() == 3){
                list.addAll(preOrder(node.childs.get(2)));
            }
        }
        return list;
        
        
    }
    @Override
    public Tip removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return delete((Tip)rootNode.values[0],rootNode);
        
    }

    @Override
    public Tip getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return (Tip)rootNode.values[0];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int depth() {
        return this.depth;
    }

    @Override
    public boolean isEmpty() {        
        return (rootNode == null);
    }

    @Override
    public Tip remove(Tip e) {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return delete(e,rootNode);
    }

    @Override
    public boolean exists(Tip e) {
        Tip tmp = search(e,rootNode);
        if(tmp!=null)
            return true;
        return false;
         
    }

    @Override
    public List<Tip> asList() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return preOrder(rootNode);
    }
    
}
