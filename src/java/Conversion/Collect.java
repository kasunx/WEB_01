/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversion;

import java.util.HashMap;

/**
 *
 * @author Kasun Kalhara
 */
public class Collect {

  static HashMap<String, String> e_key_hm = new HashMap<>();

    public static void putKey(String key, String value) {

        e_key_hm.put(key, value);
    }
    
     public static HashMap getKeyCollection() {

        return e_key_hm;
    }
    
//    public static void main(String[] args) {
//        putKey("aaaaaaaaa", System.currentTimeMillis()+"");
//        
//
//         
//         System.out.println(e_key_hm);
//         
//          putKey("aaaaaaaaa", "11122222222");
//          
//           System.out.println(e_key_hm);
//    }

}
