package org.example.b2;

public class ChuNhat extends Hinh {
    private final double chieuDai;
    private final double chieuRong;

    public ChuNhat(double chieuDai, double chieuRong) {
        if (chieuDai <= 0 || chieuRong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0.");
        }
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    @Override
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
}
