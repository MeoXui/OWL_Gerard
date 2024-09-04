package gerard;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jinca
 */
public class S1_2_and_S2_sub {
    int total = 21;
    int sCM = 0;
    int sTL = 0;
    int sCH = 0;
    int sST = 0;
    double poaST;

    public S1_2_and_S2_sub(int total, double poaST) {
        this.total = total;
        this.poaST = poaST;
    }
    
    Double base(int CHoa) {
        return 12.0 + CHoa + poaST/10;
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
    
    Double multi(int CHoa, int SThuong) {
        return (1 + 0.5 * CHoa) * (1 + 0.2 * SThuong);
    }
    
    Double pro(int CMoc, int TGian, int CHoa, int SThuong) {
        return base(CHoa) * sum(CMoc, TGian) * multi(CHoa, SThuong);
    }
    
    void getToiUu() {
        Double fdmg = 0.0;
        for (int i = 0; i < total; i++) {
            Double d1 = pro(sCM + 1, sTL, sCH, sST);
            if(fdmg < d1) fdmg = d1;
            Double d2 = pro(sCM, sTL + 1, sCH, sST);
            if(fdmg < d2) fdmg = d2;
            Double d4 = pro(sCM, sTL, sCH + 1, sST);
            if(fdmg < d4) fdmg = d4;
            Double d5 = pro(sCM, sTL, sCH, sST + 1);
            if(fdmg < d5) fdmg = d5;
            

            if(fdmg == d1) sCM++;
            if(fdmg == d2) sTL++;
            if(fdmg == d4) sCH++;
            if(fdmg == d5) sST++;
            System.out.println(sCM + "CM, "
                             + sTL + "TG, "
                             + sCH + "CH, "
                             + sST + "ST :"
                             + " Tong " + fdmg);
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "*poa sat thuong: " + poaST + "%\n"
                + "Toi uu an cho Gerard voi tong so an la: " + total + "\n"
                + " - an Cot moc: " + sCM + " an\n"
                + " - an Thoi luong: " + sTL + " an\n"
                + " - an Cuong hoa: " + sCH + " an\n"
                + " - an Sat thuong: " + sST + " an\n";
    }
}
