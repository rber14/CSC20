
package MyStackQueue;
public class Queue{
   private Node Rear=null, Front=null;
   private int size=0;
   public boolean isEmpty(){return Front==null;}
   
   public void enqueue(Object Element){
      Node Tmp=new Node();
      Tmp.data=Element;
      if(Rear==null)Rear=Front=Tmp;
      else{Rear.Next=Tmp; Rear=Tmp;}
      size++;
   }
   public Object dequeue(){
      Node Tmp=Front;
      Front=Front.Next; size--;
      if(Front==null)Rear=null;
      return Tmp.data;
   }
   public String toString(){
      Node Tmp= Front;
      String  num=""; 
      while(Tmp!=null){
         num+= Tmp.data + " ";
         Tmp=Tmp.Next;
      }
     return num;
   }
   
   public class Node{
      Object data;
      Node Next;
   }
}
