package com.wg.demo.test;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author wg
 */

@Data
@Builder
@AllArgsConstructor
public class PhTimesCardOperationRecordFeature {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 次卡活动名称
     */
    private String templateName;

    public static PhTimesCardOperationRecordFeature newFeature(Long activityId, String templateName) {
        return PhTimesCardOperationRecordFeature.builder()
                .activityId(activityId)
                .templateName(templateName)
                .build();
    }

}
