package com.wg.demo.设计模式.责任链模式.责任链;

import com.wg.demo.设计模式.责任链模式.日常.PreparationList;

/**
 * @author 汪贯
 * @desc
 */
public class HaveBreakfastFilter extends AbstractPrepareFilter {

    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isHaveBreakfast()){
            System.out.println("吃早餐");
        }
    }
}
