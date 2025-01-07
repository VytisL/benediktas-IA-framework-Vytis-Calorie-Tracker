
# Adding a New Services CRUD Window to IB IA Project

I create framework for your project.

At his moment I add admin and client login and examples views.

You need add your own views, by your project.

This guide will walk you through adding a new "Services" CRUD (Create, Read, Update, Delete) window to the  project, using the provided `ViewFactory` structure. By the end, you’ll have a functional interface for managing services, integrated seamlessly into the client menu.

---

## **1. Create a New FXML File**
1. **Location:**
   Navigate to `src/main/resources/Fxml/Client/`.

2. **Create the File:**
   Create a new file named `Services.fxml`.

3. **Design the UI:**
   Use JavaFX Scene Builder or a text editor to design a user interface for managing services. Include components such as:
    - A `TableView` to display service data.
    - Buttons for actions like "Add", "Edit", and "Delete".

---

## **2. Create a New Controller Class**
1. **Location:**
   Navigate to `src/main/java/com/benedict/minibank/Controllers/Client/`.

2. **Create the File:**
   Create a new Java class named `ServicesController.java`.

3. **Add Functionality:**
   Implement the logic to handle CRUD operations. Example:

   ```java
   package com.benedict.minibank.Controllers.Client;

   import javafx.fxml.FXML;
   import javafx.scene.control.Button;
   import javafx.scene.control.TableView;

   public class ServicesController {
       @FXML
       private TableView<?> servicesTable;

       @FXML
       private Button addServiceButton;

       @FXML
       private Button editServiceButton;

       @FXML
       private Button deleteServiceButton;

       @FXML
       public void initialize() {
           setupTable();
           addEventHandlers();
       }

       private void setupTable() {
           // Add columns and initialization logic for the table
       }

       private void addEventHandlers() {
           addServiceButton.setOnAction(event -> handleAddService());
           editServiceButton.setOnAction(event -> handleEditService());
           deleteServiceButton.setOnAction(event -> handleDeleteService());
       }

       private void handleAddService() {
           // Logic to add a new service
       }

       private void handleEditService() {
           // Logic to edit an existing service
       }

       private void handleDeleteService() {
           // Logic to delete a service
       }
   }
   ```

---

## **3. Update ViewFactory**
1. **Open ViewFactory:**
   Locate `ViewFactory.java`.

2. **Add a New Attribute and Method:**
   Add logic to load and return the `Services.fxml` view.

   ```java
   private AnchorPane servicesView;

   public AnchorPane getServicesView() {
       if (servicesView == null) {
           try {
               servicesView = new FXMLLoader(getClass().getResource("/Fxml/Client/Services.fxml")).load();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       return servicesView;
   }
   ```

---

## **4. Update ClientMenuOptions**
1. **Add a New Enum Value:**
   Open `ClientMenuOptions.java` and add:

   ```java
   SERVICES
   ```

---

## **5. Update ClientController**
1. **Open ClientController:**
   Locate `ClientController.java`.

2. **Add Switching Logic:**
   Update the `addListener` method to handle the new `SERVICES` option:

   ```java
   switch (newVal) {
       case TRANSACTIONS -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
       case ACCOUNTS -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
       case SERVICES -> client_parent.setCenter(Model.getInstance().getViewFactory().getServicesView());
       default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
   }
   ```

---

## **6. Update ClientMenuController**
1. **Add a New Button:**
    - Open `ClientMenuController.java`.
    - Add a new button for the "Services" menu option and its event handler:

   ```java
   public Button services_btn;

   private void addListeners() {
       dashboard_btn.setOnAction(event -> onDashboard());
       transaction_btn.setOnAction(event -> onTransactions());
       accounts_btn.setOnAction(event -> onAccounts());
       services_btn.setOnAction(event -> onServices());
       logout_btn.setOnAction(event -> onLogout());
   }

   private void onServices() {
       Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.SERVICES);
   }
   ```

2. **Update the FXML File:**
    - Open the client menu FXML file, e.g., `ClientMenu.fxml`.
    - Add a button for "Services":

   ```xml
   <Button fx:id="services_btn" text="Services" />
   ```

---

## **7. Test the Application**
1. Run the application.
2. Log in as a client.
3. Verify that the "Services" button in the menu switches to the newly created Services CRUD window.

---

