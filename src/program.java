import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* Java fornece um mecanismo, serializa�ao (serialization), que converte qualquer objecto numa sequencia de bits permitindo assim
 * grava-los num ficheiro binario, incluindo os seus dados. 
 * 
 *  O processo inverso chama-se Deserializa�ao e consiste em ler os bits do ficheiro binario e a recriar o objecto em memoria, que
 *  podemos passar a usar normalmente.
 *  
 *  Nota Importante: o presente processo � plantform independent, ou seja, pdemos serializar com java e deserializar com c#, ou outra
 *  qualquer plantaforma ( linguaguem )
 *  
 *  Livrarias:
 *  	-java.io.FileOutputStream      -Para abertura e manipula�ao de ficheiros
 *  	-java.io.ObjectOutputStream    - Contem os metodos de serializa�ao
 *  	-java.io.ObjectInputStream     -Contem os metodos de deserializa�ao
 *  
 *  As observa�oes seguintes tem que ser acompanhadas da correspondente observa�ao do codigo.
 *  A classe object output stream tem o metodo [Object readObject()]
 *  recebe um objecto qia�qier., seriliza-o e escreve-o numa file binaria
 *  Pode atirar uma exce�oes: se nao encontrar o ficheiro - throws IoException
 *  
 *  Faz a deserializa�ao a partir de um ficheiro e devolve um objecto do tipo Object que depois
 *  � necessario converter para o objecto pretendido atraves de um simples cast
 *  Pode atirar duas exce�oes
 *  	-Se nao encontrar o ficheiro  -Throws io.Exception
 *  	-Se nao encontrar a classe    -Throws ClassNotFoundException */

 
public class program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileAndLocation = "";
		pessoa p1 = new pessoa("Ola", "Ola");
		
		serializar(fileAndLocation, p1);
		
		pessoa p2 = (pessoa)desSerialize(fileAndLocation);
		
		System.out.println("Deserializado:" +p2.dizOla());
	}
	
	
	public static void serializar(String fileLocation, Object obj)
	{
		try {
			FileOutputStream fileOut = new FileOutputStream(fileLocation);		//Cria uma struct 
			ObjectOutputStream serialize = new ObjectOutputStream(fileOut);		//Cria o objecto7
			
			serialize.writeObject(obj);			//Serializa o objecto 
			serialize.close();					//Fecha o objecto serialize
			fileOut.close();					//Fecha o 
			System.out.println("Serializado para " + fileLocation);
			
			
		} catch (IOException e) {
			System.out.println("Erro: Impossivel criar ou abrir o ficheiro");
			e.printStackTrace();  //Imprime erro tecnico
		}
		
	}
	
	
	
	public static Object desSerialize(String fileLocation)
	{
		try {
			FileInputStream fileIn = new FileInputStream(fileLocation);
			ObjectInputStream deserialize = new ObjectInputStream(fileIn);
			Object obj = deserialize.readObject();
			
			deserialize.close();
			fileIn.close();
			
			return obj;
			
		} 
		catch (IOException e) 
		{
			// TODO: handle exception
			
			System.out.println("Erro: Impossivel aceder ao ficheiro");
			e.printStackTrace();
			return null;
			
		}
		catch (ClassNotFoundException c) 
		{
			// TODO: handle exception
			System.out.println("Erro: Impossivel aceder ao ficheiro");
			c.printStackTrace();
			return null;

		}
		
	}
	

}
