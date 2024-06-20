package org.apache.dubbo.rest.demo.routine;

import org.apache.dubbo.rest.demo.pojo.User;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

@Path("/abnormal")
public interface AbnormalRequestService {

    @GET
    @Path("/notFound")
    String testNotFound();

    @GET
    @Path("/noParam")
    String testNoParam(@QueryParam("name") String name);

    @GET
    @Path("/paramConvertFail")
    ZonedDateTime testParamConvertFai(@QueryParam("zonedDateTime") ZonedDateTime date);

    @GET
    @Path("/pathRepeat")
    String testPathRepeat1();

//    @GET
//    @Path("/pathRepeat")
    String testPathRepeat2();

    @GET
    @Path("/throwException")
    String test();
}
