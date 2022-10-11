package com.sample.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JSONUtil {

	@Test
	public void createJSON() {
		JSONObject empOne = new JSONObject();
		empOne.put("Name", "Mark");
		empOne.put("EmpNo", "101");
		empOne.put("Role", "QA");
		System.out.println(empOne.toJSONString()); // {"Role":"QA","Emp No":"101","Name":"Mark"}

		JSONObject empTwo = new JSONObject();
		empTwo.put("Name", "George");
		empTwo.put("EmpNo", "102");
		empTwo.put("Role", "Developer");
		System.out.println(empTwo.toJSONString());

		JSONArray empList = new JSONArray();
		empList.add(empOne);
		empList.add(empTwo);
		System.out.println(empList.toJSONString());// [{"Role":"QA","EmpNo":"101","Name":"Mark"},{"Role":"Developer","EmpNo":"102","Name":"George"}]

		JSONObject employees = new JSONObject();
		employees.put("Emplouees", empList);
		System.out.println(employees.toJSONString()); // {"Emplouees":[{"Role":"QA","EmpNo":"101","Name":"Mark"},{"Role":"Developer","EmpNo":"102","Name":"George"}]}

	}

}
