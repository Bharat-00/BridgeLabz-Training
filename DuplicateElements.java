/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
/*Duplicate elements from an array.*/
import java.util.*;
public class DuplicateElements
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n=sc.nextInt();
		System.out.println("enter elements: ");
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    i=sc.nextInt();
		}
		int low=0;
		int high=1;
		for(int i=0;i<arr.length-1;i++){
		    if(arr[low]==arr[high]){
		        System.out.println(" "+arr[low]);
		    }else{
		        low++;
		        high++;
		    }
		}
	}
}
