package images;

public abstract class BinaryImageDecorator implements Image {
	// Abstract base class for images implementing the Image interface
	protected int width,height;
	protected Image base1, base2;
	
	public BinaryImageDecorator(Image base1, Image base2) {
		this.width = Math.max(base1.getWidth(), base2.getWidth());
		this.height = Math.max(base1.getHeight(), base2.getHeight());
		this.base1 = base1;
		this.base2 = base2;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
