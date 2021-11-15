package com.example.bankappnew.signin.api;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CoursesApi extends AsyncTask<Object, Object, Object[]> {
    @SuppressLint("SimpleDateFormat")
    @Override
    protected Object[] doInBackground(Object... objects) {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;


        try {
            url = new URL("https://www.cbr.ru/scripts/XML_daily.asp?date_req=" +
                    new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();

            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }

        if (stringBuilder != null) {
            return new Object[]{stringBuilder.toString(), objects[0], objects[1]};
        } else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Object[] objects) {
        super.onPostExecute(objects);

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(objects[0].toString())));

            NodeList children = document.getDocumentElement().getChildNodes();
            String[] values = new String[2];

            for (int i = 0; i < children.getLength(); i++) {
                NodeList childNodes = children.item(i).getChildNodes();

                if (childNodes.item(0).getTextContent().equals("036")) {
                    ((TextView) objects[1]).setText(childNodes.item(4).getTextContent());
                } else if (childNodes.item(0).getTextContent().equals("944")) {
                    ((TextView) objects[2]).setText(childNodes.item(4).getTextContent());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
