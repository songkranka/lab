package th.co.pt.ptgapp.controller.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//import th.co.pt.pcca.pccaapp.helper.WebUtil;
public final class ThaiBaht {
    private static final String[] SCALE_TH = {"เธฅเน�เธฒเธ�", "เธชเธดเธ�", "เธฃเน�เธญเธข", "เธ�เธฑเธ�", "เธซเธกเธทเน�เธ�", "เน�เธชเธ�", "" };
    private static final String[] DIGIT_TH = { "เธจเธนเธ�เธขเน�", "เธซเธ�เธถเน�เธ�", "เธชเธญเธ�", "เธชเธฒเธก", "เธชเธตเน�", "เธซเน�เธฒ", "เธซเธ�", "เน€เธ�เน�เธ”", "เน�เธ�เธ”", "เน€เธ�เน�เธฒ" };
    private static final String[] SYMBOLS_TH = { "เธฅเธ�", "เธ�เธฒเธ—", "เธ–เน�เธงเธ�", "เธชเธ•เธฒเธ�เธ�เน�" ,"เธขเธตเน�", "เน€เธญเน�เธ”", ",", " ", "เธฟ"};
//    private static final String[] SCALE_TH = { WebUtil.GetPropertyMessage("messages_thaiBaht","million"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","ten"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","hundred"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","thousand"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","tenThousand"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","hundredThousand"), "" };
//
//    private static final String[] DIGIT_TH = { WebUtil.GetPropertyMessage("messages_thaiBaht","zero"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","one"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","two"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","three"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","four"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","five"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","six"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","seven"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","eight"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","nine") };
//
//    private static final String[] SYMBOLS_TH = { WebUtil.GetPropertyMessage("messages_thaiBaht","minus"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","baht"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","all") ,
//            WebUtil.GetPropertyMessage("messages_thaiBaht","satang"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","yi"),
//            WebUtil.GetPropertyMessage("messages_thaiBaht","ed"), ",", " ",
//            WebUtil.GetPropertyMessage("messages_thaiBaht","b")};
    private static ThaiBaht thaiBaht;
    private ThaiBaht() {}

    public static ThaiBaht getInstance(){
        if(null == thaiBaht) thaiBaht = new ThaiBaht();
        return thaiBaht;
    }

    private String valueText;

    // ยทยทยทยทยทยทยทยทยทยทยทMethodsยทยทยทยทยทยทยทยทยทยทยทยทยทยท//
    public String getText(double amount) {
        BigDecimal value = new BigDecimal(amount);
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    public String getText(float amount) {
        BigDecimal value = new BigDecimal(amount);
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    public String getText(int amount) {
        BigDecimal value = new BigDecimal(amount);
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    public String getText(long amount) {
        BigDecimal value = new BigDecimal(amount);
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    public String getText(String amount) {
        //เน�เธกเน�เธ•เน�เธญเธ�เธ�เธฒเธฃเน€เธ�เธฃเธทเน�เธญเธ�เธซเธกเธฒเธขเธ�เธญเธกเธกเธฒเธฃเน�, เน�เธกเน�เธ•เน�เธญเธ�เธ�เธฒเธฃเธ�เน�เธญเธ�เธงเน�เธฒเธ�, เน�เธกเน�เธ•เน�เธญเธ�เธ�เธฒเธฃเธ•เธฑเธงเธซเธ�เธฑเธ�เธชเธทเธญ เธ�เธฒเธ—, เน�เธกเน�เธ•เน�เธญเธ�เธ�เธฒเธฃเธชเธฑเธ�เธฅเธฑเธ�เธฉเธ“เน�เธชเธ�เธธเธฅเน€เธ�เธดเธ�เธ�เธฒเธ—
        for (String element : SYMBOLS_TH) {
            amount = amount.replace (element, "");
        }

        BigDecimal value = new BigDecimal(amount.trim());
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    public String getText(Number amount) {
        BigDecimal value = new BigDecimal(String.valueOf(amount));
        this.valueText = getThaiBaht(value);
        return this.valueText;
    }

    private static String getThaiBaht(BigDecimal amount) {
        StringBuilder builder = new StringBuilder();
        BigDecimal absolute = amount.abs();
        int precision = absolute.precision();
        int scale = absolute.scale();
        int rounded_precision = ((precision - scale) + 2);
        MathContext mc = new MathContext(rounded_precision,RoundingMode.HALF_UP);
        BigDecimal rounded = absolute.round(mc);
        BigDecimal[] compound = rounded.divideAndRemainder(BigDecimal.ONE);
        boolean negative_amount = (-1 == amount.compareTo(BigDecimal.ZERO));

        compound[0] = compound[0].setScale(0);
        compound[1] = compound[1].movePointRight(2);

        if (negative_amount) {
            builder.append(SYMBOLS_TH[0].toString());
        }

        builder.append(getNumberText(compound[0].toBigIntegerExact()));
        builder.append(SYMBOLS_TH[1].toString());

        if (0 == compound[1].compareTo(BigDecimal.ZERO)) {
            builder.append(SYMBOLS_TH[2].toString());
        } else {
            builder.append(getNumberText(compound[1].toBigIntegerExact()));
            builder.append(SYMBOLS_TH[3].toString());
        }
        return builder.toString();
    }

    private static String getNumberText(BigInteger number) {
        StringBuffer buffer = new StringBuffer();
        char[] digits = number.toString().toCharArray();

        for (int index = digits.length; index >0; --index) {
            int digit = Integer.parseInt(String.valueOf(digits[digits.length
                    - index]));
            String digit_text = DIGIT_TH[digit];
            int scale_idx = ((1 < index) ? ((index - 1) % 6) : 6);

            if ((1 == scale_idx) && (2 == digit)) {
                digit_text = SYMBOLS_TH[4].toString();
            }

            if (1 == digit) {
                switch (scale_idx) {
                    case 0:
                    case 6:
                        buffer.append((index < digits.length) ? SYMBOLS_TH[5].toString() : digit_text);
                        break;
                    case 1:
                        break;
                    default:
                        buffer.append(digit_text);
                        break;
                }
            } else if (0 == digit) {
                if (0 == scale_idx) {
                    buffer.append(SCALE_TH[scale_idx]);
                }
                continue;
            } else {
                buffer.append(digit_text);
            }
            buffer.append(SCALE_TH[scale_idx]);
        }
        return buffer.toString();
    }

    /**
     * @param args
     */
//    public static void main(String[] args) {
//        // เธ�เธธเธ”เธ—เธจเธ�เธดเธขเธกเธ�เธฑเธ”เน€เธ�เน�เธ�เธชเธญเธ�เธ•เธณเน�เธซเธ�เน�เธ�
//        System.out.println("Negative value of -1257.5463 : " + ThaiBaht.getInstance().getText(55.246));
//        System.out.println("Positive value of 1234.5463 : " + ThaiBaht.getInstance().getText(1230000));
//        System.out.println("Negative string value of -1,234.5463 : " + ThaiBaht.getInstance().getText("1234250.26"));
//
//    }

}

