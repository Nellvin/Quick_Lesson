package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaTimestamp;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Timestamp;

public class Lesson3 extends AppCompatActivity {

    TextView txt_1, txt_2, txt_3;
    ImageView img_1, img_2, img_3, playbutton;
    OnSwipeTouchListener list;
    public static Activity fa;
    MediaPlayer mediaPlayer;
    int musicTime;
    private boolean button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button1=false;
        musicTime=(int)Paper.book().read("music");

        fa=this;

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wroclawaudio);
        mediaPlayer.seekTo(musicTime);
//        mediaPlayer.start();

        LinearLayout linlay = findViewById(R.id.linlay);
        list= new OnSwipeTouchListener(this,"lesson3");
        linlay.setOnTouchListener(list);
        txt_1 = findViewById(R.id.textView2);
        txt_2 = findViewById(R.id.textView3);
        txt_3 = findViewById(R.id.textView4);

//        img_1 = findViewById(R.id.imageView);
//        img_2 = findViewById(R.id.imageView2);
//        img_3 = findViewById(R.id.imageView3);
        playbutton=findViewById(R.id.imageView4);

        txt_1.setText("\"Wrocław – zespół historycznego centrum\" uznano za Pomnik Historii zarządzeniem Prezydenta RP z 8  września 1994 r. (Monitor Polski 1994, nr 50, poz. 425). Granica zespołu zabytkowego obejmuje historyczne centrum miasta: Stare i Nowe Miasto oraz wyspy odrzańskie i przebiega Mostem Uniwersyteckim, ulicami: Drobnera, przez pl. Bema, Sienkiewicza, Wyszyńskiego, Mostem Pokoju, Al. Słowackiego, Krasińskiego, Traugutta, Podwalem, południowym brzegiem Dolnej Odry do Mostu Uniwersyteckiego.");
        txt_2.setText("\n__________________________________________________\n\n\nHistoria. Pisana historia Wrocławia rozpoczyna się w 1000 roku, w którym Bolesław Chrobry założył tu biskupstwo. Wcześniejsza osada obronna, usytuowana na wyspie odrzańskiej w miejscu obecnego Ostrowa Tumskiego, datowana na poł. IX w., związana była z plemieniem Ślężan. Po śmierci Bolesława Chrobrego Wrocław stał się faktyczną stolicą Śląska. Pierwsze budowle Wrocławia, znane jedynie z wykopalisk, to drewniane domy, wznoszone na terenie chronionym przez obwarowania drewniano-ziemne, dzielące osadę Na Ostrowie Tumskim na gród, podgrodzie i dodane później osiedle katedralne. Na nim to miała się znajdować pierwsza murowana katedra. Obok katedry, na Wyspie Pisakowej, mieściło się wzmiankowane w 1149 r. opactwo benedyktynów p.w. św. Marcina z późniejszą książęcą kaplicą grodową. Wybór Wrocławia na siedzibę księstwa został dokonany przez Henryka Brodatego w 1201 r. Jednocześnie w siłę rosła kuria biskupia na Ostrowie Tumskim, która z czasem doprowadziła do powstania wokół katedry rozległej kościelnej jurydyki. Henryk Brodaty założył plac targowy (ob. Nowy Targ), który był prawdopodobnie pierwszym elementem lokacji miasta na prawie magdeburskim. W 1224 r. sprowadzony został z Krakowa do Wrocławia zakon dominikanów i osadzony przy kościele św. Wojciecha. W 1226 r. ufundowano kościół p.w. św. Marii Magdaleny, pierwsza świątynię mieszczan.");
        txt_3.setText("\n__________________________________________________\n\n\nW 1241 r. Wrocław najechali i spustoszyli Tatarzy, kierując proces urbanizacji na nowe tory. Wyznaczony został rynek oraz układ ulic, w większości zachowany do dziś. Z pierwotnego założenia został jedynie Nowy Targ oraz nieregularności w przebiegu kilku ulic przy kościołach św. Wojciecha i św. Wincentego. W poł. XIII w. zaczęły powstawać mury miejskie. W 1261 r. Henryk III nadał ponownie Wrocławiowi prawa miejskie. W 1387 r. powstały pierwsze wodociągi miejskie. Na pocz. XV w. ukończono drugi pierścień murów miejskich wraz z 50. basztami i wieżami. W 1. poł. XV w. powstały nowe bramy i przedbramia, a w 1479 r. przy Bramie Mikołajskiej została urządzona pierwsza basteja. Kolejna przebudowa systemu obronnego miasta nastąpiła w 1526 r. W okresie wojny trzydziestoletniej, w 1634 r., powstał projekt nowoczesnego systemu fortyfikacji bastionowych, który rozbudowano w XVIII w. za Fryderyka Wielkiego. Krępujące rozwój miasta fortyfikacje zaczęto likwidować od 1807 r., gdy miasto otrzymało poforteczne grunty. Umożliwiło to połączenie centrum i przedmieść i założenie promenad na miejscu splantowanych umocnień, które do dziś wyznaczają granice Starego Miasta. Po otwarciu w 1841 r. połączenia kolejowego nastąpił gwałtowny rozwój Wrocławia. Do miasta przyłączane były kolejne tereny. Trwające 7 miesięcy oblężenie miasta w 1945 r., zakończone 7 maja kapitulacją Festung Breslau, spowodowało ogromne zniszczenia historycznego centrum. Rozpoczęta po wojnie odbudowa przywróciła układ zabudowy rynku, placu Solnego oraz – w mniejszym stopniu – poszczególnych ulic Starego Miatsa. Odbudowano natomiast wszystkie świątynie i większość monumentalnych budowli.");

        txt_1.setTextSize(17f);
        txt_2.setTextSize(17f);
        txt_3.setTextSize(17f);
//        img_1.setImageResource(R.drawable.bird_view_wroclaw);
//        img_2.setImageResource(R.drawable.back_image);
//        img_3.setImageResource(R.drawable.bird_view_wroclaw);
        playbutton.setImageResource(R.drawable.pause2);

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button1){
                    playbutton.setImageResource(R.drawable.pause2);
                    mediaPlayer.pause();
                    button1=false;
                }else {
                    playbutton.setImageResource(R.drawable.pause1);
                    mediaPlayer.start();
                    button1=true;
                }
            }
        });
        Paper.book().write("3lesson",true);



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
    @Override
    protected void onPause() {
        super.onPause();
        Paper.book().write("music", mediaPlayer.getCurrentPosition());
        Log.d("czas", String.valueOf(mediaPlayer.getCurrentPosition()));
        mediaPlayer.stop();
        mediaPlayer.release();

    }

}
