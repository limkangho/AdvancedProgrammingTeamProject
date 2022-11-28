package SwingProject;

import javax.swing.*;
import java.awt.*;

public class CreateMenuBoard_Coffee extends JPanel {
	public CreateMenuBoard_Coffee(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);
		setOpaque(true);
		setName("Coffee");

		String[] coffeeNames = { "아메리카노", "에스프레소", "카페라떼", "바닐라라떼", "카라멜 마끼아또",
		"카페모카", "카푸치노", "아포가토" };
		// int[] coffeePrices = { 2000, 1500, 3000, 4000, 4500, 4500, 3500, 4500 };
		int length = coffeeNames.length; // num of coffee menu

//		JButton bt[] = new JButton[length];
//		Label label[] = new Label[length];
//		ImageIcon icon[] = new ImageIcon[length];

		for (int i = 0; i < length; i++) {
			JPanel panelCoffeeMenu = new CreatePanel(width / 6, height / 4 + 30, Color.WHITE);

//			bt[i] = new JButton(coffeeNames[i]);

			ImageIcon imageCoffee = new ImageIcon("./images/button_image_coffee/" + coffeeNames[i] + ".jpg");
			Image imageCoffeeChanged = imageCoffee.getImage().getScaledInstance(width/6+10, height/4, Image.SCALE_SMOOTH);
			
			JButton buttonCoffeeMenu = new JButton(new ImageIcon(imageCoffeeChanged));
			buttonCoffeeMenu.setName(coffeeNames[i]);
			buttonCoffeeMenu.addActionListener(new payActinonListenerCoffee());
			buttonCoffeeMenu.setPreferredSize(new Dimension(width / 6, height / 4));

			JLabel labelCoffeeName = new JLabel(coffeeNames[i]);
//			JLabel price = new JLabel(coffeePrices[i]);
			labelCoffeeName.setFont(new Font("궁서", Font.BOLD, 13));

			panelCoffeeMenu.add(buttonCoffeeMenu);
			panelCoffeeMenu.add(labelCoffeeName);

			add(panelCoffeeMenu);

//			label[i] = new Label(coffeePrices[i] + "��");
		}
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
		setVisible(true);
	}

	// ImageIcon espresso = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\espresso.jpg");
	// ImageIcon americano = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\americano.jpg");
	// ImageIcon cafeLatte = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\cafeLatte.jpg");
	// ImageIcon vanillaLatte = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\vanillaLatte.jpg");
	// ImageIcon caramelMachiato = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\caramelMachiato.png");
	// ImageIcon cafeMocha = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\cafeMocha.jpg");
	// ImageIcon cappuccino = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\cappuccino.jpg");
	// ImageIcon affogato = new ImageIcon("C:\\Users\\laila\\OneDrive\\����\\�������α׷��� ������Ʈ\\affogato.jpg");

}
