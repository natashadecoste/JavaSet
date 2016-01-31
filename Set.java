import java.util.*; //uses the ArrayList and it's functions

public class Set {
	private ArrayList<String> set = new ArrayList<String>();
	// in order to maintain mutability, it creates an ArrayList because their
	// size is scalable

	Set(String[] x) { // constructor for the ADT will take an array of strings
		for (int i = 0; i < x.length; i++) {
			set.add(x[i]); // filling up the object's set
		}
	}

	public int getCount() {
		return set.size();
	}

	public ArrayList<String> Union(Set that) {
		ArrayList<String> union = new ArrayList<String>();
		if (this.getCount() == 0) { // if our first set is empty
			boolean check = true;
			int w = 0;
			while (w < that.getCount()) { // we will go through the second set
				// and check them all
				check = true;
				for (int i = w + 1; i < that.getCount(); i++) { // so that we
					// dont add
					// duplicates
					if (that.set.get(w).equals(that.set.get(i))) {
						w++;
						check = false; // so the next condition doesnt evaluate
					}
				}
				if (check) {
					union.add(that.set.get(w)); // adding all the items from
					// that.set
					w++;
				}
			}
			return union;
		} else { // if the first set isnt empty, we have to make sure we are
			// getting only no duplicates in the first set or second
			for (int i = 0; i < this.getCount(); i++) {
				if (that.set.contains(this.set.get(i))) {
					// do nothing, we will add it later from that.set
				} else {
					boolean c = true;
					for (int p = i + 1; p < this.getCount(); p++) {
						if (this.set.get(i).equals(this.set.get(p))) {
							c = false;
						}
					}
					if (c) {
						union.add(this.set.get(i)); // this is exclusive to
						// this.set so
						// we add it to the union
					}
				}
			} // close first for loop
			boolean check = true;
			int w = 0;
			while (w < that.getCount()) {
				check = true;
				for (int i = w + 1; i < that.getCount(); i++) {
					if (that.set.get(w).equals(that.set.get(i))) {
						w++;
						check = false;
					}
				}
				if (check) {
					union.add(that.set.get(w)); // adding all the items from
					// that.set
					w++;
				}
			}

		}
		return union;

	}

	public ArrayList<String> Intersection(Set that) {
		ArrayList<String> intersection = new ArrayList<String>();

		int first = 0;
		while (first < this.getCount()) {
			// check if it is a duplicate of one of its own set
			for (int i = first + 1; i < this.getCount(); i++) {
				if (this.set.get(first).equals(this.set.get(i))) {
					first++; // if it is a duplicate we will go to the next one
					// (the last duplicate in the set will be the
					// one added)
				}
			} // at the end of this loop our first = a unique element

			for (int j = 0; j < that.getCount(); j++) {
				if (this.set.get(first).equals(that.set.get(j))) { // checking
					// our
					// unique
					// element
					// from set
					// R with
					// all in
					// set S
					if (!intersection.contains(this.set.get(first))) { // if we
						// dont
						// already
						// have
						// it
						// added
						// to
						// our
						// intersection
						intersection.add(this.set.get(first)); // add it
					}
				}
			}
			first++;
		}
		return intersection; // return intersection
	}

	public ArrayList<String> Difference(Set that) {
		ArrayList<String> difference = new ArrayList<String>();
		for (int i = 0; i < this.getCount(); i++) {
			// check all the items in the set, if they are in S "that" set, then
			// dont add them to the difference ArrayList
			if (that.set.contains(this.set.get(i))) {
				// do nothing, we only want it to add items not in that.set
			} else {
				difference.add(this.set.get(i)); // if it is unique to set R, we
				// want to add it as an item
				// in the difference R-S
			}
		}
		return difference;
	}

	public ArrayList<String> Product(Set that) {
		ArrayList<String> product = new ArrayList<String>();
		String temp;
		for (int i = 0; i < this.getCount(); i++) {
			for (int j = 0; j < that.getCount(); j++) {
				temp = this.set.get(i) + that.set.get(j); // concatinate all the
				// possible sets
				product.add(temp); // add it to an arraylist
			} // close second for loop
		} // close first for loop
		return product; /// return the products
	}// close function bracket

	public boolean isEqual(Set that) { // all items in one set have to be
		// contained in the other set
		if (this.set.containsAll(that.set)) {
			if (that.set.containsAll(this.set)) { // same with the other way
				return true;
			}
		}
		return false; // if not they are not equal
	}

	public boolean isSubset(Set that) {
		if (this.getCount() == 0) { // all empty sets are subsets
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

	public int getCardinality() {
		int count = this.getCount(); // starting with the count
		if (this.getCount() == 0) { // if there is no items, cardinality is
			// automatically 0
			return 0;
		}
		for (int i = 0; i < this.getCount(); i++) { // going to check through
			// the items
			for (int j = i + 1; j < this.getCount(); j++) { // if it is a
				// duplicate of one
				// farther in the
				// set
				if (this.set.get(i).equals(this.set.get(j))) {
					count--; // decrease the count (which will be the
					// cardinality)
					break; // we want to then go to the next item (treating it
					// like a partition and checking all to the right of
					// it)
				} // if we don't break
			}
		}
		return count; // returns the cardinality
	}

	public String toString() { // need it in the form
		// {element1,element2,element3,...,elementN}
		String setStr = ""; // going to build it up from the empty string
		if (this.getCount() > 0) {
			for (int i = 0; i < this.getCount() - 1; i++) { // adding all the
				// elements with
				// commas in between
				setStr += this.set.get(i) + ",";
			}
			setStr += this.set.get(this.getCount() - 1); // adding the last
			// element
			// seperately
			// (because we dont
			// want a comma
			// after)
		}
		return "{" + setStr + "}"; // adding the braces
	}
}
