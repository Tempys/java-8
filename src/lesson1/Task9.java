package lesson1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * You have a class Account (number: String, balance: Long, isLocked: boolean), the list accounts of type List<Account> and the method filter(List<T> elems, Predicate<T> predicate) for filtering the given list of type T by the predicate.

 The class Account has the next methods: getNumber(), getBalance(), isLocked() for getting the values of the corresponding fields.

 Write a code for filtering the accounts list in two ways:

 get list with all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
 get all non-locked accounts with too much money (balance >= 100 000 000) and save it to the variable accountsWithTooMuchMoney
 The class Account, the list accounts (List<Account>) and the method filter(...) will be available during testing.

 Important. Use the given code template for your solution. Do not change it!

 Example of use the filter method. The code below gets only even number from the list.

 List<Integer> numbers = ...
 List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);

 PS: it's often called behaviour parametrization because behaviour of the method filter is dependent of the given predicate.
 */
public class Task9 {

      public static List<Account> filter(List<Account> list,Predicate<Account> predicate){
            return list.stream().filter(predicate).collect(Collectors.toList());
      }


    public static List<Account> filterFinal(List<Account> list,Predicate<Account> predicate){
        return list.stream().filter(x -> !x.isLocked() && x.getBalance() >= 100_000_000 ).collect(Collectors.toList());
    }

   static Predicate<Account> predicate = (x) -> x.getBalance() != 0;

    public static void main(String[] args) {

        List<Account> accounts = Arrays.asList(new Account("1",0L,true),new Account("1",1L,true)); // write your code here

        accounts.add(new Account("1",0L,true));
        accounts.add(new Account("1",1L,true));

        System.out.println(accounts);

        List<Account> nonEmptyList = filter(accounts,(x) -> x.getBalance() != 0);

        List<Account> accountsWithTooMuchMoney =  null;// write your code here
       // System.out.println(accountsWithTooMuchMoney);

// just an example
// List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
// List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);
    }
}


class Account {

  private String number;
  private Long balance;
  private boolean locked;

    public Account(String number, Long balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.locked = isLocked;
    }

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", locked=" + locked +
                '}';
    }
}