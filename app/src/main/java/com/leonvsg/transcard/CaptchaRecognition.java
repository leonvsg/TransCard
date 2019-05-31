package com.leonvsg.transcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.googlecode.tesseract.android.TessBaseAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CaptchaRecognition {

    private TessBaseAPI tesseract;
    private Context context;
    private static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/TransCard/";
    private static final String TESSDATA = "tessdata";
    private static final String TAG = CaptchaRecognition.class.getSimpleName();

    public CaptchaRecognition(Context context){
        this.context = context;
        prepareDirectory(DATA_PATH + TESSDATA);
        copyTessDataFiles();
        tesseract = new TessBaseAPI();
        tesseract.init(DATA_PATH, "eng");
    }

    public String convert(Bitmap bitmap){
        tesseract.setImage(bitmap);
        return tesseract.getUTF8Text();
    }

    private void copyTessDataFiles() {
        try {
            String[] fileList = context.getAssets().list(TESSDATA);

            for (String fileName : fileList) {

                // open file within the assets folder
                // if it is not already there copy it to the sdcard
                String pathToDataFile = DATA_PATH + TESSDATA + "/" + fileName;
                if (!(new File(pathToDataFile)).exists()) {

                    InputStream in = context.getAssets().open(TESSDATA + "/" + fileName);

                    OutputStream out = new FileOutputStream(pathToDataFile);

                    // Transfer bytes from in to out
                    byte[] buf = new byte[1024];
                    int len;

                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();

                    Log.d(TAG, "Copied " + fileName + "to tessdata");
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Unable to copy files to tessdata " + e.toString());
        }
    }

    private void prepareDirectory(String path) {

        File dir = new File(path);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                Log.e(TAG, "ERROR: Creation of directory " + path + " failed, check does Android Manifest have permission to write to external storage.");
            }
        } else {
            Log.i(TAG, "Created directory " + path);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        tesseract.end();
        super.finalize();
    }
}
