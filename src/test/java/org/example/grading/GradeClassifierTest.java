package org.example.grading;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeClassifierTest {
@ParameterizedTest
    @CsvSource({
            "0, F",
            "49, F",
            "50, D",
            "59, D",
            "60, C",
            "74, C",
            "75, B",
            "89, B",
            "90, A",
            "100, A"
    })
    @DisplayName("Classify scores at all grade boundaries")
    void testClassifyBoundaryValues(int score, String expectedGrade){
    assertEquals(expectedGrade, GradeClassifier.classify(score));
}
@ParameterizedTest
    @CsvSource({
            "-1, Score must be between 0 and 100",
            "101, Score must be between 0 and 100 ",

    })
    @DisplayName("Invalid scores should throw IllegalArgumentException")
    void testInvalidScores(int score, String expectedMessage){
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            ()-> GradeClassifier.classify(score));
    assertEquals(expectedMessage, exception.getMessage());
}
}