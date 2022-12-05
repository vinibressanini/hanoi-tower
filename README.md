# CMD hanoi tower game

Para testar este jogo você deve primeiramente fazer um clone do projeto. Uma vez clonado, siga os seguintes passos para gerar um .jar do projeto e testá-lo pelo CMD. Como utilizei IntelliJ, os passos serão para esta IDE especificamente.

1. Vá até `Project Structure`


![image](https://user-images.githubusercontent.com/91560062/205653125-eaa76267-d491-48c1-a81d-d54e7282ac8f.png)


2. Depois `Artifacts -> + -> JAR -> From Module With Dependencies`


![image](https://user-images.githubusercontent.com/91560062/205653546-456329b1-23b1-4496-b5ba-73742c9f0464.png)


3. Por fim seleciona a classe `main` como Main Class e clique em OK

![image](https://user-images.githubusercontent.com/91560062/205653764-80a0304c-bc06-4940-9239-a44f1ba4394d.png)


4. Com tudo configurado agora basta seguir o seguinte caminho `Build -> Build Artifacts -> hanoi-tower.jar -> Build`


![image](https://user-images.githubusercontent.com/91560062/205654176-296d0dd5-c69b-441a-a482-fc9fd4467287.png)
![image](https://user-images.githubusercontent.com/91560062/205654242-c85a2dd4-c894-4a46-a745-ead777b783df.png)

5. O arquivo .jar está pronto. Agora é só acessar a pasta pelo CMD (ou na IDE) e digitar o seguinte comando `java -jar hanoi-tower.jar dinamica`

6. Formas de executar 

* `hanoi-tower.jar dinamica` - Implementa a pilha dinâmica com número de pinos padrão (5)
* `hanoi-tower.jar contigua` - Implementa a pilha contigua com número de pinos padrão (5)
* `hanoi-tower.jar dinamica 3` - Implementa a pilha dinâmica com número de pinos escolhido pelo jogador
* `hanoi-tower.jar dinamica 3` - Implementa a pilha contigua com número de pinos escolhido pelo jogador
* `hanoi-tower.jar sobre` - Imprime o nome dos autores

