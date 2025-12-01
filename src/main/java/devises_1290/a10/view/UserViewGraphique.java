package devises_1290.a10.view;

import devises_1290.a10.control.UserService;
import devises_1290.a10.dal.IRate_DAO;
import devises_1290.a10.model.Rate;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class UserViewGraphique extends JFrame implements ActionListener {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextArea txtarea1;
    private JTextArea txtarea4;
    private JTextArea txtarea5;
    private JButton btnConvert;
    private JButton btnUpdate;
    private JComboBox<String> combo1;
    private JComboBox<String> combo2;
    private UserService userService;
    private IRate_DAO rDAO;

    public UserViewGraphique(IRate_DAO rateDAO) {
        this.userService = new UserService(rateDAO);
        this.rDAO = rateDAO;
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
        this.setSize(600, 200);
        this.setTitle("Currency Converter");
        this.label1 = new JLabel("Amount:");
        this.txtarea1 = new JTextArea();
        this.txtarea1.setEditable(true);
        this.label2 = new JLabel("From:");
        String[] source = new String[]{"US Dollar", "Euro", "British Pound", "Japanese Yen", "Canadian Dollar", "Australian Dollar"};
        this.combo1 = new JComboBox(source);
        this.label3 = new JLabel("To:");
        String[] target = new String[]{"US Dollar", "Euro", "British Pound", "Japanese Yen", "Canadian Dollar", "Australian Dollar"};
        this.combo2 = new JComboBox(target);
        this.btnConvert = new JButton("Convert");
        this.btnConvert.addActionListener(this);
        this.btnUpdate = new JButton("Update rate from source");
        this.btnUpdate.addActionListener(this);
        this.label4 = new JLabel("Answer:");
        this.txtarea4 = new JTextArea();
        this.txtarea4.setEditable(false);
        this.label5 = new JLabel("Exchange Rate:");
        this.txtarea5 = new JTextArea();
        this.txtarea5.setEditable(true);
        this.setLayout((LayoutManager)null);
        this.label1.setBounds(20, 20, 100, 25);
        this.txtarea1.setBounds(120, 20, 100, 25);
        this.label2.setBounds(240, 20, 50, 25);
        this.combo1.setBounds(290, 20, 120, 25);
        this.label3.setBounds(420, 20, 30, 25);
        this.combo2.setBounds(450, 20, 120, 25);
        this.btnConvert.setBounds(120, 60, 100, 25);
        this.btnUpdate.setBounds(340, 60, 200, 25);
        this.label4.setBounds(20, 100, 100, 25);
        this.txtarea4.setBounds(120, 100, 100, 25);
        this.label5.setBounds(350, 100, 100, 25);
        this.txtarea5.setBounds(450, 100, 100, 25);
        this.add(this.label1);
        this.add(this.txtarea1);
        this.add(this.label2);
        this.add(this.combo1);
        this.add(this.label3);
        this.add(this.combo2);
        this.add(this.btnConvert);
        this.add(this.btnUpdate);
        this.add(this.label4);
        this.add(this.txtarea4);
        this.add(this.label5);
        this.add(this.txtarea5);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
//        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        if (e.getSource() == this.btnConvert) {
            try {
                String inputText = this.txtarea1.getText();
                if (inputText == null || inputText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter an amount", "Input Error", 0);
                    return;
                }

                String amountText = inputText.trim();
                double amount = Double.parseDouble(amountText);
                String fromCurrency = (String)this.combo1.getSelectedItem();
                String toCurrency = (String)this.combo2.getSelectedItem();
                double result = this.userService.convert(amount, fromCurrency, toCurrency);
                this.txtarea4.setText(String.format("%.4f", result));
            } catch (NumberFormatException var17) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number", "Input Error", 0);
                this.txtarea1.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Conversion error: " + ex.getMessage(), "Error", 0);
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.btnUpdate) {
            String exchangeRateText = this.txtarea5.getText();
            if (exchangeRateText == null || exchangeRateText.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an exchange rate", "Input Error", 0);
                return;
            }
            String fromCurrency = (String)this.combo1.getSelectedItem();


            if (!exchangeRateText.isEmpty()) {
                double exchangeRate = Double.parseDouble(exchangeRateText);
                Rate rateFrom = this.userService.getRateByCurrencyName(fromCurrency);
                if (rateFrom == null) {
                    JOptionPane.showMessageDialog(this, "Source currency rate not found", "Error", 0);
                    return;
                }

                boolean updated = this.userService.changeRate(fromCurrency, exchangeRate);
                if (!updated) {
                    JOptionPane.showMessageDialog(this, "Failed to update exchange rate for " + fromCurrency, "Error", 0);
                    return;
                }
                this.txtarea5.setText(String.format("%.4f", exchangeRate));
            }
        }
    }


}
