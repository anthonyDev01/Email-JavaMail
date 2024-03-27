import org.example.ObjetoEnviaEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {


    @org.junit.Test
    public void testeEmail() throws Exception {

        StringBuilder stringBuilderTextoEmail = new StringBuilder();
        stringBuilderTextoEmail.append("<h1>Voçê está aprendendo a enviar Emails</h1><br/>");
        stringBuilderTextoEmail.append("<p style='font-size: 18px'>Esse  é um modulo muito <span style='color: #ff0000'>importante</span></p>");
        stringBuilderTextoEmail.append("<button style='background-color: #993399; border: none; padding: 10px 16px; border-radius: 20px'><a target='_blank' href='https://www.youtube.com/watch?v=zmjX0qi7qrw' style='text-decoration:none; color: #fff; '>Saiba mais</></button>");

        ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail(
                "anthonytestes01@gmail.com",
                "Anthony",
                "Testando Envio de emails com Html",
                stringBuilderTextoEmail.toString()
        );

        enviaEmail.EnviarEmailComAnexo(true);

    }
}
