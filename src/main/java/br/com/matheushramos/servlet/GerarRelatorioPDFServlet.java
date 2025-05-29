package br.com.matheushramos.servlet;

import br.com.matheushramos.util.RelatorioAtividadeManager;
import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorioPDFServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            // Gera o PDF
            byte[] pdfBytes = gerarPDF();
            
            // Converte para Base64
            String pdfBase64 = Base64.getEncoder().encodeToString(pdfBytes);
            
            // Prepara a resposta
            Map<String, String> resposta = new HashMap<>();
            resposta.put("pdfBase64", pdfBase64);
            resposta.put("fileName", "relatorio_atividades_" + 
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".pdf");
            
            // Envia a resposta
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(resposta));
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao gerar PDF: " + e.getMessage() + "\"}");
        }
    }
    
    private byte[] gerarPDF() throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        PdfWriter.getInstance(document, out);
        document.open();
        
        // Título
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Relatório de Atividades", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);
        
        // Data de geração
        Font dateFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
        Paragraph date = new Paragraph("Gerado em: " + LocalDateTime.now().format(formatter), dateFont);
        date.setAlignment(Element.ALIGN_RIGHT);
        date.setSpacingAfter(20);
        document.add(date);
        
        // Tabela de dados
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        
        // Adiciona os dados
        addTableRow(table, "Usuários Cadastrados", 
            String.valueOf(RelatorioAtividadeManager.getUsuariosCadastrados(getServletContext())));
        addTableRow(table, "Usuários Editados", 
            String.valueOf(RelatorioAtividadeManager.getUsuariosEditados(getServletContext())));
        addTableRow(table, "Usuários Removidos", 
            String.valueOf(RelatorioAtividadeManager.getUsuariosRemovidos(getServletContext())));
        
        LocalDateTime ultimaAcao = RelatorioAtividadeManager.getUltimaAcao(getServletContext());
        addTableRow(table, "Última Ação", 
            ultimaAcao != null ? ultimaAcao.format(formatter) : "Nenhuma ação registrada");
        
        document.add(table);
        document.close();
        
        return out.toByteArray();
    }
    
    private void addTableRow(PdfPTable table, String label, String value) throws DocumentException {
        Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font valueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
        
        Paragraph labelPara = new Paragraph(label, labelFont);
        Paragraph valuePara = new Paragraph(value, valueFont);
        
        table.addCell(labelPara);
        table.addCell(valuePara);
    }
} 