package images;

public class Superpose extends BinaryImageDecorator {
	// Class representing a Superpose image combining base1 and base2 images
	public Superpose(Image base1, Image base2) {
		super(base1, base2);
		this.base1 = base1;
		this.base2 = base2;
	}
	
	@Override
	public RGB get(int x, int y) { 
		// initialize the ret color to black
		// and add to ret the colors based on the coordinates
		RGB ret = new RGB(0);
		if (x<base1.getWidth() && y<base1.getHeight()) {
			ret = RGB.superpose(ret, base1.get(x, y));
		}
		if (x<base2.getWidth() && y<base2.getHeight()) {
			ret = RGB.superpose(ret, base2.get(x, y));
		}
		return ret;
	}

}
