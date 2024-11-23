// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(plus(-2,-3));       // -2 + -3

	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
   		System.out.println(minus(-2,7));    // -2 - 7
   		System.out.println(minus(-2,-4));  // -2 - -4

 		System.out.println(times(3,4));  // 3 * 4
		System.out.println(times(-3,4));  // 3 * 4
		System.out.println(times(3,-4));  // 3 * 4
 		System.out.println(times(-3,-4));  // 3 * 4


   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int additionResult = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
					additionResult++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				additionResult--;
			}
		}
		return additionResult;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int subtractionResult = x1;
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				subtractionResult++;
			}
		} else {
			for (int i = 0; i < x2; i++) {
				subtractionResult--;
			}
		}
		return subtractionResult;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiplicationResult = 0;
		if (x1 == 0 | x2 == 0) {
			multiplicationResult = 0;
			return multiplicationResult;
		}
		if (x1 > 0 && x2 > 0) {
			for (int i = 0; i < x2; i++) {
				multiplicationResult = plus(multiplicationResult, x1);
			}
		} else if (x1 > 0 && x2 < 0) {
			for (int i = 0; i > x2; i--) {
				multiplicationResult = minus(multiplicationResult, x1);
			}
		} else if (x1 < 0 && x2 > 0) {
			for (int i = 0; i < x2; i++) {
				multiplicationResult = plus(multiplicationResult, x1);
			}
		} else {
			for (int i = 0; i > x2; i--) {
				multiplicationResult = minus(multiplicationResult, x1);
			}
		}
		
		return multiplicationResult; 
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int powerResult = x;
		if (n == 0) {
			powerResult = 1;
			return powerResult;
		}
		for (int i=1; i<n; i++) {
			powerResult = times(powerResult, x);
		}
		return powerResult;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divisionResult = 0; 
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			divisionResult++;
		}
		return divisionResult;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int moduloResult = 0;
		if (x2 == 0) {
			return -1;
		}
		moduloResult = div(x1, x2);
		moduloResult = minus(x1,times(x2,moduloResult));
		return moduloResult;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int rootResult = 0;
		while (pow(rootResult+1, 2) <= x ) {
			rootResult++;
		}
		return rootResult;
	}	  	  
}