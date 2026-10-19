package org.example.b2;

public class TamGiac extends Hinh {
    private final double canhA;
    private final double canhB;
    private final double canhC;

    public TamGiac(double canhA, double canhB, double canhC) {
        if (canhA <= 0 || canhB <= 0 || canhC <= 0
                || canhA + canhB <= canhC
                || canhA + canhC <= canhB
                || canhB + canhC <= canhA) {
            throw new IllegalArgumentException("Ba cạnh không tạo thành tam giác hợp lệ.");
        }
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
    }

    @Override
    public double tinhChuVi() {
        return canhA + canhB + canhC;
    }

    @Override
    public double tinhDienTich() {
        double nuaChuVi = tinhChuVi() / 2;
        return Math.sqrt(nuaChuVi * (nuaChuVi - canhA)
                * (nuaChuVi - canhB) * (nuaChuVi - canhC));
    }
}
