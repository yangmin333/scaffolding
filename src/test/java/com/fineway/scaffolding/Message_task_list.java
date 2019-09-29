package com.fineway.scaffolding;



import com.alibaba.fastjson.JSON;
import com.fineway.util.HttpUtil;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.*;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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


public class Message_task_list extends BaseTest {
    public static final String testURL = "http://47.104.98.71:8082/sso";


    /**
     * 消息任务列表查询接口
     */

    @Test
    @DatabaseSetups({
            @DatabaseSetup(value = "/Testmessage/Setup_message.xml", type = DatabaseOperation.CLEAN_INSERT),
            @DatabaseSetup(value = "/TestMessagetask/Setup_messagetask.xml", type = DatabaseOperation.CLEAN_INSERT)})
    @ExpectedDatabases({
            @ExpectedDatabase(value = "/Testmessage/Expect_message.xml",table = "Testmessage",
                    assertionMode = DatabaseAssertionMode.NON_STRICT),
            @ExpectedDatabase(value = "/TestMessagetask/Expect_messagetask.xml",table = "TestMessagetask", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    })
    public void test() {
    String url = testURL + "/api/v1/message/task/list";
    String token = "X-Token:" + getToken("{}", "{}");
    String contentType = "Content-Type:application/json;charset=UTF-8";
    String header = token + "#" + contentType;
    String body = "{}";
    String resp = HttpUtil.post(url, header, body);
    com.alibaba.fastjson.JSONObject obj = JSON.parseObject(resp);
    // String id = obj.getString("id");
    //String receiveRoleId = obj.getString("receiveRoleId");

    //Assert.assertEquals(1,id);
   // Assert.assertEquals(3,receiveRoleId);
   }

   @Test
    public void test1() {
        String url = testURL + "/api/v1/message/task/list";
        String token = "X-Token:" + getToken("{}", "{}");
        String contentType = "Content-Type:application/json;charset=UTF-8";
        String header = token + "#" + contentType;
        String body = "{}";
        String resp = HttpUtil.post(url, header, body);
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(resp);
        Boolean result = obj.getBoolean("result");
        Assert.assertEquals(false,result);

    }
}