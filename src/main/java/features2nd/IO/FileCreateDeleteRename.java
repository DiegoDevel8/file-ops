package features2nd.IO;

import java.io.File;
import java.io.IOException;

public class FileCreateDeleteRename
{
  public static void main(String[] args)
  {
    try
    {
      File newFile = new File("my_new_file.txt");

      System.out.println("Antes de criar um novo arquivo: ");
      printFileDetails(newFile);

      // Cria um novo arquivo.
      boolean fileCreated = newFile.createNewFile();
      if(!fileCreated)
        System.out.println(newFile + " não pode ser criado.");

      System.out.println("Após a criação do novo arquivo: ");
      printFileDetails(newFile);

      // Apaga o novo arquivo.
      newFile.delete();

      System.out.println("Após apagar o novo arquivo: ");
      printFileDetails(newFile);

      // Vamos recriar o novo arquivo.
      newFile.createNewFile();

      System.out.println("Após a recriação do arquivo: ");
      printFileDetails(newFile);

      // Vamos dizer a jvm para deletar o arquivo ao encerrarmos a aplicação.
      newFile.deleteOnExit();

      System.out.println("Após a utilizar o método deleteOnExit(): ");
      printFileDetails(newFile);

      // Cria um novo arquivo e o renomeia.
      File firstFile = new File("meu_primeiro_arquivo.txt");
      File secondFile = new File("meu_segundo_arquivo.txt");

      fileCreated = firstFile.createNewFile();
    }
    catch(IOException ex)
    {
      System.err.println("Ocorreu um erro de E/S: " + ex);
    }
  }

  public static void printFileDetails(File f)
  {
    System.out.println("Caminho absoluto: " + f.getAbsoluteFile());
    System.out.println("O arquivo existe: " + f.exists());
    System.out.println("------------------------------------");
  }
}
