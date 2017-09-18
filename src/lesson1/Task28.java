package lesson1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task28 {

    public static void main(String[] args) {
        Transaction t = new Transaction();
        List<Transaction> transactions = Arrays.asList(t);
        Map<String, Long> totalSumOfTransByEachAccount =
                transactions.stream().collect( Collectors.groupingBy(item -> item.getAccount().getNumber(),Collectors.summingLong(Transaction::getSum)));
    }

    class Account{

        String number;
        Long balance;

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

    }
}

class Transaction {

    String uuid;
    Long sum;
    Account account;

    public String getUuid() {
        return uuid;
    }

    public Long getSum() {
        return sum;
    }

    public Account getAccount() {
        return account;
    }
}