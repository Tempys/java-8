package lesson1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Task36 {

    public static void main(String[] args) {

    }

    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
       return users.stream().filter(i -> i.getLogin().equals(login)).findFirst();
    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin).map(User::getAccount)
                                  .map(Account::getBalance)
                                  .filter(i -> i >0)
                                  .ifPresent(i -> System.out.println(userLogin+": "+i));


    }

    class Account {
       long balance;
       UUID guid;

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public UUID getGuid() {
            return guid;
        }

        public void setGuid(UUID guid) {
            this.guid = guid;
        }
    }

    class User {
        String login;
        Account account;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
    }
}


