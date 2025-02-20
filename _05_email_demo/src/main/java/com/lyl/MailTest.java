package com.lyl;

import cn.hutool.extra.mail.MailUtil;

/**
 * Desc:
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/02/20 09:37:49
 */
public class MailTest {
    public static void main(String[] args) {
        MailUtil.send("1552412358@qq.com", "测试", "邮件内容测试", false);
    }
}
