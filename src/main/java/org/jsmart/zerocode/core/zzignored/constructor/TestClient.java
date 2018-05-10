package org.jsmart.zerocode.core.zzignored.constructor;

import org.jsmart.zerocode.core.engine.assertion.FieldHasEndsWithValueAsserter;
import org.jsmart.zerocode.core.engine.assertion.FieldHasSubStringIgnoreCaseValueAsserter;
import org.jsmart.zerocode.core.engine.assertion.JsonAsserter;

public class TestClient {
    public static void main(String[] args) {
        EmployeeFactory empFactory=Employee::new;
        Employee emp= empFactory.getEmployee("John Hammond", 25);
        System.out.println("name, age = " + emp.getName() + ", " + emp.getAge());

        AsserterFactory asserterFactory = FieldHasEndsWithValueAsserter::new;
        JsonAsserter asserter = asserterFactory.getAsserter("$.myPath", "pink-apple");
        System.out.println("asserter.getPath() = " + asserter.getPath());

        System.out.println("asserter.assertWithJson() = " + asserter.assertWithJson("{\"myPath\": \"pink-apple\"}"));
        System.out.println("asserter.assertWithJson() = " + asserter.assertWithJson("{\"myPath\": \"actual-value\"}"));
        System.out.println("asserter.assertWithJson() = " + asserter.assertWithJson("{\"myPath\": \"green-apple\"}"));


        asserterFactory = FieldHasSubStringIgnoreCaseValueAsserter::new;
        asserter = asserterFactory.getAsserter("$.myPath", "pink-apple");
        System.out.println("asserter.getPath() = " + asserter.getPath());
        System.out.println("asserter.assertWithJson() = " + asserter.assertWithJson("{\"myPath\": \"Green-apple\"}"));
        System.out.println("asserter.assertWithJson() = " + asserter.assertWithJson("{\"myPath\": \"PINK-apple\"}"));
    }
}
