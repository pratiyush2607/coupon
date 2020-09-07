package com.example.coupon.controllers;

import com.example.coupon.domain.Coupon;
import com.example.coupon.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponRestController{
    @Autowired
    CouponRepository repository;

    @RequestMapping(value="/coupon", method= RequestMethod.GET)
    public List<Coupon>getCoupon(){
        return (List<Coupon>) repository.findAll();
    }
     @RequestMapping (value="/coupon/{couponCode)", method= RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("couponCode") String couponCode){
        return repository.findById(couponCode).get();
    }
    @RequestMapping(value="/coupon/{couponCode}", method = RequestMethod.POST)
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return repository.save(coupon);
    }
    @RequestMapping(value="/coupon/{couponCode}", method = RequestMethod.PUT)
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return repository.save(coupon);
    }
    @RequestMapping(value="/coupon/{couponCode}", method = RequestMethod.DELETE)
    public void deleteCoupon(@PathVariable("couponCode") String couponCode) {
        repository.deleteById(couponCode);
    }


}
