package day1;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    Rectangle(Dimension height, Dimension width) {
        this.height = height.getDimension();
        this.width = width.getDimension();
    }

    @Override
    public double calculateArea() {
        return this.height * this.width;
    }


    public double calculatePerimeter() {
        return 2 * (this.width + this.height);
    }
}




