package controller;

import controller.CollegeCareerChoiceController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

public class WindowCaller {
    public void collegeCareerChoice(Player player, Career career1, Career career2, Salary salary1, Salary salary2) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader collegeCareerChoiceLoader = new FXMLLoader(getClass().getResource("/view/CollegeCareerChoice.fxml"));
        CollegeCareerChoiceController collegeCareerChoiceController = new CollegeCareerChoiceController(career1, career2, salary1, salary2);
        collegeCareerChoiceLoader.setController(collegeCareerChoiceController);

        try {
            stage.setScene(new Scene(collegeCareerChoiceLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();

        player.setCareer(collegeCareerChoiceController.getChosenCareer());
        player.setSalary(collegeCareerChoiceController.getChosenSalary());
    }

    public Card chooseHouseCard(House[] houses) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader chooseHouseCardLoader = new FXMLLoader(getClass().getResource("/view/ChooseHouseCard.fxml"));
        ChooseHouseCardController chooseHouseCardController = new ChooseHouseCardController(houses);
        chooseHouseCardLoader.setController(chooseHouseCardController);

        try {
            stage.setScene(new Scene(chooseHouseCardLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();

        return chooseHouseCardController.getChosenHouse();
    }

    public Path choosePath(Path path1, Path path2) {
        Path chosenPath = null;

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader pathChoiceLoader= new FXMLLoader(getClass().getResource("/view/PathChoice.fxml"));
        PathChoiceController pathChoiceController= new PathChoiceController(path1,path2);
        pathChoiceLoader.setController(pathChoiceController);

        try {
            stage.setScene(new Scene(pathChoiceLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();

        //        stage.setScene(new Scene());

        // 1. make fxml
        // 2. make controller
        // 3. call fxml loader hereee
        // 4. initialize controller hereee
        // 5. set fxml loader's controller to the initialized controller
        // 6. show and wait then return the value



        return pathChoiceController.getChosenPath();
    }
}
