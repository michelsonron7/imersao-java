package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
	
	// Leitura da imagem
	//InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
	//InputStream inputStream = 
		//	new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
	BufferedImage imagemOriginal = ImageIO.read(inputStream);
	
	// Cria nova imagem em memória com transparência e com tamanho novo
	int largura = imagemOriginal.getWidth();
	int altura = imagemOriginal.getHeight();
	int novaAltura = altura + 200;
	BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
	
	// Copiar a imagem original para nova imagem (em memória)
	Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
	graphics.drawImage(imagemOriginal, 0, 0, null);
	
	//Configurar a fonte
	var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	graphics.setColor(Color.yellow);
	graphics.setFont(fonte);
	
	//Escrever uma frase na  nova imagem
	graphics.drawString("TOPZERA", 0, novaAltura - 100 );
	
	
	// Escrever a nova imagem em um arquivo
	ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	
	}
	
}	
