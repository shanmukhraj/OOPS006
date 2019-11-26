package DM9HashTable;

import java.util.Arrays;

class Hashtable<Key, Value>{
    Key keys[];
    Value values[];

    Hashtable(){
        keys = (Key[]) new Object[20];
        values = (Value[]) new Object[20];
    }

    public int hashCode(){
        return 17;
    }

    private boolean isFull(){
        for(int i = 0; i < keys.length; i++)
            if(keys[i] == null)
                return false;
        return true;
    }

    void put(Key key, Value value){
        int i = hashCode();
        if(isFull()) {
            keys = Arrays.copyOf(keys, 2 * keys.length);
            values = Arrays.copyOf(values, 2 * keys.length);
        }
        else {
            while(keys[i] != null){
                i = (i + 1) % keys.length;
            }
            keys[i] = key;
            values[i] = value;
        }
    }

    Value get(Key key){
        if(key != null){
            int i = hashCode();
            for(; keys[i] != null; i = (i + 1)%keys.length){
                if(keys[i].equals(key))
                    return values[i];
            }
        }
        return null;
    }

    void delete(Key key){
        if(key != null && get(key) != null) {
            int i = hashCode();
            for(; keys[i] != null; i = (i + 1)%keys.length){
                if(keys[i].equals(key)) {
                    keys[i] = null;
                    values[i] = null;
                    return;
                }
            }
        }
    }

    void display(){
        String printString = "{";
        for(int i = 0; i < keys.length; i++)
            if(keys[i] != null)
                printString += keys[i] + "=" + values[i]+ " ";
        printString += "}";
        System.out.println(printString);
    }
}

public class HashingwithLinearProbing {
    public static void main(String[] args){
        Hashtable<String, Integer> obj = new Hashtable<>();
        obj.put("rabbit", 22);
        obj.put("cat", 25);
        obj.put("dog", 23);
        System.out.println(obj.get("rabbit"));
        System.out.println(obj.get("cat"));
        System.out.println(obj.get("fish"));
        obj.display();
    }


}
