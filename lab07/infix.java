import java.io.*;
import java.util.*;

enum errorType { ExcessLeftParenthesis, ExcessRightParenthesis, ExcessOperator, ExcessOperand};
class infixException extends Exception {
private errorType etype;
public infixException(errorType et) { // constructor
etype = et;
}
public String toString() {
return etype.name();
}
}


class infix {

	static Queue infixToPostfix(String s) throws Exception 
   {
      Stack<Operator> theStack=new Stack<Operator>();
      theStack.push(new Operator('#'));
      Tokenizer T=new Tokenizer(s);
           
      LinkedList<Token> queue + new LinkedList<Token>();
      
      
      while(T.moreTokens())
      {
         Token Tok=T.nextTokens();
         if(Tok instanceof Operand)
         {
           queue.addLast(Tok);//addLast(Eitem)
         }else{
            Operator Op= (Operator)Tok;
        
            if(Op.operator=='(')
            {
               theStack.push(Op);
            }
            else if(Op.operator==')')
            {
               try{
               while((theStack.peek()).operator!='(')//changePeekLab10
               {
                  Q.addLast(theStack.pop()); //ques and pops 
               }
               theStack.pop();
               }catch (Exception e){
               throw new infixException(errorType.ExcessRightParenthesis);; //catches right
               }
               
                
               
            }else{
               while((theStack.peek)).precedence()>=Op.precedence())
               { //checks signs
                   Q.addLast(theStack.pop()); //if its higher precedence pops signs; lab10
               }
               theStack.push((Op)); //pushes into stack use the stack .push(op)
            }
         }
       }
        while((theStack.peek()).operator!='#') //checks for anything else and then pops whats left and puts in enqueue
        {
            
              
              if(theStack.peek()).operator=='(')
              {
                  throw new infixException(errorType.ExcessLeftParenthesis):
              }
              Q.addLast(theStack.pop()); //addlast lab10
        }
               
              
            
           theStack.pop();
        
      
     
       return Q;
      
    
   }
	
   static int evaluePostfix(LinkedList<Token> Post) throws Exception
   {
      
      Stack<Operand> theStack=new Stack<Operand>();
      int result=0;
      while(!Post.isEmpty()) //checks
      {
         Token Tok=(Token)Post.removeFirst();//removelabe10
         
         if(Tok instanceof Operand)
         {
            theStack.push((Operand)Tok);
         }else{ 
           try{
            Operator Op=(Operator)Tok;
            int b=((Operand)theStack.pop()).operand;  //not a put b first 
            int a=((Operand)theStack.pop()).operand; //a
            
            switch(Op.operator)
            {
               case'+':result=a+b; break;
               case'-':result=a-b; break;
               case'*':result=a*b; break;
               case'/':result=a/b; break;
            }
             }catch(Exception e){
               throw new infixException(errorType.ExcessOperator);
             }
            theStack.push(new Operand(result));
            
         }
               
               
       }    
       theStack.pop();
       if(!theStack.isEmpty())
       { 
         throw new infixException(errorType.ExcessOperand);
       }
            return result;
    } 
    
         
     
	

 public static void main(String[] args) throws IOException 
 {
	   LinkedList<Token> Post;
      try{
	      while(true) 
       {
      		System.out.print("Enter infix: ");
      		System.out.flush();
      		InputStreamReader isr = new InputStreamReader(System.in);
      		BufferedReader br = new BufferedReader(isr);
      		String s = br.readLine();  
       		if ( s.equals("") ) break;
      		Post = infixToPostfix(s);
      		System.out.println("Postfix is " + Post.toString() + '\n');
      		int result = evaluePostfix(Post);
       		System.out.println("Result is " + result + '\n');
	    }
       
    }catch(Exception e){
      System.out.println("\n*****"+e.toString()+ "*****\n");
    }
 }
 
}
