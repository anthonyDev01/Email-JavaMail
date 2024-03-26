import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
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

            System.out.println(password);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
