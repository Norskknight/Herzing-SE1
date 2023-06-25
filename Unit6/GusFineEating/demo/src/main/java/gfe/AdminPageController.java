package gfe;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;

public class AdminPageController {

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> positionColumn;

    @FXML
    private TableColumn<Employee, Employee> actionsColumn;

    public void initialize() {
        // Configure the columns to display employee data
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Add buttons for actions in the actionsColumn
        actionsColumn.setCellFactory(getActionCellFactory());
        
        // Populate the table with dummy data (you can replace it with your actual employee data)
        employeeTable.getItems().addAll(
                new Employee(1, "John Doe", "Manager"),
                new Employee(2, "Jane Smith", "Supervisor"),
                new Employee(3, "Bob Johnson", "Developer")
        );
    }
    
    private Callback<TableColumn<Employee, Employee>, TableCell<Employee, Employee>> getActionCellFactory() {
        return column -> {
            final TableCell<Employee, Employee> cell = new TableCell<>() {
                private final Button editButton = new Button("Edit");
                private final Button deleteButton = new Button("Delete");

                {
                    // Set actions for the buttons
                    editButton.setOnAction(event -> {
                        Employee employee = getTableRow().getItem();
                        //openEditEmployeeDialog(employee);
                    });

                    deleteButton.setOnAction(event -> {
                        Employee employee = getTableRow().getItem();
                        //deleteEmployee(employee);
                    });
                }

                @Override
                protected void updateItem(Employee employee, boolean empty) {
                    super.updateItem(employee, empty);
                    if (!empty) {
                        setGraphic(new HBox( editButton, deleteButton));
                    } else {
                        setGraphic(null);
                    }
                }
            };
            
            // Ensure that the cell can handle empty items properly
            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            return cell;
        };
    }

    // Rest of the code...
    @FXML
    private void openAddEmployeeDialog(){}
}
