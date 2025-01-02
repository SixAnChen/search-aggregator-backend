package com.yupi.springbootinit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SuppressWarnings({"all"})
@SpringBootTest
public class CrawlerTest {
    /**
     * 爬取图片
     *
     * @throws IOException
     */
    @Test
    void testFetchPicture() throws IOException {
        String url = "https://unsplash.com/s/photos/美食";
        Document document = Jsoup.connect(url).get();
        // System.out.println(document);
        Elements elements = document.select("img");
        // System.out.println(elements);
        for (Element element : elements) {
            // 取图片地址
            String imgUrl = element.attr("src");
            if (imgUrl.startsWith("https")) {
                System.out.println(imgUrl);
            }
            // 图片标题
            String title = element.attr("alt");
            System.out.println(title);
        }
    }
}