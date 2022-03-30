package com.wg.demo.代码骚操作.减少非空判断;

/**
 * @author wg
 */
public class MyParser implements Parser {

    private static Action DO_NOTHING = new Action() {
        public void doSomething() { /* do nothing */ }
    };

    public Action findAction(String userInput) {
        // ...
        if (null == userInput) {
            return DO_NOTHING;
        }
        return new Action() {
            @Override
            public void doSomething() {
                System.out.println("test");
            }
        };
    }


    public static void main(String[] args) {
        Parser myparser = new MyParser();
        myparser.findAction("test").doSomething();
    }

}
