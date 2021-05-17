package com.wg.demo.设计模式.责任链模式.日常;

import lombok.Data;

/**
 * @author 汪贯
 * @desc 小明要去上学，妈妈给小明列了一些上学前需要做的清单（洗头、吃早饭、洗脸），小明必须按照妈妈的要求，把清单上打钩的事情做完了才可以上学。
 * 首先我们定义一个准备列表PreparationList：
 * 定义了三件事：洗脸、洗头、吃早餐
 */
@Data
public class PreparationList {

    /**
     * 是否洗脸
     */
    private boolean washFace;

    /**
     * 是否洗头
     */
    private boolean washHair;

    /**
     * 是否吃早餐
     */
    private boolean haveBreakfast;

}
