package myMathTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;

class PolynomTest {

	static Polynom excepted_Polynom ; 
	static Polynom actual_Polynom;

	@BeforeEach
	void setUp() throws Exception 
	{
		excepted_Polynom = new Polynom();	
		actual_Polynom = new Polynom();	
	}

	@Test
	void testPolynomPolynom() {
		Polynom test = new Polynom() ; 
		excepted_Polynom.add(new Monom(3,2));
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		boolean ans = actual_Polynom.equals(excepted_Polynom) ;
		if(!ans) fail("Not yet implemented");
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		ans = actual_Polynom.equals(excepted_Polynom) ;
		if(ans) fail("Not yet implemented");
	}

	@Test
	void testPolynom() {
		actual_Polynom = new Polynom() ;
		if(!actual_Polynom.isZero()) fail("Not yet implemented");
	}

	@Test
	void testPolynomString() {
		String ValidInput = "2*x + 9*x^1/9*x + 9*x^0 + 0/x^3 + 4*X^-0 + 9*x^2/-3*x - 9*x - 4";
		String[] ValidInputArray = ValidInput.split("/");

		for (int i = 0; i < ValidInputArray.length; i++) {
			try 
			{
				actual_Polynom = new Polynom(ValidInputArray[i]);
			}
			catch (Exception e) 
			{
				fail("Not yet implemented");
			}
		}
		String inValidInput = "2*x^-1 + 9*x^1/9*xx + 9*x^0 + 0/x^3 + 4*X^0 + 9*x^2 + a/-3*xa";
		String[] inValidInputArray = inValidInput.split("/");
		for (int i = 0; i < inValidInputArray.length; i++) {
			try 
			{
				actual_Polynom = new Polynom(inValidInputArray[i]);
				fail("Not yet implemented");
			}
			catch (Exception e) 
			{

			}
		}
		//cheacking toString 
		excepted_Polynom = new Polynom();
		excepted_Polynom.add(new Monom(3,2));
		excepted_Polynom.add(new Monom(-3,3));
		try {
			actual_Polynom = new Polynom(excepted_Polynom.toString());}
		catch (Exception e) {
			fail("toString test not working well ");
		};
	}

	@Test
	void testF() {
		actual_Polynom = new Polynom(); 
		actual_Polynom.add(new Monom(1,0));
		if (actual_Polynom.f(22) != 1)  fail("Not yet implemented"); // test a number polynom (exsample y = 1 )
		actual_Polynom.add(new Monom(1,3));
		if (actual_Polynom.f(10) != 1001)  fail("Not yet implemented"); 
		actual_Polynom = new Polynom(); 
		if(actual_Polynom.f(3) != 0) fail("Not yet implemented"); // test zero polynom
	}

	@Test
	void testAddPolynom_able() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Polynom test =new Polynom("3*x^1 + 4");
		excepted_Polynom=new Polynom("2*x^3 + 6*x^1");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Polynom("3*x^4");
		excepted_Polynom=new Polynom("3*x^4 + 2*x^3 + 3*x^1 - 4");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");

	}

	@Test
	void testAddMonom() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Monom test =new Monom("3*x^1");
		excepted_Polynom=new Polynom("2*x^3 + 6*x^1 - 4");	
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Monom("3*x^4");
		excepted_Polynom=new Polynom("3*x^4 + 2*x^3 + 3*x^1 - 4");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Polynom test =new Polynom("3*x^1 - 4");
		excepted_Polynom=new Polynom("2*x^3");	
		actual_Polynom.substract(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Polynom("3*x^4 - 2*x^1");
		excepted_Polynom=new Polynom("-3*x^4 + 2*x^3 + 5*x^1 - 4");
		actual_Polynom.substract(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");	}

	@Test
	void testMultiply() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		Polynom test =new Polynom("-1*X^2 + 5");
		excepted_Polynom=new Polynom("-3*X^6 + 1*X^5 + 14*X^4 - 5*X^3 + 10*X^2 - 25");	
		actual_Polynom.multiply(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");

	}

	@Test
	void testEqualsPolynom_able() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		excepted_Polynom=new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
		excepted_Polynom=new Polynom("3*X^4 - 1*X^3 + 1*X^2 + 5");
		if(actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
	}
	@Test
	void testIsZero() {
		actual_Polynom.add(new Monom(0,4));
		boolean ans = actual_Polynom.isZero() ; 
		if(!ans) fail("The isZero function not working well ");
		actual_Polynom = new Polynom(); 
		actual_Polynom.add(new Monom(3,1));
		ans = actual_Polynom.isZero();
		if(ans) fail("The isZero function not working well ");
	}

	@Test
	void testRoot() {
		actual_Polynom.add(new Monom(1,2));
		actual_Polynom.add(new Monom(-4,0)); // x^2 -4 ---- >> the roots is -2 / +2
		double RootPositive = actual_Polynom.root(0, 3, 0.001);
		double RootNegative = actual_Polynom.root(-3, 0, 0.001);
		RootNegative = Math.abs(RootNegative);
		assertEquals(RootPositive, RootNegative);

	}

	@Test
	void testCopy() {
		Polynom_able returnedPolynom = new Polynom();
		returnedPolynom = actual_Polynom.copy();
		boolean ans = returnedPolynom.isZero();
		if(!ans)fail("Not yet implemented");

	}

	@Test
	void testDerivative() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		actual_Polynom.derivative();
		excepted_Polynom=new Polynom("12*X^3 - 3*X^2 + 2*X^1");
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Not yet implemented");
	}

	@Test
	void testArea() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		if(actual_Polynom.area(0, 4, 0.0001)!=556.1711343900323)
			fail("Not yet implemented");

	}

	@Test
	void testZero_union() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		excepted_Polynom=new Polynom("0");

		if(!actual_Polynom.derivative().derivative().derivative().derivative().derivative().equals(excepted_Polynom))
			fail("Not yet implemented");
	}

}