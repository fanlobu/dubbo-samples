package org.apache.dubbo.rest.demo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClient;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AbnormalRequestServiceIT {

    private static final String providerAddress = System.getProperty("dubbo.address", "localhost");


    @Test
    public void testNotFound(){
        RestClient.create().get()
                .uri("http://" + providerAddress + ":50052/abnormal/not")
                .header("Content-type", "application/json")
                .exchange((request, response) -> {
                    Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
                    return response;
                });
    }

    @Test
    public void testNoParam(){
        RestClient.create().get()
                .uri("http://" + providerAddress + ":50052/abnormal/notParam?name=1&a=1")
                .header( "Content-type","application/json")
                .exchange((request, response) -> {
                    System.out.println(response.getStatusCode());
                    Assert.assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
                    return response;
                });
    }

    @Test
    public void testParamConvertFail(){
        RestClient.create().get()
                .uri("http://" + providerAddress + ":50052/abnormal/paramConvertFail?zonedDateTime=2023-03-08T10:15:30+08:00")
                .header( "Content-type","application/json")
                .exchange((request, response) -> {
                    Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
                    return response;
                });
    }

    @Test
    public void testThrowException(){
        RestClient.create().get()
                .uri("http://" + providerAddress + ":50052/abnormal/throwException")
                .header( "Content-type","application/json")
                .exchange((request, response) -> {
                    Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
                    return response;
                });
    }

}
