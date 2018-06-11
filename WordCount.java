/*

Given a class Book that stores a list of words, implement a method to return the count of
a word in the book

*/

//The less memory efficient approach using a Hashmap
//

class Book {
  HashMap<String, Integer> counts;

  public Book(String[] words){
    counts = new HashMap<String, Integer>();
    for(String w : words){
      int count = counts.get(w);
      if(count == 0){
        counts.put(w, 1);
      }else{
        counts.put(w,counts.get(w)+1);
      }
    }
  }

  public int count(String w){
    int count = 0;
    count = counts.get(w);
    return count;
  }
}

//More efficient approach is to use a Trie

class Node{
  char c;
  int count = 0;
  Node[] children;
  public Node(char c){
    this.c = c;
  }

  private Node find(char c){
    for(int i=0; i<children.length-1; i++){
      if(children[i].c == c){
        return children[i];
      }
      return null;
    }
  }

  private Node addToNode(char c){
    Node n = new Node(c);
    int len = this.children.length;
    this.children = Arrays.copyOf(this.children, len+1);
    this.children[len-1] = n;
    return n;
  }

  public void add(String s){
    if(s.length == 0){
      a+=1;
      return;
    }
    char ch = s.charAt(0);
    Node f = find(ch);
    if(f == null){
      addToNode(ch).add(s.substring(1));
    }else{
      f.add(s.substring(1));
    }
  }

  public int count(String s){
    Node n = find(w.charAt(0));
    if(n == null){
      return 0;
    }else{
      count(w.substring(1));
    }
  }

}
