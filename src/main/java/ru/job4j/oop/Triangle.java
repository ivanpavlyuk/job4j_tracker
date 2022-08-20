package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter() {
        return (first.distance(second) + second.distance(third) + third.distance(first)) / 2;
    }

    public boolean exist() {
        return  first.distance(second) + second.distance(third) > third.distance(first)
                && second.distance(third) + third.distance(first) > first.distance(second)
                && third.distance(first) + first.distance(second) > second.distance(third);
    }

    public double area() {
         return exist() ? Math.sqrt(semiPerimeter() * (semiPerimeter() - first.distance(second))
                 * (semiPerimeter() - second.distance(third)) * (semiPerimeter() - third.distance(first)))
                    : -1;
        }
    }