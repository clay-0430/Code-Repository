package com.wg.demo.设计模式.责任链模式.责任链;

import com.wg.demo.设计模式.责任链模式.日常.PreparationList;

/**
 * @author 汪贯
 * @desc
 */

public abstract class AbstractPrepareFilter {

    private AbstractPrepareFilter nextPrepareFilter;

    public AbstractPrepareFilter(AbstractPrepareFilter nextPrepareFilter){
        this.nextPrepareFilter = nextPrepareFilter;
    }

    public void doFilter(PreparationList preparationList, OnlyStudy onlyStudy){
        prepare(preparationList);
        if (nextPrepareFilter == null){
            onlyStudy.study();
        }else {
            nextPrepareFilter.doFilter(preparationList, onlyStudy);
        }
    }

    public abstract void prepare(PreparationList preparationList);

}
