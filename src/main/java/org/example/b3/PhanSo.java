package org.example.b3;

public class PhanSo implements Comparable<PhanSo> {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this(0, 1);
    }

    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0.");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
        rutGon();
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0.");
        }
        this.mauSo = mauSo;
        rutGon();
    }

    public PhanSo cong(PhanSo phanSo) {
        return new PhanSo(
                Math.addExact(Math.multiplyExact(tuSo, phanSo.mauSo),
                        Math.multiplyExact(phanSo.tuSo, mauSo)),
                Math.multiplyExact(mauSo, phanSo.mauSo));
    }

    public PhanSo tru(PhanSo phanSo) {
        return new PhanSo(
                Math.subtractExact(Math.multiplyExact(tuSo, phanSo.mauSo),
                        Math.multiplyExact(phanSo.tuSo, mauSo)),
                Math.multiplyExact(mauSo, phanSo.mauSo));
    }

    public PhanSo nhan(PhanSo phanSo) {
        return new PhanSo(Math.multiplyExact(tuSo, phanSo.tuSo),
                Math.multiplyExact(mauSo, phanSo.mauSo));
    }

    public PhanSo chia(PhanSo phanSo) {
        if (phanSo.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số 0.");
        }
        return new PhanSo(Math.multiplyExact(tuSo, phanSo.mauSo),
                Math.multiplyExact(mauSo, phanSo.tuSo));
    }

    public boolean soSanh(PhanSo phanSo) {
        return compareTo(phanSo) == 0;
    }

    public PhanSo rutGon() {
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        int ucln = ucln(Math.abs(tuSo), mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        return this;
    }

    @Override
    public int compareTo(PhanSo phanSo) {
        return Long.compare((long) tuSo * phanSo.mauSo,
                (long) phanSo.tuSo * mauSo);
    }

    private int ucln(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a == 0 ? 1 : a;
    }

    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }

    @Override
    public String toString() {
        return mauSo == 1 ? Integer.toString(tuSo) : tuSo + "/" + mauSo;
    }
}
