package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E> {
	private Iterable<E> first,second;
	public Combined(Iterable<E> first, Iterable<E> second)  {
		this.first = first;
		this.second = second;
	}
	@Override
	public Iterator<E> iterator() {
		// extract iterators from the Iterables
		Iterator<E> it2 = second.iterator();
		Iterator<E> it1 = first.iterator();
		return new Iterator<E>() {
			private int sel=0; // keeps track of the current iterator
			private Iterator<E> get(int i){
				return i==0?it1:it2;
			}
			@Override
			public boolean hasNext() {
				return get(sel).hasNext();
			}

			@Override
			public E next() {
				// store the next value
				E ret = get(sel).next();
				// set sel to point to the next available iterator
				for(int i = 0; i<2;i++) {
					sel = (sel+1)%2;
					if (hasNext()) break;
				}
				return ret;
			}
		};
	}
}
