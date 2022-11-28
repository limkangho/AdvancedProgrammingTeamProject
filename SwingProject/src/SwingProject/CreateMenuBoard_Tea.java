package SwingProject;

import javax.swing.*;
import java.awt.*;

public class CreateMenuBoard_Tea extends JPanel {
    public CreateMenuBoard_Tea(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setOpaque(true);
        setName("Tea");

        String teaNames[] = {"캐모마일 블랜드 티", "유자 민트 티", "얼 그레이 티", "잉글리시 모닝 티", "자몽 허니 블랙 티",
                             "히비스커스 블랜드 티", "제주 유기 녹차", "유스베리 티"};

        for (int i = 0; i < teaNames.length; i++) {
            JPanel panelTeaMenu = new CreatePanel(width/6, height/4 + 30, Color.WHITE);

            ImageIcon imageTea = new ImageIcon("./images/button_image_tea/" + teaNames[i] + ".jpg");
            Image imageTeaChanged = imageTea.getImage().getScaledInstance(width/6+10, height/4, Image.SCALE_SMOOTH);
			
			JButton buttonTeaMenu = new JButton(new ImageIcon(imageTeaChanged));
            buttonTeaMenu.setName(teaNames[i]);
            buttonTeaMenu.addActionListener(new payActinonListenerTea());
            buttonTeaMenu.setPreferredSize(new Dimension(width/6, height/4));

            JLabel labelTeaName = new JLabel(teaNames[i]);
            labelTeaName.setFont(new Font("궁서", Font.BOLD, 13));

            panelTeaMenu.add(buttonTeaMenu);
            panelTeaMenu.add(labelTeaName);

            add(panelTeaMenu);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
        setVisible(false);
    }
}