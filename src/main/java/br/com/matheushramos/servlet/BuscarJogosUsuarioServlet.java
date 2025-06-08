package br.com.matheushramos.servlet;

import br.com.matheushramos.dao.UsuarioDao;
import br.com.matheushramos.dao.UsuarioJogosDao;
import br.com.matheushramos.model.*;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BuscarJogosUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 6828360621758109373L;
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        
        try {
            List<Usuario> usuarios = new UsuarioDao().listarTodos();
            int sucessos = 0;
            int falhas = 0;
            
            for (Usuario usuario : usuarios) {
                try {
                    PlataformaJogos plataformaJogos = consumeWebService(usuario.getId().toString());
                    
                    if (plataformaJogos.getUsuario().getId() != usuario.getId()) {
                        throw new IOException("ID do usuário no XML não corresponde ao esperado");
                    }
                    
                    List<UsuarioJogo> jogos = new ArrayList<>();
                    for (JogoResponse jogo : plataformaJogos.getUsuario().getJogos()) {
                        jogos.add(new UsuarioJogo(usuario.getId().intValue(), jogo.getId(), jogo.getNome()));
                    }
                    
                    new UsuarioJogosDao().persistirJogos(jogos);
                    sucessos++;
                } catch (Exception e) {
                    falhas++;
                    System.err.println("Erro ao processar usuário " + usuario.getId() + ": " + e.getMessage());
                }
            }
            
            BuscarJogosResponse responseObj = new BuscarJogosResponse(
                true,
                "Processados " + usuarios.size() + " usuários. Sucessos: " + sucessos + ", Falhas: " + falhas
            );
            response.getWriter().write(gson.toJson(responseObj));
            
        } catch (Exception e) {
            BuscarJogosResponse responseObj = new BuscarJogosResponse(false, e.getMessage());
            response.getWriter().write(gson.toJson(responseObj));
        }
    }
    
    private PlataformaJogos consumeWebService(String idUsuario) throws Exception {
        URL url = new URL("http://localhost:8585/api/jogos?idUsuario=" + idUsuario);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Erro ao chamar WebService. Código de resposta: " + responseCode);
        }
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            JAXBContext context = JAXBContext.newInstance(PlataformaJogos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (PlataformaJogos) unmarshaller.unmarshal(reader);
        } finally {
            conn.disconnect();
        }
    }
} 