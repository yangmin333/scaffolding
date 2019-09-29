package com.fineway.scaffolding;


import com.alibaba.fastjson.JSON;
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
public class FirstTest1 extends BaseTest{
    public static final String testURL = "http://123.56.178.143:8801";

    /**
     *督导员信息删除接口
     */

    @Test
    @DatabaseSetup(value = "/TestDirector1/Setup_director2.xml", type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value = "/TestDirector1/Expect_director2.xml",table = "director", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void Test1() {
        String url = testURL + "/lbc/api/v1/director/uuid123";
        String token = "X-Token:" + getToken("13700000005", "111111");
        String contentType = "Content-Type:application/json;charset=UTF-8";
        String header = token +  "#" + contentType;
        String resp = HttpUtil.delete(url, header);
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(resp);
        String allowance = obj.getString("allowance");
        String birthday = obj.getString("birthday");
        String certificate = obj.getString("certificate");
        String cityCode = obj.getString("cityCode");
        String contactInformation = obj.getString("contactInformation");
        String countyCode = obj.getString("countyCode");
        String directorUuid = obj.getString("directorUuid");
        String dutyRange = obj.getString("dutyRange");
        String employment = obj.getString("employment");
        String fulltimeParttime = obj.getString("fulltimeParttime");
        String gender = obj.getString("gender");
        String healthStatus = obj.getString("healthStatus");
        String jobTrainingExperience = obj.getString("jobTrainingExperience");
        String landlineNumber = obj.getString("landlineNumber");
        String levelId = obj.getString("levelId");
        String mailbox = obj.getString("mailbox");
        String maritalStatus = obj.getString("maritalStatus");
        String photo = obj.getString("photo");
        String politicalAppearance = obj.getString("politicalAppearance");
        String provinceCode = obj.getString("provinceCode");
        String registrationType = obj.getString("registrationType");
        String reportCityCode = obj.getString("reportCityCode");
        String reportCountyCode = obj.getString("reportCountyCode");
        String reportLevelId = obj.getString("reportLevelId");
        String reportProvinceCode = obj.getString("reportProvinceCode");
        String reportTownCode = obj.getString("reportTownCode");
        String speciality = obj.getString("speciality");
        String townCoded = obj.getString("townCode");
        String whetherGovernmentBuyService = obj.getString("whetherGovernmentBuyService");
        String workplace = obj.getString("workplace");




        Assert.assertEquals("GOVERNMENT",allowance);
        Assert.assertEquals("1989-08-27", birthday);
        Assert.assertEquals("取得证书", certificate);
        Assert.assertEquals("220100000000", cityCode);
        Assert.assertEquals("17666666666", contactInformation);
        Assert.assertEquals("220102001000", dutyRange);
        Assert.assertEquals("从业情况", employment);
        Assert.assertEquals("MALE", gender);
        Assert.assertEquals("Y", fulltimeParttime);
        Assert.assertEquals("GOOD", healthStatus);
        Assert.assertEquals("工作经验及经历", jobTrainingExperience);
        Assert.assertEquals("88888888", landlineNumber);
        Assert.assertEquals("5", levelId);
        Assert.assertEquals("123@qq.com", mailbox);
        Assert.assertEquals("MARRIED", maritalStatus);
        Assert.assertEquals("http://47.104.98.71:28180/pic/e2daddefdcb94ee3a0af3ad094217f80.jpg", photo);
        Assert.assertEquals("MASSES", politicalAppearance);
        Assert.assertEquals("220000000000", provinceCode);
        Assert.assertEquals("SUPERVISOR", registrationType);
        Assert.assertEquals("220100000000", reportCityCode);
        Assert.assertEquals("220102000000", reportCountyCode);
        Assert.assertEquals("5", reportLevelId);
        Assert.assertEquals("220000000000", reportProvinceCode);
        Assert.assertEquals("特长", speciality);
        Assert.assertEquals("220102001000", townCoded);
        Assert.assertEquals("Y", whetherGovernmentBuyService);
        Assert.assertEquals("工作单位", workplace);


    }


    @Test
    @DatabaseSetup(value = "/TestDirector1/Setup_director2.xml", type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value = "/TestDirector1/Expect_director2.xml", table = "director", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void Test2() {
        String url = testURL + "123.56.178.143:8801/lbc/api/v1/director/uuid123";
        String token = "X-Token:" + getToken("13700000005", "111111");
        String contentType = "Content-Type:application/json;charset=UTF-8";
        String header = token +  "#" + contentType;
        String resp = HttpUtil.delete(url, header);
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(resp);
        String code = obj.getString("code");
        String message = obj.getString("message");
        Assert.assertEquals("400", code);
        Assert.assertEquals("项目不存在", message);
        System.out.println(code + "-----" + message);
    }
}