package Project;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.io.IOException;
import java.util.StringTokenizer;

public class LeagueOfLegend {
    public static void main(String[] jinseung) {
        String Nick = JOptionPane.showInputDialog(null , "소환사명을 입력해주세요. (ex 김도영 #2007)", "GB.GG", JOptionPane.QUESTION_MESSAGE);
        StringTokenizer st = new StringTokenizer(Nick, "#");
        String url = "https://www.op.gg/summoners/kr/" + st.nextToken() + "-" + st.nextToken();

        Loading loading = new Loading(null);

        try {
            loading.showLoading();
            Document doc = Jsoup.connect(url).get();
            Element table = doc.selectFirst("table");
            Element div = doc.selectFirst("div.tier");
            Element div2 = doc.selectFirst("div.lp");
            String result = div.html();
            String result2 = div2.html();
            result = result.replaceAll("<br>", "");
            result2 = result2.replaceAll("<br>", "");
            result = result.replaceAll("<!-- -->", "");
            result2 = result2.replaceAll("<!-- -->", "");
            result = result.replaceAll(" ", "");
            result2 = result2.replaceAll(" ", "");
            JOptionPane.showMessageDialog(null, "Tier : " + result + "\n" + "LP : " + result2, "GB.GG",1);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "존재하지 않는 소환사명입니다", "GB.GG", 0);
        }finally {
            loading.hideLoading();
        }
    }
}
