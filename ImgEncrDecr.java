package Projects;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImgEncrDecr {

	public static void main(String[] args) {
		
		JFrame f =new JFrame();
		f.setTitle("Image Encryption And Decryption");
		f.setSize(400,500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font =new Font("Roboto",Font.BOLD,25);
		
		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);

		JTextField textField = new JTextField(10);
		textField.setFont(font);
		
		f.setLayout(new FlowLayout());
		f.add(button);
		f.add(textField);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{  
				System.out.println("Button Clicked"); 
				String keyStr = textField.getText();
				int keyInt = Integer.parseInt(keyStr);
				operate(keyInt);
			}  
				}); 

		
		f.setVisible(true);
	}
		public static void operate(int key)
		{
			JFileChooser filechooser = new JFileChooser();
			filechooser.showOpenDialog(null);
			File file = filechooser.getSelectedFile();
			try 
			{
				FileInputStream fis = new FileInputStream(file);
				
				byte data[] = new byte[fis.available()];
				fis.read(data);
				
				int i=0;
				for(byte b : data)
				{
					System.out.println(b);
					data[i] = (byte) (b^key);
					i++;
				}
				
				FileOutputStream fos =new FileOutputStream(file);
				fos.write(data);
				fos.close();
				fis.close();
				
				JOptionPane.showMessageDialog(null,"Done");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}
