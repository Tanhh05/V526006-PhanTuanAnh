package org.example.b2;

public class HinhTron extends Hinh {
    private final double banKinh;

    public HinhTron(double banKinh) {
        if (banKinh <= 0) {
            throw new IllegalArgumentException("Bán kính phải lớn hơn 0.");
        }
        this.banKinh = banKinh;
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
}
