/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logical;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author DynamicSP
 */
public class EcLogger{
   private  final String DEFAULT_ENCODING="UTF-8"; 
   private  final String NON_DEFAULT_ENCODING="ISO-8859-1"; 
    BASE64Encoder enc=new BASE64Encoder();
    BASE64Decoder dec=new BASE64Decoder();

   private  String base64encode(String text){
      try {
         String rez = enc.encode( text.getBytes( NON_DEFAULT_ENCODING ) );
         return rez;         
      }
      catch ( UnsupportedEncodingException e ) {
         return null;
      }
   }//base64encode

   private  String base64decode(String text){

         try {
            return new String(dec.decodeBuffer( text ),NON_DEFAULT_ENCODING);
         }
         catch ( IOException e ) {
           return null;
         }

      }//base64decode

      public static void main(String[] args){

            String txt="some text to be encrypted" ;
            String key="key phrase used XOR-ing";
//            System.out.println(txt+" XOR-ed to: "+(txt=xorMessage( txt, key )));
//            String encoded=base64encode( txt );       
//            System.out.println( " is encoded to: "+encoded+" and that is decoding to: "+ (txt=base64decode( encoded )));
//            System.out.print( "XOR-ing back to original: "+xorMessage( txt, key ) );
      }
      public String classLoade(String s){
           String s1;
           String txt=s ;
            String key="key phrase used XOR-ing";
            txt=xorMessage( txt, key );
            s1=base64encode( txt );  
          return s1;
      }
      public  String classDeLoade(String s){
        String s1;
        String txt=s ;
        String key="key phrase used XOR-in";
        txt=base64decode( txt );
        s1=xorMessage( txt, key );
        return s1;
      }
      private  String xorMessage(String txt, String key){
       try {
            if (txt==null || key==null ) return null;

            char[] keys=key.toCharArray();
            char[] text=txt.toCharArray();

            int ml=text.length;
            int kl=keys.length;
            char[] newmsg=new char[ml];

            for (int i=0; i<ml; i++){
               newmsg[i]=(char)(text[i]^keys[i%kl]);
        }//for i
            text=null; keys=null;
            return new String(newmsg);
      }
      catch ( Exception e ) {
         return null;
       }  
      }//xorMessage

}//class