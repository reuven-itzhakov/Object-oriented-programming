package images;

public class Invert extends ImageDecorator {
	// Class representing an invert image using base image
	public Invert(Image base) {
		super(base);
	}

	@Override
	public RGB get(int x, int y) {
		return base.get(x, y).invert();
	}

}
