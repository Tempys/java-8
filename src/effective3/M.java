package effective3;

import java.nio.file.LinkOption;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class M {

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Long(1));
        list.add(new Double(1));

        List<? extends Number> list1 = new ArrayList<Integer>();

        System.out.println(list);





    }
}
