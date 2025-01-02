package com.yupi.springbootinit.model.entity;

import lombok.Data;

/**
 * @Author: SixAn
 * @Date: 2025-01-02 19:53
 * @Description:
 */
@SuppressWarnings({"all"})
@Data
public class Picture {
    /**
     * 图片地址
     */
    private String url;
    /**
     * 图片标题
     */
    private String title;
}
