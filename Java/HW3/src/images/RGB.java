package images;

public class RGB {
	//Class representing an RGB color with various utilities
	private double red, green, blue; // Red, green, and blue components of the color

	public static final RGB BLACK = new RGB(0); 
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	public RGB(double red, double green, double blue) {
		// Initialize color components with values clamped between 0 and 1
		this.red = Math.min(Math.max(red, 0), 1);
		this.green = Math.min(Math.max(green, 0), 1);
		this.blue = Math.min(Math.max(blue, 0), 1);
	}

	public RGB(double grey) {
		// Initialize a grayscale color
		this(grey, grey, grey);
	}

	public double getRed() {
		return red;
	}

	public double getGreen() {
		return green;
	}

	public double getBlue() {
		return blue;
	}

	public RGB invert() {
		// Invert the color
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	public RGB filter(RGB filter) {
		// Apply a color filter
		return new RGB(filter.red * red, filter.green * green, filter.blue * blue);
	}

	public static RGB superpose(RGB rgb1, RGB rgb2) {
		// Superpose two colors
		return new RGB(rgb1.red + rgb2.red, rgb1.green + rgb2.green, rgb1.blue + rgb2.blue);
	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		// Mix two colors with a given alpha value
		alpha = Math.min(Math.max(alpha, 0), 1);
		double red = (alpha * rgb1.red + (1 - alpha) * rgb2.red);
		double green = (alpha * rgb1.green + (1 - alpha) * rgb2.green);
		double blue = (alpha * rgb1.blue + (1 - alpha) * rgb2.blue);
		return new RGB(red, green, blue);
	}

	@Override
	public String toString() {
		// Return the string representation of the color
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
}
