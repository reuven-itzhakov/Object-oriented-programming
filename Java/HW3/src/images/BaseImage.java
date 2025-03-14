package images;

public abstract class BaseImage implements Image{
	// Abstract base class for images implementing the Image interface
	protected int width,height; // Dimensions of the image
	public BaseImage(int width,int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
