package DM10BinarySearchTree.Assignment1;

class Node<K, V>{
    Node<K,V> left;
    K key;
    V value;
    Node<K,V> right;

    Node(K k, V v){
        this.key = k;
        this.value = v;
    }
}

public class BST<Key extends Comparable<Key>, Value>{
    Node<Key,Value> root;

    boolean contains(Node<Key, Value> r, Key k){
        if(r == null)
            return false;
        else if(r.key.compareTo(k) == 0)
            return true;
        else
            return contains(r.left, k) || contains(r.right, k);
    }

    private Node<Key, Value> insert(Node<Key, Value> r, Key k, Value v){
        if(contains(r, k)){
            if(r.key.compareTo(k) == 0)
                r.value = v;
            else if (k.compareTo(r.key) > 0)
                r.right = insert(r.right, k, v);
            else
                r.left = insert(r.left, k, v);
            return r;
        }
        else {
            if (r == null)
                r = new Node<>(k, v);
            else if (k.compareTo(r.key) > 0)
                r.right = insert(r.right, k, v);
            else
                r.left = insert(r.left, k, v);
            return r;
        }
    }
    void put(Key key, Value value){
        if(root == null)
            root = new Node<>(key,value);
        else
            insert(root, key, value);
    }

    boolean isEmpty(){
        return root==null;
    }
    Value temp = null;
    private Value get(Node<Key, Value> r, Key key){

        if(r != null) {
            if(key.compareTo(r.key) == 0) {
                temp = r.value;
                return temp;
            }
            get(r.left, key);
            get(r.right, key);
        }
        return temp;
    }

    Value get(Key key){
        return get(root, key);
    }

    private Key minNode(Node<Key, Value> r){
        if(r != null) {
            if (r.left == null)
                return r.key;
            else
                return minNode(r.left);
        }
        return null;
    }

    private Key maxNode(Node<Key, Value> r){
        if(r!=null) {
            if (r.right == null)
                return r.key;
            else
                return maxNode(r.right);
        }
        return null;
    }

    Key min(){
        return minNode(root);
    }

    Key max(){
        return maxNode(root);
    }
    Key k_temp = null;
    private void floor(Node <Key,Value> r,Key key){
        if(r != null) {
            floor(r.left, key);
            if (r.key.compareTo(key) <= 0)
                k_temp = r.key;
            floor(r.right, key);
        }
    }

    private void ceiling(Node <Key,Value> r, Key key){
        if(r != null){
            ceiling(r.left, key);
            if(r.key.compareTo(key) >= 0) {
                k_temp = r.key;
                return;
            }
            ceiling(r.right, key);
        }
    }

    Key floor(Key key){
        floor(root,key);
        return k_temp;
    }

    Key ceiling(Key key){
        ceiling(root, key);
        return k_temp;
    }
    boolean flag = false;
    int position = 0;
    private Key select(Node<Key, Value> r, int pos){
        if(r != null){
            select(r.left, position);
            if(position == 0) {
                if (!flag) {
                    //System.out.println(r.value);
                    k_temp = r.key;
                    flag = true;
                }
            }
            else
                position--;
            select(r.right, position);
        }
        return null;
    }
    Key select(int pos){
        position = pos;
        select(root, pos);
        return k_temp;
    }

    private void delete(Node<Key,Value> r, Key key, Node<Key, Value> p){
        if(r != null){
            if(r.key.compareTo(key)==0){
                if(r.left == null && r.right == null){
                    if(p == r){
                        root = null;
                        return;
                    }
                    if(p.left == r)
                        p.left = null;
                    else if(p.right == r)
                        p.right = null;
                }
                else if(r.left == null || r.right == null){
                    if(p == r){
                        if(r.right != null){
                            root = r.right;
                            p.right = null;
                            p = null;
                        }
                        else {
                            root = r.left;
                            p.left = null;
                            p = null;
                        }
                        //return;
                    }
                    else if(r.right != null){
                        if(p.left == r)
                            p.left = r.right;
                        else if(p.right == r)
                            p.right = r.right;
                    }
                    else{
                        if(p.left == r)
                            p.left = r.left;
                        else if(p.right == r)
                            p.right = r.left;
                    }
                }
                else{
                    Key temp = minNode(r.right); // or you can take temp = max(r.left)
                    r.key = temp;
                    delete(r.right, temp, r); // deleting the duplicate by bringing it to either 1 or 2 case.
                }
            }
            delete(r.left, key, r);
            delete(r.right, key, r);
        }
    }

    void delete(Key key){
        delete(root, key, root);
    }

    private void deleteMax(Node<Key,Value> r){
        if(r.right == null) {
            delete(r.key);
            return;
        }
        deleteMax(r.right);
    }

    private void deleteMin(Node<Key,Value> r){
        if(r.left == null) {
            delete(r.key);
            return;
        }
        deleteMin(r.left);
    }

    void deleteMax(){
        deleteMax(root);
    }

    void deleteMin(){
        deleteMin(root);
    }

    void inorderTraversal(Node<Key, Value> r){
        if(r != null){
            inorderTraversal(r.left);
            System.out.println(r.key);
            inorderTraversal(r.right);
        }
    }
    public static void main(String[] args){
        BST<Book,Integer> bst = new BST<Book,Integer>();
        bst.put(new Book("IT","Viswas",400.0),2);
        bst.put(new Book("Harry","JK",600.0),1);
        bst.put(new Book("Street","Kiran",800.0),6);
        System.out.println(bst.isEmpty());
        System.out.println(bst.get(new Book("IT","Viswas",400.0)));
        //System.out.println(bst.floor(new Book("IT","Viswas",400.0)).title);
        System.out.println(bst.select(0).title);
        //bst.deleteMin();
        //System.out.println(bst.get(new Book("Algorithms","Bob Sedgewick",6000.0)));
        //bst.delete(new Book("Algorithms","Bob Sedgewick",6000.0));
        //bst.put(new Book("Street","Kiran",800.0),6);
        //bst.put(new Book("Mental","Robert",1800.0),8);
        //bst.put(new Book("TheBook","Joy",24000.0),9);
        //System.out.println(bst.max().title);
        //bst.inorderTraversal(bst.root);
        //System.out.println(bst.get(new Book("Street","Kiran",800.0)));
    }
}
