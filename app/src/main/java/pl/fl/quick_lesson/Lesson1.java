package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Lesson1 extends AppCompatActivity {

    TextView txt_1, txt_2, txt_3;
    ImageView img_1, img_2, img_3;
    OnSwipeTouchListener list;
    public static Activity fa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
        fa = this;



        LinearLayout linlay = findViewById(R.id.linlay);
        list= new OnSwipeTouchListener(this,"lesson1");
        linlay.setOnTouchListener(list);
        txt_1 = findViewById(R.id.textView2);
        txt_2 = findViewById(R.id.textView3);
        txt_3 = findViewById(R.id.textView4);

        img_1 = findViewById(R.id.imageView);
        img_2 = findViewById(R.id.imageView2);
        img_3 = findViewById(R.id.imageView3);

        txt_1.setText("Wytyczony w 1242 Rynek Główny we Wrocławiu od zarania istnienia służył jako plac targowy o wymiarach 212 x 175 metrów. Handlowano na nim m.in. pieczywem, tłuszczem, płótnem, wyrobami metalowymi. Na Rynku działały także punkty usługowe np. krawieckie i szewski. Początkowo działaność była prowadzona w drewnianych budach, a murowane obiekty pojawiły się dopiero pod koniec XIII wieku.\n" +
                "\n" +
                "Na samym Rynku Głównym jak i wokół niego skoncentrowane się liczne zabytki będące najcenniejszym skarbem dziedzictwa narodowego. Od rynku we wszystkich kierunkach odchodzi aż 11 uliczek. Za południowo-zachodnim narożnikiem Rynku Głównego znajduje się rynek pomocniczy zwany Placem Solnym.\n");
        txt_2.setText("\n__________________________________________________\n\n\nStary Ratusz na Rynku Głównym\n" +
                "W centrum Rynku Głównego zlokalizowany jest Stary Ratusz, którego budowa rozpoczęła się od 1299 roku. Ratusz był sukcesywnie rozbudowywany i modernizowany przez kolejne wieki dlatego widać w nim wpływy róznych epok z przewagą gotyku.\n" +
                "Zabytkowy zegar astronomiczny na Starym Ratuszu\n" +
                "Warto m.in zwrócić uwagę na zegar astronomiczny z jedną wskazówką i słońcem w centrum tarczy, który został tam umieszczony w 1580 roku. W podziemiach Ratusza znajduje się także Piwnica Świdnicka, która od zarania funkcjonowała jako piwiarnia.");
        txt_3.setText("\n__________________________________________________\n\n\nNowy Ratusz na Rynku Głównym\n" +
                "Wzniesiony w stylu neogotyckim w latach 1860-1863 Nowy Ratusz obecnie jest siedzibą Prezydenta Miasta Wrocławia. W podziemiach Nowego Ratusza znajduje się sławna restauracja Spiż.\n" +
                "Pomnik Aleksandra Fredro\n" +
                "Przed Nowym Ratuszem w 1956 roku został ustawiony pomnik Aleksandra Fredry dla przypomnienia wagi wspólnych losów wielu wrocławian i lwowian jakie wichry historii im zgotowały.\n" +
                "Pręgierz na Rynku Głównym\n" +
                "Przed Starym Ratuszem obecnie stoi od 1492 roku kamienny pręgierz. Pierwotnie w tym miejscu znajdował się ogrodzony i otoczony rowem plac, na którym osądzano winnych przestępstw..");

        img_1.setImageResource(R.drawable.bird_view_wroclaw);
        img_2.setImageResource(R.drawable.back_image);
        img_3.setImageResource(R.drawable.bird_view_wroclaw);
        txt_1.setTextSize(17f);
        txt_2.setTextSize(17f);
        txt_3.setTextSize(17f);

    }

    @Override
    protected void onResume() {
        list.changeOnScreen(true);
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        MainActivity.main.getWindow();
        this.finish();
    }
}
