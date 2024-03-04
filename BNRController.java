import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BNRController {
    private BNRModel model;
    private BNRView view;
    private String userInput;
    private static int leftCoin;
    private static int rightCoin;
    public static double valoareConversie = 1.00;
    private String sumaInput;
    public BNRController(BNRModel model, BNRView view) {
        this.model = model;
        this.view = view;
        leftCoin = 0;
        rightCoin = 0;
        valoareConversie = 1.00;
        sumaInput = "";
        //Adaugam ascultatorii
        view.addGetMonedaListener(new GetMonedaLeftListener(), new GetMonedaRightListener());
        view.addUpdateListener(new Update());
        }
    class GetMonedaLeftListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            userInput = "1 ";
            userInput += view.getSelectLeft().getSelectedItem();
            leftCoin = BNRModel.determineCoinIndex(view.getSelectLeft().getSelectedItem().toString());
            userInput += " = ";
            valoareConversie = model.getConversii()[leftCoin][rightCoin];
            userInput += Double.toString(valoareConversie) + " ";
            userInput += view.getSelectRight().getSelectedItem();
            view.getInformatie().setText(userInput);
        }
    }
    class GetMonedaRightListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            userInput = "1 " + view.getSelectLeft().getSelectedItem() + " = ";
            rightCoin = BNRModel.determineCoinIndex(view.getSelectRight().getSelectedItem().toString());
            valoareConversie = model.getConversii()[leftCoin][rightCoin];
            userInput += Double.toString(valoareConversie) + " ";
            userInput += view.getSelectRight().getSelectedItem();
            view.getInformatie().setText(userInput);
        }
    }

    class Update implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            double A;
            sumaInput = view.getInputSuma().getText();
            try {
                model.conversie(sumaInput, valoareConversie);
                view.setOutputRez(model.getRezultat() + " " + view.getSelectRight().getSelectedItem().toString());
            }
            catch (NumberFormatException e){
                view.printeazaError("Nu ati introdus un numar, ci '" + sumaInput + "'");
            }
        }
    }
}
