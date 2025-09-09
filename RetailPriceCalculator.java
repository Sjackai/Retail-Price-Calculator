import javax.swing.*; //import the swing GUI parts
import java.awt.*; //import UI for GridBagLayout/GridBagConstraints
import java.awt.event.ActionEvent; //import for user actions and button handling
import java.awt.event.ActionListener; //import for handling button clicks




public class RetailPriceCalculator extends JFrame implements ActionListener {
    //declare instance variables for GUI, make priv. to be accesed from RetailPriceCalculator
    private JTextField wholesaleCostField; //GUI input field for wholesaleCostFiled
    private JTextField markupPercentageField; //GUI input field for markupPercentageField
    private JTextField retailPriceField; //displays output
    private JButton calculateButton; //GUI input with formatted button
    private JButton exitButton; //GUI input with formatted button

    //setting up construtor for RetailPriceCalculator
    public RetailPriceCalculator() { //GUI components are initialized and assembled
        setTitle("Retail Price Calculator"); //creating a simple title for GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for when user exits
        setSize(450, 300); // Dimensions for height for better spacing
        setLocationRelativeTo(null); // set positions of window - null for center in middle of screen
        setResizable(false); // set functions for user to control size of screen to off so it cant be moved.

        // The start of my panel setup
        // start a new JPanel object named mainPanel
        JPanel mainPanel = new JPanel(); //create a new panel to hold calc component
        // assign Gridbaglayout to mainpanel
        mainPanel.setLayout(new GridBagLayout()); //set up grid to hold labels, text fields, etc.
        //adds space around mainPanel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // create a frame for paddding

        // GUI
        // Labels
        // Create a jlabel to ask the user to enter their wholesale cost.(readonly)
        JLabel wholesaleCostLabel = new JLabel("Enter Items Wholesale Cost:"); //create JLabel object and display
        //Jlabel for markup % (readonly)
        JLabel markupPercentageLabel = new JLabel("Enter Items Markup Percentage:"); //create JLabel object and display -
        // Jlabel for the retail price display(readonly)
        JLabel retailPriceLabel = new JLabel("Items Retail Price:");
        // Start of input
        wholesaleCostField = new JTextField(10);
        markupPercentageField = new JTextField(10); // Set preferred width

        //creating ouput fields (read only)
        // creates retailPriceField with width of 10
        retailPriceField = new JTextField(10); //create textbox for retailPriceField
        // start retailPriceField as read only/false
        retailPriceField.setEditable(false);


        //create buttons
        calculateButton = new JButton("Calculate Retail Price"); //create a button object with txt, uses the calculateButton var
        exitButton = new JButton("Exit"); //create another exit button
        calculateButton.addActionListener(this); //tell object that when action happens it should perform
        exitButton.addActionListener(this); //tell object that when action happens it should perform

        GridBagConstraints gbc = new GridBagConstraints();//create GridBagConstraints object to hold details for next item wholesalelabel

        gbc.insets = new Insets(5, 5, 5, 5); // add 5 pixel space, top, left, bottom, right
        gbc.gridx = 0; // column 0 for next item wholesalelabel
        gbc.gridy = 0; // row 0 for next item wholesalelabel
        gbc.anchor = GridBagConstraints.WEST; // put left of the cell, use anchor to keep it stuck
        mainPanel.add(wholesaleCostLabel, gbc); //add the wholesalelabel onto mainpanel
        gbc.gridx = 1; // column 1 for next item wholesaleCostField
        gbc.gridy = 0; // row 0 for next item wholesaleCostField to be next to wholesalelabel
        gbc.fill = GridBagConstraints.HORIZONTAL; // get text field horizontal

        gbc.weightx = 1.0; // widen the columns

        mainPanel.add(wholesaleCostField, gbc);//add the wholesaleCostField onto mainpanel


        // Row 1: MarkupPercentage

        gbc.gridx = 0; // change gbc to reset back to column 0 for markupPercentage

        gbc.gridy = 1; // change to put markupPercentageLabel on row 1

        gbc.anchor = GridBagConstraints.WEST; // put left of the cell, use anchor to keep it stuck
        gbc.fill = GridBagConstraints.NONE; // dont allow markupPercentageLabel to change, labels dont need to change

        gbc.weightx = 0; // dont give column extra space only for labels

        mainPanel.add(markupPercentageLabel, gbc); //add the markupPercentageLabel onto mainpanel


        gbc.gridx = 1; // put markupPercentageField into column 1

        gbc.gridy = 1; // put markupPercentageField into column 1

        gbc.fill = GridBagConstraints.HORIZONTAL; //fill markupPercentageField fully horizontally for input
        gbc.weightx = 1.0; // allow markupPercentageField to take up entire space when typing

        mainPanel.add(markupPercentageField, gbc);//add markupPercentageField onto GUI


        // row 2: RetailPriceLabel

        gbc.gridx = 0; // put RetailPriceLabel on column 0

        gbc.gridy = 2; // put RetailPriceLabel on row 2

        gbc.anchor = GridBagConstraints.WEST; // put on left side

        gbc.fill = GridBagConstraints.NONE; // dont allow label to expand size
        gbc.weightx = 0; // dont allow labels column to expand size

        mainPanel.add(retailPriceLabel, gbc); //add retailPriceLabel onto mainpanel


        gbc.gridx = 1; // put retailPriceField onto column 1

        gbc.gridy = 2; // put retailPriceField into row 2

        gbc.fill = GridBagConstraints.HORIZONTAL; // fill retailPriceField fully horizontally for input
        gbc.weightx = 1.0; // allow markupPercentageField to take up entire space when typing
        mainPanel.add(retailPriceField, gbc); //add retailPriceField onto mainpanel

        //row 3:Calculate button
        gbc.gridx = 0; //start at column 0
        gbc.gridy = 3; //new row
        gbc.gridwidth = 2; //have button go across both columns
        gbc.fill = GridBagConstraints.HORIZONTAL; //move button horizontally
        gbc.weightx = 1.0; //button takes up space horitzontally
        mainPanel.add(calculateButton, gbc); //add calc button to main panel

        //row 4: for exit button
        gbc.gridx = 0; //start at column 0
        gbc.gridy = 4; //sart anohter row for exit button
        gbc.gridwidth = 2; //go across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL; //move button horizontally
        gbc.weightx = 1.0; //hold space
        mainPanel.add(exitButton, gbc); //add exit button to main panel


        add(mainPanel); //add the mainpanel where everything is onto the jframe/RetailPriceCalculator
        pack(); //automatic resize for
        setVisible(true); //use this method to get the parts to appear on users screen
    }
    @Override
    public void actionPerformed(ActionEvent e) { //calls the action event when it happens on actionlisteners like calc/exit button
        if (e.getSource() == calculateButton) { //if the calc button is clicked print that its calculating the price

            double wholesaleCost = 0; //declare var. wholesale cost as a double for money, to store users input
            double markupPercentage = 0; //declare var. markup Percentage as a double for money, to store users input
            double retailPrice = 0; //var to store the actual ending price

            try { //use try block to catch any exceptions
                String wholesaleCostFieldValue = wholesaleCostField.getText(); //get text from wholesaleCostField, and store
                //it as a string called wholesaleCostFieldValue
                String markupPercentageFieldValue = markupPercentageField.getText(); //get text from markupPercentageField, and store
                //it as a string called wholesaleCostFieldValue

                if (wholesaleCostFieldValue.isEmpty() || markupPercentageFieldValue.isEmpty()) { //if nothing is typed in at least one of the fields but calc is clicked the print this message
                    JOptionPane.showMessageDialog(this, "Error! Please enter values for both Wholesale Cost" +
                            " and Markup Percentage.");
                    return; //if nothing is typed then return nothing and break the code
                }
                wholesaleCost = Double.parseDouble(wholesaleCostFieldValue); //passes the if check, converts to double
                markupPercentage = Double.parseDouble(markupPercentageFieldValue); //passes the if check, converts to double
//store into var. "wholesaleCost"/ "markupPercentage"
            } catch (
                    NumberFormatException ex) { //catch block is here to handle any NumberFormatException but if the user enters words
                //it will display this message
                JOptionPane.showMessageDialog(this, "Wrong format error! Please only enter numbers for both of " +
                        "your inputs.");
                return; //if the error happens then break the code
            }
            catch (Exception ex) { //if theres an error that NumersFormatException didnt catch, this will be the general
                //exception block to catch it and display a the exceptions message
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            if (wholesaleCost < 0) { //if the var. wholesaleCost which holds the users input is negative/less than 0
                //display this message on screen
                JOptionPane.showMessageDialog(this, "Error! Wholesale Cost cant be negative." +
                        " Please enter a positive number.");
                return; //if this error is found end cod
            }
            if (markupPercentage < 0) { //if the var. markupPercentage which holds the users input is negative/less than 0
                //display this message on screen
                JOptionPane.showMessageDialog(this, "Error! Markup Percentage cant be negative." +
                        " Please enter a positive number.");
                return; //if this error is found end code
            }

            retailPrice = calculateRetail(wholesaleCost,markupPercentage); //call calculateRetail method and use wholesaleCost
            //and markupPercentage as arguments
            String formattedRetailPrice = String.format("%.2f", retailPrice); //create a string to hold the new formatted retailprice
            //use %.2f for precision, 2 digits after decimal point
            formattedRetailPrice = "$" +  formattedRetailPrice; //the formattedRetailPrice will now have a '$' next to the number

            retailPriceField.setText(formattedRetailPrice); //use formattedRetailPrice, which is a string, and set it
            //in the retailPriceField

        } else if (e.getSource() == exitButton) { //if the source isn't the calc button then its the exit button, so print that its exiting
            System.exit(0); //exit out of program
        }
    }
    private double calculateRetail(double cost, double markup) { //create method calculateRetail, with 2 double parameters
        double retailPriceResult; //create var. retailPriceResult that's a double to store the calculated retailPrice

        retailPriceResult = cost * (1 + (markup / 100.0)); //this is the formula to find the retailPrice and will be stored
        // in the var I just created, retailPriceResult
        return retailPriceResult; //return the var. that holds the retailPrice
    }
        public static void main(String[] args) { //main method to run program
            RetailPriceCalculator calculator = new RetailPriceCalculator(); //call RetailPriceCalculator and create a new instance of the class to display
        }
    }
