package org.example.btvn;

import java.util.Scanner;

public class NhanVien extends Nguoi {
    private int soNamCongTac;
    private double heSoLuong;

    public NhanVien() {
        super();
        soNamCongTac = 0;
        heSoLuong = 0;
    }

    public NhanVien(String hoTen, int tuoi, int soNamCongTac, double heSoLuong) {
        super(hoTen, tuoi);
        this.soNamCongTac = soNamCongTac;
        this.heSoLuong = heSoLuong;
    }

    public int getSoNamCongTac() {
        return soNamCongTac;
    }

    public void setSoNamCongTac(int soNamCongTac) {
        this.soNamCongTac = soNamCongTac;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    // Nhập thông tin cơ bản kế thừa từ Nguoi và thông tin riêng của nhân viên.
    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);

        System.out.print("Số năm công tác: ");
        soNamCongTac = nhapSoNguyenKhongAm(scanner);

        System.out.print("Hệ số lương: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Vui lòng nhập hệ số lương hợp lệ: ");
            scanner.next();
        }
        heSoLuong = scanner.nextDouble();
        scanner.nextLine();
    }

    // Tính lương theo đơn vị triệu đồng: 1.5 triệu * hệ số + 0.2 triệu * số năm công tác.
    public double tinhTienLuong() {
        return 1.5 * heSoLuong + 0.2 * soNamCongTac;
    }

    // In toàn bộ thông tin của nhân viên và tiền lương.
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Số năm công tác: %d | Hệ số lương: %.2f | Lương: %.2f triệu đồng%n",
                soNamCongTac, heSoLuong, tinhTienLuong());
    }
}
