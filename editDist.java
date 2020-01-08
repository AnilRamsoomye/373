import java.lang.*;

public class editDist
{ 
	static int min(int x,int y,int z) 
	{ 
		if (x <= y && x <= z) {
			return x; 
		}
		if (y <= x && y <= z) {
			return y; 
		}
		else { 
			return z; 
		}
	} 

	static int eD(String a, String b, int m, int n) 
	{ 
		int distances[][] = new int[m+1][n+1]; 
	
		for (int i=0; i<=m; i++) 
		{ 
			for (int j=0; j<=n; j++) 
			{  
				if (i==0) 
					distances[i][j] = j;
	
				else if (j==0) 
					distances[i][j] = i; 
	
				else if (Character.toUpperCase(a.charAt(i-1)) == Character.toUpperCase(b.charAt(j-1))) // if last characters are equal
					distances[i][j] = distances[i-1][j-1]; 
	
				else
					distances[i][j] = 1 + min(distances[i][j-1], // Insert 
									distances[i-1][j], // Remove 
									distances[i-1][j-1]); // Replace 
			} 
		} 

		return distances[m][n]; 
	} 

	

	public static void main(String args[]) 
	{ 
		String str1 = "watch the movie raising arizona?"; 
		String str2 = "watch da mets raze arizona?"; 
		System.out.println( eD( str1 , str2 , str1.length(), str2.length()) ); 

		String str3 = "this is what happens when I type slow"; 
		String str4 = "htishisth whaty havpens when ui type fasht"; 
		System.out.println( eD( str3 , str4 , str3.length(), str4.length()) );

		String str5 = "leonard skiena"; 
		String str6 = "lynard skynard"; 
		System.out.println( eD( str5 , str6 , str5.length(), str6.length()) );

	} 
}
