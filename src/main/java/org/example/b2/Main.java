package org.example.b2;

public class Main {
    public static void main(String[] args) {
        Hinh[] cacHinh = {
                new TamGiac(3, 4, 5),
                new HinhTron(2),
                new ChuNhat(5, 3)
        };

        String[] tenHinh = {"Tam giác", "Hình tròn", "Chữ nhật"};
        for (int i = 0; i < cacHinh.length; i++) {
            System.out.printf("%s: chu vi = %.2f, diện tích = %.2f%n",
                    tenHinh[i], cacHinh[i].tinhChuVi(), cacHinh[i].tinhDienTich());
        }
    }
}
