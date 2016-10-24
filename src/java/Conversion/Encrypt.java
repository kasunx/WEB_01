/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversion;

/**
 *
 * @author Kasun Kalhara
 */
public class Encrypt {

    public static String getKey() {

        String en_k1 = "";

        String in_k1 = System.currentTimeMillis() + "";
        System.out.println(in_k1);

        for (String in_kys : in_k1.split("")) {

            switch (in_kys) {
                case "0":
                    en_k1 += "8";
                    break;
                case "1":
                    en_k1 += "5";
                    break;
                case "2":
                    en_k1 += "0";
                    break;
                case "3":
                    en_k1 += "4";
                    break;
                case "4":
                    en_k1 += "9";
                    break;
                case "5":
                    en_k1 += "1";
                    break;
                case "6":
                    en_k1 += "6";
                    break;
                case "7":
                    en_k1 += "3";
                    break;
                case "8":
                    en_k1 += "7";
                    break;
                case "9":
                    en_k1 += "2";
                    break;
            }
        }                         
        return en_k1;
    }

//    public static void main(String[] args) {
////        username("kasunxkalhara1211@gmail.com");
//    }

}
