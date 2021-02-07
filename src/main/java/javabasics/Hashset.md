By definition, each and every element in a set is unique and there are no duplicate elements in it.

import java.util.HashSet;
public class Test {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(true);
        hashSet.add("String");
        hashSet.add("String");
        System.out.println(hashSet); //[123, String, true]
    }
}
    

When you pass duplicate element in the add() method of the Set object ,it will return false and does not add it to the HashSet since the element is already present.

Lets see how this add() method is implemented internally in Java?

If we open the HashSet implementation of the add() method in Java APIs i.e. rt.jar , you will find the following code in it:

public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable {
    
    private transient HashMap<E, Object> map;

    private static final Object PRESENT = new Object();

    public HashSet() {
        map = new HashMap<>();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
}

The uniqueness in set is achieved internally through HashMap . Whenever we create an object of HashSet it will create an object of HashMap.
But there is a small catch. We need a key-value pair to add an entry to a HashMap . In HashSet, the argument passed in the add(Element E) method becomes the key in the HashMap but what becomes its corresponding value? Java API developers decided to add a dummy value to use here. This dummy is called PRESENT which is an Object refence returned by doing new Object().
So , actually when we are invoking HashSet.add(“String”) Java internally puts that element E (i.e. “String”) as a key in the HashMap (created in HashSet constructor) and a dummy value i.e. Object’s object is passed as a value to the key.
Now, if we see HashMap’s put(Key k,Value V) method:
public V put(K key, V value) {
}
A. It returns null ,if key is unique and it’s successfully added to the map
B. Old Value of the key , if key is duplicate
So , in our HashSet’s add() method , we check the return value of map.put(key, value) method and compare it with null:
public boolean add(E e) {
return map.put(e, PRESENT)==null;
}
If map.put(key, value) returns null ,then map.put(e, PRESENT)==null will return true and element is added to the HashSet.
And, if map.put(key,value) returns old value of the key, then map.put(e, PRESENT)==null will return false and element is not added to the HashSet.
Isn’t it so simple !!!
