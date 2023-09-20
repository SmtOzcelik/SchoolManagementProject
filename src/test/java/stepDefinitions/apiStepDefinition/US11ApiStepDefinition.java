package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.US11Pojo.LessonProgramPojo;
import pojos.US11Pojo.ResponsePojo;
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
        spec.pathParams("first", "lessonPrograms", "second", "save");

        //US11PostPojo expectedData = new US11PostPojo(day,educationTermId,lessonIdList,startTime,stopTime)

        ArrayList<Integer> lessonIdArrayList=new ArrayList<>();
        lessonIdArrayList.add(lessonIdList);

        LessonProgramPojo expectedData=new LessonProgramPojo(day,educationTermId,lessonIdArrayList,startTime,stopTime);
        System.out.println(expectedData);



        Response response=given(spec).body(expectedData).post("{first}/{second}");


        ResponsePojo actualData = response.as(ResponsePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getDay(),actualData.getObject().getDay());
        //assertEquals(expectedData.getStartTime(),actualData.getObject().getStartTime());

        //2.yöntem JsonPath
        JsonPath jsonPath = response.jsonPath();

        assertEquals("Created Lesson Program",jsonPath.getString("message"));

        actualLessonProgramId = jsonPath.getInt("object.lessonProgramId");






       /* Map<String,Object> actualData= ApiUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println(actualData);
        Map<String,Integer> lessonProgramId=(Map<String, Integer>) actualData.get("object");
        actualLessonProgramId=lessonProgramId.get("lessonProgramId");

        */



    }


    @Then("delete the posted lessonProgram")
    public void deleteThePostedLessonProgram() {

        //https://managementonschools.com/app/lessonPrograms/delete/123
        spec.pathParams("first", "lessonPrograms", "second", "delete","third",actualLessonProgramId);
        Response response = given(spec).delete("{first}/{second}/{third}");
        assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        assertEquals("Lesson Program Deleted",jsonPath.getString("message"));


    }

}
