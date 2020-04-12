package com.example.slamjammonitor.Services;

import com.example.slamjammonitor.Entity.Merch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Class service for the product's
 * @author whatislove118
 */

@Service
public class MerchServices {

    /** Application context field  */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * This method get prototype bean Merch from the application context and initialize him
     * @param id - product's id
     * @param name - product's name
     * @param sizes - product's sizes
     * @param price - product's price
     * @param src - product's image src
     * @return new Merch object
     * */
    public Merch initMerch(String id, String name, String price, Set<String> sizes, String src){
        Double correctPrice = Double.parseDouble(price.replace("руб ","").replace(",00","").replace(".",""));
        Merch merch = applicationContext.getBean("merch",Merch.class);
        merch.setId(id);
        merch.setName(name);
        merch.setPrice(correctPrice);
        merch.setSizes(sizes);
        merch.setSrc(src);
        return merch;
    }


}

