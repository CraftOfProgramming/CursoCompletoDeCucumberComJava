package com.craftofprogramming.biblioteca;

import io.cucumber.java.en.Given;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BuiltInParameterTypesStepDefs {

//    @Given("Eu comi {byte} pepino")
//    public void euComiPepino(byte bpepinoCount) {
//        System.out.println("bpepinoCount = " + bpepinoCount);
//    }

//    @Given("Eu comi {short} pepino")
//    public void euComiPepino(short spepinoCount) {
//        System.out.println("spepinoCount = " + spepinoCount);
//    }

//    @Given("Eu comi {int} pepino(s)")
//    public void euComiPepino(int ipepinoCount) {
//        System.out.println("ipepinoCount = " + ipepinoCount);
//    }

//    @Given("Eu comi {float} pepinos")
//    public void euComiPepino(float fpepinoCount) {
//        System.out.println("fpepinoCount = " + fpepinoCount);
//    }

    @Given("Eu comi {double} pepino(s)")
    public void euComiPepino(double dpepinoCount) {
        System.out.println("dpepinoCount = " + dpepinoCount);
    }

    @Given("Este e' {} Byte")
    public void thisIsByte(Byte bParam) {
        System.out.println("bParam = " + bParam);
    }

    @Given("Este e' {} Short")
    public void thisIsByte(Short shortParam) {
        System.out.println("shortParam = " + shortParam);
    }

    @Given("Este e' {} Integer")
    public void thisIsByte(Integer integerParam) {
        System.out.println("integerParam = " + integerParam);
    }

    @Given("Este e' {} Long")
    public void thisIsByte(Long longParam) {
        System.out.println("longParam = " + longParam);
    }

    @Given("Este e' {} Float")
    public void thisIsByte(Float floatParam) {
        System.out.println("floatParam = " + floatParam);
    }

    @Given("Este e' {} Double")
    public void thisIsByte(Double doubleParam) {
        System.out.println("doubleParam = " + doubleParam);
    }

    @Given("Este e' {} BigInteger")
    public void thisIsByte(BigInteger bigIntegerParam) {
        System.out.println("bigIntegerParam = " + bigIntegerParam);
    }

    @Given("Este e' {} BigDecimal")
    public void thisIsByte(BigDecimal bigDecimalParam) {
        System.out.println("bigDecimalParam = " + bigDecimalParam);
    }

    @Given("Eu chamo-me {string}")
    public void iAm(String nomes) {
        System.out.println("nomes = " + nomes);
    }

    @Given("O meu primeiro nome e' {word}")
    public void myFirstNameIs(String nome) {
        System.out.println("nome = " + nome);
    }

    @Given("O meu apelido e' {word}")
    public void myLastNameIsNilton(String apelido) {
        System.out.println("apelido = " + apelido);
    }
}
