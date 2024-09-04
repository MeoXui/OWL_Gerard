/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerard;

/**
 *
 * @author jinca
 */
public class S1_2_and_S1_sub {
    int total = 21;
    int sCM = 0;
    //int sHD = 0;
    int sTL = 0;
    int sCH = 0;
    int sST = 0;
    double poaST;

    public S1_2_and_S1_sub(int total, double poaST) {
        this.total = total;
        this.poaST = poaST;
    }
    Double base() {
        return 10.0 + poaST/10;
    }
    
    Double skill(int at, int CMoc) {
        return 0.4 + at * 0.0375 * CMoc;
    }
    
    Double sum(int CMoc, int TGian) {
        Double s = 0.0;
        for(int i = 0; i <= (16 + 8 * TGian); i++)
            s += skill(i, CMoc);
        return s;
    }
    
    Double pro(int CMoc, int TGian, int CHoa, int SThuong) {
        return base() * (1 + 0.2 * SThuong) * (sum(CMoc, TGian) * (1 + 0.5 * CHoa) + sum(CMoc, TGian) / 2);
    }
    
    void getToiUu() {
        Double finalDmg = 0.0;
        for (int i = 0; i < total; i++) {
            Double d1 = pro(sCM + 1, sTL, sCH, sST);
            if(finalDmg < d1) finalDmg = d1;
            Double d2 = pro(sCM, sTL + 1, sCH, sST);
            if(finalDmg < d2) finalDmg = d2;
            Double d4 = pro(sCM, sTL, sCH + 1, sST);
            if(finalDmg < d4) finalDmg = d4;
            Double d5 = pro(sCM, sTL, sCH, sST + 1);
            if(finalDmg < d5) finalDmg = d5;

            if(finalDmg == d1) sCM++;
            if(finalDmg == d2) sTL++;
            if(finalDmg == d4) sCH++;
            if(finalDmg == d5) sST++;
            System.out.println(sCM + "CM, "
                             + sTL + "TG, "
                             + sCH + "CH, "
                             + sST + "ST :"
                             + " Tong " + finalDmg);
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Toi uu an cho Gerard voi tong so an la: " + total + "\n"
                + " - an Cot moc: " + sCM + " an\n"
                + " - an Thoi luong: " + sTL + " an\n"
                + " - an Cuong hoa: " + sCH + " an\n"
                + " - an Sat thuong: " + sST + " an\n";
    }
}
