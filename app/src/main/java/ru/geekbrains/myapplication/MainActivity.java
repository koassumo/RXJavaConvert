package ru.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

//    EditText editText;
//    Button button1;
//    TextView textView;
//    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        initFile();

//        editText = findViewById(R.id.save_text);
//        button1 = findViewById(R.id.btn_save);
//        textView = findViewById(R.id.open_text);
//        button2 = findViewById(R.id.btn_open);

    }

    private void initFile() {

        String basePath = Environment.getExternalStorageDirectory().getAbsolutePath(); // разный на разных дивайсах /storage/emulated/0
        String fileName = "pic.jpg";
        String fullPath = basePath + "/" + fileName;
                File imgFile = new File(fullPath);

        if (imgFile.exists()){

            // Вариант 1. Картинку видит, но не выводит ее в imageView (по неизвестным причинам)
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);

            // Вариант 2. Картинку видит, но также не работает (по неизвестным причинам)
            imageView.setImageURI(Uri.fromFile(imgFile));

        } else {
            Toast.makeText(this, "файл не найден", Toast.LENGTH_LONG).show();
        }



// ниже просто тщетные попытки что-то с этим сделать, они только для меня представляют ценность


//        // textView.setBackgroundResource(R.drawable.z_snow_white);  // картинка фоном в textView
//        //ActivityCompat.requestPermissions(this, arrayOf());
//        //FileOutputStream fos = null;
//        String basePath = Environment.getExternalStorageDirectory().getAbsolutePath(); // разный на разных дивайсах /storage/emulated/0
//        //String folderName = "/111/myFolder";
//        String fileName = "pic.bmp";
//        String fullPath = basePath + "/" + fileName;
//        //String fullPath = "/sdcard/pic.bmp";
//
//        //String z = "/data/data/RxJavaConvert/z_snow_white.png";
//
////        imageView.setImageDrawable(Drawable.createFromPath(z));
//
//        //File imgFile = new File(fullPath);
//        //File imgFile = new File("/sdcard/pic.bmp");
//        File imgFile = new File("/storage/emulated/0/snow.png");
//
//        if (imgFile.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            //ImageView myImage = (ImageView) findViewById(R.id.image);
//            //imageView.setImageBitmap(myBitmap);
//            Toast.makeText(this, imgFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
//            //textView.setBackgroundResource(imgFile.);
//
//            //ImageView myImage = new ImageView(this);
//
//
//            //Resources res = getResources();
//            //int resID = res.getIdentifier("z_snow_white.png", "drawable", getApplicationContext().getPackageName());
//            //imageView.setImageResource(resID);
//            ImageView img= (ImageView) findViewById(R.id.image);
//            img.setImageResource(R.drawable.z_snow_white);
//            imageView.setImageURI(Uri.fromFile(imgFile));
//
//        } else {
//            Toast.makeText(this, fullPath, Toast.LENGTH_LONG).show();
//        }


//        File myFile = new File(fullPath); //Создание объекта файла.
//        try {
//            EditText textBox = (EditText) findViewById(R.id.save_text);
//            String text = textBox.getText().toString();
//
//
//
//            if (!myFile.getParentFile().exists()) //Если нет директорий в пути, то они будут созданы:
//                myFile.getParentFile().mkdirs();
//            myFile.createNewFile();     //Если файл существует, то он будет перезаписан
//            FileOutputStream fOut = new FileOutputStream(myFile);
//            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
//            myOutWriter.write("111");
//            myOutWriter.close();
//            fOut.close();

//            String text = "111";
//            fos = openFileOutput(fullPath, MODE_PRIVATE);
//            fos.write(text.getBytes());
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//        } catch (IOException ex) {
//            Toast.makeText(this, "fff", Toast.LENGTH_SHORT).show();
//        } finally {
//            try {
//                if (fos != null)
//                    fos.close();
//            } catch (IOException ex) {
//
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }


        //I used the following code to create a temporary file for writing bytes. And its working fine.

        // Environment.getExternalStorageDirectory() + "/" + File.separator +


//        File file = new File("testMe.txt");
//        file.createNewFile();
//        byte[] data1 = {1, 1, 0, 0};
//
//        //write the bytes in file
//        if (file.exists()) {
//            OutputStream fo = new FileOutputStream(file);
//            fo.write(data1);
//            fo.close();
//            System.out.println("file created: " + file);
//        }

        //deleting the file
        //file.delete();
        //System.out.println("file deleted");
    }
}