package telas;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AgendamentoTela {
    private AndroidDriver app;

    public AgendamentoTela(AndroidDriver app) {
        this.app = app;
    }

 /*   public AgendamentoTela botaoMeusAgendamentos(){
        return this;
    }*/

    public AgendamentoTela selecaoTipoAgendamento(String tipoAgendamento) {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")).click();
        List<WebElement> elements = app.findElements(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
        for (WebElement element : elements) {
            if (element.getText().equals(tipoAgendamento)) {
                element.click();
            }
        }

        return this;
    }

    public AgendamentoTela botaoOk() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[4]")).click();
        return this;
    }

/*    public AgendamentoTela botaoVoltar(){

    }*/

    public AgendamentoTela botaoTitular() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        return this;
    }

    public AgendamentoTela botaoAgendar() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[3]")).click();
        return this;
    }

    public AgendamentoTela selecionarDataDisponivel() {
   /*     List<WebElement> elements = app.findElements(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
        for (WebElement element : elements) {
            System.out.println(elements);
            if (element.getText().equals("26")) {
                element.click();
            }
        }*/
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[30]/android.view.ViewGroup")).click();
        return this;
    }

    public AgendamentoTela botaoOK(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[37]")).click();
        return this;
    }

    public AgendamentoTela selecionarHora(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
        return this;
    }

    public AgendamentoTela confirmarAgendamento(){
        app.findElement(By.id("android:id/button2")).click();
        return this;
    }

    public String mensagemSucessoAgendamento(){
         String mensagem = app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
         String mensagem2 = app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
         String mensagemFinal = mensagem+" "+mensagem2;
         System.out.println(mensagemFinal);
        return mensagemFinal;
    }
}