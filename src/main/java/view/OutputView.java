package view;

import constants.Description;



public class OutputView {
    public void startNotify() {
        System.out.println(Description.ORDER_START.getMessage());
    }

    public void endNotify() {
        System.out.println(Description.ORDER_END.getMessage());
    }

}