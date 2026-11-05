package org.example.btvn;

import java.util.Scanner;

public class Nguoi {
    private String hoTen;
    private int tuoi;

    public Nguoi() {
        this("", 0);
    }

    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    // Nhập họ tên và tuổi của một người.
    public void nhap(Scanner scanner) {
        System.out.print("Họ tên: ");
        hoTen = scanner.nextLine();

        System.out.print("Tuổi: ");
        tuoi = nhapSoNguyenKhongAm(scanner);
    }

    // In thông tin cơ bản của một người.
    public void xuat() {
        System.out.printf("Họ tên: %s | Tuổi: %d", hoTen, tuoi);
    }

    protected int nhapSoNguyenKhongAm(Scanner scanner) {
        int value;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập số nguyên không âm: ");
                scanner.next();
            }
            value = scanner.nextInt();
            scanner.nextLine();
            if (value >= 0) {
                return value;
            }
            System.out.print("Giá trị không được âm, nhập lại: ");
        }
    }
}
