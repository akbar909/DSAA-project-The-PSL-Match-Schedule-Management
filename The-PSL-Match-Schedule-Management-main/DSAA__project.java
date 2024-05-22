
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Match {
        private String team1;
        private String team2;
        private String month;
        private String day;
        private String time;

        // Constructor
        public Match(String team1, String team2, String month, String day, String time) {
                this.team1 = team1;
                this.team2 = team2;
                this.month = month;
                this.day = day;
                this.time = time;
        }

        // Getters
        public String getTeam1() {
                return team1;
        }

        public String getTeam2() {
                return team2;
        }

        public String getMonth() {
                return month;
        }

        public String getDay() {
                return day;
        }

        public String getTime() {
                return time;
        }
}

class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                // Handle action events here
        }
}

public class DSAA__project extends javax.swing.JDialog {
        private List<Match> matches = new ArrayList<>();
        private Set<String> selectedDateTime = new HashSet<>();
        private Stack<String> itemStack;
        private Stack<String>[] columnStacks;

        /**
         * Creates new form DSAA__project
         */
        public DSAA__project(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
                itemStack = new Stack<>();

                // Initialize stacks for each column
                columnStacks = new Stack[6];
                initializeItems(columnStacks); // Method to initialize items in the stack
                addToTable(); // Method to add items from stack to jTable2
                this.setSize(900, 380);

                setBackgroundImage("D:\\The-PSL-Match-Schedule-Management-main\\The-PSL-Match-Schedule-Management-main\\PSL___LOGO.jpg");
                setBackgroundImage1("D:\\The-PSL-Match-Schedule-Management-main\\The-PSL-Match-Schedule-Management-main\\PSL___LOGO.jpg");

        }

        private void initializeItems(Stack<String>[] columnStacks) {
                // Initialize each column stack before pushing items onto them
                for (int i = 0; i < columnStacks.length; i++) {
                        columnStacks[i] = new Stack<>();
                }
                // Push items onto Sixth column stack
                columnStacks[5].push("Yasir Khan");
                columnStacks[5].push("Mohammad Rizwan (c)(wk)");
                columnStacks[5].push("David Willey");
                columnStacks[5].push("Usman Khan");
                columnStacks[5].push("Johnson Charles");
                columnStacks[5].push("Khushdil Shah");
                columnStacks[5].push("Usama Mir");
                columnStacks[5].push("Iftikhar Ahmed");
                columnStacks[5].push("Chris Jordan");
                columnStacks[5].push("Abbas Afridi");
                columnStacks[5].push("Mohammad Ali");

                // Push items onto Fifth column stack
                columnStacks[4].push("Sahibzada Farhan");
                columnStacks[4].push("Mirza Tahir Baig");
                columnStacks[4].push("Abdullah Shafique");
                columnStacks[4].push("Shai Hope (wk)");
                columnStacks[4].push("Shaheen Afridi (c)");
                columnStacks[4].push("Sikandar Raza");
                columnStacks[4].push("David Wiese");
                columnStacks[4].push("Geroge Linde");
                columnStacks[4].push("Jahandad Khan");
                columnStacks[4].push("Tayyab Abbas");
                columnStacks[4].push("Zaman Khan");

                // Push items onto Forth column stack
                columnStacks[3].push("jason Roy");
                columnStacks[3].push("Saud Shakeel");
                columnStacks[3].push("Rilee Rossow (c)");
                columnStacks[3].push("Khawaja Nafay");
                columnStacks[3].push("Laurie Evans (wk)");
                columnStacks[3].push("Mohammad Wasim jr.");
                columnStacks[3].push("Omair Yousuf");
                columnStacks[3].push("Akeal Hosein");
                columnStacks[3].push("Mohammad Amir");
                columnStacks[3].push("Abrar Ahmed");
                columnStacks[3].push("Sohail Khan");

                // Push items onto Third column stack
                columnStacks[2].push("Martin Guptill");
                columnStacks[2].push("Colin Munro");
                columnStacks[2].push("Agha Ali Salman");
                columnStacks[2].push("Shadab Khan (c)");
                columnStacks[2].push("Azam Khan (wk)");
                columnStacks[2].push("Imad Wasim");
                columnStacks[2].push("Haider Ali");
                columnStacks[2].push("Faheem Ashraf");
                columnStacks[2].push("Naseem Shah");
                columnStacks[2].push("Hunain Shah");
                columnStacks[2].push("Tymal Mills");

                // Push items onto Second column stack
                columnStacks[1].push("Tim Seifert (wk)");
                columnStacks[1].push("James Vince");
                columnStacks[1].push("Shan Masood (c)");
                columnStacks[1].push("Shoaib Malik");
                columnStacks[1].push("Irfan Khan");
                columnStacks[1].push("Kieron Pollard");
                columnStacks[1].push("Anwar Ali");
                columnStacks[1].push("Daniels Sams");
                columnStacks[1].push("Arafat Minhas");
                columnStacks[1].push("Hasan Ali");
                columnStacks[1].push("Zahid Mehmood");

                // Push items onto First column stack
                columnStacks[0].push("Saim Ayub");
                columnStacks[0].push("Babar Azam (c)");
                columnStacks[0].push("Mohammad Haris (wk)");
                columnStacks[0].push("Haseebullah Khan");
                columnStacks[0].push("Tom Kohler Cadmore");
                columnStacks[0].push("Rovman Powell");
                columnStacks[0].push("Asif Ali");
                columnStacks[0].push("Aamer Jamal");
                columnStacks[0].push("Naveen Ul Haq");
                columnStacks[0].push("Umair Afridi");
                columnStacks[0].push("Salman Irshad");

        }

        private void addToTable() {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                // Clear existing rows
                model.setRowCount(0);

                // Ensure columnStacks is initialized before using it
                if (columnStacks == null || columnStacks.length != 6) {
                        System.out.println("Error: columnStacks not properly initialized.");
                        return; // Exit the method if columnStacks is not properly initialized
                }

                // Populate jTable2 from column stacks
                for (int i = 0; i < 11; i++) {
                        Object[] rowData = new Object[6]; // 6 columns in total
                        for (int j = 0; j < 6; j++) {
                                // Check if columnStacks[j] is not null before accessing it
                                if (columnStacks[j] != null && !columnStacks[j].isEmpty()) {
                                        rowData[j] = columnStacks[j].get(i);
                                } else {
                                        rowData[j] = null; // Or any default value you prefer
                                }
                        }
                        model.addRow(rowData);
                }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        private void setBackgroundImage(String imagePath) {
                // Load the image
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Create a JLabel with the background image
                JLabel backgroundLabel = new JLabel(imageIcon);

                // Set the size and position of the label to match the size of jPanel1
                backgroundLabel.setBounds(-275, 0, jPanel1.getWidth(), jPanel1.getHeight());

                // Set the opacity of the background label
                backgroundLabel.setOpaque(true); // Set it to transparent
                backgroundLabel.setBackground(new Color(0, 0, 0, 60)); // Set the background color with reduced alpha
                                                                       // (opacity)

                // Set jPanel1 as the content pane of the dialog with the background label
                jPanel1.setLayout(null); // Ensure that jPanel1 uses absolute positioning
                jPanel1.add(backgroundLabel);

                // Ensure that jPanel1 repaints itself to show the background image
                jPanel1.repaint();
        }

        private void setBackgroundImage1(String imagePath) {
                // Load the image
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Create a JLabel with the background image
                JLabel backgroundLabel = new JLabel(imageIcon);

                // Set the size and position of the label to match the size of jPanel1
                backgroundLabel.setBounds(-60, 0, jPanel3.getWidth(), jPanel3.getHeight());

                // Set the opacity of the background label
                backgroundLabel.setOpaque(true); // Set it to transparent
                backgroundLabel.setBackground(new Color(0, 0, 0, 60)); // Set the background color with reduced alpha
                                                                       // (opacity)

                // Set jPanel1 as the content pane of the dialog with the background label
                jPanel3.setLayout(null); // Ensure that jPanel1 uses absolute positioning
                jPanel3.add(backgroundLabel);

                // Ensure that jPanel1 repaints itself to show the background image
                jPanel3.repaint();
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                jPanel3 = new javax.swing.JPanel();
                jTabbedPane1 = new javax.swing.JTabbedPane();
                jPanel1 = new javax.swing.JPanel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox3 = new javax.swing.JComboBox<>();
                jComboBox4 = new javax.swing.JComboBox<>();
                jComboBox5 = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jComboBox6 = new javax.swing.JComboBox<>();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jPanel5 = new javax.swing.JPanel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                panel1 = new java.awt.Panel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                jScrollPane3 = new javax.swing.JScrollPane();
                jPanel6 = new javax.swing.JPanel();
                jPanel7 = new javax.swing.JPanel();
                jLabel8 = new javax.swing.JLabel();
                jTextField2 = new javax.swing.JTextField();
                jButton3 = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                jTable3 = new javax.swing.JTable();
                jLabel10 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jTextField1 = new javax.swing.JTextField();
                jLabel9 = new javax.swing.JLabel();
                jButton2 = new javax.swing.JButton();

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Peshawar Zalmi",
                                "Karachi Kings",
                                "Islamabad United", "Lahore Qalandars", "Quetta Gladiators", "Multan Sultans" }));
                jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox1ActionPerformed(evt);
                        }
                });

                jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                                                "14", "15", "16",
                                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                                                "29", "30" }));
                jComboBox3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox3ActionPerformed(evt);
                        }
                });

                jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afternoon", "Evening" }));
                jComboBox4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox4ActionPerformed(evt);
                        }
                });

                jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feburary", "March" }));
                jComboBox5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox5ActionPerformed(evt);
                        }
                });

                jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton1.setText("Schedule");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel1.setText("Team 1");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel2.setText("Team 2");

                jComboBox6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karachi Kings",
                                "Peshawar Zalmi",
                                "Islamabad United", "Lahore Qalandars", "Quetta Gladiators", "Multan Sultans" }));
                jComboBox6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox6ActionPerformed(evt);
                        }
                });

                jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel3.setText("Month");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel4.setText("Day");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel5.setText("Time");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel5,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                99,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addComponent(jLabel4,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                99,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jComboBox6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jComboBox4,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                0,
                                                                                                                172,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jComboBox3,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jComboBox5,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addContainerGap(1125, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jComboBox6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                31,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(6, 6, 6)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jComboBox5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                31,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(12, 12, 12)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                31,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBox3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jComboBox4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton1)
                                                                .addContainerGap(54, Short.MAX_VALUE)));

                jTabbedPane1.addTab("Schedule", jPanel1);

                jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel7.setText("Scheduled Matches");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                " Match No.", "Match", " Day", " Timing"
                                }));
                jScrollPane1.setViewportView(jTable1);

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                900,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(283, 283, 283)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel7)
                                                                                                .addGap(200, 200, 200))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel6,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(948, 948,
                                                                                                                948)))));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel7)
                                                                                                .addGap(350, 350, 350)
                                                                                                .addComponent(jLabel6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                326,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 1442,
                                                                Short.MAX_VALUE));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                jTabbedPane1.addTab("View Schedule", jPanel2);

                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null }
                                },
                                new String[] {
                                                "Peshawar Zalmi", "Karachi Kings", "Islamabad United",
                                                "Quetta Gladiators", "Lahore Qalandars",
                                                "Multan Sultans"
                                }));
                jScrollPane2.setViewportView(jTable2);

                javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                900,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 542, Short.MAX_VALUE)));
                panel1Layout.setVerticalGroup(
                                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                480,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                jTabbedPane1.addTab("Teams", panel1);

                jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel8.setText("Match No.");

                jTextField2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField2ActionPerformed(evt);
                        }
                });

                jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton3.setText("Search");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                jTable3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null },
                                                { null, null, null, null, null, null }
                                },
                                new String[] {
                                                "Team1", "vs", "Team2", "Month", "Day", "TIme"
                                }));
                jTable3.addAncestorListener(new javax.swing.event.AncestorListener() {
                        public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                                jTable3AncestorAdded(evt);
                        }

                        public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                        }

                        public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                        }
                });
                jScrollPane4.setViewportView(jTable3);

                jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel10.setText("Searhed Match");

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGroup(jPanel7Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel7Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(183, 183, 183)
                                                                                                .addComponent(jLabel8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                105,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel7Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jButton3,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                205,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jTextField2)))
                                                                                .addGroup(jPanel7Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(335, 335, 335)
                                                                                                .addComponent(jLabel10,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                140,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 94, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                669,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(88, 88, 88)));
                jPanel7Layout.setVerticalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jPanel7Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel8))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton3)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jLabel10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                31,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(705, Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel7,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(573, Short.MAX_VALUE)));
                jPanel6Layout.setVerticalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                jScrollPane3.setViewportView(jPanel6);

                jTabbedPane1.addTab("Search Schedule", jScrollPane3);

                jTextField1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField1ActionPerformed(evt);
                        }
                });

                jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel9.setText("Match No:");

                jButton2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
                jButton2.setText("Delete");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(136, 136, 136)
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                226,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(986, Short.MAX_VALUE)));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel9)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(4, 4, 4)
                                                                                                .addComponent(jTextField1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                29,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(205, 205, 205)));

                jTabbedPane1.addTab("Delete Schedule", jPanel4);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTabbedPane1));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTabbedPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                350,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 481, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>

        private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                // Get the match number entered by the user
                int matchNumberToRetrieve;
                try {
                        matchNumberToRetrieve = Integer.parseInt(jTextField2.getText());
                } catch (NumberFormatException ex) {
                        // Show a warning message if the input is not a valid number
                        JOptionPane.showMessageDialog(this, "Please enter a valid match number.", "Invalid Input",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // Check if the match number is within the range of matches
                if (matchNumberToRetrieve <= 0 || matchNumberToRetrieve > matches.size()) {
                        // Show a warning message if the entered match number is out of range
                        JOptionPane.showMessageDialog(this,
                                        "Match with number " + matchNumberToRetrieve + " does not exist.",
                                        "Match Not Found", JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // Retrieve the match details
                Match matchToRetrieve = matches.get(matchNumberToRetrieve - 1);

                // Clear the table before displaying the match details
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.setRowCount(0);

                // Display the full match details in the JTable
                model.addRow(new Object[] { matchToRetrieve.getTeam1(), "vs", matchToRetrieve.getTeam2(),
                                matchToRetrieve.getMonth(), matchToRetrieve.getDay(), matchToRetrieve.getTime() });
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                // Get the serial number entered by the user
                int serialNumberToDelete;
                try {
                        serialNumberToDelete = Integer.parseInt(jTextField1.getText());
                } catch (NumberFormatException ex) {
                        // Show a warning message if the input is not a valid number
                        JOptionPane.showMessageDialog(this, "Please enter a valid serial number.", "Invalid Input",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // Check if the serial number is within the range of matches
                if (serialNumberToDelete <= 0 || serialNumberToDelete > matches.size()) {
                        // Show a warning message if the entered serial number is out of range
                        JOptionPane.showMessageDialog(this,
                                        "Match with serial number " + serialNumberToDelete + " does not exist.",
                                        "Match Not Found", JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // Remove the match from the list
                matches.remove(serialNumberToDelete - 1);

                // Clear the table before displaying the matches
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                // Display all the remaining match schedules
                int serialNumber = 1;
                for (Match match : matches) {
                        model.addRow(new Object[] { serialNumber++, match.getTeam1() + " vs " + match.getTeam2(),
                                        match.getMonth() + " " + match.getDay(), match.getTime() });
                }

                // Show a success message
                JOptionPane.showMessageDialog(this,
                                "Match with serial number " + serialNumberToDelete + " deleted successfully!");
        }

        private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jTable3AncestorAdded(javax.swing.event.AncestorEvent evt) {
                // TODO add your handling code here:
        }

        private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                String team1 = jComboBox1.getSelectedItem().toString();
                String team2 = jComboBox6.getSelectedItem().toString();
                String month = jComboBox5.getSelectedItem().toString();
                String day = jComboBox3.getSelectedItem().toString();
                String time = jComboBox4.getSelectedItem().toString();

                // Create a new Match object
                Match newMatch = new Match(team1, team2, month, day, time);

                // Store the match in the list
                matches.add(newMatch);

                // Clear the table before displaying the matches
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                // Display all the entered match schedules
                int serialNumber = 1;
                for (Match match : matches) {
                        model.addRow(new Object[] { serialNumber++, match.getTeam1() + " vs " + match.getTeam2(),
                                        match.getMonth() + " " + match.getDay(), match.getTime() });
                }

                // Show a success message
                JOptionPane.showMessageDialog(this, "Match schedule added successfully!");
        }

        private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                String selectedMonth = jComboBox5.getSelectedItem().toString();
                String selectedDay = jComboBox3.getSelectedItem().toString();
                String selectedTime = jComboBox4.getSelectedItem().toString();

                String selectedDateTimeStr = selectedMonth + "-" + selectedDay + "-" + selectedTime;

                if (selectedDateTime.contains(selectedDateTimeStr)) {
                        JOptionPane.showMessageDialog(this, "This date and time has already been selected.");
                        // Reset the selection if it's already been selected
                        // jComboBox5.setSelectedIndex(0);
                        // jComboBox3.setSelectedIndex(0);
                        // jComboBox4.setSelectedIndex(0);
                } else {
                        selectedDateTime.add(selectedDateTimeStr);
                }
        }

        private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                String selectedMonth = jComboBox5.getSelectedItem().toString();
                String selectedDay = jComboBox3.getSelectedItem().toString();
                String selectedTime = jComboBox4.getSelectedItem().toString();

                String selectedDateTimeStr = selectedMonth + "-" + selectedDay + "-" + selectedTime;

                if (selectedDateTime.contains(selectedDateTimeStr)) {
                        JOptionPane.showMessageDialog(this, "This date and time has already been selected.");
                        // // Reset the selection if it's already been selected
                        // jComboBox5.setSelectedIndex(0);
                        // jComboBox3.setSelectedIndex(0);
                        // jComboBox4.setSelectedIndex(0);
                } else {
                        selectedDateTime.add(selectedDateTimeStr);
                }
        }

        private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                String selectedMonth = jComboBox5.getSelectedItem().toString();
                String selectedDay = jComboBox3.getSelectedItem().toString();
                String selectedTime = jComboBox4.getSelectedItem().toString();

                String selectedDateTimeStr = selectedMonth + "-" + selectedDay + "-" + selectedTime;

                if (selectedDateTime.contains(selectedDateTimeStr)) {
                        JOptionPane.showMessageDialog(this, "This date and time has already been selected.");
                        // // Reset the selection if it's already been selected
                        // jComboBox5.setSelectedIndex(0);
                        // jComboBox3.setSelectedIndex(0);
                        // jComboBox4.setSelectedIndex(0);
                } else {
                        selectedDateTime.add(selectedDateTimeStr);
                }
        }

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                // Remove the action listener temporarily
                ActionListener[] listeners = jComboBox6.getActionListeners();
                for (ActionListener listener : listeners) {
                        jComboBox6.removeActionListener(listener);
                }

                // Get the selected item from jComboBox1
                String selectedItem = jComboBox1.getSelectedItem().toString();

                // Remove the selected item from jComboBox6
                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) jComboBox6.getModel();
                model.removeElement(selectedItem);

                // Add back the action listener
                for (ActionListener listener : listeners) {
                        jComboBox6.addActionListener(listener);
                }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(DSAA__project.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(DSAA__project.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(DSAA__project.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(DSAA__project.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the dialog */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                DSAA__project dialog = new DSAA__project(new javax.swing.JFrame(), true);
                                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                        @Override
                                        public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                        }
                                });
                                dialog.setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JComboBox<String> jComboBox5;
        private javax.swing.JComboBox<String> jComboBox6;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTable jTable2;
        private javax.swing.JTable jTable3;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private java.awt.Panel panel1;
        // End of variables declaration
}
