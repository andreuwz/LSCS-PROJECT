package controller;

import exception.IntegerAboveThresholdException;
import exception.IntegerNegativeValueException;
import model.ConvertorModel;
import view.ConvertorMainScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertorController {

    private ConvertorMainScreen mainScreen;
    private ConvertorModel mainModel;

    public ConvertorController(ConvertorMainScreen mainScreen, ConvertorModel mainModel) {
        this.mainScreen = mainScreen;
        this.mainModel = mainModel;

        this.mainScreen.convertButtonListener(new ConvertorListener());
    //the constructor which initializes the objects (classes) and implements the dependency inversion
    }

    class ConvertorListener implements ActionListener {
        //this nested class implements the ActionListener, so we can use the nested class as a parameter in the
        // convertButtonListener method
        @Override
        public void actionPerformed(ActionEvent e) {
            //here in the method of the ActionListener interface are added several simple if operators to check the length of the
            // input number and also several ones to cover the unaccepted values which a user can enter in the text field
            if (e.getSource() == mainScreen.performConverting) {

                try {
                    int inputNumber = mainScreen.getNumberInput();
                    int inputNumberLength = Integer.toString(inputNumber).length();


                    if (inputNumber > 999) {
                        throw new IntegerAboveThresholdException("The input integer is above the upper threshold of 999");
                    }

                    if (inputNumber < 0) {
                        throw new IntegerNegativeValueException("The input integer is negative which is not accepted");
                    }
                    switch (inputNumberLength) {
                    //enhanced switch is used to cover the different input sizes of the number
                    // after each valid case, the switch breaks
                        case 1 -> {
                            mainModel.convertSingleDigitNumbers(inputNumber);
                            mainScreen.displayOutputString(mainModel.outputString);
                            mainScreen.numberInput.setText("Enter the number here");
                        }
                        case 2 -> {
                            mainModel.convertDoubleDigitNumbers(inputNumber);
                            mainScreen.displayOutputString(mainModel.outputString);
                            mainScreen.numberInput.setText("Enter the number here");
                        }
                        case 3 -> {
                            mainModel.convertTripleDigitNumbers(inputNumber);
                            mainScreen.displayOutputString(mainModel.outputString);
                            mainScreen.numberInput.setText("Enter the number here");
                        }
                    }


                } catch (NumberFormatException wrongFormatException) {
                    System.out.println(wrongFormatException);
                    mainScreen.displayErrorMessageOne();
                    mainScreen.numberInput.setText("Enter the number here");
                } catch (IntegerAboveThresholdException aboveThresholdException) {
                    System.out.println(aboveThresholdException);
                    mainScreen.displayErrorMessageTwo();
                    mainScreen.numberInput.setText("Enter the number here");
                } catch (IntegerNegativeValueException negativeValueException) {
                    System.out.println(negativeValueException);
                    mainScreen.displayErrorMessageThree();
                    mainScreen.numberInput.setText("Enter the number here");
                }

                //The try and catch  are used to cover 3 unacceptable cases:
                // First - In the input text field are entered unacceptable symbols
                // Second - In the input text field are entered 4- digit numbers
                // Third - In the input text field are entered negative values

            }
        }
    }
}
