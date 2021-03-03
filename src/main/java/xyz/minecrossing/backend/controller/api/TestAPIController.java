package xyz.minecrossing.backend.controller.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestAPIController implements TestAPI {

    @Override
    public ResponseEntity<Object> test() {
        HashMap<String, String> value = new HashMap<>();
        value.put("msg", "Test message!");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TestObject> objtest() {
        return ResponseEntity
                .ok()
                .body(new TestObject(
                                1,
                                "Me",
                                new TestData(
                                        "Definitely",
                                        "Also Definitely"
                                )
                        )
                );
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    class TestObject {
        private int id;
        private String name;
        private TestData testdata;

        public TestObject(int id, String name, TestData testdata) {
            this.id = id;
            this.name = name;
            this.testdata = testdata;
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    class TestData {
        private String something;
        private String somethingElse;

        public TestData(String something, String somethingElse) {
            this.something = something;
            this.somethingElse = somethingElse;
        }
    }
}
