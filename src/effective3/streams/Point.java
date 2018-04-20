package effective3.streams;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Point {
    private double value;
    private Optional<Point> next;

    public Point(double value) {
        this.value = value;
    }

    public Point(double value, Point next) {
        this.value = value;
        this.next = Optional.ofNullable(next);
    }

    @Override
    public String toString() {
        return "Point{" + "value=" + value + ", next=" + next + '}';
    }

    public Stream<Point> flatten() {
        if (next == null || !next.isPresent()) return Stream.of(this);
        return Stream.concat(Stream.of(this), next.get().flatten());
    }

    public double getValue() {
        return value;
    }

    public static void main(String[] args) {
        Point p3 = new Point(13);
        Point p2 = new Point(12, p3);
        Point p = new Point(11, p2);
        Point p1 = new Point(10, p);


        System.out.println(p1.flatten().map(Point::getValue).collect(toList()));

        Point last1 = new Point(300);
        Point last = new Point(100, last1);
        Point point = new Point(200, last);
        point.flatten().forEach(u -> System.out.println(u.value));
    }
}
