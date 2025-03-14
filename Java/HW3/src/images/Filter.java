package images;

public class Filter extends ImageDecorator {
	// Class representing a Filter image using base image the filter colors
	private RGB filter;
	
	public Filter(Image base, RGB filter) {
		super(base);
		this.filter = filter;
	}

	@Override
	public RGB get(int x, int y) {
		return filter.filter(base.get(x, y));
	}

}
