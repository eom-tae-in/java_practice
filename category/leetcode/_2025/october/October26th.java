package category.leetcode._2025.october;

public class October26th {

    class Bank {

        private final long[] balance;

        public Bank(long[] balance) {
            this.balance = new long[balance.length + 1];
            System.arraycopy(balance, 0, this.balance, 1, balance.length);
        }

        public boolean transfer(int account1, int account2, long money) {
            if (isInvalidAccount(account1) || isInvalidAccount(account2) || isInsufficientBalance(account1, money)) {
                return false;
            }

            balance[account1] -= money;
            balance[account2] += money;

            return true;
        }

        private boolean isInvalidAccount(int account) {
            return account > balance.length;
        }

        private boolean isInsufficientBalance(int account, long money) {
            return balance[account] < money;
        }

        public boolean deposit(int account, long money) {
            if (isInvalidAccount(account)) {
                return false;
            }

            balance[account] += money;

            return true;
        }

        public boolean withdraw(int account, long money) {
            if (isInvalidAccount(account) || isInsufficientBalance(account, money)) {
                return false;
            }

            balance[account] -= money;

            return true;
        }
    }
}
