package equiv;

import java.util.Set;
import java.util.HashSet;

public class Equiv<E>{
	// Class that representing equivalence classes
	private Set<Set<E>> setOfSets;
	
	public Equiv() {
		setOfSets = new HashSet<Set<E>>();
	}
	
	public void add(E e1, E e2) {
		Set<E> set1 = getSet(e1);
		Set<E> set2 = getSet(e2);
		// if e1 and e2 aren't in set, create a new set and add them
		if(set1==null && set2==null) {
			Set <E> newSet = new HashSet<>();
			newSet.add(e1);
			newSet.add(e2);
			setOfSets.add(newSet);
		}
		// if e1 and e2 already in set, add all elements from the e2's set
		// to the e1's set, and then delete e2's set
		else if(set1!=null && set2!=null) {
			if(set1!=set2) {
				set1.addAll(set2);
				setOfSets.remove(set2);
			}	
		}
		// if one of them isn't in set' add him to the other set
		else if(set1 != null) {
			set1.add(e2);
		}
		else if(set2 != null) {
			set2.add(e1);
		}
	}
	public boolean are(E e1, E e2) {
		// check if it is the same set
		return getSet(e1) == getSet(e2);
	}
	private Set<E> getSet(E element){
		// return the set of given element
		for(Set<E> s: setOfSets){
			if (s.contains(element))
				return s;
		}
		return null;
	}
}
