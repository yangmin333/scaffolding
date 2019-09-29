package com.fineway.scaffolding;

import com.alibaba.fastjson.JSON;
import com.fineway.scaffolding.service.HelloService;
import com.fineway.util.HttpUtil;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
public class MyTest extends BaseTest {
    public static final String testURL = "http://121.42.201.123:20091/";

    @Test
    @DatabaseSetup(value = "/testPerson/Setup_person.xml", type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value = "/testPerson/Expect_person.xml", table = "person", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void Test1() {
        String url = testURL + "chime/api/v1/manager/project/82/community";
        String token = "X-Token:" + getToken("17700000008", "111111");
        String clientId = "X-Client-Id:1";
        String contentType = "Content-Type:application/json;charset=UTF-8";
        String xappid = "X-App-Id:dongya";
        String header = token + "#" + clientId + "#" + contentType + "#" + xappid;
        String resp = HttpUtil.get(url, header);
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(resp);
        String code = obj.getString("code");
        String message = obj.getString("message");
        Assert.assertEquals("400", code);
        Assert.assertEquals("项目不存在", message);
        System.out.println(code + "-----" + message);
    }
}