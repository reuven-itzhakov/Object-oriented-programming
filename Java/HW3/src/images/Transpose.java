package images;

public class Transpose extends ImageDecorator {
	// Class representing a Transpose image using base image
	public Transpose(Image base) {
		super(base, base.getHeight(), base.getWidth());
	}
	
	@Override
	public RGB get(int x, int y) {
		return base.get(y, x);
	}

}
