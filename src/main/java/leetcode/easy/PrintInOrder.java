package leetcode.easy;

public class PrintInOrder {
    class Foo {
        private volatile int num = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (num != 1) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (num != 2) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
