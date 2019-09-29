package com.test.emailgen;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.test.emailgen.util.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneratorTest {

    @Test
    public void testGenerateUsername(){
        assertEquals("anjani",new Generator("anjani").getUserName());
        assertEquals("yusuke.iseya",new Generator("Yusuke Iseya").getUserName());
        assertEquals("stephan.shakalakalaka",new Generator("Stephan Danu Shakalakalaka ").getUserName());
    }

    @Test
    public void testGenerateEmail(){
        assertEquals("anjani@kalimat.ai",new Generator("anjani").getEmail());
        assertEquals("yusuke.iseya@kalimat.ai",new Generator("Yusuke Iseya").getEmail());
        assertEquals("stephan.shakalakalaka@kalimat.ai",new Generator("Stephan Danu Shakalakalaka ").getEmail());

    }
}
