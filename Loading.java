package Project;
import javax.swing.*;

public class Loading extends JDialog {
    private JLabel loadingLabel;
    private Timer timer;
    private int doCount;

    public Loading(JFrame parent) {
        super(parent, "GB.GG", true);
        loadingLabel = new JLabel("로딩 중.");
        add(loadingLabel);
        setSize(200, 100);
        setLocationRelativeTo(parent);
        setResizable(false);

        doCount = 0;
        timer = new Timer(500, e -> {
            updateLoadingLabel();
        });
        timer.start();
    }
    private void updateLoadingLabel(){
        doCount++;
        if(doCount >3){
            doCount = 0;
        }

        String dots = "";
        for(int i = 0; i < doCount; i++){
            dots += ".";
        }

        loadingLabel.setText("로딩 중" + dots);
    }

    public void showLoading() {
        setVisible(true);
    }

    public void hideLoading() {
        setVisible(false);
    }
}
