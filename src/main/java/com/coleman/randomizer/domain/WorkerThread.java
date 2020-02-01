package com.coleman.randomizer.domain;

import com.coleman.randomizer.utils.RandomUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WorkerThread implements Runnable {

    String name;

    private RandomUtils randomUtils = new RandomUtils();

    private Thread t;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public WorkerThread(String name){
        this.name = name;
    }

    public void start() {
        if(t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            String filename = randomUtils.randomFileName();
            String dataset = randomUtils.randomDataset();
            String path = "/opt/testData/" +dataset+"/"+ filename;
            File file = new File(path);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Model model = new Model();
            try {
                model = new Model(randomUtils.randomFirstName(), randomUtils.randomLastName(), randomUtils.randomLastName(),
                        randomUtils.randomNumber(5), randomUtils.randomAddress(), randomUtils.randomDate(), randomUtils.randomDate(),
                        randomUtils.randomNumber(5), randomUtils.randomFirstName() + " " + randomUtils.randomLastName(),
                        randomUtils.randomAddress(), dataset);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String json = gson.toJson(model);

            try {
                FileOutputStream fos = new FileOutputStream(path);
                fos.write(json.getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //long fileSize = file.length();


            // LOGIC TO UPLOAD TO S3 GOES HERE


            //file.delete();
            //System.out.println(gson.toJson(model));


            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
