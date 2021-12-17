package com.rookie.hustle.remote;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zbhou
 * @Date 2021/3/8 11:14 上午
 * @Version 1.0
 **/

@RefreshScope
@FeignClient(name = "prettyy", url = "{$http_server_url.prettyy}")
public interface IFeignPrettyyService {

    /**
     * 获取商品fen
     * @param platform
     * @param sourceCateId
     * @return
     */
    @PostMapping(value = "/v1/Categories/sourceCateMap", consumes = MediaType.APPLICATION_JSON_VALUE)
    String prettyyGetSourceCateMap(@RequestParam("platform") String platform,
                                   @RequestParam("source_cate_id") String sourceCateId);
}
