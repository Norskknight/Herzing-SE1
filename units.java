import java.util.Scanner;
public class units{
   static void question(){
      System.out.println("do you want unit one(1) or Unit two(2)? (1,2)");
      }

   public static void main(String[] args) {

//select unit
      Scanner input = new Scanner(System.in); 
      question();
      //input
      int select = input.nextInt();
      if (select==1){
         unitOne uone = new unitOne();
         uone.play(input);
         
      }else if (select==2){
         unitTwo u2 = new unitTwo();
         u2.go(input);
      }
   }
   
}