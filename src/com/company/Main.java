package com.company;

import controller.ConvertorController;
import model.ConvertorModel;
import view.ConvertorMainScreen;

public class Main {

    public static void main(String[] args) {
    ConvertorMainScreen mainScreen = new ConvertorMainScreen();
    ConvertorModel mainModel = new ConvertorModel();
    ConvertorController mainController = new ConvertorController(mainScreen, mainModel);
    mainScreen.setVisible(true);

    //Hello. This is a simple program, which converts integers in the range [0;999] to bulgarian words.
    //The program uses Java GUI and the design pattern "Model-View-Controller" is implemented.
    //The classes are segregated into separate packages, as per the design pattern.
    //Comments are used widely throughout the code and the arrangement of the lines is in a good order.
    //The program was created using Intellij.

    }

}
