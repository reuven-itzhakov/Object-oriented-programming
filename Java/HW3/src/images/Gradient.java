package images;

public class Gradient extends BaseImage {
	//Class representing a gradient image transitioning from start color to end color
	private RGB start, end; // RGB values for the start and end of the gradient

	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height);
		this.start = start;
		this.end = end;
	}

	@Override
	public RGB get(int x, int y) {
		// Calculate the RGB value based on horizontal position in the gradient
		return RGB.mix(start, end, 1 - (double) x / width);
	}
}
