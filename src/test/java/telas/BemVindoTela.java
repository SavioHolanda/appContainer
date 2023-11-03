package telas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BemVindoTela {
    private AndroidDriver app;

    public BemVindoTela(AndroidDriver app) {
        this.app = app;
    }

    public BemVindoTela botaoAvancar() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]")).click();
        return this;
    }

    public BemVindoTela txtCpf(String txtCPF) {
        app.findElement(By.className("android.widget.EditText")).click();
        app.findElement(By.className("android.widget.EditText")).sendKeys(txtCPF);
        return this;
    }

    public BemVindoTela btnAvancar() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        return this;
    }

    public LoginTela btnAvancarSimples() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        return new LoginTela(app);
    }

    public BemVindoTela selecionarEmpresabem() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView")).click();
        return this;
    }

    public LoginTela btnEmpresaAvancar() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
        return new LoginTela(app);
    }

    public String mensagemErro() {
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }

    public String mensagemDadosNaoEncontrados() {
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }

    public String mensagemCpfCampo() {
        return app.findElement(By.className("android.widget.EditText")).getText();
    }

    public FormPrimeiroAcessoTela FormPrimeiroAcessoTela() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")).click();
        return new FormPrimeiroAcessoTela(app);
    }

    /**** Mensagens ***/

    public String msnErro() {
        return "Error";
    }

    public String msnDadosNaoEncontrados() {
        return "Dados não encontrados";
    }

    public String msnCpf() {
        return "CPF";
    }

    /*** requisições para API ***/
    public static String gerarToken(){
        try {
            String endpoint = "https://homologendpoint.nhgtech.com.br/api/token";
            String username = "02971008312";
            String password = "Fale1234@";

            // Criar uma conexão para o endpoint de autenticação
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurar a requisição para o método POST
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Montar os dados de autenticação no corpo da requisição
            String dadosAutenticacao = "username=" + username + "&password=" + password + "&grant_type=password";
            byte[] postData = dadosAutenticacao.getBytes("UTF-8");

            // Definir o comprimento do corpo da requisição
            con.setRequestProperty("Content-Length", String.valueOf(postData.length));

            // Habilitar a escrita para a conexão (para enviar dados)
            con.setDoOutput(true);

            // Escrever os dados no corpo da requisição
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(postData);

            // Obter a resposta do servidor
            int responseCode = con.getResponseCode();
            System.out.println("Gerador do token, Código de resposta: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                String token = jsonObject.get("access_token").getAsString();
                return token;

            } else {
                System.out.println("Falha na autenticação. Verifique suas credenciais.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BemVindoTela limparPrimeiroAcesso() {
        try {
            // URL da API para a qual você deseja enviar o POST
            String url = "https://homologendpoint.nhgtech.com.br/api/acesso/CentralPrivacidade/DeleteAceites/75598710030/99/149";
            String url2 = "https://homologendpoint.nhgtech.com.br/api/acesso/vida/DeletePrimeiroAcesso/75598710030/99/149";

            // Crie uma URLConnection com a URL especificada
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            URL obj2 = new URL(url2);
            HttpURLConnection con2 = (HttpURLConnection) obj.openConnection();

            // Configurar a requisição para o método POST
            con.setRequestMethod("DELETE");
            con2.setRequestMethod("DELETE");

            String token = gerarToken();

            // Se a API requer autenticação, você pode adicionar um cabeçalho de autorização
            con.setRequestProperty("Authorization", "bearer " +token);
            con2.setRequestProperty("Authorization", "bearer " +token);

            // Obter a resposta da API
            int responseCode = con.getResponseCode();
            int responseCode2 = con2.getResponseCode();
            System.out.println("Primeiro acesso, Código de resposta: " + responseCode);
            System.out.println("Documento de privacidade, Código de resposta: " + responseCode2);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}