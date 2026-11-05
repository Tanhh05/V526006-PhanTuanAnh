package org.example.b4;

public class Point3D extends Point2D {
    private double z;

    // Tạo điểm mặc định tại gốc tọa độ O(0, 0, 0).
    public Point3D() {
        this(0, 0, 0);
    }

    // super(x, y) khởi tạo phần tọa độ kế thừa từ Point2D.
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Tính khoảng cách 3D; nếu other là điểm 2D thì xem tọa độ z của nó là 0.
    @Override
    public double distance(Point2D other) {
        double dz = other instanceof Point3D ? z - ((Point3D) other).z : z;
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Trả về điểm 3D đối xứng qua gốc tọa độ O(0, 0, 0).
    @Override
    public Point3D symmetric() {
        return new Point3D(-getX(), -getY(), -z);
    }

    // Ghi đè phép tịnh tiến 2D để dời x, y và giữ nguyên z.
    @Override
    public void translate(double dx, double dy) {
        super.translate(dx, dy);
    }

    // Tịnh tiến điểm 3D theo cả ba độ lệch.
    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);
        z += dz;
    }

    // Hiển thị cả ba tọa độ.
    @Override
    public void display() {
        System.out.printf("(%.2f, %.2f, %.2f)%n", getX(), getY(), z);
    }
}
