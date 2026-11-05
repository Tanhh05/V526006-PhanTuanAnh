package org.example.btvn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Nhập số lượng nhân viên: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập số nguyên dương: ");
                scanner.next();
            }
            n = scanner.nextInt();
            scanner.nextLine();
            if (n <= 0) {
                System.out.println("Số lượng nhân viên phải lớn hơn 0.");
            }
        } while (n <= 0);

        ArrayList<NhanVien> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập nhân viên thứ " + (i + 1) + ":");
            NhanVien nhanVien = new NhanVien();
            nhanVien.nhap(scanner);
            danhSach.add(nhanVien);
        }

        // Tìm nhân viên có số năm công tác nhiều nhất.
        NhanVien thamNienCaoNhat = danhSach.get(0);
        for (NhanVien nhanVien : danhSach) {
            if (nhanVien.getSoNamCongTac() > thamNienCaoNhat.getSoNamCongTac()) {
                thamNienCaoNhat = nhanVien;
            }
        }

        System.out.println("\nNhân viên có số năm công tác nhiều nhất:");
        thamNienCaoNhat.xuat();

        // Sắp xếp danh sách theo lương giảm dần.
        danhSach.sort(Comparator.comparingDouble(NhanVien::tinhTienLuong).reversed());

        System.out.println("\nDanh sách nhân viên theo lương từ cao đến thấp:");
        for (NhanVien nhanVien : danhSach) {
            nhanVien.xuat();
        }

        scanner.close();
    }
}
