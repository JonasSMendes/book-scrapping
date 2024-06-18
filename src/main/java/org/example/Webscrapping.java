package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class Webscrapping {
    public static void main(String[] args) {
        String url = "https://books.toscrape.com/catalogue/page-";
        String result = "";
        Document doc;
        Elements books;

        while (!result.contains("50")) {

            try {
                for (int i = 1; i <= 50; i++) {
                    result = String.valueOf(i);

                    doc = Jsoup.connect(url + result + ".html").get();
                    books = doc.select(".product_pod");

                    for (Element bk : books) {

                        String title = bk.select("h3 > a").text();
                        String price = bk.select(".price_color").text();


                        System.out.println("""
                                                    
                            #####################################
                                      Webscrapping
                                      
                            Title : %s
                            Price : %s                            
                            #####################################
                            """.formatted(title, price));
                    }

                }

            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}