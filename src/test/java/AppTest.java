import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    private String userName = "";
    private String password = "";

    @org.junit.Test
    public void testeEmail() {

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

            Address[] toUser = InternetAddress.parse("anthonychukwudi01@outlook.com, anthonychukwuditestes01@gmail.com, anthonychukwudi02@outlook.com");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName, "Anthony"));/*Quem esta enviando*/
            message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
            message.setSubject("Primeiro email enviado co java");/*Assunto do email*/
            message.setText("voce esta aprendendo a enviar mensagens usando o javamail");/*Enviando o email*/

            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
