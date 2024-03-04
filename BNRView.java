import javax.swing.*;
import java.awt.*;

public class BNRView extends JFrame {
    private JPanel wrapper = new JPanel();
    private JPanel left = new JPanel();

    ///Componente left container
    private String[] monede = {"EUR", "RON", "USD"};
    private JComboBox selectLeft = new JComboBox(monede);
    //------
    private JPanel right = new JPanel();

    ///Componente right container
    private JComboBox selectRight = new JComboBox(monede);
    //------

    private JPanel mid = new JPanel();
    ///Componente mid container
    private JButton converteste = new JButton();
    private JTextField inputSuma = new JTextField();
    private JTextField outputRez = new JTextField();
    //------

    private JPanel sus = new JPanel();
    ///Componente container de sus
    private JLabel informatie = new JLabel();//TODO: aici e hardcodat
    //------

    private JPanel jos = new JPanel();
    ///Componente container de jos
    private JLabel labelSuma = new JLabel("Suma");
    private JLabel labelRezultat = new JLabel("Rezultat");
    //------
    private BNRModel model;
    BNRView(BNRModel model){
        this.model = model;
        relatedToWrapper();
        relatedToLeftContainer();
        relatedToRightContainer();
        relatedToMidContainer();
        relatedToSus();
        relatedToJos();
        this.setContentPane(wrapper);
        this.setTitle("Convertor valuta");
        //TODO: paseaza urmatoarea linie controller-ului
        //If I do this, ar trebui ca in view sa am ca atribut un obiect de tip controller, ceea ce nu vrem!!
        this.setBackground(Color.decode("#004225"));
        this.setSize(new Dimension(600, 300));//setSize, baa, stie Giosan ce stie!
        this.setLocationRelativeTo(null);//ca sa puna fereastra pe centru
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void relatedToWrapper(){
        wrapper.setLayout(new BorderLayout());
        wrapper.add(sus, BorderLayout.NORTH);
        wrapper.add(jos, BorderLayout.SOUTH);
        wrapper.add(left, BorderLayout.WEST);
        wrapper.add(mid, BorderLayout.CENTER);
        wrapper.add(right, BorderLayout.EAST);
    }
    public void relatedToLeftContainer(){
        left.add(selectLeft);
        selectLeft.setPreferredSize(new Dimension(200, 30));
        left.setBackground(Color.decode("#FF9207"));
    }
    public void relatedToRightContainer(){
        right.add(selectRight);
        selectRight.setPreferredSize(new Dimension(200, 30));
        right.setBackground(Color.decode("#FF9207"));
    }
    public void relatedToMidContainer(){
        converteste.setText(">>");
        //mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
        //mid.add(Box.createRigidArea(new Dimension(0, 5)));
        mid.setLayout(new FlowLayout());
        mid.add(converteste);
        converteste.setBackground(Color.decode("#FF9207"));
        //converteste.setBorder(new RoundedBorder);
        //|-> https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
        mid.setBackground(Color.decode("#0596D8"));
    }
    public void relatedToSus(){
        informatie.setText("1 " + getSelectLeft().getSelectedItem().toString() + " = " +
                BNRController.valoareConversie + " " + getSelectRight().getSelectedItem().toString());//"1 CEVA = atata ALTCEVA"
        sus.add(informatie);
        sus.setBackground(Color.decode("#0596D8"));
    }
    public void relatedToJos(){
        jos.setLayout(new GridLayout(2, 2));
        jos.add(labelSuma);
        jos.add(inputSuma);
        inputSuma.setMargin(new Insets(2, 30, 2, 30));
        jos.add(labelRezultat);
        jos.add(outputRez);
        outputRez.setMargin(new Insets(2, 30, 2, 30));
        jos.setBackground(Color.decode("#0596D8"));
    }

    public JPanel getWrapper() {
        return wrapper;
    }

    public JPanel getLeft() {
        return left;
    }

    public String[] getMonede() {
        return monede;
    }

    public JComboBox getSelectLeft() {
        return selectLeft;
    }

    public JPanel getRight() {
        return right;
    }

    public JComboBox getSelectRight() {
        return selectRight;
    }

    public JPanel getMid() {
        return mid;
    }

    public JButton getConverteste() {
        return converteste;
    }

    public JTextField getInputSuma() {
        return inputSuma;
    }

    public JTextField getOutputRez() {
        return outputRez;
    }

    public JPanel getSus() {
        return sus;
    }

    public JLabel getInformatie() {
        return informatie;
    }

    public JPanel getJos() {
        return jos;
    }

    public JLabel getLabelSuma() {
        return labelSuma;
    }

    public JLabel getLabelRezultat() {
        return labelRezultat;
    }

    public BNRModel getModel() {
        return model;
    }

    public void setOutputRez(String outputRez) {
        this.outputRez.setText(outputRez);
    }

    void printeazaError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    public void addGetMonedaListener(BNRController.GetMonedaLeftListener getMonedaLeftListener, BNRController.GetMonedaRightListener getMonedaRightListener) {
        selectLeft.addActionListener(getMonedaLeftListener);
        selectRight.addActionListener(getMonedaRightListener);
    }
    public void addUpdateListener(BNRController.Update update){
        converteste.addActionListener(update);
    }

}
