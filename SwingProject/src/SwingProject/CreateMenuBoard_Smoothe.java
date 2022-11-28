package SwingProject;

import javax.swing.*;
import java.awt.*;

public class CreateMenuBoard_Smoothe extends JPanel{
    public CreateMenuBoard_Smoothe(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setOpaque(true);
        setName("Smoothe");

        String smootheNames[] = {"딸기 스무디", "키위 스무디", "토마토 스무디", "초록 스무디"};

        for (int i = 0; i < smootheNames.length; i++) {
            JPanel panelSmootheMenu = new CreatePanel(width/6, height/4 + 30, Color.WHITE);

            ImageIcon imageSmoothe = new ImageIcon("./images/button_image_smoothe/" + smootheNames[i] + ".jpg");
            Image imageSmootheChanged = imageSmoothe.getImage().getScaledInstance(width/6+10, height/4, Image.SCALE_SMOOTH);

			JButton buttonSmootheMenu = new JButton(new ImageIcon(imageSmootheChanged));
            buttonSmootheMenu.setName(smootheNames[i]);
            buttonSmootheMenu.addActionListener(new payActinonListenerSmoothe());
            buttonSmootheMenu.setPreferredSize(new Dimension(width/6, height/4));

            JLabel labelSmootheName = new JLabel(smootheNames[i]);
            labelSmootheName.setFont(new Font("궁서", Font.BOLD, 13));

            panelSmootheMenu.add(buttonSmootheMenu);
            panelSmootheMenu.add(labelSmootheName);

            add(panelSmootheMenu);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
        setVisible(false);
    }
}
