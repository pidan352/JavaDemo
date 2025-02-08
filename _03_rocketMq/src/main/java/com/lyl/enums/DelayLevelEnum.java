package com.lyl.enums;

/**
 * Desc:
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/02/08 09:07:02
 */
public enum DelayLevelEnum {
    LEVEL_1(1, 1000),          // 1s
    LEVEL_2(2, 5000),          // 5s
    LEVEL_3(3, 10000),         // 10s
    LEVEL_4(4, 30000),         // 30s
    LEVEL_5(5, 60000),         // 1min
    LEVEL_6(6, 120000),        // 2min
    LEVEL_7(7, 180000),        // 3min
    LEVEL_8(8, 240000),        // 4min
    LEVEL_9(9, 300000),        // 5min
    LEVEL_10(10, 360000),      // 6min
    LEVEL_11(11, 420000),      // 7min
    LEVEL_12(12, 480000),      // 8min
    LEVEL_13(13, 540000),      // 9min
    LEVEL_14(14, 600000),      // 10min
    LEVEL_15(15, 1200000),     // 20min
    LEVEL_16(16, 1800000),     // 30min
    LEVEL_17(17, 3600000),     // 1h
    LEVEL_18(18, 7200000);     // 2h

    private final int level;   // 投递等级
    private final long delayMillis; // 延迟时间（毫秒）

    // 构造函数
    DelayLevelEnum(int level, long delayMillis) {
        this.level = level;
        this.delayMillis = delayMillis;
    }

    // 获取投递等级
    public int getLevel() {
        return level;
    }

    // 获取延迟时间（毫秒）
    public long getDelayMillis() {
        return delayMillis;
    }

    // 根据投递等级获取对应的枚举实例
    public static DelayLevelEnum fromLevel(int level) {
        for (DelayLevelEnum delayLevel : DelayLevelEnum.values()) {
            if (delayLevel.getLevel() == level) {
                return delayLevel;
            }
        }
        throw new IllegalArgumentException("Invalid delay level: " + level);
    }
}
