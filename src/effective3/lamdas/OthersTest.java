package effective3.lamdas;

import java.util.Arrays;

public class OthersTest {

    private  final int a=1;


   private void test(){


       Arrays.asList("ss","fff").stream().forEach(i -> {
           int a = this.a;
       });


       Runnable a = new Runnable() {
           @Override
           public void run() {

           }
       };
   }


}
