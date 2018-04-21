/*
import java.util.Queue;

/*************************************************************************
 *  Compilation:  javac SeparateChainingHashST.java
 *  Execution:    java SeparateChainingHashST
 *
 *  A symbol table implemented with a separate-chaining hash table.
 * 
 *  % java SeparateChainingHashST
 *
 ************************************************************************

*//** This is an implementation of a symbol table using a hash table.
 * The collisions are resolved using linked lists.
 * Following our usual convention for symbol tables, 
 * the keys are pairwise distinct.
 * <p>
 * Esta � uma implementa��o de tabela de s�mbolos que usa uma 
 * tabela de espalhamento. As colis�es s�o resolvidas por meio 
 * de listas ligadas.
 * Seguindo a conven��o usual para tabelas de s�mbolos,
 * as chaves s�o distintas duas a duas.
 * <p>
 * For additional documentation, see 
 * <a href="http://algs4.cs.princeton.edu/34hash/">Section 3.4</a> 
 * of "Algorithms, 4th Edition" (p.458 of paper edition), 
 * by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *//*

public class HashChain<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    // largest prime <= 2^i for i = 3 to 31
    // not currently used for doubling and shrinking
    // private static final int[] PRIMES = {
    //    7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
    //    32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
    //    8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
    //    536870909, 1073741789, 2147483647
    // };

    private int N;                               // number of key-value pairs
    private int M;                               // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of linked-list symbol tables


   *//** Constructor. Creates an empty separate chaining hash table.
    * <p>
    * Construtor: cria uma tabela de espalhamento 
    * com resolu��o de colis�es por encadeamento. 
    *//*
    public HashChain() {
        this(INIT_CAPACITY);
    } 

   *//** Constructor. Creates an empty separate chaining hash table
    * with M linked lists.
    * <p>
    * Construtor: cria uma tabela de espalhamento 
    * com M listas ligadas.
    *//*
    public HashChain(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains
    // rehashing all of the keys
    //
    // redimensiona a tabela de espalhamento de modo que ela tenha
    // chains listas ligadas e reinsere todas s chaves 
    private void resize(int chains) {
        HashChain<Key, Value> temp;
        temp = new HashChain<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.M  = temp.M;
        this.N  = temp.N;
        this.st = temp.st;
    }

    // hash function: returns a hash value between 0 and M-1
    // fun��o de espalhamento: devolve um valor hash entre 0 e M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    } 

    // return number of key-value pairs in symbol table
    public int size() {
        return N;
    } 

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    } 

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    } 

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }

        // double table size if average length of list >= 10
        if (N >= 10*M) resize(2*M);

        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, val);
    } 

    // delete key (and associated value) if key is in the table
    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2*M) resize(M/2);
    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 


   *//***********************************************************************
    *  Unit test client.
    ***********************************************************************//*
    public static void main(String[] args) { 
        HashChain<String, Integer> st;
        st = new HashChain<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 

    }

}
*/