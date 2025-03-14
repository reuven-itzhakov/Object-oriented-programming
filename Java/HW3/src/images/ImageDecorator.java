package images;

public abstract class ImageDecorator implements Image {
	//Abstract class for decorating an image with additional functionality
	protected int width, height; // Dimensions of the image
	protected Image base; // Base image to be decorated

	public ImageDecorator(Image base, int width, int height) {
		// Initialize with base image and given width and height
		this.width = width;
		this.height = height;
		this.base = base;
	}

	public ImageDecorator(Image base) {
		// Initialize with dimensions from the base image
		this.width = base.getWidth();
		this.height = base.getHeight();
		this.base = base;
	}

	@Override
	public int getWidth() {
		return width; // Return the width of the image
	}

	@Override
	public int getHeight() {
		return height; // Return the height of the image
	}
}
