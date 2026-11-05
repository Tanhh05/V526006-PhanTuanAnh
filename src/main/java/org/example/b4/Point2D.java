package org.example.b4;

public class Point2D {
    private double x;
    private double y;

    // Tạo điểm mặc định tại gốc tọa độ O(0, 0).
    public Point2D() {
        this(0, 0);
    }

    // Tạo điểm tại tọa độ (x, y).
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Tính khoảng cách từ điểm hiện tại đến một điểm 2D khác.
    public double distance(Point2D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Trả về điểm đối xứng của điểm hiện tại qua gốc tọa độ.
    public Point2D symmetric() {
        return new Point2D(-x, -y);
    }

    // Dời điểm hiện tại theo độ lệch dx và dy.
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Hiển thị tọa độ điểm.
    public void display() {
        System.out.printf("(%.2f, %.2f)%n", x, y);
    }
}
