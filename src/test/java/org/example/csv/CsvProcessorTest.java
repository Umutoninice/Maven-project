package org.example.csv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CsvProcessorTest {

    @Mock
    private FileReader mockFileReader;
    @InjectMocks
    private CsvProcessor csvProcessor;

    private static final String Test_Path= "students.csv";

    @Test
    @DisplayName("Should process student grades using mocked FileReader")
    void testProcessStudentGrades(){
        List<String> mockData = Arrays.asList(
                "Aline,80,90,70",
                "Nice,60,55,65"
        );
        when(mockFileReader.readLines(any())).thenReturn(mockData);
        // call method under test
        List<StudentRecord> records = csvProcessor.processStudentGrades(Test_Path);

        assertNotNull(records);
        assertEquals(2, records.size());


        StudentRecord firstRecord = records.get(0);
        assertEquals("Aline", firstRecord.getName());
        assertEquals(Arrays.asList(80,90,70), firstRecord.getGrades());
        assertEquals(80.0, firstRecord.getAverage());

        StudentRecord secondRecord= records.get(1);
        assertEquals("Nice", secondRecord.getName());
        assertEquals(Arrays.asList(60,55,65), secondRecord.getGrades());
        assertEquals(60.0, secondRecord.getAverage());

        // check that the dependency was called exactly once
        verify(mockFileReader, times(1)).readLines(Test_Path);
    }

    // Verify Behavior Tests

    @Test
    @DisplayName("Should verify readLines is called exactly once with correct path")
    void testVerifyReadLinesCalledOnce() {

        List<String> mockData = Arrays.asList(
                "Aline,80,90,70",
                "Nice,60,55,65"
        );
        when(mockFileReader.readLines(Test_Path)).thenReturn(mockData);

        csvProcessor.processStudentGrades(Test_Path);

        // Verify: readLines was called exactly once with the correct path
        verify(mockFileReader, times(1)).readLines(Test_Path);
    }

    @Test
    @DisplayName("Should verify readLines is called exactly once using any() matcher")
    void testVerifyReadLinesCalledOnceWithAnyMatcher() {

        List<String> mockData = Arrays.asList("Aline,80,90,70");
        when(mockFileReader.readLines(any())).thenReturn(mockData);

        csvProcessor.processStudentGrades(Test_Path);

        verify(mockFileReader, times(1)).readLines(anyString());
    }


}