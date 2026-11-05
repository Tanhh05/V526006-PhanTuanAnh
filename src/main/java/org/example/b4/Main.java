package org.example.b4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Danh sách đa hình: cùng kiểu Point2D nhưng chứa được cả Point3D.
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D(1, 2));
        points.add(new Point2D(4, 6));
        points.add(new Point3D(1, 1, 1));
        points.add(new Point3D(4, 5, 1));
        points.add(new Point2D(-2, 3));
        points.add(new Point2D(1, 7));

        // Cộng khoảng cách của hai điểm kề nhau nếu chúng cùng loại.
        double total2D = 0;
        double total3D = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point2D current = points.get(i);
            Point2D next = points.get(i + 1);

            if (current instanceof Point3D && next instanceof Point3D) {
                total3D += current.distance(next);
            } else if (!(current instanceof Point3D) && !(next instanceof Point3D)) {
                total2D += current.distance(next);
            }
        }
        System.out.printf("Tổng khoảng cách các cặp điểm 2D liên tiếp: %.2f%n", total2D);
        System.out.printf("Tổng khoảng cách các cặp điểm 3D liên tiếp: %.2f%n", total3D);

        // Lưu số lượng ban đầu để chỉ tạo điểm đối xứng từ các điểm gốc.
        int originalSize = points.size();
        for (int i = 0; i < originalSize; i++) {
            points.add(points.get(i).symmetric());
        }

        System.out.println("\nDanh sách sau khi thêm các điểm đối xứng:");
        for (int i = 0; i < points.size(); i++) {
            System.out.print((i + 1) + ". ");
            points.get(i).display(); // Gọi đúng phiên bản display theo kiểu thực tế.
        }

        // Thử tịnh tiến một điểm 2D và một điểm 3D.
        Point2D point2D = new Point2D(2, 3);
        Point3D point3D = new Point3D(2, 3, 4);
        point2D.translate(1, -1);
        point3D.translate(1, -1, 2);
        System.out.println("\nĐiểm 2D sau tịnh tiến (1, -1):");
        point2D.display();
        System.out.println("Điểm 3D sau tịnh tiến (1, -1, 2):");
        point3D.display();
    }
}
