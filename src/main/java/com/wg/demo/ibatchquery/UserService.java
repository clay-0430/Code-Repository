package com.wg.demo.ibatchquery;

import java.util.List;
import java.util.Map;

/**
 * @Author : dongpo
 */
public interface UserService {

    Map<String, Users> queryUserByIdBatch(List<UserWrapBatchService.Request> userReqs);

}
