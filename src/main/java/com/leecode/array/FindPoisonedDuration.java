package com.leecode.array;

/**
 * <br/><a href="https://leetcode.cn/problems/teemo-attacking/description/">495. 提莫攻击</a>
 */
public class FindPoisonedDuration {

    /**
     * 扫描法<br/>
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度 <br/>
     * 空间复杂度：O(1)。<br/>
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDurationScanning(int[] timeSeries, int duration) {
        int beginTime, endTime, poisonedDuration = 0;
        beginTime = timeSeries[0];
        endTime = beginTime + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= endTime) {
                endTime = timeSeries[i] + duration;
            } else {
                poisonedDuration += endTime - beginTime;
                beginTime = timeSeries[i];
                endTime = beginTime + duration;
            }
        }
        poisonedDuration += endTime - beginTime;
        return poisonedDuration;
    }

    /**
     * 重叠解法<br/>
     * 研究解法想到,代码轻便不少<br/>
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度(仍需要扫描一遍) <br/>
     * 空间复杂度：O(1)。<br/>
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //计算出总中毒时长
        int poisonedDuration = timeSeries.length * duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i - 1] + duration > timeSeries[i]) {
                //减去重合部分
                poisonedDuration -= timeSeries[i - 1] + duration - timeSeries[i];
            }
        }
        //得出实际时长
        return poisonedDuration;
    }
}
