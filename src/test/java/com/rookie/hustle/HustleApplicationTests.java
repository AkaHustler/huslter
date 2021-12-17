package com.rookie.hustle;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Objects;

@SpringBootTest
class HustleApplicationTests {




    @Test
    void test() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://yangkeduo.com/goods.html?goods_id=221272061113";
        Request build = new Request.Builder().url(url)
                .header("Cookie", "PDDAccessToken:CURJADIGMOW2P3UFBMUNKA4IQLEAON4VWNWWRPSAIWOFZOUXUTSA111328d;pdd_user_id=6449634051378;")
                .get()
                .build();
        try {
            Response execute = okHttpClient.newCall(build).execute();
            if (Objects.isNull(execute.body())) {
                return;
            }
            String string = execute.body().string();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPretty() {
    }

}
