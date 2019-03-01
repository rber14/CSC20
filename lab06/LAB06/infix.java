// infix.java
/*
Roberto Campos
lab05
sec 206 TTh9am
oct 5
*/

import java.io.*;
import MyStackQueue.*;

class infix {

	static Queue infixToPostfix(String s)
   {
      Stack theStack=new Stack();
      theStack.push(new Operator('#'));
      Tokenizer T=new Tokenizer(s);
      //Token Tok= T.nextToken();
      
      Queue Q=new Queue();
      
      
      while(T.moreTokens())
      {
         Token Tok=T.nextTokens();
         if(Tok instanceof Operand)
         {
            Q.enqueue(Tok);
         }
         else
         {
            Operator Op= (Operator)Tok;
        
            if(Op.operator=='(')
            {
               theStack.push(Op);
            }
            else if(Op.operator==')')
            {
               while(((Operator)theStack.top()).operator!='(')
               {
                  Q.enqueue(theStack.pop()); //ques and pops 
               }
               theStack.pop();
            }else{
               while(((Operator)theStack.top()).precedence()>=Op.precedence())
               { //checks signs
                   Q.enqueue(theStack.pop()); //if its higher precedence pops signs;
               }
               theStack.push((Op)); //pushes into stack use the stack .push(op)
            }
         }
       }
        while(((Operator)theStack.top()).operator!='#') //checks for anything else and then pops whats left and puts in enqueue
        {
            Q.enqueue(theStack.pop());
        }
      
     
       return Q;
      
    
   }
	static int evaluePostfix(Queue Post) 
   {
      Stack theStack=new Stack();
      int result=0;
      while(!Post.isEmpty()) //checks
      {
         Token Tok=(Token)Post.dequeue();
         
         if(Tok instanceof Operand)
         {
            theStack.push(Tok);
         }else{
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
            theStack.push(new Operand(result));
         }
               
               
       }    
            return result;
    } 
    
         
     
	

	public static void main(String[] args) throws IOException 
   {
	   Queue Post;
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
  }
}
