package SwingProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentFrame extends JFrame{
    public static final int payWidth = 480;
    public static final int payHeight = 720;

    public PaymentFrame(JButton menuButton) {
        setTitle("Payment Frame");
        Container payContentPane = getContentPane();
        payContentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // 메뉴 확인 창 중앙 출력
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - payWidth) / 2, (screenSize.height - payHeight) / 2);

        // 선택 메뉴 출력 ------------------------------------------------------------------------------------------
        JPanel topMenuPanelLeft = new CreatePanel(payWidth/2 - 20, payHeight/3, null);
        JPanel topMenuPanelRight = new CreatePanel(payWidth/2 - 20, payHeight/3, null);
        topMenuPanelRight.setLayout(new GridLayout(4, 1));
        
        // 이미지 크기 조정
        ImageIcon payMenuImage = new ImageIcon("./images/button_image_tea/" + menuButton.getName()  + ".jpg");
        Image payImage = payMenuImage.getImage().getScaledInstance(payWidth/3, payHeight/4, Image.SCALE_SMOOTH);
        ImageIcon finalPayMenuImage = new ImageIcon(payImage);
        JLabel imageLabel = new JLabel(finalPayMenuImage, JLabel.CENTER);

        // 메뉴 크기 조정
        JLabel payMenuName =  new JLabel(menuButton.getName());
        payMenuName.setFont(new Font("Serif", Font.BOLD, 20));

        topMenuPanelLeft.add(imageLabel);
        topMenuPanelRight.add(new JLabel(""));  //  가운데 출력을 위한 빈줄 추가
        topMenuPanelRight.add(payMenuName);

        payContentPane.add(topMenuPanelLeft);
        payContentPane.add(topMenuPanelRight);


        // 사이즈 선택 ------------------------------------------------------------------------------------------
        payContentPane.add(new CreatePanel(payWidth, payHeight/300, Color.BLACK));
        JPanel sizeSelectPanel = new CreateMessagePanel(payWidth, payHeight/15, "사이즈를 선택하세요.", 20);
        String[] sizeOption = {"Tall", "Grande", "Venti"};
        JPanel sizeOptionPanel = new CreateOptionButton(payWidth, payHeight/10, sizeOption);

        payContentPane.add(sizeSelectPanel);
        payContentPane.add(sizeOptionPanel);

        // 얼음 선택
        payContentPane.add(new CreatePanel(payWidth, payHeight/300, Color.BLACK));
        JPanel iceSelectPanel = new CreateMessagePanel(payWidth, payHeight/15, "얼음 양을 선택하세요.", 20);
        String[] iceOption = {"아주 조금", "조금", "보통", "많이", "아주 많이"};
        JPanel iceOptionPanel = new CreateOptionButton(payWidth, payHeight/10, iceOption);

        payContentPane.add(iceSelectPanel);
        payContentPane.add(iceOptionPanel);

        // 취소 / 완료
        payContentPane.add(new CreatePanel(payWidth, payHeight/300, Color.BLACK));
        String[] endOption = {"취소", "완료"};
        JPanel endSelectPanel = new CreateOptionButton(payWidth, payHeight/3, endOption);

        payContentPane.add(new CreatePanel(payWidth, payHeight/10, null));
        payContentPane.add(endSelectPanel);

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
            JButton option = new JButton(options[i]);
            option.setPreferredSize(new Dimension(width/4, height/3));
            add(option);
        }
    }
}

class payActinonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton payMenuButton = (JButton) e.getSource();
        new PaymentFrame(payMenuButton);
    }
}
