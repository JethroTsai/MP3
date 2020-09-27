package controller;

import controller.CollegeCareerChoiceController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

public class WindowCaller {
    public void collegeCareerChoice(GameResource gameResource, Player player) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);

        Career career1, career2;
        Salary salary1, salary2;
        career1 = gameResource.getCareers().getTopCard(player.hasDegree());
        career2 = gameResource.getCareers().getTopCard(player.hasDegree());
        salary1 = gameResource.getSalaries().getTopCard();
        salary2 = gameResource.getSalaries().getTopCard();

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

        //return unchosen card
        if (collegeCareerChoiceController.getChosenCareer().equals(career1))
        {
            gameResource.getCareers().getListCareers().add(career2);
        }
        else
        {
            gameResource.getCareers().getListCareers().add(career1);
        }
        if (collegeCareerChoiceController.getChosenSalary().equals(salary1))
        {
            gameResource.getSalaries().getListSalary().add(salary2);
        }
        else
        {
            gameResource.getSalaries().getListSalary().add(salary1);
        }

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

    public void careerCard(Career career,Player player)
    {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);


        FXMLLoader careerCardLoader = new FXMLLoader(getClass().getResource("/view/CareerCard.fxml"));
        CareerCardController careerCardController= new CareerCardController(career);
        careerCardLoader.setController(careerCardController);

        try {
            stage.setScene(new Scene(careerCardLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();

        player.setCareer(career);

    }

    public void salaryCard(Salary salary,Player player)
    {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);


        FXMLLoader salaryCardLoader = new FXMLLoader(getClass().getResource("/view/CareerCard.fxml"));
       SalaryController salaryController= new SalaryController(salary);
        salaryCardLoader.setController( salaryController);

        try {
            stage.setScene(new Scene(salaryCardLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();

        player.setSalary(salary);

    }

    public void actionCard(Action act)
    {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader actionCardLoader= new FXMLLoader(getClass().getResource("/view/ActionCard.fxml"));
        ActionCardController actionCardController= new ActionCardController(act);
        actionCardLoader.setController(actionCardController);

        try {
            stage.setScene(new Scene(actionCardLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();


    }
}
