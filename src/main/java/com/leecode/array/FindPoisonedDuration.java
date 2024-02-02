package com.leecode.array;

/**
 *
 *
 * <br/><a href="https://leetcode.cn/problems/teemo-attacking/description/">495. 提莫攻击</a>
 */
public class FindPoisonedDuration {

    /**
     * 计算法<br/>
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度 <br/>
     * 空间复杂度：O(1)。<br/>
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int beginTime,endTime,poisonedDuration = 0;
        beginTime = timeSeries[0];
        endTime = beginTime+duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] <= endTime){
                endTime = timeSeries[i]+duration;
            }else{
                poisonedDuration += endTime - beginTime;
                beginTime = timeSeries[i];
                endTime = beginTime+duration;
            }
        }
        poisonedDuration += endTime - beginTime;
        return poisonedDuration;
    }
}
