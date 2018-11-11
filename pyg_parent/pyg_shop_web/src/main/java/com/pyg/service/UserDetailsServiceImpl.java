package com.pyg.service;

import com.pyg.pojo.TbSeller;
import com.pyg.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里是个list
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        //add一个role
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller seller = sellerService.findOne(username);
        //看看这个是不是一个审核状态
        if ("1".equals(seller.getStatus())) {


            //当我们返回一个user的时候框架就会认为商家可以登陆了
            return new User(username, seller.getPassword(), grantedAuthorityList);
        }

        return null;
    }
}
