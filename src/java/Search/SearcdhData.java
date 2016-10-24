/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import java.util.HashMap;

/**
 *
 * @author Kasun Kalhara
 */
public class SearcdhData {

    static HashMap pages_data = new HashMap();

    static void putPageData(String x) {
        pages_data.clear();
        String arre0[] = x.split(",");
        double dala_length = arre0.length;
        int page = (int) Math.ceil(dala_length / 10);

        int data[] = null;

        for (int i = 0; i < dala_length; i++) {

            if (i % 10 < 10) {

                System.out.println(((i / 10) + 1) + "--" + (i % 10) + "--" + arre0[i]);

                if (i % 10 == 0) {
                    data = new int[10];
                }

                data[i % 10] = Integer.parseInt(arre0[i]);

                if (i % 10 == 9) {
                    pages_data.put(((i / 10) + 1), data);
                }
                if (i == dala_length - 1) {
                    pages_data.put(((i / 10) + 1), data);
                }
            }
        }

    }

    public static int[] getPageData(int page_no) {
        int page_data[] = (int[]) pages_data.get(page_no);
        return page_data;
    }

    static int getPagesCount() {           
        return pages_data.size();
    }

}
