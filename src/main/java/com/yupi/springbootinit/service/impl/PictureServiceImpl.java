package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.springbootinit.model.entity.Picture;
import com.yupi.springbootinit.service.PictureService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: SixAn
 * @Date: 2025-01-02 20:11
 * @Description:
 */
@Service
@SuppressWarnings({"all"})
public class PictureServiceImpl implements PictureService {
    @Override
    public Page<Picture> searchPicture(String searchText, Long pageNum, Long pageSize) throws IOException {
        String url = "https://unsplash.com/s/photos/" + searchText;
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img");
        List<Picture> list = new ArrayList<>();
        for (Element element : elements) {
            // 取图片地址
            Picture picture = new Picture();
            String imgUrl = element.attr("src");
            if (imgUrl.startsWith("https")) {
                picture.setUrl(imgUrl);
            }
            // 图片标题
            String title = element.attr("alt");
            if (title != null && title.length() > 0) {
                picture.setTitle(title);
            }
            list.add(picture);
        }
        Page<Picture> picturePage = new Page<>(pageNum, pageSize);
        picturePage.setRecords(list);
        return picturePage;
    }
}
