package Characters;

public enum Level { // enum z wymaganym exp, na określony poziom
    _1(1,100),
    _2(2,300),
    _3(3,600),
    _4(4,1000),
    _5(5,1500),
    _6(6,2100),
    _7(7,2800),
    _8(8,3600),
    _9(9,4500),
    _10(10,5500),
    _11(11,7000),
    _12(12,9000),
    _13(13,11500),
    _14(14,15000),
    _15(15,20000),
    _16(16,28000),
    _17(17,35000),
    _18(18,47000),
    _19(19,60000),
    _20(20,80000);

    private int level;
    private int exp;

    Level(int lvl,int exp) {
        this.exp = exp;
    }
}
