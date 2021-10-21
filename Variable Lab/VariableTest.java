import java.util.Scanner;
public class VariableTest{
	public static void main(String [] args){
		//part 1
		System.out.println("Part 1");
		byte one = 5;
		System.out.println("one is a byte and has the value of " + one + ".");
		short two = 10;
		System.out.println("two is a short and has the value of " + two + ".");
		int three = 300;
		System.out.println("three is an int and has the value of " + three + ".");
		long four = 100;
		System.out.println("four is a long and has the value of " + four + ".");
		float five = 5f;
		System.out.println("five is a float and has the value of " + five + ".");
		double six = 6.0;
		System.out.println("six is a double and has the value of " + six + ".");
		char seven =75;
		System.out.println("seven is a char and has the value of " + seven + ".");
		boolean eight = true;
		System.out.println("eight is a  boolean and has the value of " + eight + ".");
		System.out.println("");

		//part two
		System.out.println("Part 2");
		char charh = 72;
		char chare = 101;
		char charl = 108;
		char charo = 111;
		char charw = 87;
		char charr = 114;
		char chard = 100;
		char space = 32;
		char quotes = 34;
		char exclamation = 33;
		System.out.print(quotes);
		System.out.print(charh);
		System.out.print(chare);
		System.out.print(charl);
		System.out.print(charl);
		System.out.print(charo);
		System.out.print(space);
		System.out.print(charw);
		System.out.print(charo);
		System.out.print(charr);
		System.out.print(charl);
		System.out.print(chard);
		System.out.print(exclamation);
		System.out.print(quotes);
		System.out.println("\n");

		//part 3
		System.out.println("Part 3");
		//formula 1
		int length = 5;
		int width = 3;
		int area = length * width;
		System.out.println("Area of Rectangle");
		System.out.println("area = length * width");
		System.out.println("length = " + length + ", width = " + width);
		System.out.println("area = " + area);
		System.out.println("");
		//formula 2
		int base = 10;
		int height = 10;
		int trianglearea = base * height /2;
		System.out.println("Area of Triangle");
		System.out.println("area = base * height /2");
		System.out.println("base = " + base + ", height = " + height);
		System.out.println("area = " + trianglearea);
		System.out.println("");
		//formula 3
		int sidelength = 2;
		int squarearea = sidelength * sidelength;
		System.out.println("Area of Square");
		System.out.println("area = sidelength * sidelength");
		System.out.println("sidelength = " + sidelength);
		System.out.println("area = " + squarearea);
		System.out.println("");
		//formula 4
		int side = 4;
		int perimeter = side * 4;
		System.out.println("Perimeter of a Square");
		System.out.println("perimeter = side * 4");
		System.out.println("side = " + side);
		System.out.println("perimeter = " + perimeter);
		System.out.println("");
		//formula 5
		int length1 = 20;
		int width2 = 15;
		int perimeter1 = 2 * length1 + 2 * width2;
		System.out.println("Perimeter of a Rectangle");
		System.out.println("perimeter = 2 * (length + width)");
		System.out.println("length = " + length1 + ", width = " +width2);
		System.out.println("perimeter = " + perimeter1);
		System.out.println("");

		//part 4
		System.out.println("Part 4");
		//formula 1
		double a = 3;
		double b = 4;
		double c = Math.sqrt( Math.pow(a,2) + Math.pow(b,2));
		System.out.println("Pythagorean Formula");
		System.out.println("c = sqrt( a^2 + b^2 )");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("");
		//formula 2
		System.out.println("Distance Formula");
		double x1 = 4;
		double y1 = 6;
		double x2 = 2;
		double y2 = 6;
		double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1-y2), 2));
		System.out.println("The distance between (" + x1 + ", " + y1 + ")");
		System.out.println("and (" + x2 + ", " + y2 + ") is ");
		System.out.println(distance + ".");
		System.out.println("");

		//challenge
		System.out.println("Challenge");
		double pi = 3.14;
		double circlearea = pi * Math.pow(radius, 2);
		System.out.println("Area of a Circle");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input an integer radius");
		int raidus = keyboard.nextInt();











		}
	}
