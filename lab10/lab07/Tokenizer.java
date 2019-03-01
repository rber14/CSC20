public class Tokenizer{
   private char[] Buf;
   private int cur;
      
   Tokenizer(String infixExpression){
      Buf=infixExpression.toCharArray();
      cur=0;
   }
   boolean moreTokens(){
      while((cur<Buf.length)&&(Buf[cur]==' '))
      {
         cur++;
      }
      return cur<Buf.length;
   }
 
   Token nextTokens(){
      while(cur<Buf.length && Buf[cur]==' ')
      {
       cur++;
      }
      if(cur>=Buf.length){
         return null;
      }
      int result=0;
      if(Buf[cur]>47 && Buf[cur]<58){
         int start=cur; 
         while(cur<Buf.length&& Buf[cur]>47 && Buf[cur]<58){
            cur++;
         }
         
        
         String Digits=new String(Buf, start, cur-start);
         int num=Integer.valueOf(Digits).intValue();
         return new Operand(num);
      }else{
         return new Operator(Buf[cur++]);
      }
  }
}

   
   

  

     
     