package CodSOFT;
import java.util.Scanner;
public class RANDOM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=(int)((Math.random()*100)+1);
		int c =0;
		for (int i=0;i<5 ; i++) {
			System.out.println("enter any int from 1 to 100");
			int h=sc.nextInt();
			if(h==a) {
				c+=1;
				System.out.println("correct");	
				break;
				
			}
			else if(h>a) {
				c+=1;
				System.out.println("too high,try again");		
			}
			else if(h<a) {
				c+=1;
				System.out.println("too low,try again");		
			}
			
			
			
		}
		
		System.out.print(c);	
		System.out.println("-trials taken");	
		System.out.println("no.was"+a);	
		
		sc.close();
				
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
