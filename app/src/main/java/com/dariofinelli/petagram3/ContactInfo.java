package com.dariofinelli.petagram3;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactInfo extends AppCompatActivity {

    TextInputEditText tEditName;
    TextInputEditText tEditEmail;
    TextInputEditText tEditMessage;
    Button btSend;
    Session session;
    String emailFrom;
    String password;
    String name;
    String email;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);

        Toolbar actionbBarContact = (Toolbar) findViewById(R.id.actionBarContact);
        setSupportActionBar(actionbBarContact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tEditName = (TextInputEditText) findViewById(R.id.tEditName);
        tEditEmail = (TextInputEditText) findViewById(R.id.tEditEmail);
        tEditMessage = (TextInputEditText) findViewById(R.id.tEditMessage);
        btSend = (Button) findViewById(R.id.btSend);

        emailFrom = "correocurso24@gmail.com";
        password = "CorreoCurso12";

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = tEditName.getText().toString();
                email = tEditEmail.getText().toString();
                message = tEditMessage.getText().toString();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(emailFrom, password);
                        }
                    });

                    if (session != null) {
                        Message msg = new MimeMessage(session);
                        msg.setFrom(new InternetAddress(emailFrom));
                        msg.setSubject(name);
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                        msg.setContent(message, "text/html; charset=utf-8");

                        Transport.send(msg);

                        Snackbar.make(v, "Correo enviado", Snackbar.LENGTH_LONG).show();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(v, "Error enviando correo", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
