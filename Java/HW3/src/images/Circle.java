package images;

public class Circle extends BaseImage {
	//Class representing a circular image with a gradient between center and outside colors
	private int centerX, centerY, radius; // Center coordinates and radius of the circle
	private RGB center, outside; // RGB values for the center and outside of the circle

	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		// Constructor for a square image with the circle centered
		this(size, size, size / 2, size / 2, radius, center, outside);
	}

	@Override
	public RGB get(int x, int y) {
		// Calculate the RGB value based on distance from the center
		return RGB.mix(outside, center, Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)) / radius);
	}
}
