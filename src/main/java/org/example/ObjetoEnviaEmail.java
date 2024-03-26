package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ObjetoEnviaEmail {

    private String userName = "anthonytestes01@gmail.com";
    private String password = "jzxv bxwl ceud ycjs";

    private String listaDestinatarios = "";
    private String nomeRemetente = "";
    private String assuntoEmail = "";

    private String  mensagemEmail = "";

    public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String mensagemEmail){
        this.listaDestinatarios = listaDestinatarios;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.mensagemEmail = mensagemEmail;
    }
    public void EnviarEmail(boolean envioHtml){
        try {
            /*------------------------Configurando as propriedades de conexão------------------------*/

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");/*Autorização*/
            properties.put("mail.smtp.starttles", "true");/*Autenticação*/
            properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
            properties.put("mail.smtp.port", "465"); /*Porta do servidor*/
            properties.put("mail.smtp.socketFactory.port", "465");/*Expecifica a porta aser conectada pelo socket*/
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexao ao SMTP*/

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Address[] toUser = InternetAddress.parse(listaDestinatarios);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName, nomeRemetente));/*Quem esta enviando*/
            message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
            message.setSubject(assuntoEmail);/*Assunto do email*/

            if (envioHtml){
                message.setContent(mensagemEmail, "text/html; charset=utf-8");
            }
            else {
                message.setText(mensagemEmail);/*mensagem do email*/
            }


            Transport.send(message);/*Enviando o email*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}