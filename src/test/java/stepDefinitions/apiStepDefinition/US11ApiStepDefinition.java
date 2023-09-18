package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US11Pojo.LessonProgramPojo;
import utilities.ApiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US11ApiStepDefinition {

    public static Integer actualLessonProgramId;
    @Given("send post lesson program day {string} , educationTermID {int} ,lessonidList {int} ,startTime {string}, stopTime {string} as Vice Dean")
    public void sendPostLessonProgramDayEducationTermIDLessonidListStartTimeStopTimeAsViceDean(String day, Integer educationTermId, Integer lessonIdList, String startTime , String stopTime) {
        ArrayList<Integer> lessonIdArrayList=new ArrayList<>();
        lessonIdArrayList.add(lessonIdList);
        spec.pathParams("first", "lessonPrograms", "second", "save");
        LessonProgramPojo expectedData=new LessonProgramPojo(day,educationTermId,lessonIdArrayList,startTime,stopTime);
        System.out.println(expectedData);
        Response response=given(spec).body(expectedData).post("{first}/{second}");
        Map<String,Object> actualData= ApiUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println(actualData);
        Map<String,Integer> lessonProgramId=(Map<String, Integer>) actualData.get("object");
        actualLessonProgramId=lessonProgramId.get("lessonProgramId");



    }

    @Then("delete the posted lessonProgram")
    public void deleteThePostedLessonProgram() {

        //https://managementonschools.com/app/lessonPrograms/delete/123
        spec.pathParams("first", "lessonPrograms", "second", "delete","third",actualLessonProgramId);
        Response response = given(spec).delete("{first}/{second}/{third}");
        assertEquals(200, response.statusCode());
    }

}
