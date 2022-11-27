package SwingProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JTable;
import javax.swing.BorderFactory;


// 패널 생성 클래스
class CreatePanel extends JPanel {
    public CreatePanel(int width, int height, Color color) {
        setPreferredSize(new Dimension(width, height));
        setBackground(color);
        setOpaque(true);
    }
}

// 버튼 생성 클래스
class CreateButton extends JButton {
    public CreateButton(String name, int alignment, Color color) {
        setText(name);
        setHorizontalAlignment(alignment);
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}

// 키오스크 메인 클래스
public class KioskApp extends JFrame {
    public static final int width = 768;
    public static final int height = 1024;

    public JPanel menuBoardCoffee = new CreateMenuBoard_Coffee(width, (((height/10)*7)*9)/10);
    public JPanel menuBoardTea = new CreateMenuBoard_Tea(width, (((height/10)*7)*9)/10);
    public JPanel menuBoardSmoothe = new CreateMenuBoard_Smoothe(width, (((height/10)*7)*9)/10);
    public JPanel menuBoardBakery = new CreateMenuBoard_Bakery(width, (((height/10)*7)*9)/10);

    public KioskApp() {
        String[] stringMenuCategoryNames = {"Coffee", "Tea", "Smoothe", "Bakery"};

        setTitle("Kiosk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 키오스크 화면 중앙 출력
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Top Panel
        JPanel panelTop = new CreatePanel(width, height/10, Color.LIGHT_GRAY);
        JLabel labelBrandImage = new JLabel("브랜드 이미지 들어갈 곳?");
        panelTop.add(labelBrandImage);

        // Middle Panel
        JPanel panelMiddle = new CreatePanel(width, (height/10)*7, Color.GRAY);
        JPanel categoryTab = new CreateMenuCategoryTabs(width, (height/10)*7, 4, stringMenuCategoryNames);
        categoryTab.setBackground(Color.GRAY);
        panelMiddle.add(categoryTab);

        // Middle Panel에 카테고리별 메뉴화면 추가
        panelMiddle.add(menuBoardCoffee);
        panelMiddle.add(menuBoardTea);
        panelMiddle.add(menuBoardSmoothe);
        panelMiddle.add(menuBoardBakery);

        // set Bottom panel
        JPanel panelBottom = new CreatePanel(width, (height/10)*3/2, Color.LIGHT_GRAY);
        panelBottom.setLayout(new FlowLayout());

        // JPanel panelOrderHistory = new CreatePanel(width/2, (height/10)*2/2, Color.ORANGE);
        String[][] rec = {
            { "Coffee", "2", "1500" },
            { "Tea", "1", "3000" },
            { "Smoothe", "1", "2500" },
            { "Bakery", "1", "3500" },
            { "Juice", "1", "5000" },
            { "Whatever", "3", "4000" },
         };
        String[] header = { "Product", "Amount", "Price" };
        JTable table = new JTable(rec, header);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrolledTable = new JScrollPane(table);
        scrolledTable.setPreferredSize(new Dimension(width/2, (height/10)));
        scrolledTable.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        // panelOrderHistory.add(new JScrollPane(scrolledTable));
        // panelOrderHistory.add(scrolledTable);
        
        JPanel panelOrderSubmit = new CreatePanel(width/3, (height/10)*1/2, Color.CYAN);
        JButton buttonOrderSubmit = new CreateButton("Submit", JLabel.CENTER, Color.DARK_GRAY);
        buttonOrderSubmit.setPreferredSize(new Dimension(width/3, (height/10)*1/2));
        buttonOrderSubmit.setFont(new Font("Serif", Font.BOLD, 20));
        buttonOrderSubmit.setName("Submit");
        buttonOrderSubmit.addActionListener(new OrderSubmit());
        
        panelOrderSubmit.add(buttonOrderSubmit);
        // panelBottom.add(panelOrderHistory);
        panelBottom.add(scrolledTable);
        panelBottom.add(buttonOrderSubmit);


        // Merge all Panel
        contentPane.add(panelTop);
        contentPane.add(panelMiddle);
        contentPane.add(panelBottom);

        setSize(width, height);
        setVisible(true);
        setResizable(false);
    }

    // 카테고리 생성 클래스(패널)
    class CreateMenuCategoryTabs extends JPanel {
        public CreateMenuCategoryTabs(int width, int height, int categoryNum, String[] categoryNames) {
            JPanel[] panelMenuCategoryTabItems = new JPanel[categoryNum];

            this.setLayout(new FlowLayout(FlowLayout.CENTER, width/30, 0));

            for (int i=0; i<categoryNum; i++) {
                panelMenuCategoryTabItems[i] = new CreatePanel(width/6, height/10, Color.DARK_GRAY);
                panelMenuCategoryTabItems[i].setLayout(new BorderLayout());

                JButton categoryButton = new CreateButton(categoryNames[i], JLabel.CENTER, Color.WHITE);
                categoryButton.setFont(new Font("Serif", Font.BOLD, 20));
                categoryButton.setName(categoryNames[i]);
                categoryButton.addActionListener(new ChangeCategoryTab());

                panelMenuCategoryTabItems[i].add(categoryButton, BorderLayout.CENTER);
                this.add(panelMenuCategoryTabItems[i]);
            }
        }
    }

    // 카테고리 전환 Action 이벤트 리스너 클래스
    class ChangeCategoryTab implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton catButton = (JButton)e.getSource();
            JPanel categories[] = {menuBoardCoffee, menuBoardTea, menuBoardSmoothe, menuBoardBakery};
            
            for (int i = 0; i < categories.length; i++) {
                categories[i].setVisible(false);

                if (catButton.getName() == categories[i].getName()) {
                    categories[i].setVisible(true);
                }
            }
        }
    }

    // 결제 버튼 Action 이벤트 리스너 클래스
    class OrderSubmit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton Button = (JButton)e.getSource();
            if (Button.getName().equals("Submit")) {
                // 결제 버튼 눌렀을 시 액션 연결 -> 현주, 희찬, 지윤
            }
        }
    }

    public static void main(String[] args) {
        new KioskApp();
    }
}