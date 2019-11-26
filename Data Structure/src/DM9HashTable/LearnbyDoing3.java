package DM9HashTable;


class Hash {
    Character[] hashtable;

    Hash(int capacity) {
        hashtable = new Character[capacity];
    }

    public int hashFunc(char k) {
        return k % hashtable.length;
    }

    void put(char key) {
        int index = hashFunc(key);
        if(hashtable[index] == null)
            hashtable[index] = key;
        else{
            while(hashtable[index] != null)
                index = (index+1) % hashtable.length;
            hashtable[index] = key;
        }
    }
}

public class LearnbyDoing3 {
    public static void main(String[] args) {
        String str = "ABCDEFG";
        Hash h_obj = new Hash(7);
        for(int index = 0; index<str.length();index++)
            h_obj.put(str.charAt(index));
        for(int index = 0; index<h_obj.hashtable.length;index++)
            System.out.println(h_obj.hashtable[index]);
    }
}