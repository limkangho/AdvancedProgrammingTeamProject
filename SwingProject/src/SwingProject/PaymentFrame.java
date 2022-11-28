package SwingProject;

import javax.swing.*;
import java.awt.*;

public class PaymentFrame extends JFrame{
    public static final int payWidth = 480;
    public static final int payHeight = 720;
    public Container payContentPane = getContentPane();

    public PaymentFrame() {}

    public PaymentFrame(JButton buttonMenu, String menuName, String imageType) {
        setTitle("Payment Frame");
        payContentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // 메뉴 확인 창 중앙 출력
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - payWidth) / 2, (screenSize.height - payHeight) / 2);

        // 선택 메뉴 출력 ------------------------------------------------------------------------------------------
        JPanel panelMenuTopLeft = new CreatePanel(payWidth/2 - 20, payHeight/3, null);
        JPanel panelMenuTopRight = new CreatePanel(payWidth/2 - 20, payHeight/3, null);
        panelMenuTopRight.setLayout(new GridLayout(4, 1));
        
        // 이미지 크기 조정
        ImageIcon imagePayMenu = new ImageIcon("./images/button_image_" + menuName + "/" + buttonMenu.getName()  + "." + imageType);
        Image imagePayMenuChanged = imagePayMenu.getImage().getScaledInstance(payWidth/3, payHeight/4, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(imagePayMenuChanged), JLabel.CENTER);

        // 메뉴 크기 조정
        JLabel labelPayMenuName =  new JLabel(buttonMenu.getName());
        labelPayMenuName.setFont(new Font("Serif", Font.BOLD, 20));

        panelMenuTopLeft.add(imageLabel);
        panelMenuTopRight.add(new JLabel(""));  //  가운데 출력을 위한 빈줄 추가
        panelMenuTopRight.add(labelPayMenuName);

        payContentPane.add(panelMenuTopLeft);
        payContentPane.add(panelMenuTopRight);

                
        setSize(payWidth, payHeight);
        setVisible(true);
    }
}

class CreateMessagePanel extends JPanel {
    public CreateMessagePanel(int width, int height, String text, int fontSize) {
        setPreferredSize(new Dimension(width, height));
        setBackground(null);
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel message = new JLabel(text);
        message.setFont(new Font("돋움", Font.BOLD, fontSize));

        add(message);
    }
}

class CreateOptionButton extends JPanel {
    public CreateOptionButton(int width, int height, String[] options) {
        setPreferredSize(new Dimension(width, height));
        setBackground(null);
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < options.length; i++) {
            JButton buttonOption = new JButton(options[i]);
            buttonOption.setName(options[i]);
            buttonOption.setPreferredSize(new Dimension(width/4, height/3));
            add(buttonOption);
        }
    }
}