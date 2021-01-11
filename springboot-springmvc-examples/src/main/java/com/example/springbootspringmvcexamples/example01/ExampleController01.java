package com.example.springbootspringmvcexamples.example01;

import com.example.springbootspringmvcexamples.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/example01/")
public class ExampleController01 {
    @GetMapping("index")
    public Map getIndex() {
        return Map.of("name","sun");
    }
    @GetMapping("addresses")
    public Map getAddresses() {
        Address a1 = new Address(1,"乌兰浩特","aaa", LocalDateTime.now());
        Address a2 = new Address(2,"哈尔滨","bbb", LocalDateTime.now());
        Address a3 = new Address(3,"阿尔山","ccc", LocalDateTime.now());
        return Map.of("name","chao","addresses",List.of(a1,a2,a3));
    }
    @PostMapping("addresses")
    public Map postAddress(@RequestBody Address address) {
        log.debug(address.getComment());
        log.debug(address.getDetail());
        log.debug("{}",address.getId());
        return Map.of();
    }
    @PostMapping("addresses2")
    public Map postAddress2(@RequestBody Address address) {
        log.debug(address.getComment());
        log.debug(address.getDetail());
        log.debug("{}",address.getUser().getId());
        return null;
    }
    @GetMapping("addresses/{aid}")
    public Map getAddress(@PathVariable int aid) {
        Address address = ADDRESSES.stream()
                .filter(a -> a.getId() == aid)
                .findFirst()
                .orElse(new Address());
        return Map.of("address",address);
    }
    private final List<Address> ADDRESSES = create();
    private List<Address> create(){
        Address a1 = new Address(1,"wlht","a",LocalDateTime.now());
        Address a2 = new Address(2,"heb","b",LocalDateTime.now());
        Address a3 = new Address(3,"aes","c",LocalDateTime.now());
        return List.of(a1,a2,a3);
    }

}
