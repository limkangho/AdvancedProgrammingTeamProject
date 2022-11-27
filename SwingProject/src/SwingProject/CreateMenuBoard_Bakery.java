package SwingProject;

import javax.swing.*;
import java.awt.*;

public class CreateMenuBoard_Bakery extends JPanel {
    public CreateMenuBoard_Bakery(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setOpaque(true);
        setName("Bakery");

        String teaNames[] = {"캐모마일 블랜드 티"};

        for (int i = 0; i < teaNames.length; i++) {
            JPanel menuBox = new CreatePanel(width/6, height/4 + 30, Color.WHITE);

            ImageIcon img = new ImageIcon("./images/button_image_tea/" + teaNames[i] + ".jpg");
            JButton teaMenuButton = new JButton(img);
            teaMenuButton.setPreferredSize(new Dimension(width/6, height/4));

            JLabel menuName = new JLabel(teaNames[i]);
            menuName.setFont(new Font("궁서", Font.BOLD, 13));

            menuBox.add(teaMenuButton);
            menuBox.add(menuName);

            add(menuBox);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
        setVisible(false);
    }
}
