public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen;

    public Rectangle() {
        width = 1.0;
        height= 1.0;
        id = idGen++;
    }
    public Rectangle(double width, double height) {
        this();
        setWidth(width);
        setHeight(height);

    }

    public void setWidth(double width) {
        if  (width > 0) {
            this.width = width;
        }
        else {throw new IllegalArgumentException("width must be greater than zero");}
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
        else {throw new IllegalArgumentException("height must be greater than zero");}
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public double area() {
        return height * width;

    }
    public double perimeter() {
        return 2 * (height + width);
    }
    @Override
    public String toString () {
        return "Rectangle id=" +id +", Height=" +height + ", Width=" +width;
    }
}
