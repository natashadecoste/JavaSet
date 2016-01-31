

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class testSet {
	private static String inputFile = "src/input.txt"; // always reading from
	// input.txt
	private static String outputFile = "src/output.txt"; // always write to the
	// output.txt

	public static void testUnion() {
		String line[] = null; // this is going to split the line into a string
		// array, each line formatted <Set R> <Set S>
		// <Union> <Intersection> <Difference> <Product>
		// <isEqual> <isSubset> <getCount> <Cardinality>
		// <toString>
		String temp; // this reads the whole line
		Set R; // will hold set R
		Set S; // will hold set S
		int count = 1; // for writing to console the test numbers
		System.out.println("Entering testUnion..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile)); // for
			// reading
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)); // for
			// writing
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" "); // inputs are split at the spaces

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(",")); // stripping
					// the
					// end
					// brackets
				} else { // this is if there was an empty set inputted []
					String[] p = {}; // creates an empty set
					R = new Set(p);
				}

				if (line[1].length() > 2) { // same as above but for set S
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				// test them for union
				bw.write("Union test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				String union = (R.Union(S)).toString().replace(" ", ""); // turns
				// the
				// union
				// into
				// a
				// string
				// like
				bw.write("Union of R & S: " + union); // for the output file
				bw.newLine();

				if (union.equals(line[2])) { // line[2] is the answer for union
					System.out.println("Test case " + count + " passed."); // checking
					// the
					// test
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++; // moving to the next test case
			}
			filereader.close();
			bw.close();

		} catch (Exception e) { // for input/output exception
			e.printStackTrace();
		}
		System.out.println("testUnion complete.");
		System.out.println();

	}

	public static void testIntersection() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		Set S;
		int count = 1;
		System.out.println("Entering testIntersection..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				if (line[1].length() > 2) {
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				// test them for Intersection
				bw.write("Intersection test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				String intersection = (R.Intersection(S)).toString().replace(" ", "");
				bw.write("Intersection of R & S: " + intersection);
				bw.newLine();

				if (intersection.equals(line[3])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}
			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testIntersection complete.");
		System.out.println();

	}

	public static void testDifference() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		Set S;
		int count = 1;
		System.out.println("Entering testDifference..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				if (line[1].length() > 2) {
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				// test them for Difference

				bw.write("Difference test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				String difference = (R.Difference(S)).toString().replace(" ", "");
				bw.write("Intersection of R & S: " + difference);
				bw.newLine();

				if (difference.equals(line[4])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}
			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testDifference complete.");
		System.out.println();

	}

	public static void testProduct() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		Set S;
		int count = 1;
		System.out.println("Entering testProduct..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				if (line[1].length() > 2) {
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				// test them for Product
				bw.write("Product test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				String product = (R.Product(S)).toString().replace(" ", "");
				bw.write("Product of R X S: " + product);
				bw.newLine();

				if (product.equals(line[5])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testProduct complete.");
		System.out.println();

	}

	public static void testIsEqual() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		Set S;
		int count = 1;
		System.out.println("Entering testIsEqual..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				if (line[1].length() > 2) {
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				// test them for Equality
				bw.write("isEqual test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				String equal;
				if (R.isEqual(S)) {
					equal = "true";
					bw.write("It IS equal");
					bw.newLine();
				} else {
					equal = "false";
					bw.write("It is NOT equal");
					bw.newLine();
				}

				if (equal.equals(line[6])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testIsEqual complete.");
		System.out.println();

	}

	public static void testIsSubset() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		Set S;
		int count = 1;
		System.out.println("Entering testIsSubset..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				if (line[1].length() > 2) {
					S = new Set(line[1].substring(1, line[1].length() - 1).split(","));
				} else {
					String[] p = {};
					S = new Set(p);
				}

				bw.write("isSubset test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();
				bw.write("Set S: " + S.toString());
				bw.newLine();

				// test them for isSubsetw
				String subset;
				if (R.isSubset(S)) {
					subset = "true";
					bw.write("R IS a subset of S");
					bw.newLine();
				} else {
					subset = "false";
					bw.write("R is NOT subset of S");
					bw.newLine();
				}

				if (subset.equals(line[7])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testIsSubset complete.");
		System.out.println();

	}

	public static void testGetCount() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		int count = 1;
		System.out.println("Entering testGetCount..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				// test them for getCount()
				bw.write("getCount test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();

				int c = R.getCount();
				bw.write("Set R count =  " + c);
				bw.newLine();

				if (c == Integer.parseInt(line[8])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testGetCount complete.");
		System.out.println();

	}

	public static void testGetCardinality() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		int count = 1;
		System.out.println("Entering testGetCardinality..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				// test them for getCardinality()
				int c = R.getCardinality();
				// test them for getCount()
				bw.write("getCardinality test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();

				bw.write("Set R Cardinality =  " + c);
				bw.newLine();

				// System.out.println(c);
				if (c == Integer.parseInt(line[9])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testGetCardinality complete.");
		System.out.println();

	}

	public static void testToString() {
		String line[] = null; // for splitting up the line into the different
		// parts (see above)
		String temp; // this reads the whole line
		Set R;
		int count = 1;
		System.out.println("Entering testToString..");
		try {
			BufferedReader filereader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			while ((temp = filereader.readLine()) != null) {
				line = temp.split(" ");

				if (line[0].length() > 2) {
					R = new Set(line[0].substring(1, line[0].length() - 1).split(","));
				} else {
					String[] p = {};
					R = new Set(p);
				}

				// test them for toString()
				String name = R.toString();
				bw.write("toString test number " + count);
				bw.newLine();
				bw.write("Set R: " + R.toString());
				bw.newLine();

				if (name.equals(line[10])) {
					System.out.println("Test case " + count + " passed.");
					System.out.println("...");
					bw.write("Test case passed.");
					bw.newLine();
					bw.newLine();
				} else {
					System.out.println("Test case " + count + " failed.");
					System.out.println("...");
					bw.write("Test case failed.");
					bw.newLine();
					bw.newLine();
				}

				count++;

			}

			filereader.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testToString complete.");
		System.out.println();

	}

	public static void main(String[] args) {
		// each function reopens the filereader so that it restarts reading the
		// lines again in order to perform the different tests on the same sets

		testUnion();
		testIntersection();
		testDifference();
		testProduct();
		testIsEqual();
		testIsSubset();
		testGetCount();
		testGetCardinality();
		testToString();

	}// end of the main

}
