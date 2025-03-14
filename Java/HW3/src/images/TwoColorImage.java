package images;

public class TwoColorImage extends BaseImage {
	// Class representing two color image using two images and function that will choose
	// the final color to the same (x,y) coordinates
	private RGB zero, one;
	private TwoDFunc func;
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
	}

	@Override
	public RGB get(int x, int y) {
		return RGB.mix(zero, one,1 - func.f((double)x/width, (double)y/height));
	}

}
