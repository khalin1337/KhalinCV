import java.util.*;

// Абстрактний клас для фігур
abstract class Shape {
    private Color color;

    public Shape() {
        this.color = getRandomColor();
    }

    public Color getColor() {
        return color;
    }

    private static Color getRandomColor() {
        Random random = new Random();
        return Color.values()[random.nextInt(Color.values().length)];
    }

    public abstract double getArea();

    public abstract String getDescription();

    public void draw() {
        System.out.println(getDescription());
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        super();
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getDescription() {
        return String.format("Фігура: квадрат, площа: %.3f кв. од., довжина сторони: %.3f од., колір: %s.", getArea(), side, getColor().getName());
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }

    public double getHypotenuse() {
        return Math.sqrt(base * base + height * height);
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getDescription() {
        return String.format("Фігура: трикутник, площа: %.3f кв. од., гіпотенуза: %.3f од., колір: %s.", getArea(), getHypotenuse(), getColor().getName());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return String.format("Фігура: коло, площа: %.3f кв. од., радіус: %.3f од., колір: %s.", getArea(), radius, getColor().getName());
    }
}

class Trapezoid extends Shape {
    private double base1;
    private double base2;
    private double height;

    public Trapezoid(double base1, double base2, double height) {
        super();
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * (base1 + base2) * height;
    }

    @Override
    public String getDescription() {
        return String.format("Фігура: трапеція, площа: %.3f кв. од., основи: %.3f од. та %.3f од., висота: %.3f од., колір: %s.", getArea(), base1, base2, height, getColor().getName());
    }
}

enum Color {
    RED("червоний"),
    BLUE("синій"),
    YELLOW("жовтий"),
    GREEN("зелений"),
    ORANGE("помаранчевий"),
    PURPLE("фіолетовий"),
    PINK("рожевий"),
    BLACK("чорний"),
    WHITE("білий"),
    GREY("сірий");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static Shape getRandomShape() {
        Random random = new Random();

        switch (random.nextInt(4)) {
            case 0:
                return new Square(random.nextDouble() * 10 + 1);
            case 1:
                return new Triangle(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 2:
                return new Circle(random.nextDouble() * 10 + 1);
            case 3:
                return new Trapezoid(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int numberOfShapes = random.nextInt(10) + 1;

        List<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < numberOfShapes; i++) {
            shapes.add(getRandomShape());
        }

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
