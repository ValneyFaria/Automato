package automato;

public class SequentialSearchST<Key,Value> {

	   private Node first;

	   // nó da lista ligada
	   private class Node {
	      private Key key;
	      private Value val;
	      private Node next;
	      public Node(Key key, Value val, Node next) { // construtor
	         this.key = key;
	         this.val = val;
	         this.next = next;
	      }
	   }

	   public Value get(Key key) { 
	      for (Node x = first; x != null; x = x.next)
	         if (key.equals(x.key))
	            return x.val;      // acerto
	      return null;             // falha
	   }

	   public void put(Key key, Value val) { 
	     for (Node x = first; x != null; x = x.next)
	        if (key.equals(x.key)) { 
	           x.val = val;
	           return; 
	     }                                   // acerto: atualiza val
	     first = new Node(key, val, first);  // falha: acrescenta novo nó
	   }
	}