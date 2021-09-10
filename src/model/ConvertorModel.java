package model;

public class ConvertorModel {

    public String outputString = " ";
    char temporaryChar = ' ';
    int firstDigit = 0;
    int secondDigit = 0;
    int thirdDigit = 0;
    // several variables: the char holds an information temporarily, the string gives the final resultant string
    // and the integers give information about the input digits of the number

    private final String[] singleDigitNumbers = {"Нула", "Едно", "Две", "Три", "Четири", "Пет", "Шест", "Седем", "Осем",
            "Девет"};
    private final String[] doubleDigitNumbers = {"надесет", "десет", "двадесет", "Десет", "Двадесет"};
    private final String[] tripleDigitNumbers = {"Сто", "ста", "стотин"};
    //3 (constant) static arrays, which hold crucial string information about the bulgarian translation of each number

    public String convertSingleDigitNumbers(int firstDigit) {
        return outputString = singleDigitNumbers[firstDigit];
    }
    //method for single digit number from the input
    public String convertDoubleDigitNumbers(int digit) {

        temporaryChar = Integer.toString(digit).charAt(0);
        firstDigit = Character.getNumericValue(temporaryChar);
        temporaryChar = Integer.toString(digit).charAt(1);
        secondDigit = Character.getNumericValue(temporaryChar);

        if (firstDigit >= 3 && firstDigit <= 9 && secondDigit != 0 && digit < 20) {
            return outputString =
                    singleDigitNumbers[firstDigit] + doubleDigitNumbers[1];
        }
        if (digit == 10) {
            return outputString = doubleDigitNumbers[3];
        }
        if (digit == 20) {
            return outputString = doubleDigitNumbers[4];
        }
        if (digit >= 30 && secondDigit == 0) {
            return outputString = singleDigitNumbers[firstDigit] + doubleDigitNumbers[1];
        }
        if (digit > 20 && secondDigit != 0) {
            return outputString =
                    singleDigitNumbers[firstDigit] + doubleDigitNumbers[1] + " и " + singleDigitNumbers[secondDigit].toLowerCase();
        }
        if (digit > 12 && digit < 20 && secondDigit != 0) {
            return outputString = singleDigitNumbers[secondDigit] + doubleDigitNumbers[0];
        }
        if (digit == 11) {
            return outputString = "Единадесет";
        }
        if (digit == 12) {
            return outputString = "Дванадесет";

        } else {
            return " ";

        }

    }
    //method for double digit number from the input
    public String convertTripleDigitNumbers(int digit) {

        temporaryChar = Integer.toString(digit).charAt(0);
        firstDigit = Character.getNumericValue(temporaryChar);
        temporaryChar = Integer.toString(digit).charAt(1);
        secondDigit = Character.getNumericValue(temporaryChar);
        temporaryChar = Integer.toString(digit).charAt(2);
        thirdDigit = Character.getNumericValue(temporaryChar);
        //assign each digit from the input to the respective variables

        //---------- special cases ----------
        if (firstDigit == 1 && secondDigit == 1 && thirdDigit == 1) {
            return outputString = tripleDigitNumbers[0] +  " и единадесет";
        }
        if (firstDigit == 1 && secondDigit == 1 && thirdDigit == 2) {
            return outputString = tripleDigitNumbers[0] +  " и дванадесет";
        }
        if (digit == 100) {
            return outputString = tripleDigitNumbers[0];
        }
        if (secondDigit == 0 && firstDigit == 1) {
            return outputString =
                    tripleDigitNumbers[0] + " и " + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        if (firstDigit == 1 && thirdDigit == 0 && digit == 110) {
            return outputString = tripleDigitNumbers[0] +  " и " + doubleDigitNumbers[1];
        }
        if (firstDigit == 1 && thirdDigit == 0 && digit > 110 && secondDigit != 2) {
            return outputString = tripleDigitNumbers[0] + " и " + singleDigitNumbers[secondDigit].toLowerCase()
                    + doubleDigitNumbers[1];
        }
        if (digit == 120 && secondDigit == 2) {
            return outputString = tripleDigitNumbers[0] + " и " + doubleDigitNumbers[4].toLowerCase();
        }
        //---------- special cases ----------


        //----------all 3-digit numbers with 0 as second number----------
        if (firstDigit > 1 && firstDigit < 4 && secondDigit == 0 && thirdDigit !=0) {
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и " + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        if (firstDigit > 3 && firstDigit < 10 && secondDigit == 0 && thirdDigit !=0) {
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и " + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        //----------all 3-digit numbers with 0 as second digit----------


        //--------- all 3- digit numbers ending with 10----------
        if (firstDigit > 1 && thirdDigit == 0 && secondDigit == 1 && firstDigit < 4) { //numbers between 2 and 3 hundred
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и " + doubleDigitNumbers[1];
        }
        if (firstDigit > 3 && thirdDigit == 0 && secondDigit == 1 && firstDigit < 10) { //numbers between 4 and 9 hundred
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и " + doubleDigitNumbers[1];
        }
        //--------- all 3- digit numbers ending with 10----------


        //---------- all 3- digit numbers ending with 0, except 10----------
        if (firstDigit > 1  && firstDigit < 4 && thirdDigit == 0 && secondDigit !=2 && secondDigit !=0) { //numbers between 2 and 3
            // hundred with the second digit different from 2
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и "
                            + singleDigitNumbers[secondDigit].toLowerCase() + doubleDigitNumbers[1];
        }
        if (firstDigit > 3  && firstDigit < 10 && thirdDigit == 0 && secondDigit !=2 && secondDigit !=0) { //numbers between 4 and 9
            // hundred
            // with the second digit different from 2
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и "
                            + singleDigitNumbers[secondDigit].toLowerCase() + doubleDigitNumbers[1].toLowerCase();
        }
        if (firstDigit > 1  && firstDigit < 4 && thirdDigit == 0 && secondDigit == 2) { //numbers between 2 and 3 hundred
            // with the second digit equal to 2
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и "
                            + doubleDigitNumbers[4].toLowerCase();
        }
        if (firstDigit > 3  && firstDigit < 10 && thirdDigit == 0 && secondDigit == 2) { //numbers between 4 and 9 hundred
            // with the second digit equal to 2
            return outputString =
                    singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и "
                            + doubleDigitNumbers[4].toLowerCase();
        }
        //---------- all 3- digit numbers ending with 0, except 10----------


        //---------- all 3- digit numbers with the second and third digit different from 0 and third different from 1----------
        if (firstDigit == 1 && secondDigit == 2 && thirdDigit !=0) { //for all 12x numbers
            return outputString = tripleDigitNumbers[0] + " " + doubleDigitNumbers[2].toLowerCase() + " и "
                    + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        if (firstDigit == 1 && secondDigit != 2 && thirdDigit !=0 && digit >=120) { //for all 1xx numbers
            return outputString = tripleDigitNumbers[0] + " " + singleDigitNumbers[secondDigit] + doubleDigitNumbers[1] + " "
                    + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        if (firstDigit > 1 && firstDigit < 4 && secondDigit != 1 && thirdDigit !=0) { //numbers between 2 and 3 hundred
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[1]+ " "
                    + singleDigitNumbers[secondDigit].toLowerCase()
                    + doubleDigitNumbers[1].toLowerCase() + " и " + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        if (firstDigit > 3 && firstDigit < 10 && secondDigit != 1 && thirdDigit !=0) { //numbers between 4 and 9 hundred
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " "
                    + singleDigitNumbers[secondDigit].toLowerCase()
                    + doubleDigitNumbers[1].toLowerCase() + " и " + singleDigitNumbers[thirdDigit].toLowerCase();
        }
        //---------- all 3- digit numbers with the second and third digit different from 0 and third different from 1----------

        //---------- all 3- digit numbers with the second digit equal to 1 ----------
        if (firstDigit == 1 && secondDigit == 1 && thirdDigit != 0 && digit !=111 && digit != 112) { // for all 11x numbers
            return outputString = tripleDigitNumbers[0] + " и "
                    + singleDigitNumbers[thirdDigit].toLowerCase() + doubleDigitNumbers[0];
        }
        if (firstDigit > 3 && secondDigit == 1 && thirdDigit != 0 && firstDigit < 10 && thirdDigit != 1 && thirdDigit != 2 && secondDigit !=0) {
            //for all x1x numbers, except x12 & x11
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и "
                    + singleDigitNumbers[thirdDigit].toLowerCase() + doubleDigitNumbers[0];
        }
        if (firstDigit > 1 && secondDigit == 1 && thirdDigit != 0 && firstDigit < 4 && thirdDigit !=1 && thirdDigit !=2 && secondDigit !=0) {
            //for all x1x numbers above 3 hundred, except x12 & x12
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и "
                    + singleDigitNumbers[thirdDigit].toLowerCase() + doubleDigitNumbers[0];
        }
        //---------- all 3- digit numbers with the second digit equal to 1 ----------


        //---------- all 3- digit numbers ending with numbers 1 or 2 ----------
        if (firstDigit > 1 && secondDigit == 1 && thirdDigit == 1 && firstDigit < 4) { // for 2 or 3 hundred, ending with 11
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и единадесет";
        }
        if (firstDigit > 1 && secondDigit == 1 && thirdDigit == 2 && firstDigit < 4) { // for 2 or 3 hundred, ending with 12
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[1] + " и дванадесет";
        }
        if (firstDigit > 3 && secondDigit == 1 && thirdDigit == 1 && firstDigit < 10) { // for above 4 hundred, ending with 11
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и единадесет";
        }
        if (firstDigit > 3 && secondDigit == 1 && thirdDigit == 2 && firstDigit < 10) { // for above 4 hundred, ending with 12
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[2] + " и дванадесет";
        }
        //---------- all 3- digit numbers ending with numbers 1 or 2 ----------


        //---------- all 3- digit numbers in the form of x00 ----------
        if (firstDigit > 1 && firstDigit < 4 && secondDigit == 0 && thirdDigit == 0) {
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[1];
        }
        if (firstDigit > 3 && firstDigit < 10 && secondDigit == 0 && thirdDigit == 0) {
            return outputString = singleDigitNumbers[firstDigit] + tripleDigitNumbers[2];
        }
        //---------- all 3- digit numbers in the form of x00 ----------


        else {
            return " ";
        }

    }
    //method for triple digit number from the input - the most complicated one
    //the if operator is used, instead of switch, to cover all the special cases, although the time complexity is a lot worse
    //this all is due to the language complexity
}
