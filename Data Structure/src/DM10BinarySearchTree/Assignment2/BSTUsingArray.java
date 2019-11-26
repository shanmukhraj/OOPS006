package DM10BinarySearchTree.Assignment2;
import java.util.Arrays;
public class BSTUsingArray {
    int[] keys;
    int[] left_ind, right_ind;
    int size;

    BSTUsingArray(int cap){
        keys = new int[cap];
        left_ind = new int[cap];
        Arrays.fill(left_ind, -1);
        right_ind = new int[cap];
        Arrays.fill(right_ind, -1);
        size = 0;
    }

    void insert(int key){
        if(size < keys.length) {
            if (size == 0)
                keys[size++] = key;
            else{
                for(int i = 0; i < size;) {
                    if (key > keys[i]){
                        if (right_ind[i] == -1) {
                            right_ind[i] = size;
                            keys[size++] = key;
                            break;
                        }
                        else
                            i = right_ind[i];
                    }
                    else if (key < keys[i]) {
                        if (left_ind[i] == -1) {
                            left_ind[i] = size;
                            keys[size++] = key;
                            break;
                        }
                        else
                            i = left_ind[i];
                    }
                }
            }
        }
    }

    void display(){
        for(int i = 0; i < size;i++)
            System.out.print(keys[i]+" ");
        System.out.print("\n");
        for(int i = 0; i < size;i++)
            System.out.print(left_ind[i]+" ");
        System.out.print("\n");
        for(int i = 0; i < size;i++)
            System.out.print(right_ind[i]+" ");
        System.out.print("\n");
    }

    public static void main(String[] args){
        BSTUsingArray bstArray = new BSTUsingArray(6);
        bstArray.insert(11);
        bstArray.insert(12);
        bstArray.insert(20);
        bstArray.insert(14);
        bstArray.insert(18);
        bstArray.insert(15);
        bstArray.display();
    }
}
