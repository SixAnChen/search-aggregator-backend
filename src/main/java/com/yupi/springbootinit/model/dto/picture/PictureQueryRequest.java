package com.yupi.springbootinit.model.dto.picture;

import com.yupi.springbootinit.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings({"all"})
public class PictureQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 搜索词
     */
    private String searchText;
}
