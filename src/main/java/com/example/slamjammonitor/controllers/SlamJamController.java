package com.example.slamjammonitor.controllers;

import com.example.slamjammonitor.Entity.Merch;
import com.example.slamjammonitor.Services.MerchServices;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.internal.xsom.impl.scd.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class controller for analyze products
 * @author whatislove118
 */
@RestController
@RequestMapping("/slamjam")
    public class SlamJamController {
        /**Field with service for Merch*/
        @Autowired
        private MerchServices merchServices;

    /**
     * This method get product's page from the website slamjam.com and parse price,name,src of the image and sizes
     * @param id - product's from the site slamjam.com
     * @return ResponseEntity(merch,HttpStatus.ACCEPTED) in JSON formatt
     */
    @GetMapping(value = "/{id}",produces = "application/json")
        @JsonFormat
        public ResponseEntity analyzeMerch(@PathVariable("id") String id){
            Document document=null;
            Set<String> sizes = new HashSet<>();

            try {
                document = Jsoup.connect("https://www.slamjam.com/en_RU/"+id+".html").header("Accept-Encoding", "gzip, deflate").userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36").maxBodySize(0).get();
            }catch (IOException e){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            String src = document.select("img").get(2).absUrl("src");
            Elements sizesListElements = document.select("option[data-availability]");
            for (Element size : sizesListElements){
                sizes.add(size.text());
            }
            String price = document.select("span.value").first().text();

            String name = document.select("h1.product-name").first().text();

            Merch merch = merchServices.initMerch(id,name,price,sizes,src);
            return new ResponseEntity(merch,HttpStatus.ACCEPTED);
        }



    }
