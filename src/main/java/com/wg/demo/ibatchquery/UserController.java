package com.wg.demo.ibatchquery;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

/**
 * @Author : dongpo
 */
public class UserController {

    /**
     * 请求合并
     * @param userId
     * @return
     */
    @RequestMapping("/merge")
    public Callable<Users> merge(Long userId) {
        return new Callable<Users>() {
            @Override
            public Users call() throws Exception {
                return null;
//                return userBatchService.queryUser(userId);
            }
        };
    }
}
