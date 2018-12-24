package com.minbo.dubbo.consumer.util.bankcard;

public class Main {

    private static final Integer card_length_16 = 16;
    private static final Integer card_length_19 = 19;

    public static void main(String[] args) {
        // 卡号
        String cardNumber = "6226 0902 1929 8748";
        System.out.println("输入的卡号" + cardNumber);
        // 去空格
        cardNumber = cardNumber.replaceAll(" ", "");
        System.out.println("去空格后的卡号" + cardNumber);

        // 卡号位数的校验
        if (cardNumber.length() == card_length_16 || cardNumber.length() == card_length_19) {

        } else {
            System.out.println("卡号位数无效");
            return;
        }

        // 校验卡号是不是合法
        if (checkBankCard.checkBankCard(cardNumber) != true) {
            System.out.println("卡号校验失败");
            return;
        }

        //判断是不是银联，老的卡号都是服务电话开头，比如农行是95599
        // http://cn.unionpay.com/cardCommend/gyylbzk/gaishu/file_6330036.htmlh
        if (cardNumber.startsWith("62")) {
            System.out.println("中国银联卡");
        } else {
            System.out.println("国外的卡，或者旧银行卡，暂时没有收录");
            return;
        }

        // 获取银行卡的信息
        String name = BankCardBin.getNameOfBank(cardNumber);
        System.out.println("银行卡信息" + name);

        //归属地每个银行不一样，这里只收录农行少数地区代码
        if (name.startsWith("农业银行") == true) {
            if (cardNumber.length() == 19) {
                name = AbcBankAddr.getAddrOfBank(cardNumber.substring(6, 10));
                System.out.println("开户行" + name);
            }
        }

    }
}
