package org.example.b3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soLuong;
        do {
            System.out.print("Nhập số lượng phân số: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập một số nguyên: ");
                scanner.next();
            }
            soLuong = scanner.nextInt();
            if (soLuong <= 0) {
                System.out.println("Số lượng phải lớn hơn 0.");
            }
        } while (soLuong <= 0);

        List<PhanSo> cacPhanSo = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập phân số thứ " + (i + 1) + ":");
            int tuSo = nhapSoNguyen(scanner, "  Tử số: ");
            int mauSo;
            do {
                mauSo = nhapSoNguyen(scanner, "  Mẫu số (khác 0): ");
                if (mauSo == 0) {
                    System.out.println("Mẫu số không được bằng 0, vui lòng nhập lại.");
                }
            } while (mauSo == 0);
            cacPhanSo.add(new PhanSo(tuSo, mauSo));
        }

        PhanSo tong = new PhanSo();
        PhanSo lonNhat = cacPhanSo.get(0);
        int soPhanSoKhongNguyen = 0;

        for (PhanSo phanSo : cacPhanSo) {
            tong = tong.cong(phanSo);
            if (phanSo.compareTo(lonNhat) > 0) {
                lonNhat = phanSo;
            }
            if (!phanSo.laSoNguyen()) {
                soPhanSoKhongNguyen++;
            }
        }

        System.out.println("Tập phân số: " + cacPhanSo);
        System.out.println("Phân số lớn nhất: " + lonNhat);
        System.out.println("Tổng các phân số: " + tong);
        System.out.println("Số phân số không phải số nguyên: " + soPhanSoKhongNguyen);
    }

    private static int nhapSoNguyen(Scanner scanner, String loiNhac) {
        System.out.print(loiNhac);
        while (!scanner.hasNextInt()) {
            System.out.print("Vui lòng nhập một số nguyên: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
