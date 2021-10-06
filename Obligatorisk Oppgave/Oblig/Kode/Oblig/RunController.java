package Oblig;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class RunController implements Initializable {

    //////////////////////////////////////////
    // *** Variabels ***
    //////////////////////////////////////////

    // General variables
    private int counter = 0, currentSelectedIndex;
    private double pX1, pX2, pY1, pY2, size;
    private GraphicsContext tempG;
    private boolean rectangleButtonStatus = false, circleButtonStatus = false, lineButtonStatus = false,
            textButtonClick = false;
    private ArrayList<Figur> figurer = new ArrayList<Figur>();

    // FXML Variables
    @FXML
    private Pane masterPane;
    @FXML
    private Canvas tempCanvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider brushSize;
    @FXML
    private Button toFront, toBack, rectangle, circle, line, rotateForward, rotateBackward, text;
    @FXML
    private TableView<FigurTable> tableview;
    @FXML
    private Label shapetypeInfo, colorInfo, linelengthInfo, arealInfo;

    //////////////////////////////////////////
    // *** Listeners ***
    //////////////////////////////////////////
    @FXML
    private void canvasMousePressed(MouseEvent e) {
        size = brushSize.getValue();
        pX1 = e.getX();
        pY1 = e.getY();
    }

    @FXML
    private void canvasMouseDragged(MouseEvent e) {
        size = brushSize.getValue();
        pX2 = e.getX();
        pY2 = e.getY();

        if (rectangleButtonStatus)
            drawRectangleEffect();
        if (circleButtonStatus)
            drawCircleEffect();
        if (lineButtonStatus)
            drawLineEffect();
    }

    @FXML
    private void canvasMouseReleased(MouseEvent e) {
        if (rectangleButtonStatus)
            drawRectangle();
        if (circleButtonStatus)
            drawCircle();
        if (lineButtonStatus)
            drawLine();
        if (textButtonClick)
            drawText();
        tempG.clearRect(0, 0, tempCanvas.getWidth(), tempCanvas.getHeight());
    }

    @FXML
    private void rectangleButtonClick(ActionEvent e) {
        rectangleButtonStatus = true;
        circleButtonStatus = false;
        lineButtonStatus = false;
        textButtonClick = false;
    }

    @FXML
    private void circleButtonClick(ActionEvent e) {
        rectangleButtonStatus = false;
        circleButtonStatus = true;
        lineButtonStatus = false;
        textButtonClick = false;
    }

    @FXML
    private void lineButtonClick(ActionEvent e) {
        rectangleButtonStatus = false;
        circleButtonStatus = false;
        lineButtonStatus = true;
        textButtonClick = false;
    }

    @FXML
    private void textButtonClick(ActionEvent e) {
        rectangleButtonStatus = false;
        circleButtonStatus = false;
        lineButtonStatus = false;
        textButtonClick = true;
    }

    @FXML
    private void brushButtonClick(ActionEvent e) {
        rectangleButtonStatus = false;
        circleButtonStatus = false;
        lineButtonStatus = false;
        textButtonClick = false;
    }

    @FXML
    private void colorpickerClick(ActionEvent e) {
        changeColorOnShape();
    }

    @FXML
    private void toBackButtonClick(ActionEvent e) {
        changeOrderBackward();
    }

    @FXML
    private void toForwardButtonClick(ActionEvent e) {
        changeOrderForward();
    }

    @FXML
    private void toRotateForwardClick(ActionEvent e) {
        rotateForward();
    }

    @FXML
    private void toRotateBackwardClick(ActionEvent e) {
        rotateBackward();
    }

    @FXML
    private void onSelectChange(MouseEvent e) {
        if (!tableview.getSelectionModel().isEmpty()) {
            currentSelectedIndex = tableview.getSelectionModel().getSelectedItem().getId();
            Figur figur = figurer.get(currentSelectedIndex);
            switch (figurer.get(currentSelectedIndex).getType()) {
                case "Circle":
                    UpdateLabels.setLabelCircle(figur, shapetypeInfo, colorInfo, linelengthInfo, arealInfo);
                    break;
                case "Rectangle":
                    UpdateLabels.setLabelRectangle(figur, shapetypeInfo, colorInfo, linelengthInfo, arealInfo);
                    break;
                case "Line":
                    UpdateLabels.setLabelLine(figur, shapetypeInfo, colorInfo, linelengthInfo, arealInfo);
                    break;
                case "Text":
                    UpdateLabels.setLabelText(figur, shapetypeInfo, colorInfo, linelengthInfo, arealInfo);
                    break;
                default:
                    break;
            }
        }
    }

    //////////////////////////////////////////
    // *** Drawing ***
    //////////////////////////////////////////
    private void drawRectangle() {
        figurer.add(new Figur(counter, "Rectangle", MyColor.getColorName(colorPicker.getValue())));
        figurer.get(counter).setRectangle();
        figurer.get(counter).setRectangle(pX1, pY1, pX2, pY2);
        figurer.get(counter).getRetangle().setFill(colorPicker.getValue());
        masterPane.getChildren().add(figurer.get(counter).getRetangle());
        tableview.getItems().add(new FigurTable(counter, "Rectangle"));
        counter++;
    }

    private void drawRectangleEffect() {
        Figur figur = new Figur();
        figur.setRectangle();
        figur.getRetangle().drawRectangleEffect(tempG, tempCanvas, pX1, pY1, pX2, pY2, colorPicker.getValue());
    }

    private void drawCircle() {
        figurer.add(new Figur(counter, "Circle", MyColor.getColorName(colorPicker.getValue())));
        figurer.get(counter).setCircle();
        figurer.get(counter).setCircle(pX1, pY1, pX2, pY2);
        figurer.get(counter).getCircle().setFill(colorPicker.getValue());
        masterPane.getChildren().add(figurer.get(counter).getCircle());
        tableview.getItems().add(new FigurTable(counter, "Circle"));
        counter++;
    }

    private void drawCircleEffect() {
        Figur figur = new Figur();
        figur.setCircle();
        figur.getCircle().drawCircleEffect(tempG, tempCanvas, pX1, pY1, pX2, pY2, colorPicker.getValue());
    }

    private void drawLine() {
        figurer.add(new Figur(counter, "Line", MyColor.getColorName(colorPicker.getValue())));
        figurer.get(counter).setLine(pX1, pY1, pX2, pY2);
        figurer.get(counter).getLine().setStroke(colorPicker.getValue());
        masterPane.getChildren().add(figurer.get(counter).getLine());
        tableview.getItems().add(new FigurTable(counter, "Line"));
        counter++;
    }

    private void drawLineEffect() {
        Figur figur = new Figur();
        figur.setLine();
        figur.getLine().drawLineEffect(tempG, tempCanvas, pX1, pY1, pX2, pY2, colorPicker.getValue());
    }

    private void drawText() {
        String input = JOptionPane.showInputDialog(null, "Text: ");
        if (input != null) {
            figurer.add(new Figur(counter, "Text", MyColor.getColorName(colorPicker.getValue())));
            figurer.get(counter).setText(pX1, pY1, input);
            figurer.get(counter).getText().setFont(Font.font("arial", brushSize.getValue()));
            figurer.get(counter).getText().setFill(colorPicker.getValue());
            masterPane.getChildren().add(figurer.get(counter).getText());
            tableview.getItems().add(new FigurTable(counter, "Text"));
            counter++;
        }
    }

    //////////////////////////////////////////
    // *** Other ***
    //////////////////////////////////////////

    public void onSave() {
        try {
            Image snapshop = masterPane.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshop, null), "png", new File("New.png"));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
        }
    }

    public void onExit() {
        Platform.exit();
    }

    public void changeOrderForward() {
        try {
            if (currentSelectedIndex != counter - 1) {
                ObservableList<Node> workingCollection = FXCollections.observableArrayList(masterPane.getChildren());
                Collections.swap(workingCollection, currentSelectedIndex, currentSelectedIndex + 1);
                masterPane.getChildren().setAll(workingCollection);

                figurer.get(currentSelectedIndex + 1).setId(currentSelectedIndex);
                figurer.get(currentSelectedIndex).setId(currentSelectedIndex + 1);

                Collections.swap(figurer, currentSelectedIndex, currentSelectedIndex + 1);
                tableview.getItems().get(currentSelectedIndex).setId(currentSelectedIndex + 1);
                tableview.getItems().get(currentSelectedIndex + 1).setId(currentSelectedIndex);
                tableview.getItems().add(currentSelectedIndex + 1, tableview.getItems().remove(currentSelectedIndex));

                currentSelectedIndex = currentSelectedIndex + 1;
                tableview.sort();
                tableview.refresh();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You need to select a shape first!");
        }
    }

    public void changeOrderBackward() {
        try {
            if (currentSelectedIndex != 0) {
                ObservableList<Node> workingCollection = FXCollections.observableArrayList(masterPane.getChildren());
                Collections.swap(workingCollection, currentSelectedIndex, currentSelectedIndex - 1);
                masterPane.getChildren().setAll(workingCollection);

                figurer.get(currentSelectedIndex - 1).setId(currentSelectedIndex);
                figurer.get(currentSelectedIndex).setId(currentSelectedIndex - 1);

                Collections.swap(figurer, currentSelectedIndex, currentSelectedIndex - 1);
                tableview.getItems().get(currentSelectedIndex).setId(currentSelectedIndex - 1);
                tableview.getItems().get(currentSelectedIndex - 1).setId(currentSelectedIndex);
                tableview.getItems().add(currentSelectedIndex - 1, tableview.getItems().remove(currentSelectedIndex));

                currentSelectedIndex = currentSelectedIndex - 1;

                tableview.sort();
                tableview.refresh();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You need to select a shape first!");
        }
    }

    public void rotateForward() {
        try {
            figurer.get(currentSelectedIndex).rotateForward();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You need to select a shape first!");
        }
    }

    public void rotateBackward() {
        try {
            figurer.get(currentSelectedIndex).rotateBackward();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You need to select a shape first!");
        }
    }

    public void changeColorOnShape() {
        try {
            figurer.get(currentSelectedIndex).changeColor(colorPicker.getValue());
            figurer.get(currentSelectedIndex).setColor(MyColor.getColorName(colorPicker.getValue()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You need to select a shape first!");
        }
    }

    //////////////////////////////////////////
    // *** Intializer ***
    //////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tempG = tempCanvas.getGraphicsContext2D();
        // ID
        TableColumn<FigurTable, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setMinWidth(100);
        idColumn.setSortType(TableColumn.SortType.DESCENDING);
        // Type
        TableColumn<FigurTable, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setMinWidth(100);

        tableview.getColumns().addAll(idColumn, typeColumn);
    }
}