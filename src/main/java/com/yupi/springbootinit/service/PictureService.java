package com.yupi.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.springbootinit.model.entity.Picture;

import java.io.IOException;

public interface PictureService {
    /**
     * 分页获取列表
     */
    Page<Picture> searchPicture(String searchText, Long pageNum, Long pageSize) throws IOException;
}
