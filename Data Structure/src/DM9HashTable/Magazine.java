package DM9HashTable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Magazine {
	Hashtable<String, Integer> note = new Hashtable<String, Integer>();
	Hashtable<String, Integer> mag = new Hashtable<String, Integer>();
	
	public void add(String st, String st1) {
		int c1 = 0;
		int c2 = 0;
		String[] r = st.split(" ");
		String[] m= st1.split(" ");
		for (int i = 0; i < r.length; i++) {
			if (note.containsKey(r[i])) {
				note.remove(r[i]);
				note.put(r[i], ++c1);
				System.out.println(note);
				}
			
			else {
				note.put(r[i], c2 + 1);
				System.out.println(note);
				}
			}
		for (int i = 0; i < m.length; i++) {
			if (mag.containsKey(m[i])) {
				mag.remove(m[i]);
				mag.put(m[i], ++c2);
				}
			else {
				mag.put(m[i], c2 + 1);
				System.out.println(mag);
			}
		}

	}

	public boolean check() {
		int flag = 0;
		Enumeration<String> e = note.keys();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			if ((!(mag).containsKey(s))) {
				flag = flag + 1;
			} 
			else if (!mag.containsKey(s) && mag.get(s) < note.get(s)) {
				flag = flag + 1;
			}
			else {
				flag = 0;
			}
		}

		if (flag == 1) {
			System.out.println("false");
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String m="i want to kidnap so i want magazine to collect the words from that";
		String n="i want magazine";
		Magazine mr = new Magazine();
		mr.add(n, m);
		System.out.println(mr.check());

	}

}




	


