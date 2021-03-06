package com.google.style.manage.controller;

import com.google.style.service.first.GoodsService;
import com.google.style.model.first.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangz
 * @date 2018/1/26 17:05
 *  For test
 **/

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


      @Autowired
      private GoodsService goodsService;

      @RequestMapping("/save")
      public void save(@RequestBody Goods goods){
          Integer saveStatus = goodsService.save(goods);
          if(saveStatus!=1){
                log.info("=======save fail ======");
          }else {
              log.info("======= success ======");
          }
      }

    @RequestMapping("/find/{id}")
    public Goods findById(@PathVariable Integer id){
        Goods goods = goodsService.findGoodsById(id);
        if(goods!=null){
            log.info("=======find success ======");
        }else {
            log.info("======= fail ======");
        }
        return goods;

    }



    @RequestMapping("/ti")
    public void ti(){
       log.info("==================11111===============");
    }

    String  value;

	public final String setValue(String newValue) {
		Long startTime = System.currentTimeMillis();
		 String oldValue = value;
		 value = newValue;
		 Long endTime = System.currentTimeMillis();
		 log.info("总计1："+(endTime-startTime)+" 修改后值为："+value);
		 return oldValue;
	}

	public void setValue2(String newValue){
		Long startTime = System.currentTimeMillis();
		this.value = newValue;
		Long endTime = System.currentTimeMillis();
		log.info("总计2："+(endTime-startTime)+" 修改后值为："+value);
	}


}
