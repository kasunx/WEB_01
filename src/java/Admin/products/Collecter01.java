/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kasun Kalhara
 */
public class Collecter01 {

    static int i = 0;
    static String key = null;
    static String value = null;
    static String unit = null;
    static HashMap<String, List> specifications = new HashMap<>();

    static List<String> v1 = null;

    public static void collectSpec(String val) {

        switch (i % 3) {
            case 0:

                key = val;
                i++;
                System.out.println(key);
                break;
            case 1:
                value = val;
                i++;
                System.out.println(value);
                break;
            case 2:

                unit = val;
                System.out.println(unit);

                v1 = new ArrayList<String>();
                v1.add(value);
                v1.add(unit);
                System.out.println(v1);

                specifications.put(key, v1);
                System.out.println(specifications);

                i++;
                break;
            default:
        }

    }

//    static String delivery_areas = "";
    static String delivery_areas = "";

    static void collectDeliveryArea(String val) {

        delivery_areas += ">" + val;

    }

    static List<String> product_images = new ArrayList<String>();

    static void collectImages(String rpath) {

        product_images.add(rpath);
    }

    static List<String> undc = null;

    static void udeleteSpecifications(String uddata) {

        System.out.println("sffffffffffffffffff");

    }
}
