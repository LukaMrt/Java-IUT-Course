package com.lukamaret.course.ihm.projetTP.seance1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringMoteurTest {

    private StringMoteur stringMoteur;

    @BeforeEach
    void setUp() {
        stringMoteur = new StringMoteur();
    }

    @Test
    void upperCase_shouldReturnTEST_whenEntryIsTest() {

        String result = stringMoteur.upperCase("Test");

        assertThat(result).isEqualTo("TEST");
    }

    @Test
    void upperCase_shouldReturnAAA_whenEntryIsAaa() {

        String result = stringMoteur.upperCase("Aaa");

        assertThat(result).isEqualTo("AAA");
    }

    @Test
    void lowerCase_shouldReturntest_whenEntryIsTest() {

        String result = stringMoteur.lowerCase("Test");

        assertThat(result).isEqualTo("test");
    }

    @Test
    void lowerCase_shouldReturnaaa_whenEntryIsAaa() {

        String result = stringMoteur.lowerCase("Aaa");

        assertThat(result).isEqualTo("aaa");
    }

    @Test
    void capitalizeWords_shouldReturnTestTest_whenEntryIstestTest() {

        String result = stringMoteur.capitalizeWords("test test");

        assertThat(result).isEqualTo("Test Test");
    }

    @Test
    void capitalizeWords_shouldReturnAaAa_whenEntryIsaaaa() {

        String result = stringMoteur.capitalizeWords("aa aa");

        assertThat(result).isEqualTo("Aa Aa");
    }

    @Test
    void addAtStart_shouldReturnAB_whenEntryIsBA() {

        String result = stringMoteur.addAtStart("B", "A");

        assertThat(result).isEqualTo("AB");
    }

    @Test
    void addAtStart_shouldReturnBA_whenEntryIsAB() {

        String result = stringMoteur.addAtStart("A", "B");

        assertThat(result).isEqualTo("BA");
    }

    @Test
    void addAtEnd_shouldReturnAB_whenEntryIsAB() {

        String result = stringMoteur.addAtEnd("A", "B");

        assertThat(result).isEqualTo("AB");
    }

    @Test
    void addAtEnd_shouldReturnBA_whenEntryIsBA() {

        String result = stringMoteur.addAtEnd("B", "A");

        assertThat(result).isEqualTo("BA");
    }

    @Test
    void splitWordsWithComa_shouldReturnTestTestWithComa_whenEntryIsTestTest() {

        String result = stringMoteur.splitWordsWithComa("Test  Test");

        assertThat(result).isEqualTo("Test, Test");
    }

    @Test
    void splitWordsWithComa_shouldReturnTestAAWithComa_whenEntryIsTestAA() {

        String result = stringMoteur.splitWordsWithComa("Test A A");

        assertThat(result).isEqualTo("Test, A, A");
    }

    @Test
    void sizeWithoutSpace_shouldReturn4_whenEntryIsTest() {

        String result = stringMoteur.sizeWithoutSpace("Test");

        assertThat(result).isEqualTo("4");
    }

    @Test
    void sizeWithoutSpace_shouldReturn8_whenEntryIsTestTestWithSpace() {

        String result = stringMoteur.sizeWithoutSpace("Test Test");

        assertThat(result).isEqualTo("8");
    }

    @Test
    void simpleOperation_shouldReturn1_whenEntryIs1Plus0() {

        String result = stringMoteur.simpleOperation("1 + 0");

        assertThat(result).isEqualTo("1.0");
    }

    @Test
    void simpleOperation_shouldReturn2_whenEntryIs1Minus1() {

        String result = stringMoteur.simpleOperation("1 - 1");

        assertThat(result).isEqualTo("0.0");
    }

    @Test
    void simpleOperation_shouldReturn2_whenEntryIs1Multiply2() {

        String result = stringMoteur.simpleOperation("1 * 2");

        assertThat(result).isEqualTo("2.0");
    }

    @Test
    void simpleOperation_shouldReturn2_whenEntryIs2Divide1() {

        String result = stringMoteur.simpleOperation("2 / 1");

        assertThat(result).isEqualTo("2.0");
    }

}
