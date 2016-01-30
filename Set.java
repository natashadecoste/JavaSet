import java.util.*;

public class Set {
	private ArrayList<String> set = new ArrayList<String>(); // in order to
																// maintain
																// mutability,
																// it creates an
																// ArrayList
																// because their
																// size is
																// scalable

	Set(String[] x) { // constructor for the ADT will take an array of strings
		for (int i = 0; i < x.length; i++) {
			set.add(x[i]);
		}
	}

	public int getCount() {
		return set.size();
	}

	public ArrayList<String> Union(Set that) {
		ArrayList<String> union = new ArrayList<String>();
		for (int i = 0; i < this.getCount(); i++) {
			if (that.set.contains(this.set.get(i))) {
				// do nothing, we will add it later from that.set
			} else {
				union.add(this.set.get(i)); // this is exclusive to this.set so
											// we add it to the union
			}
		} // close first for loop

		for (int i = 0; i < that.getCount(); i++) {
			union.add(that.set.get(i)); // adding all the items from that.set
		}

		return union;

	}

	public ArrayList<String> Intersection(Set that) {
		ArrayList<String> intersection = new ArrayList<String>();

		for (int i = 0; i < this.getCount(); i++) {
			for (int j = 0; j < that.getCount(); j++) {
				if (this.set.get(i) == that.set.get(j)) {
					intersection.add(that.set.get(j));
				} // close if statement
			} // close second for loop
		} // close first for loop
		return intersection;
	}

	public ArrayList<String> Difference(Set that) {
		ArrayList<String> difference = new ArrayList<String>();
		for (int i = 0; i < this.getCount(); i++) {
			// check all the items in the set, if they are in S "that" set, then
			// dont add them to the difference ArrayList
			if (that.set.contains(this.set.get(i))) {
				// do nothing
			} else {
				difference.add(this.set.get(i));
			}
		}
		return difference;
	}

	public ArrayList<String[]> Product(Set that) {
		ArrayList<String[]> product = new ArrayList<String[]>();
		for (int i = 0; i < this.getCount(); i++) {
			for (int j = 0; j < that.getCount(); j++) {
				product.add(new String[] { this.set.get(i), that.set.get(j) });
			} // close second for loop
		} // close first for loop
		return product;
	}// close function bracket

	public boolean isEqual(Set that) {
		if (this.set.containsAll(that.set)) {
			if (that.set.containsAll(this.set)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSubset(Set that) {
		if (this.getCount() == 0) {
			return true;
		}
		// if all items in this.set are in that.set
		for (int i = 0; i < this.getCount(); i++) {
			if (that.set.contains(this.set.get(i))) {
				// nothing
			} // end if bracket
			else {
				return false; // because set that does not contain one of the
								// items in this.set
			} // end else bracket
		} // end for
		return true;
	}

	public String toString() {
		return this.set + " ";
	}
}
