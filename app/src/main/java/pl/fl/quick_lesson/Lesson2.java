package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alphamovie.lib.AlphaMovieView;

public class Lesson2 extends AppCompatActivity {

    TextView txt_1, txt_2, txt_3;
    OnSwipeTouchListener list;
    public static Activity fa;
    private AlphaMovieView alphaMovieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        fa=this;

        LinearLayout linlay = findViewById(R.id.linlay);
        list= new OnSwipeTouchListener(this,"lesson2");
        linlay.setOnTouchListener(list);

        alphaMovieView = (AlphaMovieView) findViewById(R.id.video_player);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.videoplayback;
        alphaMovieView.setVideoFromUri(this,Uri.parse(path));
        alphaMovieView.setOnTouchListener(new videoTouchListener(this, alphaMovieView));

        txt_1 = findViewById(R.id.textView2);
        txt_2 = findViewById(R.id.textView3);
        txt_3 = findViewById(R.id.textView4);

        txt_1.setText("\n\nSukiennice we Wrocławiu\n" +
                "Niegdyś w centrum Rynku Głównego obok Ratusza stały rzędy stoisk handlarzy, które z czasem zamieniały się w murowane budynki, a następnie w ciągi kamienic. W sposób naturalny powstały pomiędzy tymi kamienicami trzy równoległe uliczki biegnące ze wschodu na zachód (Sukiennice, Przejście Żelaźnicze oraz Przejście Garncarskie) oraz jedna uliczka biegnąca protopadle do nich tj Przejście Poprzeczne. Obecnie w tychże kamieniczkach działają restauracje, puby, galerie i sklepiki.\n" +
                "Zabytkowe Kamienice Rynku Głównego\n" +
                "Wschodnia strona Rynku Głównego - Strona Zielonej Rury\n" +
                "Nazwa Zielonej Rury pochodzi od studni, która przed wiekami funkcjonowała w tej częsci Rynku. Najciekwaszymi kamienicami są tutaj: Dom Pod Złotą Koroną (1528 rok) oraz Dom Pod Złotym Psem (1713 rok).");
        txt_2.setText("\n__________________________________________________\n\n\nZachodnia strona Rynku Głównego - Strona Siedmiu Elektorów\n" +
                "Zachodnia strona Rynku Głównego jeśli chodzi o kamienice należy do najciekawszych. Znajdują się tutaj m.in.: dom Pod Gryfami (XVI wiek), kamienica Pod Złoty Orłem (XVIII wiek), kamienica Dwór Polski, kamienica Pod Złotym Słońcem, kamienica Pod Błękitnym Słońcem (XVI wiek) oraz dom Pod Siedmioma Elektorami (XVII wiek). W kamienicy Pod Błękitnym Słońcem znajduje się popularny pasaż handlowy.\n" +
                "Północna strona Rynku Głównego - Targ Łakoci\n" +
                "Po północnej stronie Rynku w Średniowieczu handlowano przede wszystkim łakociami i wyrobami piekarniczymi - stąd jego nazwa. Ciekawsze kamienice tej strony to: kamienica Pod Trójcą Świętą (XVIII wiek) oraz kamienica Pod Złotą Palmą.");
        txt_3.setText("\n__________________________________________________\n\n\nPołudniowa strona Rynku Głównego - Strona Złotego Pucharu\n" +
                "Kamienice południowej strony, na które warto zwrócić uwagę to: kamienica Pod Złotym Dzbanem posiadająca podziemne przejście do Piwnicy Świdnickiej, dom Pod Starą Szubienicą,\n" +
                "Zabytkowe kamieniczki \"Jaś\" i \"Małgosia\"\n" +
                "Na północno-zachodnim narożniku Rynku Głównego, na skrzyżowaniu ulic Św. Mikołaja i Odrzeańskiej znajdują się słynne kamieniczki \"Jaś\" (mniejsza kamienica z lewej) i \"Małgosia\" (większa kamienica z prawej) połączone barokową bramą z 1782 roku");

        txt_1.setTextSize(17f);
        txt_2.setTextSize(17f);
        txt_3.setTextSize(17f);
    }


    @Override
    protected void onResume() {
        list.changeOnScreen(true);
        alphaMovieView.onResume();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        MainActivity.main.getWindow();
        this.finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        alphaMovieView.onPause();
    }
}
