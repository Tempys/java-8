package effective3.concurrency;

import java.util.HashSet;

public class MainConcurrency {

    public static void main(String[] args) {
        ObservableSet<Integer> set =  new ObservableSet<>(new HashSet<>());
        //set.addObserver((s, e) -> System.out.println(e));
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);

                if (e == 23)
                     s.removeObserver(this);
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
