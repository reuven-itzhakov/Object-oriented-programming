package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
	private int[][] arrs;
	
	public TwoArrays(int[] a1, int[] a2) {
		arrs = new int[][]{new int[a1.length], new int[a2.length]};
		// copy the arrays' contents
		for (int i = 0; i < a1.length; i++) {
			arrs[0][i]=a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			arrs[1][i]=a2[i];
		}
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<>(){
			private int[] idxs = {0,0};
			private int sel = 0;
			
			@Override
			public boolean hasNext() {
				return idxs[sel] < arrs[sel].length;
			}

			@Override
			public Integer next() {
				// get the Integer in the current array in the correct index
				Integer ret = arrs[sel][idxs[sel]];
				// set idxs[sel] and then sel for the next call
				idxs[sel]++;
				for(int i = 0; i<2;i++) {
					sel = (sel+1)%2;
					if (hasNext()) break;
				}
				return ret;
			}
		};
	}

}
