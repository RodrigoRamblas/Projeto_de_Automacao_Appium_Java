package lello.appium.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertJson {
    String fileName = "";

    JSONParser parser = new JSONParser();
    
    public Object JsonConvertido(String fileName) throws IOException, ParseException {
        Object obj = parser.parse(new FileReader(fileName));
        return obj;
    }
    
    public List Aluguel(String fileName) throws IOException, ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String know = (String) jsonObject.get("saiba mais");
        String later = (String) jsonObject.get("mais tarde");
        String msg = (String) jsonObject.get("mensagem");
        List userPass = new ArrayList();
        userPass.add(know);
        userPass.add(later);
        userPass.add(msg);
        return userPass;
    }

    public List Login(String fileName) throws IOException, ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String user = (String) jsonObject.get("usuario");
        String pass = (String) jsonObject.get("senha");
        List userPass = new ArrayList();
        userPass.add(user);
        userPass.add(pass);
        return userPass;
    }

    public List Ocorrencia(String fileName) throws IOException, ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String text = (String) jsonObject.get("texto");
        String no = (String) jsonObject.get("nao");
        String yes = (String) jsonObject.get("sim");
        String msg = (String) jsonObject.get("mensagem");
        JSONArray assunto = (JSONArray) jsonObject.get("assunto");

        List userPass = new ArrayList();
        userPass.add(text);
        userPass.add(no);
        userPass.add(yes);
        userPass.add(msg);
        userPass.add(assunto);
        return userPass;
    }
    public List Veiculo(String fileName) throws IOException, ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String no = (String) jsonObject.get("nao");
        String yes = (String) jsonObject.get("sim");
        String msg = (String) jsonObject.get("mensagem");

        List userPass = new ArrayList();
        userPass.add(no);
        userPass.add(yes);
        userPass.add(msg);
        return userPass;
    }
    public List Autorizar(String fileName) throws IOException, ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String inter = (String) jsonObject.get("interfonar");
        String acess = (String) jsonObject.get("acesso direto");
        String msg = (String) jsonObject.get("mensagem");
        JSONArray tipoAcesso = (JSONArray) jsonObject.get("tipoAcesso");

        List userPass = new ArrayList();
        userPass.add(inter);
        userPass.add(acess);
        userPass.add(msg);
        userPass.add(tipoAcesso);
        return userPass;
    }

    public List Assunto(String fileName) throws IOException, org.json.simple.parser.ParseException {
        Object o = JsonConvertido(fileName);
        JSONObject jsonObject =  (JSONObject) o;
        String mood = (String) jsonObject.get("elogios");
        String suggest = (String) jsonObject.get("sugestoes");
        String warning = (String) jsonObject.get("reclamacoes");
        String other = (String) jsonObject.get("outros");
        List userPass = new ArrayList();
        userPass.add(mood);
        userPass.add(suggest);
        userPass.add(warning);
        userPass.add(other);
        return userPass;
    }
}
