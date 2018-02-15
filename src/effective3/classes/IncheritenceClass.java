package effective3.classes;

public class IncheritenceClass extends SuperClass {


    @Override
    public int getBalance() {
        return 5;
    }


    public  int calculateFinalSum(){
        return calculateSumAnnoitet(5);
    }


    public static void main(String[] args) {
        IncheritenceClass incheritenceClass = new IncheritenceClass();

        System.out.println(incheritenceClass.calculateFinalSum());
    }
}
