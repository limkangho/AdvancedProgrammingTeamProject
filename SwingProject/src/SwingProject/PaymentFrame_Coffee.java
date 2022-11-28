package SwingProject;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class PaymentFrame_Coffee extends PaymentFrame {
    public PaymentFrame_Coffee(JButton buttonMenu) {
        super(buttonMenu, "coffee", "jpg");

        // 사이즈 선택 ------------------------------------------------------------------------------------------
        super.payContentPane.add(new CreatePanel(payWidth, payHeight/300, Color.BLACK));
        JPanel panelSizeSelect = new CreateMessagePanel(payWidth, payHeight/15, "사이즈를 선택하세요.", 20);
        String[] sizeOption = {"Tall", "Grande", "Venti"};
        JPanel panelSizeOptions = new CreateOptionButton(payWidth, payHeight/10, sizeOption);

        super.payContentPane.add(panelSizeSelect);
        super.payContentPane.add(panelSizeOptions);

        // 얼음 선택
        super.payContentPane.add(new CreatePanel(payWidth, payHeight/300, Color.BLACK));
        JPanel panelIceSelct = new CreateMessagePanel(payWidth, payHeight/15, "얼음 양을 선택하세요.", 20);
        String[] iceOption = {"아주 조금", "조금", "보통", "많이", "아주 많이"};
        JPanel panelIceOptions = new CreateOptionButton(payWidth, payHeight/10, iceOption);

        super.payContentPane.add(panelIceSelct);
        super.payContentPane.add(panelIceOptions);
    }
}

class payActinonListenerCoffee implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton buttonPayMenu = (JButton) e.getSource();
        new PaymentFrame_Coffee(buttonPayMenu);
    }
}
