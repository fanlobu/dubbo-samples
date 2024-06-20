package org.apache.dubbo.rest.demo.routine;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rest.demo.pojo.User;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@DubboService
public class AbnormalRequestServiceImpl extends Application implements AbnormalRequestService{
    @Override
    public String testNotFound() {
        return null;
    }

    @Override
    public String testNoParam(String name) {
        return name;
    }

    @Override
    public ZonedDateTime testParamConvertFai(ZonedDateTime date) {
        return date;
    }


    @Override
    public String testPathRepeat1() {
        return "path repeat1";
    }

    @Override
    public String testPathRepeat2() {
        return "path repeat2";
    }

    @Override
    public String test() {
        throw new RuntimeException();
    }

}
