package hcmute.edu.vn.foody07;

public class TinhThanh {
    public int CodeNumber;
    public String ProvinceName;

    public TinhThanh(int codeNumber, String provinceName) {
        CodeNumber = codeNumber;
        ProvinceName = provinceName;
    }

    public void setCodeNumber(int codeNumber) {
        CodeNumber = codeNumber;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public int getCodeNumber() {
        return CodeNumber;
    }

    public String getProvinceName() {
        return ProvinceName;
    }
}
