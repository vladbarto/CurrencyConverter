public class Main {
    public static void main(String[] args) {
        BNRModel model = new BNRModel();
        BNRView view = new BNRView(model);
        BNRController controller = new BNRController(model, view);
        view.setVisible(true);
    }
}