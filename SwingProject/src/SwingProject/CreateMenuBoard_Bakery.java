package SwingProject;

import javax.swing.*;
import java.awt.*;

public class CreateMenuBoard_Bakery extends JPanel {
    public CreateMenuBoard_Bakery(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setOpaque(true);
        setName("Bakery");

        String bakeryNames[] = {"허니 브레드", "쿠키슈", "메이플 와플", "치즈케이크", "티라미수"};


        for (int i = 0; i < bakeryNames.length; i++) {
            JPanel panelBakeryMenu = new CreatePanel(width/6, height/4 + 30, Color.WHITE);

            ImageIcon imageBakery = new ImageIcon("./images/button_image_bakery/" + bakeryNames[i] + ".png");
            Image imageBakeryChanged = imageBakery.getImage().getScaledInstance(width/6+10, height/4, Image.SCALE_SMOOTH);

			JButton buttonBakeryMenu = new JButton(new ImageIcon(imageBakeryChanged));
            buttonBakeryMenu.setName(bakeryNames[i]);
            buttonBakeryMenu.addActionListener(new payActinonListenerBakery());
            buttonBakeryMenu.setPreferredSize(new Dimension(width/6, height/4));

            JLabel labelBakeryName = new JLabel(bakeryNames[i]);
            labelBakeryName.setFont(new Font("궁서", Font.BOLD, 13));

            panelBakeryMenu.add(buttonBakeryMenu);
            panelBakeryMenu.add(labelBakeryName);

            add(panelBakeryMenu);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
        setVisible(false);
    }
}
